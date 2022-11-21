package com.example.fongfood.repositories;

import com.example.fongfood.models.entities.CartEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<CartEntity, Long> {
  List<CartEntity> findAllByUserId(Long userId);

  CartEntity findByUserIdAndProductId(Long userId, Long productId);
}
