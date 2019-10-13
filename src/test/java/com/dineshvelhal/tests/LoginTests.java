package com.dineshvelhal.tests;

import static org.testng.Assert.assertEquals;
import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.dineshvelhal.pages.LoginPage;

public class LoginTests {
  WebDriver driver;
  LoginPage loginPage;
  String appUrl;

  @Test
  public void successful_login_test() {
    loginPage = new LoginPage(driver);

    assertEquals(loginPage.login("admin", "admin").getTitle(), "Confirmation1!");
  }

  @Test
  public void unsuccessful_login_test() {
    driver.navigate().to(appUrl);
    loginPage = new LoginPage(driver);

    assertEquals(loginPage.login("admin", "admin1").getTitle(), "Login");
    assertEquals(loginPage.getLoginErrorMsg(), "Incorrect username or password. Try again!!");
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

  }

  @AfterClass
  public void afterClass() {
    driver.quit();
    driver = null;
  }

}
