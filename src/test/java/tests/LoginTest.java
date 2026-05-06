package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest{

    @Test(testName = "Позитивный логин",
            invocationCount = 3,
            threadPoolSize = 3,
    description = "Логин с валидными кредами")
    @Description ("Проверка логина с валидными кредами")
    @Epic("E2E")
    @Feature("Логин в SauceDemo")
    @Story("Позитивный логин")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PL")
    @Issue("PL-B")
    @Owner("Вейт Владимир")
    public void checkLoginWithPositive() {
        getLoginPage().open();
        getLoginPage().login("standard_user","secret_sauce");
        assertEquals(getProductsPage().getTitle(),"Products");
    }

    @DataProvider(name = "Тестовые данные для негативного логина", indices = {0, 2})
    public Object[][] loginData() {
        return new Object[][] {
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"test", "test", "Epic sadface: Username and password do not match any user in this service"}
        };
    }
    @Description ("Проверка логина с не валидными кредами")
    @Epic("E2E")
    @Feature("Логин в SauceDemo негатив")
    @Story("Негативный логин")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("NL")
    @Issue("NL-B")
    @Owner("Вейт Владимир")
    @Test (dataProvider = "Тестовые данные для негативного логина",testName = "Негативный логин ",
            description = "Ввод невалидный значений с помощью метода датапровайдер")
    public void negativeLogin(String user, String password, String errorMessage) {
        getLoginPage().open();
        getLoginPage().login(user, password);
        assertEquals(getLoginPage().errorMessage(), errorMessage);
    }
}
