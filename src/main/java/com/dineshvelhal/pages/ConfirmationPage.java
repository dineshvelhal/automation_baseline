package com.dineshvelhal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage extends PageBase {
  private By confirmationMessage = By.cssSelector("body > div > h1");

  public ConfirmationPage(WebDriver driver) {
    super(driver);
    this.driver = driver;
  }

  public String getMessage() {
    return driver.findElement(confirmationMessage).getText();
  }

}
