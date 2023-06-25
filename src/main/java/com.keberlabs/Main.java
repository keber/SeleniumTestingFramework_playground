package com.keberlabs;

import com.keberlabs.drivers.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


public class Main {

    public static void main(String[] args){

        //System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
/*
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);


        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.wikipedia.org/");
        wait.until(visibilityOfElementLocated(By.xpath("//*[@id=\"js-link-box-pt\"]/strong")));
        // SELECTORES
        // Por ID <- más rápida
        String text = driver.findElement(By.id("js-link-box-es")).getText();
        System.out.println("1: " + text);

        // por xpath <- sirve para cualquier elemento del DOM
        text = driver.findElement(By.xpath("//*[@id=\"js-link-box-es\"]")).getText();
        System.out.println("2: " + text);

        // selectores CSS <- para cualquier elemento
        text = driver.findElement(By.cssSelector("#js-link-box-es")).getText();
        System.out.println("3: " + text);

        text = driver.findElement(By.xpath("/html/body/div[2]/div[2]/a/strong")).getText();
        System.out.println("4: " + text);

        // Buscar un texto
        WebElement searchBox = driver.findElement(By.id("searchInput"));
        String busqueda = "gatos";
        searchBox.sendKeys(busqueda);

        WebElement buttonSearch = driver.findElement(By.cssSelector("#search-form > fieldset > button"));
        buttonSearch.click();

        WebElement titleSearchedPage = driver.findElement(By.cssSelector("#firstHeading > span"));
        if (titleSearchedPage.getText().equals("Felis silvestris catus")){
            System.out.println(titleSearchedPage.getText());
            System.out.println("Exito! buscamos gatos");
        }
        else {
            System.out.println(":C");
        }

        driver.close();
        driver.quit();
*/

        DriverSingleton driverSingleton = DriverSingleton.getInstance("ChromeWindows");
        WebDriver driver = driverSingleton.getDriver();

        driver.get("https://www.wikipedia.org/");
        WebElement searchBox = driver.findElement(By.id("searchInput"));
        String busqueda = "gatos";
        searchBox.sendKeys(busqueda);

        WebElement buttonSearch = driver.findElement(By.cssSelector("#search-form > fieldset > button"));
        buttonSearch.click();

        driverSingleton.closeDriver();

    }
}
