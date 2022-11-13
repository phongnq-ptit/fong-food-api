package com.example.fongfood.services.impl;

import com.example.fongfood.exceptions.ResponseError;
import com.example.fongfood.models.ResponseObject;
import com.example.fongfood.models.entities.CartEntity;
import com.example.fongfood.models.entities.ProductEntity;
import com.example.fongfood.models.entities.UserEntity;
import com.example.fongfood.repositories.CartRepo;
import com.example.fongfood.repositories.UserRepo;
import com.example.fongfood.services.ICartService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService implements ICartService {

  @Autowired
  private CartRepo cartRepo;

  @Autowired
  private UserRepo userRepo;

  @Autowired
  private UserService userService;

  @Autowired
  private ProductService productService;

  @Override
  public ResponseObject<List<CartEntity>> getCartByUser(Long userId) {
    try {
      Optional<UserEntity> user = userRepo.findById(userId);

      if (!user.isPresent()) {
        throw new ResponseError(404, "Cannot find id " + userId + "!");
      }

      List<CartEntity> carts = cartRepo.findAllByUserId(userId).stream().map(
          row -> {
            ResponseObject<UserEntity> _user = userService.getUser(row.getUserId());
            ResponseObject<ProductEntity> _product = productService.get(row.getProductId());
            row.setUser(_user.getData());
            row.setProduct(_product.getData());
            return row;
          }
      ).collect(Collectors.toList());

      return new ResponseObject<List<CartEntity>>(
          200,
          "Cart of user " + user.get().getName() + " !",
          carts
      );
    } catch (ResponseError e) {
      return new ResponseObject<List<CartEntity>>(
          e.getStatus(),
          e.getMessage(),
          null
      );
    }
  }

  @Override
  public ResponseObject<CartEntity> createCartByUser(CartEntity cart) {
    return null;
  }

  @Override
  public ResponseObject<CartEntity> updateCart(CartEntity cartUpdate, Long id) {
    return null;
  }

  @Override
  public ResponseObject<Object> deleteCart(Long id) {
    return null;
  }
}
