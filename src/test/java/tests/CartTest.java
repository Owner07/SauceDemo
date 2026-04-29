package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest{

    @Test (testName = "Проверка страницы корзины"
            ,description = "Успешный логин, переход на страницу корзины и проверка что находимся на страницы корзины")
    public void cartPageTest() {
        loginGood();
        inCart();
        Assert.assertEquals(getCartPage().getTitleCart(), "Your Cart");
    }

    @Test (testName = "Проверка страницы чекаута"
            ,description = "Успешный логин, переход на страницу, клик по кнопке чекаута, проверка перехода")
    public void checkCkeck() {
        loginGood();
        inCart();
        getCartPage().clickCheckout();
        Assert.assertEquals(getCartPage().getCheckoutTitle(), "Checkout: Your Information");
    }

    @Test (testName = "Проверка кнопки вернутся на страницу продуктов"
            ,description = "Успешный логин, переход на страницу корзины, клик по кнопке возврата на страницу продуктов")
    public void checkButtonBackToProduct() {
        loginGood();
        inCart();
        getCartPage().clickBackToCart();
        Assert.assertEquals(getCartPage().getTitleProduct(), "Products");
    }

    @Test (testName = "Проверка перехода на продукт из корзины"
            ,description = "Успешный логин,добавление 2ух продуктов, переход на страницу корзины" +
            " и проверка что успешно переходим на страницу продукта")
    public void checkClicklProductInCart() {
        loginGood();
        addProdBase();
        addProdBase();
        inCart();
        getCartPage().clickProductToCart(1);
        Assert.assertEquals(getCartPage().getTitleToPageProduct(),"Sauce Labs Bike Light");
    }

    @Test (testName = "Проверка наполнения корзины"
            ,description = "Успешный логин,добавление 2ух продуктов, переход на страницу корзины, удаление 1 продукта" +
            "и проверка что в корзине 1 товар")
    public void checkDelProduct() {
        loginGood();
        addProdBase();
        addProdBase();
        inCart();
        getCartPage().delProduct();
        Assert.assertEquals(getCartPage().checkBadge(),"1");
    }
}
