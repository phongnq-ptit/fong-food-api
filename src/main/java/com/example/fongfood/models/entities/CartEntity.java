package com.example.fongfood.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tbl_cart")
public class CartEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private Long userId;
  private Long productId;
  @Column(columnDefinition = "int default 1")
  private int quantity;
  @Transient
  @ManyToOne
  private UserEntity user;
  @Transient
  @ManyToOne
  private ProductEntity product;

  public CartEntity() {
  }

  public CartEntity(Long id, int quantity, UserEntity user, ProductEntity product) {
    this.id = id;
    this.quantity = quantity;
    this.user = user;
    this.product = product;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @JsonIgnore
  public Long getUserId() {
    return userId;
  }

  @JsonProperty
  public void setUserId(Long userId) {
    this.userId = userId;
  }

  @JsonIgnore
  public Long getProductId() {
    return productId;
  }

  @JsonProperty
  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public UserEntity getUser() {
    return user;
  }

  public void setUser(UserEntity user) {
    this.user = user;
  }

  public ProductEntity getProduct() {
    return product;
  }

  public void setProduct(ProductEntity product) {
    this.product = product;
  }
}
