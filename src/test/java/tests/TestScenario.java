package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.DriverManager;

public class
TestScenario extends BaseTest{

    SoftAssert softAssert = new SoftAssert();

    @Test (testName = "Сценарий добавления продукта в корзину",
            description = "Логин,добавление продукта в корзину, переход в корзину, проверка стоимости продукта.")
    public void scenario() {
        getLoginPage().open();
        getLoginPage().login("standard_user","secret_sauce");
        DriverManager.getDriver().findElement(By.cssSelector("#add-to-cart-sauce-labs-bolt-t-shirt")).click();
        DriverManager.getDriver().findElement(By.cssSelector(".shopping_cart_link")).click();
        String name = DriverManager.getDriver().findElement(By.cssSelector("[data-test=inventory-item-name]")).getText();
        softAssert.assertEquals(name, "Sauce Labs Bolt T-Shirt");
        String durtyPrice = DriverManager.getDriver().findElement(By.cssSelector("[data-test=inventory-item-price]")).getText();
        String price = durtyPrice.replaceAll("[^0-9.]", "");
        softAssert.assertEquals(price, "15.99");
        softAssert.assertAll();
    }
}
