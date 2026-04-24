package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestScenario extends BaseTest{

    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void scenario() {

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
}

