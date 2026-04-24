package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void checkLoginWithPositive() {
        driver.get("https://www.saucedemo.com/");
        String name = "standard_user";
        String passWord = "secret_sauce";
        WebElement user = driver.findElement(By.name("user-name"));
        user.sendKeys(name);
        WebElement pass = driver.findElement(By.name("password"));
        pass.sendKeys(passWord);
        driver.findElement(By.id("login-button")).click();
        String title = driver.findElement(By.cssSelector("[data-test=title]")).getText();
        Assert.assertEquals(title,"Products");
    }
}
