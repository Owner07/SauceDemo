package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@Log4j2
public class ProductsPage extends BasePage{

    private final By TITLE = By.cssSelector("[data-test=title]");
    private final By PRODUCT = By.cssSelector("[data-test='inventory-item-name']");
    private final By BUTTON_ADD = By.cssSelector("[data-test^='add-to-cart']");
    private final By BUTTON_DEL = By.cssSelector("[data-test^='remove']");
    private final By BADGE = By.cssSelector("[data-test='shopping-cart-link']");
    private final By BUTTON_BACK = By.cssSelector("[id='back-to-products']");
    private final By BUTTON_BACK_IN_BADGE = By.cssSelector("[id='continue-shopping']");
    private final By BUTTON_ADD_PAGE = By.cssSelector(".btn_inventory");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public int getItemCount() {
    return driver.findElements(PRODUCT).size();
    }

    @Step ("Нахождение продукта и переход на него")
    public ProductsPage clickProduct(int i) {
        log.info("Finding and adding product number '{}'", i);
        List<WebElement> items = driver.findElements(PRODUCT);
        items.get(i).click();
        return this;
    }

    public String buttonBackToProduct() {
        return driver.findElement(BUTTON_BACK).getText();
    }

    public String buttonAdd() {
        return driver.findElement(BUTTON_ADD).getText();
    }

    @Step ("Нажатие на кнопку добавить продукт")
    public ProductsPage clicklButtonAdd() {
        log.info("Adding product");
        driver.findElement(BUTTON_ADD).click();
        return this;
    }

    public String buttonDel() {
        return driver.findElement(BUTTON_DEL).getText();
    }

    @Step ("Нажатие на кнопку удалить продукт")
    public ProductsPage clicklButtomDel() {
        log.info("Deleted product");
        driver.findElement(BUTTON_DEL).click();
        return this;
    }

    @Step ("Добавление продукта с номером: '{i}'")
    public ProductsPage addProduct(int i) {
        log.info("Adding product in number '{}'", i);
        List<WebElement> items = driver.findElements(BUTTON_ADD_PAGE);
        items.get(i).click();
        return this;
    }

    @Step ("Сравнение количества продуктов в корзине")
    public String getCountBadge(){
        log.info("Comparison quantity product in cart");
        WebElement badge = driver.findElement(BADGE);
        return badge.isDisplayed() ? badge.getText() : "0";
    }

    @Step ("Переход со страницы продуктов в корзину")
    public CartPage clickBadge() {
        log.info("Transition page in cart");
        driver.findElement(BADGE).click();
        return new CartPage(driver);
    }

    public String getButtonBackBadge() {
        return driver.findElement(BUTTON_BACK_IN_BADGE).getText();
    }

    @Step ("Удаление продукта из корзины")
    public CartPage delProduct() {
        log.info("Deleted products in cart");
        driver.findElement(BUTTON_DEL).click();
        return new CartPage(driver);
    }
}
