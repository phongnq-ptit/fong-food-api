package com.example.fongfood.services.impl;

import com.example.fongfood.exceptions.ResponseError;
import com.example.fongfood.models.ResponseObject;
import com.example.fongfood.models.entities.CategoryEntity;
import com.example.fongfood.models.entities.ImageEntity;
import com.example.fongfood.models.entities.ProductEntity;
import com.example.fongfood.repositories.CategoryRepo;
import com.example.fongfood.repositories.ProductRepo;
import com.example.fongfood.repositories.UploadRepo;
import com.example.fongfood.services.IProductService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

  @Autowired
  private ProductRepo productRepo;

  @Autowired
  private CategoryRepo categoryRepo;

  @Autowired
  private UploadRepo uploadRepo;

  @Override
  public ResponseObject<List<ProductEntity>> getAll(Long category, String search) {
    try {
      List<ProductEntity> products;

      products = productRepo.findAll().stream().map(
          row -> {
            Optional<CategoryEntity> _category = categoryRepo.findById(row.getCategoryId());
            List<ImageEntity> images = uploadRepo.findAllByProductId(row.getId());
            row.setImages(images);
            row.setCategory(_category.get());
            row.setImage(images.get(0).getUrl());
            return row;
          }
      ).collect(Collectors.toList());

      if (category != -1) {
        products = productRepo.findAllByCategoryId(category).stream().map(
            row -> {
              Optional<CategoryEntity> _category = categoryRepo.findById(row.getCategoryId());
              List<ImageEntity> images = uploadRepo.findAllByProductId(row.getId());
              row.setImages(images);
              row.setCategory(_category.get());
              row.setImage(images.get(0).getUrl());
              return row;
            }
        ).collect(Collectors.toList());
      } else if (!search.equalsIgnoreCase("")) {
        products = productRepo.search(search).stream().map(
            row -> {
              Optional<CategoryEntity> _category = categoryRepo.findById(row.getCategoryId());
              List<ImageEntity> images = uploadRepo.findAllByProductId(row.getId());
              row.setImages(images);
              row.setCategory(_category.get());
              row.setImage(images.get(0).getUrl());
              return row;
            }
        ).collect(Collectors.toList());
      }

      return new ResponseObject<List<ProductEntity>>(200, "Get all products successful!", products);
    } catch (Exception e) {
      return new ResponseObject<List<ProductEntity>>(
          500,
          e.getMessage(),
          null
      );
    }
  }

  @Override
  public ResponseObject<ProductEntity> get(Long id) {
    try {
      Optional<ProductEntity> product = productRepo.findById(id);

      if (!product.isPresent()) {
        throw new ResponseError(404, "Cannot find id " + id + " !");
      }

      List<ImageEntity> images = uploadRepo.findAllByProductId(product.get().getId());
      Optional<CategoryEntity> category = categoryRepo.findById(product.get().getCategoryId());
      product.get().setImages(images);
      product.get().setCategory(category.get());
      product.get().setImage(images.get(0).getUrl());

      return new ResponseObject<ProductEntity>(
          200,
          "Get product " + id + " successful!",
          product.get()
      );
    } catch (ResponseError e) {
      return new ResponseObject<ProductEntity>(
          e.getStatus(),
          e.getMessage(),
          null
      );
    }
  }

  @Override
  public ResponseObject<ProductEntity> create(ProductEntity product) {
    return null;
  }

  @Override
  public ResponseObject<ProductEntity> update(ProductEntity productUpdate, Long id) {
    return null;
  }

  @Override
  public ResponseObject<Object> remove(Long id) {
    return null;
  }
}
