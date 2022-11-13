package com.example.fongfood.controllers;

import com.example.fongfood.models.ResponseObject;
import com.example.fongfood.models.entities.ProductEntity;
import com.example.fongfood.services.impl.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping()
  public ResponseEntity<ResponseObject<List<ProductEntity>>> getAll(
      @RequestParam(name = "category", defaultValue = "-1") Long categoryId,
      @RequestParam(name = "search", defaultValue = "") String search) {
    return ResponseEntity.ok().body(productService.getAll(categoryId, search));
  }
}
