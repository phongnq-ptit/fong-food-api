package com.example.fongfood.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tbl_products")
public class ProductEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private int price;
  private String description;
  private Long categoryId;
  @ManyToOne
  @Transient
  private CategoryEntity category;
  @OneToMany
  @Transient
  private List<ImageEntity> images;

  public ProductEntity() {
  }

  public ProductEntity(Long id, String name, int price, String description,
      CategoryEntity category, List<ImageEntity> images) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.description = description;
    this.category = category;
    this.images = images;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @JsonIgnore
  public Long getCategoryId() {
    return categoryId;
  }

  @JsonProperty
  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }

  public CategoryEntity getCategory() {
    return category;
  }

  public void setCategory(CategoryEntity category) {
    this.category = category;
  }

  public List<ImageEntity> getImages() {
    return images;
  }

  public void setImages(List<ImageEntity> images) {
    this.images = images;
  }
}
