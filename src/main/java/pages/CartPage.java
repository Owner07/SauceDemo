package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage{

    private final By BUTTON_CHEKOUT = By.cssSelector("[id='checkout']");
    private final By BUTTON_BACK_IN_BADGE = By.cssSelector("[id='continue-shopping']");
    private final By CHECK_TITLE = By.cssSelector("[data-test='title']");
    private final By PRODUCT = By.cssSelector("[data-test='inventory-item-name']");
    private final By BUTTON_DEL = By.cssSelector("[data-test^='remove']");
    private final By TITLE_CART = By.cssSelector("[data-test='title']");
    private final By TITLE_CART_PRODUCT = By.cssSelector("[data-test='title']");
    private final By BADGE = By.cssSelector("[data-test='shopping-cart-link']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleCart() {
        return driver.findElement(TITLE_CART).getText();
    }

    public String getTitleProduct() {
        return driver.findElement(TITLE_CART_PRODUCT).getText();
    }

    public String getTitleToPageProduct() {
        return driver.findElement(PRODUCT).getText();
    }

    @Step ("Переход на страницу чекаута")
    public void clickCheckout() {
        driver.findElement(BUTTON_CHEKOUT).click();
    }

    public String getCheckoutTitle() {
        return driver.findElement(CHECK_TITLE).getText();
    }

    @Step ("Переход на страницу корзины")
    public void clickBackToCart() {
        driver.findElement(BUTTON_BACK_IN_BADGE).click();
    }

    @Step ("Переход на продукт из корзины под номером '{i}'")
    public void clickProductToCart(int i) {
        List<WebElement> items = driver.findElements(PRODUCT);
        items.get(i).click();
    }

    @Step ("Удаление продукта")
    public void delProduct() {
        driver.findElement(BUTTON_DEL).click();
    }

    public String checkBadge() {
        return driver.findElement(BADGE).getText();
    }
}
