package com.dineshvelhal.pages;

import org.openqa.selenium.WebDriver;

public class PageBase {
  protected WebDriver driver;

  public PageBase(WebDriver driver) {
    super();
    this.driver = driver;
  }

  public String getTitle() {
    return driver.getTitle();
  }

  public String getCurrentURL() {
    return driver.getCurrentUrl();
  }
}
