package com.example.fongfood.controllers;

import com.example.fongfood.models.ResponseObject;
import com.example.fongfood.models.entities.CartEntity;
import com.example.fongfood.services.impl.CartService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cart")
public class CartController {
  @Autowired
  private CartService cartService;

  @GetMapping("/{userId}")
  public ResponseEntity<ResponseObject<List<CartEntity>>> getCartByUser(@PathVariable("userId") Long userId) {
    return ResponseEntity.ok().body(cartService.getCartByUser(userId));
  }
}
