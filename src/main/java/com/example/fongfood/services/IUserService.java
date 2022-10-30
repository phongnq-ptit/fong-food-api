package com.example.fongfood.services;

import com.example.fongfood.models.ResponseObject;
import com.example.fongfood.models.entities.UserEntity;
import com.example.fongfood.models.enums.UserRole;
import java.util.List;

public interface IUserService {

  ResponseObject<List<UserEntity>> getAllUser(UserRole role);

  ResponseObject<UserEntity> getUser(Long id);

  ResponseObject<UserEntity> login(UserEntity user);

  ResponseObject<UserEntity> register(UserEntity newUser);

  ResponseObject<UserEntity> updateUser(Long id, UserEntity updateUser);

  ResponseObject<Object> removeUser(Long id);
}
