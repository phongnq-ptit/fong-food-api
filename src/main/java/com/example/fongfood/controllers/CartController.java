package com.example.fongfood.controllers;

import com.example.fongfood.models.ResponseObject;
import com.example.fongfood.models.entities.CartEntity;
import com.example.fongfood.services.impl.CartService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cart")
public class CartController {

  @Autowired
  private CartService cartService;

  @GetMapping()
  public ResponseEntity<ResponseObject<List<CartEntity>>> getCartByUser(
      @RequestParam( name = "userId") String userId) {
    return ResponseEntity.ok().body(cartService.getCartByUser(Long.parseLong(userId)));
  }

  @PostMapping()
  public ResponseEntity<ResponseObject<CartEntity>> createCartByUser(@RequestBody CartEntity cart) {
    return ResponseEntity.ok().body(cartService.createCartByUser(cart));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<ResponseObject<CartEntity>> updateCartItem(
      @RequestBody CartEntity cartUpdate, @PathVariable("id") Long id
  ) {
    return ResponseEntity.ok().body(cartService.updateCart(cartUpdate, id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<ResponseObject<Object>> deleteCartItem(@PathVariable("id") Long id) {
    return ResponseEntity.ok().body(cartService.deleteCart(id));
  }
}
