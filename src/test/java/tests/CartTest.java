package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest{

    @Test
    public void cartPageTest() {
        loginGood();
        inCart();
        Assert.assertEquals(cartPage.getTitleCart(), "Your Cart");
    }

    @Test
    public void checkCkeck() {
        loginGood();
        inCart();
        cartPage.clickCheckout();
        Assert.assertEquals(cartPage.getCheckoutTitle(), "Checkout: Your Information");
    }

    @Test
    public void checkButtonBackToProduct() {
        loginGood();
        inCart();
        cartPage.clickBackToCart();
        Assert.assertEquals(cartPage.getTitleProduct(), "Products");
    }

    @Test
    public void checkClicklProductInCart() {
        loginGood();
        addProdBase();
        addProdBase();
        inCart();
        cartPage.clickProductToCart(1);
        Assert.assertEquals(cartPage.getTitleToPageProduct(),"Sauce Labs Bike Light");
    }

    @Test
    public void checkDelProduct() {
        loginGood();
        addProdBase();
        addProdBase();
        inCart();
        cartPage.delProduct();
        Assert.assertEquals(cartPage.checkBadge(),"1");
    }
}
