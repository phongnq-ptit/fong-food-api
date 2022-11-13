package com.example.fongfood.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.fongfood.exceptions.ResponseError;
import com.example.fongfood.models.ResponseObject;
import com.example.fongfood.models.entities.ImageEntity;
import com.example.fongfood.repositories.UploadRepo;
import com.example.fongfood.services.ICloudinaryService;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CloudinaryService implements ICloudinaryService {

  Cloudinary cloudinary;

  private Map<String, String> valuesMap = new HashMap<>();

  @Autowired
  private UploadRepo uploadRepo;

  public CloudinaryService() {
    valuesMap.put("cloud_name", "dicisqibf");
    valuesMap.put("api_key", "486944772924843");
    valuesMap.put("api_secret", "GxSnuaFCedQfx8pHaFDzYMkODqw");
    cloudinary = new Cloudinary(valuesMap);
  }

  @Override
  public ResponseObject<ImageEntity> upload(
      MultipartFile multipartFile,
      Long userId,
      Long productId
  ) {
    try {
      if (userId == -1 && productId == -1) {
        throw new ResponseError(400,
            "Need to specify the object to upload the image! (userId or productId is require)");
      }

      if (multipartFile.isEmpty()) {
        throw new ResponseError(404, "No files have been uploaded!");
      }

      File file = null;
      file = convert(multipartFile);

      if (file.length() > 1024 * 1024) {
        throw new ResponseError(400, "File size large more than 1Mb!");
      }

      String mimeType = FilenameUtils.getExtension(file.getPath());
      if (!mimeType.equals("jpg") && !mimeType.equals("png") && !mimeType.equals("jpeg")) {
        throw new ResponseError(400, "Incorrect file format!");
      }

      // column userId is unique
      if (userId != -1) {
        Optional<ImageEntity> checkUserId = Optional.ofNullable(uploadRepo.findByUserId(userId));
        if (checkUserId.isPresent()) {
          throw new ResponseError(400, "UserId already exists!");
        }
      }

      Map img = cloudinary.uploader().upload(file, ObjectUtils.asMap("folder", "fong-food"));

      ImageEntity newImage = new ImageEntity();
      newImage.setUrl(img.get("secure_url").toString());
      newImage.setPublicId(img.get("public_id").toString().split("/")[1]);
      if (userId != -1) {
        newImage.setUserId(userId);
      }
      if (productId != -1) {
        newImage.setProductId(productId);
      }

      file.delete();

      return new ResponseObject<ImageEntity>(
          200,
          "Upload image successful!",
          uploadRepo.save(newImage)
      );
    } catch (ResponseError e) {
      return new ResponseObject<ImageEntity>(
          e.getStatus(),
          e.getMessage(),
          null
      );
    } catch (IOException e) {
      return new ResponseObject<ImageEntity>(
          500,
          e.getMessage(),
          null
      );
    }
  }

  @Override
  public ResponseObject<Object> destroy(String publicId) {
    try {
      Optional<ImageEntity> image = Optional.ofNullable(
          uploadRepo.findByPublicId(publicId));

      if (!image.isPresent()) {
        throw new ResponseError(404, "PublicId does not exists!");
      }

      Map result = cloudinary.uploader().destroy("fong-food/" + publicId, ObjectUtils.emptyMap());

      if (!result.get("result").toString().equalsIgnoreCase("ok")) {
        throw new ResponseError(400, "Delete image unsuccessful!");
      }

      uploadRepo.deleteById(image.get().getId());

      return new ResponseObject<Object>(
          200,
          "Remove image successful!",
          "No content."
      );
    } catch (ResponseError e) {
      return new ResponseObject<Object>(
          e.getStatus(),
          e.getMessage(),
          null
      );
    } catch (IOException e) {
      return new ResponseObject<Object>(
          500,
          e.getMessage(),
          null
      );
    }
  }

  private File convert(MultipartFile multipartFile) throws IOException {
    File file = new File(multipartFile.getOriginalFilename());
    FileOutputStream fo = new FileOutputStream(file);
    fo.write(multipartFile.getBytes());
    fo.close();
    return file;
  }
}
