package com.keberlabs.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeWindows implements DriverStrategy {
    @Override

    public WebDriver setStrategy() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe"); // Windows

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--no-sandbox");
        return new ChromeDriver(options);
    }

}
