package com.example.fongfood.services;

import com.example.fongfood.models.ResponseObject;
import com.example.fongfood.models.entities.CartEntity;
import java.util.List;

public interface ICartService {

  ResponseObject<List<CartEntity>> getCartByUser(Long userId);

  ResponseObject<CartEntity> createCartByUser(CartEntity cart);

  ResponseObject<CartEntity> updateCart(CartEntity cartUpdate, Long id);

  ResponseObject<Object> deleteCart(Long id);
}
