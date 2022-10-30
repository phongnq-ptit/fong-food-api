package com.example.fongfood.services.impl;

import com.example.fongfood.exceptions.ResponseError;
import com.example.fongfood.models.ResponseObject;
import com.example.fongfood.models.entities.ImageEntity;
import com.example.fongfood.models.entities.UserEntity;
import com.example.fongfood.models.enums.UserRole;
import com.example.fongfood.repositories.UploadRepo;
import com.example.fongfood.repositories.UserRepo;
import com.example.fongfood.services.IUserService;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

  @Autowired
  private UserRepo userRepo;

  @Autowired
  private UploadRepo uploadRepo;

  // Encrypt passwords with MD5 algorithm
  public String hashPassword(String password) throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("MD5");
    md.update(password.getBytes());
    byte[] digest = md.digest();
    String myHash = DatatypeConverter
        .printHexBinary(digest);
    return myHash;
  }

  @Override
  public ResponseObject<List<UserEntity>> getAllUser(UserRole role) {
    try {
      List<UserEntity> users = null;

      if (role.getLabel() != "null") {
        users = userRepo.findAllByRole(role).stream().map(
            row -> {
              ImageEntity avatar = uploadRepo.findByUserId(row.getId());
              return new UserEntity(row.getId(), row.getEmail(), row.getName(), row.getTel(),
                  row.getAddress(),
                  row.getRole(),
                  avatar);
            }
        ).collect(Collectors.toList());
      } else {
        users = userRepo.findAll().stream().map(
            row -> {
              ImageEntity avatar = uploadRepo.findByUserId(row.getId());
              return new UserEntity(row.getId(), row.getEmail(), row.getName(), row.getTel(),
                  row.getAddress(),
                  row.getRole(),
                  avatar);
            }
        ).collect(Collectors.toList());
      }

      return new ResponseObject<List<UserEntity>>(
          200,
          "Get all users successful!",
          users
      );
    } catch (Exception e) {
      return new ResponseObject<List<UserEntity>>(
          500,
          e.getMessage(),
          null
      );
    }
  }

  @Override
  public ResponseObject<UserEntity> getUser(Long id) {
    try {
      Optional<UserEntity> user = userRepo.findById(id);

      if (!user.isPresent()) {
        throw new ResponseError(404, "Cannot find id " + id + "!");
      }

      ImageEntity avatar = uploadRepo.findByUserId(user.get().getId());

      UserEntity _user = new UserEntity(user.get().getId(), user.get().getEmail(),
          user.get().getName(), user.get().getTel(),
          user.get().getAddress(),
          user.get().getRole(),
          avatar);

      return new ResponseObject<UserEntity>(
          200,
          "Get user " + id + " successful!",
          _user
      );
    } catch (ResponseError e) {
      return new ResponseObject<UserEntity>(
          e.getStatus(),
          e.getMessage(),
          null
      );
    }
  }

  @Override
  public ResponseObject<UserEntity> login(UserEntity user) {
    try {
      Optional<UserEntity> _user = Optional.ofNullable(
          userRepo.findByEmailAndPassword(user.getEmail(), hashPassword(user.getPassword())));

      if (!_user.isPresent()) {
        throw new ResponseError(404, "Email or Password incorrect!");
      }

      return new ResponseObject<UserEntity>(
          200,
          "Login successful!",
          _user.get()
      );
    } catch (ResponseError e) {
      return new ResponseObject<UserEntity>(
          e.getStatus(),
          e.getMessage(),
          null
      );
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public ResponseObject<UserEntity> register(UserEntity user) {
    try {
      Optional<UserEntity> checkEmail = Optional.ofNullable(userRepo.findByEmail(user.getEmail()));

      if (checkEmail.isPresent()) {
        throw new ResponseError(400, "Email " + user.getEmail() + " already exists!");
      }

      user.setPassword(hashPassword(user.getPassword()));

      return new ResponseObject<UserEntity>(
          200,
          "Register user: " + user.getEmail() + " successful!",
          userRepo.save(user)
      );
    } catch (ResponseError e) {
      return new ResponseObject<UserEntity>(
          e.getStatus(),
          e.getMessage(),
          null
      );
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public ResponseObject<UserEntity> updateUser(Long id, UserEntity updateUser) {
    try {
      Optional<UserEntity> newUser = userRepo.findById(id)
          .map(row -> {
            row.setName(updateUser.getName());
            row.setTel(updateUser.getTel());
            row.setAddress(updateUser.getAddress());
            row.setEmail(updateUser.getEmail());
            try {
              row.setPassword(hashPassword(updateUser.getPassword()));
            } catch (NoSuchAlgorithmException e) {
              throw new RuntimeException(e);
            }
            row.setRole(updateUser.getRole());
            return userRepo.save(row);
          });

      if (!newUser.isPresent()) {
        throw new ResponseError(404, "Cannot find id " + id + "!");
      }

      return new ResponseObject<UserEntity>(
          200,
          "Update user " + id + " successful!",
          newUser.get()
      );
    } catch (ResponseError e) {
      return new ResponseObject<UserEntity>(
          e.getStatus(),
          e.getMessage(),
          null
      );
    }
  }

  @Override
  public ResponseObject<Object> removeUser(Long id) {
    try {
      boolean exists = userRepo.existsById(id);

      if (!exists) {
        throw new ResponseError(404, "Cannot find id " + id + "!");
      }

      userRepo.deleteById(id);

      return new ResponseObject<Object>(
          200,
          "Remove user " + id + " successful!",
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
