package com.example.fongfood.controllers;

import com.example.fongfood.models.ResponseObject;
import com.example.fongfood.models.entities.CategoryEntity;
import com.example.fongfood.services.impl.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

  @Autowired
  private CategoryService categoryService;

  @GetMapping()
  public ResponseEntity<ResponseObject<List<CategoryEntity>>> getAllCategories() {
    return ResponseEntity.ok().body(categoryService.getCategories());
  }

  @GetMapping("/{id}")
  public ResponseEntity<ResponseObject<CategoryEntity>> getcategory(@PathVariable("id") Long id) {
    return ResponseEntity.ok().body(categoryService.getCategory(id));
  }
}
