package com.keberlabs;

import com.keberlabs.drivers.DriverSingleton;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class MainTest {
    static WebDriver driver;
    @BeforeAll
    static void initializeDriver(){
        DriverSingleton driverSingleton = DriverSingleton.getInstance("Chrome");
        WebDriver driver = driverSingleton.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Maximizar la ventana
        driver.manage().window().maximize();
    }

    @Test
    void testWikipediaSearch(){
        driver.get("https://www.wikipedia.org/");
        // Buscar un texto
        WebElement searchBox = driver.findElement(By.id("searchInput"));
        String busqueda = "gatos";
        searchBox.sendKeys(busqueda);

        WebElement buttonSearch = driver.findElement(By.cssSelector("#search-form > fieldset > button"));
        buttonSearch.click();

        WebElement titleSearchedPage = driver.findElement(By.cssSelector("#firstHeading > span"));
        assertEquals(titleSearchedPage.getText(),"Felis silvestris catus");
        assertEquals(driver.getCurrentUrl(), "https://es.wikipedia.org/wiki/Felis_silvestris_catus");

    }

    @Test
    void testKeberLabsRender(){
        driver.get("https://www.keberlabs.com");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(visibilityOfElementLocated(By.xpath("/html/body/nav[2]")));

        WebElement text = driver.findElement(By.xpath("/html/body/section[1]/div[1]/div/div/div/ul/li[1]/div/h1"));
        assertEquals(text.getText(),"Your App Website. Made Simple.", "No se encontró el texto principal.");
    }

    @AfterAll
    static void closeDriver(){
        driver.close();
        driver.quit();
    }
}