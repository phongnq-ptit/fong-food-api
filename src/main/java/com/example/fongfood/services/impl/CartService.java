package com.example.fongfood.services.impl;

import com.example.fongfood.exceptions.ResponseError;
import com.example.fongfood.models.ResponseObject;
import com.example.fongfood.models.entities.CartEntity;
import com.example.fongfood.models.entities.ProductEntity;
import com.example.fongfood.models.entities.UserEntity;
import com.example.fongfood.repositories.CartRepo;
import com.example.fongfood.repositories.ProductRepo;
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
  private ProductRepo productRepo;

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
    try {
      ResponseObject<UserEntity> user = userService.getUser(cart.getUserId());

      if (user.getData() == null) {
        throw new ResponseError(404, "Cannot find userId " + cart.getUserId() + "!");
      }

      ResponseObject<ProductEntity> product = productService.get(cart.getProductId());

      if (product.getData() == null) {
        throw new ResponseError(404, "Cannot find productId " + cart.getProductId() + "!");
      }

      Optional<CartEntity> existsCart = Optional.ofNullable(
          cartRepo.findByUserIdAndProductId(cart.getUserId(),
              cart.getProductId()));

      if (existsCart.isPresent()) {
        throw new ResponseError(400, "The product already exists in the cart!");
      }

      CartEntity newCart = new CartEntity();
      newCart.setUserId(cart.getUserId());
      newCart.setProductId(cart.getProductId());
      newCart.setUser(user.getData());
      newCart.setProduct(product.getData());
      newCart.setQuantity(1);

      newCart = cartRepo.save(newCart);

      return new ResponseObject<CartEntity>(
          200,
          "Cart of user " + user.getData().getName() + " !",
          newCart
      );
    } catch (ResponseError e) {
      return new ResponseObject<CartEntity>(
          e.getStatus(),
          e.getMessage(),
          null
      );
    }
  }

  // Increment and decrement quantity
  @Override
  public ResponseObject<CartEntity> updateCart(CartEntity cartUpdate, Long id) {
    try {
      if (cartUpdate.getQuantity() < 1) {
        throw new ResponseError(400, "Quantity value cannot be less than 1!");
      }

      Optional<CartEntity> cart = cartRepo.findById(id);

      if (!cart.isPresent()) {
        throw new ResponseError(404, "Cannot found cartId " + id + " !");
      }

      cart.get().setQuantity(cartUpdate.getQuantity());
      cart.get().setUser(userService.getUser(cart.get().getUserId()).getData());
      cart.get().setProduct(productService.get(cart.get().getProductId()).getData());

      return new ResponseObject<CartEntity>(
          200,
          "Update cart item successful!",
          cartRepo.save(cart.get())
      );
    } catch (ResponseError e) {
      return new ResponseObject<CartEntity>(
          e.getStatus(),
          e.getMessage(),
          null
      );
    }
  }

  @Override
  public ResponseObject<Object> deleteCart(Long id) {
    try {
      Optional<CartEntity> cart = cartRepo.findById(id);

      if (!cart.isPresent()) {
        throw new ResponseError(404, "Cannot found cartId " + id + " !");
      }

      cartRepo.deleteById(cart.get().getId());

      return new ResponseObject<Object>(
          200,
          "Delete cart item successful!",
          "No content!"
      );
    } catch (ResponseError e) {
      return new ResponseObject<Object>(
          e.getStatus(),
          e.getMessage(),
          null
      );
    }
  }
}
