package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestScenario extends BaseTest{

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void scenario() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
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
