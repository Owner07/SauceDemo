package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void checkLoginWithPositive() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        Assert.assertEquals(productsPage.getTitle(),"Products");
    }

    @Test
    public void checkLoginWithEmptyPassword() {
        loginPage.open();
        loginPage.login("standard_user","");
        Assert.assertEquals(loginPage.errorMessage(),"Epic sadface: Password is required");
    }

    @Test
    public void checkLoginWithEmptyUserName() {
        loginPage.open();
        loginPage.login("","secret_sauce");
        Assert.assertEquals(loginPage.errorMessage(),"Epic sadface: Username is required");
    }

    @Test
    public void checkLoginWithNoAuthUser() {
        loginPage.open();
        loginPage.login("123","123");
        Assert.assertEquals(loginPage.errorMessage(),"Epic sadface: Username and password do not match any user in this service");
    }
}
