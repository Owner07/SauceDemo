import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.HashMap;

public class LocatorTest {
    WebDriver driver;

    @Test
    public void checkLocator() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
        String q = "standard_user";
        String w = "secret_sauce";
        driver.findElement(By.id("user-name"));
        driver.findElement(By.name("user-name"));
        driver.findElement(By.className("login_credentials_wrap-inner"));
        driver.findElement(By.tagName("h4"));
        driver.findElement(By.cssSelector(".login_password"));
        driver.findElement(By.cssSelector(".submit-button.btn_action"));
        driver.findElement(By.cssSelector(".login_credentials_wrap .login_credentials_wrap-inner"));
        driver.findElement(By.cssSelector("#login-button"));
        driver.findElement(By.cssSelector("br"));
        driver.findElement(By.cssSelector("div.login_credentials"));
        driver.findElement(By.cssSelector("[data-test='username']"));
        WebElement user = driver.findElement(By.name("user-name"));
        user.sendKeys(q);
        WebElement pass = driver.findElement(By.name("password"));
        pass.sendKeys(w);
        driver.findElement(By.id("login-button")).click();
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
    @AfterMethod
    public void quit(){
        if(driver != null){
            driver.quit();
        }
    }
}