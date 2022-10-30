package com.example.fongfood.services;

import com.example.fongfood.models.ResponseObject;
import com.example.fongfood.models.entities.CategoryEntity;
import java.util.List;

public interface ICategoryService {

  ResponseObject<List<CategoryEntity>> getCategories();

  ResponseObject<CategoryEntity> getCategory(Long id);

  ResponseObject<CategoryEntity> addCategory(CategoryEntity newCategory);

  ResponseObject<CategoryEntity> updateCategory(Long id, CategoryEntity updateCategory);

  ResponseObject<Object> removeCategory(Long id);
}
