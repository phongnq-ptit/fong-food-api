package com.example.fongfood.models.enums;

public enum UserRole {
  CLIENT("CLIENT"),
  ADMIN("ADMIN"),
  NULL("null");

  private String label;

  UserRole(String label) {
    this.label = label;
  }

  public String getLabel() {
    return label;
  }
}
