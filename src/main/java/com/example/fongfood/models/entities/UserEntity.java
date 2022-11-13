package com.example.fongfood.models.entities;

import com.example.fongfood.models.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tbl_users")
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;

  @Column(name = "name")
  private String name;

  @Column(name = "tel")
  private String tel;

  @Column(name = "address")
  private String address;

  @Column(name = "role")
  @Enumerated(EnumType.STRING)
  private UserRole role;

  @OneToOne
  @Transient
  private ImageEntity avatar;

  public UserEntity() {
  }

  public UserEntity(Long id, String email, String password, String name, String tel, String address,
      UserRole role, ImageEntity avatar) {
    this.id = id;
    this.email = email;
    this.password = password;
    this.name = name;
    this.tel = tel;
    this.address = address;
    this.role = role;
    this.avatar = avatar;
  }

  public UserEntity(Long id, String email, String name, String tel, String address, UserRole role,
      ImageEntity avatar) {
    this.id = id;
    this.email = email;
    this.name = name;
    this.tel = tel;
    this.address = address;
    this.role = role;
    this.avatar = avatar;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @JsonIgnore
  public String getPassword() {
    return password;
  }

  @JsonProperty
  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public UserRole getRole() {
    return role;
  }

  public void setRole(UserRole role) {
    this.role = role;
  }

  public ImageEntity getAvatar() {
    return avatar;
  }

  public void setAvatar(ImageEntity avatar) {
    this.avatar = avatar;
  }
}
