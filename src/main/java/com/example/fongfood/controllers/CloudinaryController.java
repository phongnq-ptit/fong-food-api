package com.example.fongfood.controllers;

import com.example.fongfood.services.impl.CloudinaryService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/cloudinary")
public class CloudinaryController {

  @Autowired
  private CloudinaryService cloudinaryService;

  @PostMapping("/upload")
  public ResponseEntity<?> upload(
      @RequestParam MultipartFile files,
      @RequestParam(name = "userId", defaultValue = "-1") String userId,
      @RequestParam(name = "productId", defaultValue = "-1") String productId) throws IOException {
    return new ResponseEntity(
        cloudinaryService.upload(files, Long.parseLong(userId), Long.parseLong(productId)),
        HttpStatus.OK);
  }

  @DeleteMapping("/destroy/{publicId}")
  public ResponseEntity<?> destroy(@PathVariable("publicId") String publicId) throws IOException {
    return new ResponseEntity(cloudinaryService.destroy(publicId), HttpStatus.OK);
  }
}
