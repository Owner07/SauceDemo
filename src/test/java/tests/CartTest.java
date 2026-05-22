package tests;

import io.qameta.allure.*;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j2
public class CartTest extends BaseTest{

    @Test (testName = "Проверка страницы корзины"
            ,description = "Успешный логин, переход на страницу корзины и проверка что находимся на страницы корзины")
    @Description("Проверка что находимся на странице корзины")
    @Epic("E2E")
    @Feature("Страница корзины")
    @Story("Проверка кнопки перехода в корзину")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("NL")
    @Issue("NL-B")
    @Owner("Вейт Владимир")
    public void cartPageTest() {
        log.info("Checking cart page");
        loginGood();
        inCart();
        Assert.assertEquals(getCartPage().getTitleCart(), "Your Cart");
    }

    @Test (testName = "Проверка страницы чекаута"
            ,description = "Успешный логин, переход на страницу, клик по кнопке чекаута, проверка перехода")
    @Description("Проверка что находимся на странице чекаута")
    @Epic("E2E")
    @Feature("Страница чекаута")
    @Story("Проверка кнопки перехода в чекаута")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("NL")
    @Issue("NL-B")
    @Owner("Вейт Владимир")
    public void checkCkeck() {
        log.info("Checking page cart");
        loginGood();
        inCart()
        .clickCheckout();
        Assert.assertEquals(getCartPage().getCheckoutTitle(), "Checkout: Your Information");
    }

    @Test (testName = "Проверка кнопки вернутся на страницу продуктов"
            ,description = "Успешный логин, переход на страницу корзины, клик по кнопке возврата на страницу продуктов")
    @Description("Проверка что находимся на странице продуктов, переход из корзины")
    @Epic("E2E")
    @Feature("Страница продуктов, со страницы корзины")
    @Story("Проверка кнопки перехода в продукты")
    @Severity(SeverityLevel.MINOR)
    @TmsLink("NL")
    @Issue("NL-B")
    @Owner("Вейт Владимир")
    public void checkButtonBackToProduct() {
        log.info("Checking opened page cart in page products");
        loginGood();
        inCart()
        .clickBackToCart();
        Assert.assertEquals(getCartPage().getTitleProduct(), "Products");
    }

    @Test (testName = "Проверка перехода на продукт из корзины"
            ,description = "Успешный логин,добавление 2ух продуктов, переход на страницу корзины" +
            " и проверка что успешно переходим на страницу продукта")
    @Description("Проверка что находимся на странице продуктов, переход из корзины")
    @Epic("E2E")
    @Feature("Страница продуктов, со страницы корзины")
    @Story("Проверка кнопки перехода в продукты")
    @Severity(SeverityLevel.MINOR)
    @TmsLink("NL")
    @Issue("NL-B")
    @Owner("Вейт Владимир")
    public void checkClicklProductInCart() {
        log.info("Login and transition page products and adding products");
        loginGood();
        addProdBase();
        addProdBase();
        inCart()
        .clickProductToCart(1);
        Assert.assertEquals(getCartPage().getTitleToPageProduct(),"Sauce Labs Bike Light");
    }

    @Test (testName = "Проверка наполнения корзины"
            ,description = "Успешный логин,добавление 2ух продуктов, переход на страницу корзины, удаление 1 продукта" +
            "и проверка что в корзине 1 товар")
    @Description("Проверка что находимся на странице корзины, взаимодействие с продуктами")
    @Epic("E2E")
    @Feature("Страница корзины + добавление продукта")
    @Story("Добавление продуктов")
    @Severity(SeverityLevel.MINOR)
    @TmsLink("NL")
    @Issue("NL-B")
    @Owner("Вейт Владимир")
    public void checkDelProduct() {
        log.info("Login and transition page products and adding products and deleted");
        loginGood();
        addProdBase();
        addProdBase();
        inCart()
        .delProduct();
        Assert.assertEquals(getCartPage().checkBadge(),"1");
    }
}
