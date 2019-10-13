package com.dineshvelhal.tests;

import static org.testng.Assert.assertEquals;
import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.dineshvelhal.pages.ConfirmationPage;
import com.dineshvelhal.pages.LoginPage;
import com.dineshvelhal.pages.RegistrationPage;

public class RegistrationTests {
  WebDriver driver;
  LoginPage loginPage;
  RegistrationPage registrationPage;
  ConfirmationPage confirmationPage;
  String appUrl;

  @Test
  public void successful_registration_test() {
    confirmationPage = registrationPage.register("Dinesh", "Velhal", "dinesh@velhal", "password",
        "password", true);

    assertEquals(confirmationPage.getTitle(), "Confirmation!");
  }

  @Parameters({"browser", "remote", "gridurl", "appurl"})
  @BeforeClass
  public void beforeClass(String browser, String remote, String gridURL, String appurl)
      throws MalformedURLException {

    System.out.println("Browser=" + browser + " RemoteExecution=" + remote + " gridURL=" + gridURL
        + " appURL=" + appurl);

    appUrl = appurl;
    driver = TestConfig.getDriver(browser, remote, gridURL);
    driver.get(appUrl);

    loginPage = new LoginPage(driver);
    registrationPage = loginPage.gotoRegistration();
  }

  @AfterClass
  public void afterClass() {
    driver.quit();
    driver = null;
  }

}
