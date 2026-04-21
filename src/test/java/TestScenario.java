import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;

public class TestScenario {
    WebDriver driver;

    @Test
    public void scenario() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        SoftAssert softAssert = new SoftAssert();
        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
        String a = "standard_user";
        String w = "secret_sauce";
        WebElement user = driver.findElement(By.name("user-name"));
        user.sendKeys(a);
        WebElement pass = driver.findElement(By.name("password"));
        pass.sendKeys(w);
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-bolt-t-shirt")).click();
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
        String name = driver.findElement(By.cssSelector("[data-test=inventory-item-name]")).getText();
        softAssert.assertEquals(name, "Sauce Labs Bolt T-Shirt");
        String durtyPrice = driver.findElement(By.cssSelector("[data-test=inventory-item-price]")).getText();
        String price = durtyPrice.replaceAll("[^0-9.]", "");
        softAssert.assertEquals(price, "15.99");
        softAssert.assertAll();
    }

    @AfterMethod
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}

