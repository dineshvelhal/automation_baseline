package com.dineshvelhal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {
  private By usernameField = By.id("user");
  private By passwordField = By.id("password");
  private By loginButton = By.id("login");

  private By loginErrorMsg = By.id("message");

  private By registerLink = By.xpath("//a[@href='register.html']");

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  public ConfirmationPage login(String userName, String password) {
    driver.findElement(usernameField).sendKeys(userName);
    driver.findElement(passwordField).sendKeys(password);
    driver.findElement(loginButton).click();

    return new ConfirmationPage(driver);
  }

  public String getLoginErrorMsg() {
    return driver.findElement(loginErrorMsg).getText();
  }

  public RegistrationPage gotoRegistration() {
    driver.findElement(registerLink).click();

    return new RegistrationPage(driver);
  }
}
