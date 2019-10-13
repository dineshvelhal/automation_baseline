package com.dineshvelhal.tests;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestConfig {
  public static String chromeDriverPath = "E:\\SeleniumDrivers\\chromedriver_v77.exe";

  public static WebDriver getDriver(String browser, String remote, String gridURL)
      throws MalformedURLException {
    WebDriver driver;

    if (remote.equalsIgnoreCase("yes")) {
      if (browser.equalsIgnoreCase("chrome")) {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.LINUX);
        driver = new RemoteWebDriver(new URL(gridURL), capabilities);
      } else {
        throw new WebDriverException("Only Chrome browser is supported at present");
      }
    } else {
      setDriverServerPath(browser);
      driver = new ChromeDriver();
    }

    return driver;
  }

  public static void setDriverServerPath(String browser) {
    if (browser.equalsIgnoreCase("chrome")) {
      System.setProperty("webdriver.chrome.driver", chromeDriverPath);
    } else {
      throw new WebDriverException("Only Chrome browser is supported at present");
    }
  }

}
