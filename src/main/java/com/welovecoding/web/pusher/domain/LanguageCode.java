package com.welovecoding.web.pusher.domain;

/**
 * Example: "en" (English), "ja" (Japanese), "kok" (Konkani)
 *
 * http://en.wikipedia.org/wiki/List_of_ISO_639-1_codes
 * http://docs.oracle.com/javase/7/docs/api/java/util/Locale.html
 */
public enum LanguageCode {

  de("admin.locale.de"),
  en("admin.locale.en");

  private final String label;

  private LanguageCode(String label) {
    this.label = label;
  }

  public String getLabel() {
    return label;
  }

  @Override
  public String toString() {
    switch (this) {
      case de:
        return "German";
      default:
        return "English";
    }
  }

}
