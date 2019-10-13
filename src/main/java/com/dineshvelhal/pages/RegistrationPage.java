package com.dineshvelhal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage extends PageBase {

  private By firstNameField = By.name("first_name");
  private By lastNameField = By.name("last_name");
  private By emailField = By.name("email");
  private By passwordField = By.name("password");
  private By confirmPasswordField = By.name("confirm_password");
  private By acceptTermsCheckBox = By.name("terms");
  private By registerButton = By.name("submit_button");

  private By passwordErrorMessage = By.id("message");

  public RegistrationPage(WebDriver driver) {
    super(driver);
  }

  public ConfirmationPage register(String firstName, String lastName, String email, String password,
      String confirmPassword, boolean acceptTerms) {

    driver.findElement(firstNameField).sendKeys(firstName);
    driver.findElement(lastNameField).sendKeys(lastName);
    driver.findElement(emailField).sendKeys(email);
    driver.findElement(passwordField).sendKeys(password);
    driver.findElement(confirmPasswordField).sendKeys(confirmPassword);

    WebElement acceptTermsElement = driver.findElement(acceptTermsCheckBox);
    if (!acceptTermsElement.isSelected() && acceptTerms) {
      acceptTermsElement.click();
    }

    driver.findElement(registerButton).click();

    return new ConfirmationPage(driver);
  }

  public String getPasswordErrorMessage() {
    return driver.findElement(passwordErrorMessage).getText();
  }
}
