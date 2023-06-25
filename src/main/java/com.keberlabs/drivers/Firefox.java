package com.keberlabs.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements DriverStrategy {
    @Override

    public WebDriver setStrategy() {
        System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver"); // Linux
        return new FirefoxDriver();
    }

}
