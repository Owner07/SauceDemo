package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By USERNAME_FIELD = By.cssSelector("[id=user-name]");
    private final By USERPASS_FIELD = By.cssSelector("[id=password]");
    private final By LOGIN_BUTTON = By.cssSelector("[id=login-button]");
    private final By ERROR_MASSAGE = By.cssSelector("[data-test=error]");

    @Step ("Открытие начальной страницы Сауз демо")
    public LoginPage open(){
        log.info("Open page in '{}'", BASE_URL);
        driver.get(BASE_URL);
        return this;
    }

    public LoginPage isPageOpen(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        return this;
    }

    @Step ("Введение кредов на странице логина с именем: '{user}' и паролем: '{password}'")
    public ProductsPage login(String user, String password) {
        log.info("Login with credential login: '{}' and password: '{}'", user, password);;
        driver.findElement(USERNAME_FIELD).sendKeys(user);
        driver.findElement(USERPASS_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new ProductsPage(driver);
    }

//    public void login2() {
//        driver.get("https://admin-demo.nopcommerce.com/login");
//        driver.findElement(By.xpath("//*[text()='Log in']")).click();
//    }

    @Step ("Получение ошибки при неудачном логине")
    public String errorMessage() {
        return driver.findElement(ERROR_MASSAGE).getText();
    }
}
