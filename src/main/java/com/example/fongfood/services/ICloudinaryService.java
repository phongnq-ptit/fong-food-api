package com.example.fongfood.services;

import com.example.fongfood.models.ResponseObject;
import com.example.fongfood.models.entities.ImageEntity;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

public interface ICloudinaryService {

  ResponseObject<ImageEntity> upload(MultipartFile multipartFile, Long userId, Long productId);

  ResponseObject<Object> destroy(String publicId);
}
