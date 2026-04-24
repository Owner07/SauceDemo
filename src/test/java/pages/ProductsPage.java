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



    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public int getItemCount() {
    return driver.findElements(PRODUCT).size();
    }

    public void addProduct(int i) {
        List<WebElement> items = driver.findElements(PRODUCT);
        items.get(i).findElement(BUTTON_ADD).click();
    }

    public void delProduct(int i) {
        List<WebElement> items = driver.findElements(PRODUCT);
        items.get(i).findElement(BUTTON_DEL).click();
    }

    public String getCountBadge(){
        WebElement badge = driver.findElement(BADGE);
        return badge.isDisplayed() ? badge.getText() : "0";
    }

}
