package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest{

    @Test (testName = "Страница продуктов"
            ,description = "Успешный логин и проверка что находимся на странице продуктов")
    public void checkPage(){
        loginGood();
        Assert.assertEquals(getProductsPage().getTitle(),"Products");
    }

    @Test (testName = "Количество продуктов"
            ,description = "Успешный логин и проверка что продуктов на странице 6")
    public void checkCountProducts() {
        loginGood();
        Assert.assertEquals(getProductsPage().getItemCount(),6);
    }

    @Test (testName = "Страница продукта номер 2"
            ,description = "Успешный логин и проверка что находимся на странице продукта")
    public void clickToProducts() {
        loginGood();
        getProductsPage().clickProduct(1);
        Assert.assertEquals(getProductsPage().buttonBackToProduct(),"Back to products");
    }

    @Test (testName = "Проверка кнопки добавить"
            ,description = "Успешный логин и проверка что кнопка добавить продукт кликается")
    public void addProduct() {
    loginGood();
    getProductsPage().clickProduct(2);
    getProductsPage().clicklButtonAdd();
    Assert.assertEquals(getProductsPage().buttonDel(),"Remove");
    }

    @Test (testName = "Проверка кнопки добавить + удалить"
            ,description = "Успешный логин и проверка что кнопка добавить продукт и удалить кликается")
    public void delProduct() {
        loginGood();
        getProductsPage().clickProduct(4);
        getProductsPage().clicklButtonAdd();
        getProductsPage().clicklButtomDel();
        Assert.assertEquals(getProductsPage().buttonAdd(),"Add to cart");
    }

    @Test (testName = "Проверка кнопки корзины"
            ,description = "Успешный логин и проверка что кнопка корзины кликается")
    public void clickToBadge() {
        loginGood();
        getProductsPage().clickBadge();
        Assert.assertEquals(getProductsPage().getButtonBackBadge(),"Continue Shopping");
    }
    @Test (testName = "Проверка добавления продуктов в корзину"
            ,description = "Успешный логин и проверка что 3 продукта добавились и один удалился из корзины")
    public void getCountBadges() {
        loginGood();
        getProductsPage().addProduct(1);
        getProductsPage().addProduct(2);
        getProductsPage().addProduct(0);
        getCartPage().delProduct();
        Assert.assertEquals(getProductsPage().getCountBadge(),"2");
    }
}
