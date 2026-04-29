package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LocatorTest extends BaseTest{

    @Test
    public void checkLocator() {

        loginPage.open();
        loginPage.login("standard_user","secret_sauce");

        driver.findElement(By.cssSelector("[data-test='inventory-item-name']"));
        driver.findElement(By.cssSelector("[class~='btn']"));
        driver.findElement(By.cssSelector("[id|='add-to-cart']"));
        driver.findElement(By.cssSelector("[id^='add-to-cart']"));
        driver.findElement(By.cssSelector("[id$='backpack']"));
        driver.findElement(By.cssSelector("[id*='sauce']"));
        driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']"));
        driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']"));
        driver.findElement(By.xpath("//div[contains(@data-test, 'inventory-item')]"));
        driver.findElement(By.xpath("//div[contains(text(), 'desired state')]"));
        driver.findElement(By.xpath("//div[contains(@class, 'item') and @data-test='inventory-item-name']"));
        driver.findElement(By.xpath("//div[contains(text(), 'T-Shirt')]//ancestor::div[@class='inventory_item']"));
        driver.findElement(By.xpath("//div[@class = 'inventory_item_img']//descendant::a[@id='item_0_img_link']"));
        driver.findElement(By.xpath("//div[contains(text(), 'T-Shirt')]/following::div[@data-test='inventory-item-price']"));
        driver.findElement(By.xpath("//div[@data-test='inventory-item-name']/parent::a/parent::div"));
        driver.findElements(By.xpath("//div[@data-test='inventory-item-name']/preceding::div[@data-test='inventory-item-name']"));
    }
}
