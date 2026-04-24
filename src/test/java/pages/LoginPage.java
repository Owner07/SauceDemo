package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By USERNAME_FIELD = By.cssSelector("[id=user-name]");
    private final By USERPASS_FIELD = By.cssSelector("[id=password]");
    private final By LOGIN_BUTTON = By.cssSelector("[id=login-button]");
    private final By ERROR_MASSAGE = By.cssSelector("[data-test=error]");

    public void open(){
        driver.get("https://www.saucedemo.com/");
    }


}
