package com.example.fongfood.services.impl;

import com.example.fongfood.exceptions.ResponseError;
import com.example.fongfood.models.ResponseObject;
import com.example.fongfood.models.entities.CategoryEntity;
import com.example.fongfood.repositories.CategoryRepo;
import com.example.fongfood.services.ICategoryService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService {

  @Autowired
  private CategoryRepo categoryRepo;

  @Override
  public ResponseObject<List<CategoryEntity>> getCategories() {
    try {
      return new ResponseObject<List<CategoryEntity>>(
          200,
          "Get all category successful!",
          categoryRepo.findAll()
      );
    } catch (Exception e) {
      return new ResponseObject<List<CategoryEntity>>(
          500,
          e.getMessage(),
          null
      );
    }
  }

  @Override
  public ResponseObject<CategoryEntity> getCategory(Long id) {
    try {
      Optional<CategoryEntity> category = categoryRepo.findById(id);

      if (!category.isPresent()) {
        throw new ResponseError(404, "Cannot find id " + id + " !");
      }

      return new ResponseObject<CategoryEntity>(
          200,
          "Get category" + id + " successful!",
          category.get()
      );
    } catch (ResponseError e) {
      return new ResponseObject<CategoryEntity>(
          e.getStatus(),
          e.getMessage(),
          null
      );
    }
  }

  @Override
  public ResponseObject<CategoryEntity> addCategory(CategoryEntity newCategory) {
    return null;
  }

  @Override
  public ResponseObject<CategoryEntity> updateCategory(Long id, CategoryEntity updateCategory) {
    return null;
  }

  @Override
  public ResponseObject<Object> removeCategory(Long id) {
    return null;
  }
}
