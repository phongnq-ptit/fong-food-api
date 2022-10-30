package com.example.fongfood.repositories;

import com.example.fongfood.models.entities.UserEntity;
import com.example.fongfood.models.enums.UserRole;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, Long> {

  UserEntity findByEmail(String email);

  UserEntity findByEmailAndPassword(String email, String password);

  List<UserEntity> findAllByRole(UserRole role);
}
