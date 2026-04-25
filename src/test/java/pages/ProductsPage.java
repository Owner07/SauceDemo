package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage{

    private final By TITLE = By.cssSelector("[data-test=title]");
    private final By PRODUCT = By.cssSelector("[data-test='inventory-item-name']");
    private final By BUTTON_ADD = By.cssSelector("[data-test^='add-to-cart']");
    private final By BUTTON_DEL = By.cssSelector("[data-test^='remove']");
    private final By BADGE = By.cssSelector("[data-test='shopping-cart-link']");
    private final By BUTTON_BACK = By.cssSelector("[id='back-to-products']");
    private final By BUTTON_BACK_IN_BADGE = By.cssSelector("[id='continue-shopping']");
    private final By BUTTON_ADD_PAGE = By.cssSelector(".btn_inventory");
    private final By BUTTON_DEL_PAGE = By.cssSelector("");



    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public int getItemCount() {
    return driver.findElements(PRODUCT).size();
    }

    public void clickProduct(int i) {
        List<WebElement> items = driver.findElements(PRODUCT);
        items.get(i).click();
    }

    public String buttonBackToProduct() {
        return driver.findElement(BUTTON_BACK).getText();
    }
    public String buttonAdd() {
        return driver.findElement(BUTTON_ADD).getText();
    }

    public void clicklButtonAdd() {
        driver.findElement(BUTTON_ADD).click();
    }

    public String buttonDel() {
        return driver.findElement(BUTTON_DEL).getText();
    }

    public void clicklButtomDel() {
        driver.findElement(BUTTON_DEL).click();
    }

    public void addProduct(int i) {
        List<WebElement> items = driver.findElements(BUTTON_ADD_PAGE);
        items.get(i).click();
    }

    public String getCountBadge(){
        WebElement badge = driver.findElement(BADGE);
        return badge.isDisplayed() ? badge.getText() : "0";
    }

    public void clickBadge() {
        driver.findElement(BADGE).click();
    }

    public String getButtonBackBadge() {
        return driver.findElement(BUTTON_BACK_IN_BADGE).getText();
    }

    public void delProduct() {
        driver.findElement(BUTTON_DEL).click();
    }
}
