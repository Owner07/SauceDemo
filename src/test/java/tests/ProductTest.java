package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.AllureUtils;
import utils.DriverManager;

public class ProductTest extends BaseTest{

    @Test (testName = "Страница продуктов"
            ,description = "Успешный логин и проверка что находимся на странице продуктов")
    @Description("Проверка что находимся на странице продуктов")
    @Epic("E2E")
    @Feature("Страница продуктов")
    @Story("Проверка страницы продуктов")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("NL")
    @Issue("NL-B")
    @Owner("Вейт Владимир")
    public void checkPage(){
        loginGood();
        Assert.assertEquals(getProductsPage().getTitle(),"Products");
    }

    @Test (testName = "Количество продуктов"
            ,description = "Успешный логин и проверка что продуктов на странице 6")
    @Description("Проверка что продуктов на странице 6")
    @Epic("E2E")
    @Feature("Страница продуктов")
    @Story("Проверка количества продуктов")
    @Severity(SeverityLevel.MINOR)
    @TmsLink("NL")
    @Issue("NL-B")
    @Owner("Вейт Владимир")
    public void checkCountProducts() {
        loginGood();
        Assert.assertEquals(getProductsPage().getItemCount(),6);
    }

    @Description("Проверка что можем перейти на продукт со страницы продуктов")
    @Epic("E2E")
    @Feature("Страница продукта")
    @Story("Проверка страницы продукта")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("NL")
    @Issue("NL-B")
    @Owner("Вейт Владимир")
    @Test (testName = "Страница продукта номер 2"
            ,description = "Успешный логин и проверка что находимся на странице продукта")
    public void clickToProducts() {

        loginGood()
                .clickProduct(1);
        Assert.assertEquals(getProductsPage().buttonBackToProduct(),"Back to products");
    }

    @Test (testName = "Проверка кнопки добавить"
            ,description = "Успешный логин и проверка что кнопка добавить продукт кликается")
    @Description("Проверка что кликабельности кнопки дабавления продуктов")
    @Epic("E2E")
    @Feature("Кнопка добавить продукт")
    @Story("Проверка кнопки")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("NL")
    @Issue("NL-B")
    @Owner("Вейт Владимир")
    public void addProduct() {
    loginGood()
    .clickProduct(2)
    .clicklButtonAdd();
    Assert.assertEquals(getProductsPage().buttonDel(),"Remove");
    }

    @Test (testName = "Проверка кнопки добавить + удалить"
            ,description = "Успешный логин и проверка что кнопка добавить продукт и удалить кликается")
    @Description("Проверка  кликабельности кнопки дабавления  и удаления продуктов")
    @Epic("E2E")
    @Feature("Кнопка добавить/удалить продукт")
    @Story("Проверка кнопок")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("NL")
    @Issue("NL-B")
    @Owner("Вейт Владимир")
    public void delProduct() {
        loginGood()
        .clickProduct(4)
        .clicklButtonAdd()
        .clicklButtomDel();
        Assert.assertEquals(getProductsPage().buttonAdd(),"Add to cart");
    }

    @Test (testName = "Проверка кнопки корзины"
            ,description = "Успешный логин и проверка что кнопка корзины кликается")
    @Description("Проверка кликабельности кнопки корзины продуктов")
    @Epic("E2E")
    @Feature("Кнопка корзины продукт")
    @Story("Проверка кнопки корзины")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("NL")
    @Issue("NL-B")
    @Owner("Вейт Владимир")
    public void clickToBadge() {
        loginGood()
        .clickBadge();
        Assert.assertEquals(getProductsPage().getButtonBackBadge(),"Continue Shopping");
    }

    @Test (testName = "Проверка добавления продуктов в корзину"
            ,description = "Успешный логин и проверка что 3 продукта добавились и один удалился из корзины")
    @Description("Проверка дабавления продуктов и удаления")
    @Epic("E2E")
    @Feature("Добавить и удалить продукт")
    @Story("Проверка взаимодействия с продуктами")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("NL")
    @Issue("NL-B")
    @Owner("Вейт Владимир")
    public void getCountBadges() {
        loginGood()
        .addProduct(1)
        .addProduct(2)
        .addProduct(0);
        getCartPage().delProduct();
        Assert.assertEquals(getProductsPage().getCountBadge(),"2");
    }
}
