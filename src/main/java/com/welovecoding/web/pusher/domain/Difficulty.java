package com.welovecoding.web.pusher.domain;

public enum Difficulty {

  EASY("admin.form.label.beginner"),
  MEDIUM("admin.form.label.advanced"),
  HARD("admin.form.label.pros");

  private final String label;

  private Difficulty(String label) {
    this.label = label;
  }

  public String getLabel() {
    return label;
  }

}
