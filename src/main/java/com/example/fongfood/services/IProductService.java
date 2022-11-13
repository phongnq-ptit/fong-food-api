package com.example.fongfood.services;

import com.example.fongfood.models.ResponseObject;
import com.example.fongfood.models.entities.ProductEntity;
import java.util.List;

public interface IProductService {
  ResponseObject<List<ProductEntity>> getAll(Long category, String search);
  ResponseObject<ProductEntity> get(Long id);
  ResponseObject<ProductEntity> create(ProductEntity product);
  ResponseObject<ProductEntity> update(ProductEntity productUpdate, Long id);
  ResponseObject<Object> remove(Long id);
}
