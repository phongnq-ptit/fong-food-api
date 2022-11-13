package com.example.fongfood.repositories;

import com.example.fongfood.models.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<CategoryEntity, Long> {

  CategoryEntity findByName(String name);
}
