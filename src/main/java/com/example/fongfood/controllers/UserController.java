package com.example.fongfood.controllers;

import com.example.fongfood.models.ResponseObject;
import com.example.fongfood.models.entities.UserEntity;
import com.example.fongfood.models.enums.UserRole;
import com.example.fongfood.repositories.UserRepo;
import com.example.fongfood.services.impl.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping()
  public ResponseEntity<ResponseObject<List<UserEntity>>> getAllUsers(
      @RequestParam(value = "role", defaultValue = "NULL") UserRole role
  ) {
    return ResponseEntity.ok().body(userService.getAllUser(role));
  }

  @GetMapping("/{id}")
  public ResponseEntity<ResponseObject<UserEntity>> getUser(@PathVariable("id") Long id) {
    return ResponseEntity.ok().body(userService.getUser(id));
  }

  @PostMapping("/register")
  public ResponseEntity<ResponseObject<UserEntity>> register(@RequestBody UserEntity user) {
    return ResponseEntity.ok().body(userService.register(user));
  }

  @PostMapping("/login")
  public ResponseEntity<ResponseObject<UserEntity>> login(@RequestBody UserEntity user) {
    return ResponseEntity.ok().body(userService.login(user));
  }

  @PutMapping("/{id}")
  public ResponseEntity<ResponseObject<UserEntity>> updateUser(@RequestBody UserEntity updateUser,
      @PathVariable("id") Long id) {
    return ResponseEntity.ok().body(userService.updateUser(id, updateUser));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> removeUser(@PathVariable("id") Long id) {
    return ResponseEntity.ok().body(userService.removeUser(id));
  }
}
