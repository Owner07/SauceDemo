package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest{

    @Test
    public void cartPageTest() {
        loginGood();
        inCart();
        Assert.assertEquals(getCartPage().getTitleCart(), "Your Cart");
    }

    @Test
    public void checkCkeck() {
        loginGood();
        inCart();
        getCartPage().clickCheckout();
        Assert.assertEquals(getCartPage().getCheckoutTitle(), "Checkout: Your Information");
    }

    @Test
    public void checkButtonBackToProduct() {
        loginGood();
        inCart();
        getCartPage().clickBackToCart();
        Assert.assertEquals(getCartPage().getTitleProduct(), "Products");
    }

    @Test
    public void checkClicklProductInCart() {
        loginGood();
        addProdBase();
        addProdBase();
        inCart();
        getCartPage().clickProductToCart(1);
        Assert.assertEquals(getCartPage().getTitleToPageProduct(),"Sauce Labs Bike Light");
    }

    @Test
    public void checkDelProduct() {
        loginGood();
        addProdBase();
        addProdBase();
        inCart();
        getCartPage().delProduct();
        Assert.assertEquals(getCartPage().checkBadge(),"1");
    }
}
