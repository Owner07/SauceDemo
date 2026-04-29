package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest{

    @Test
    public void checkPage(){
        loginGood();
        Assert.assertEquals(getProductsPage().getTitle(),"Products");
    }

    @Test
    public void checkCountProducts() {
        loginGood();
        Assert.assertEquals(getProductsPage().getItemCount(),6);
    }

    @Test
    public void clickToProducts() {
        loginGood();
        getProductsPage().clickProduct(1);
        Assert.assertEquals(getProductsPage().buttonBackToProduct(),"Back to products");
    }

    @Test
    public void addProduct() {
    loginGood();
    getProductsPage().clickProduct(2);
    getProductsPage().clicklButtonAdd();
    Assert.assertEquals(getProductsPage().buttonDel(),"Remove");
    }

    @Test
    public void delProduct() {
        loginGood();
        getProductsPage().clickProduct(4);
        getProductsPage().clicklButtonAdd();
        getProductsPage().clicklButtomDel();
        Assert.assertEquals(getProductsPage().buttonAdd(),"Add to cart");
    }

    @Test
    public void clickToBadge() {
        loginGood();
        getProductsPage().clickBadge();
        Assert.assertEquals(getProductsPage().getButtonBackBadge(),"Continue Shopping");
    }
    @Test
    public void getCountBadges() {
        loginGood();
        getProductsPage().addProduct(1);
        getProductsPage().addProduct(2);
        getProductsPage().addProduct(0);
        getCartPage().delProduct();
        Assert.assertEquals(getProductsPage().getCountBadge(),"2");
    }
}
