package com.example.fongfood.repositories;

import com.example.fongfood.models.entities.ImageEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadRepo extends JpaRepository<ImageEntity, Long> {

  ImageEntity findByUserId(Long userId);

  List<ImageEntity> findAllByProductId(Long productId);

  ImageEntity findByPublicId(String publicId);
}
