package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest{

    @Test
    public void checkPage(){
        loginGood();
        Assert.assertEquals(productsPage.getTitle(),"Products");
    }

    @Test
    public void checkCountProducts() {
        loginGood();
        Assert.assertEquals(productsPage.getItemCount(),6);
    }

    @Test
    public void clickToProducts() {
        loginGood();
        productsPage.clickProduct(1);
        Assert.assertEquals(productsPage.buttonBackToProduct(),"Back to products");
    }

    @Test
    public void addProduct() {
    loginGood();
    productsPage.clickProduct(2);
    productsPage.clicklButtonAdd();
    Assert.assertEquals(productsPage.buttonDel(),"Remove");
    }

    @Test
    public void delProduct() {
        loginGood();
        productsPage.clickProduct(4);
        productsPage.clicklButtonAdd();
        productsPage.clicklButtomDel();
        Assert.assertEquals(productsPage.buttonAdd(),"Add to cart");
    }

    @Test
    public void clickToBadge() {
        loginGood();
        productsPage.clickBadge();
        Assert.assertEquals(productsPage.getButtonBackBadge(),"Continue Shopping");
    }
    @Test
    public void getCountBadges() {
        loginGood();
        productsPage.addProduct(1);
        productsPage.addProduct(2);
        productsPage.addProduct(0);
        productsPage.delProduct();
        Assert.assertEquals(productsPage.getCountBadge(),"2");
    }
}
