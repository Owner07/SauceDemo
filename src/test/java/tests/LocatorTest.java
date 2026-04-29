package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LocatorTest extends BaseTest{

    @Test (testName = "Чек локаторов",
    description = "Успешный логин + проверка локаторов")
    public void checkLocator() {
        getLoginPage().open();
        getLoginPage().login("standard_user","secret_sauce");
        DriverManager.getDriver().findElement(By.cssSelector("[data-test='inventory-item-name']"));
        DriverManager.getDriver().findElement(By.cssSelector("[class~='btn']"));
        DriverManager.getDriver().findElement(By.cssSelector("[id|='add-to-cart']"));
        DriverManager.getDriver().findElement(By.cssSelector("[id^='add-to-cart']"));
        DriverManager.getDriver().findElement(By.cssSelector("[id$='backpack']"));
        DriverManager.getDriver().findElement(By.cssSelector("[id*='sauce']"));
        DriverManager.getDriver().findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']"));
        DriverManager.getDriver().findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']"));
        DriverManager.getDriver().findElement(By.xpath("//div[contains(@data-test, 'inventory-item')]"));
        DriverManager.getDriver().findElement(By.xpath("//div[contains(text(), 'desired state')]"));
        DriverManager.getDriver().findElement(By.xpath("//div[contains(@class, 'item') and @data-test='inventory-item-name']"));
        DriverManager.getDriver().findElement(By.xpath("//div[contains(text(), 'T-Shirt')]//ancestor::div[@class='inventory_item']"));
        DriverManager.getDriver().findElement(By.xpath("//div[@class = 'inventory_item_img']//descendant::a[@id='item_0_img_link']"));
        DriverManager.getDriver().findElement(By.xpath("//div[contains(text(), 'T-Shirt')]/following::div[@data-test='inventory-item-price']"));
        DriverManager.getDriver().findElement(By.xpath("//div[@data-test='inventory-item-name']/parent::a/parent::div"));
        DriverManager.getDriver().findElements(By.xpath("//div[@data-test='inventory-item-name']/preceding::div[@data-test='inventory-item-name']"));
    }
}
