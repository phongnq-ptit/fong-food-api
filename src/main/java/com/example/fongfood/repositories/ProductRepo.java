package com.example.fongfood.repositories;

import com.example.fongfood.models.entities.ProductEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepo extends JpaRepository<ProductEntity, Long> {

  List<ProductEntity> findAllByCategoryId(Long categoryId);

  @Query("SELECT p FROM ProductEntity p WHERE p.name LIKE %?1%")
  List<ProductEntity> search(String search);
}
