package com.example.fongfood.exceptions;

public class ResponseError extends Exception {

  private int status;
  private String message;

  public ResponseError(int status, String message) {
    super();
    this.status = status;
    this.message = message;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  @Override
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
