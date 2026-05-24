package tests;

import io.qameta.allure.*;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Log4j2
public class LoginTest extends BaseTest {

    @Test(testName = "Позитивный логин",
            invocationCount = 1,
            threadPoolSize = 1,
            description = "Логин с валидными кредами")
    @Description("Проверка логина с валидными кредами")
    @Epic("E2E")
    @Feature("Логин в SauceDemo")
    @Story("Позитивный логин")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PL")
    @Issue("PL-B")
    @Owner("Вейт Владимир")
    public void checkLoginWithPositive() {
        log.info("Check positive login");
        getLoginPage().open()
                .login(user, password);
        assertEquals(getProductsPage().getTitle(), "Products");
    }

    @DataProvider(name = "Тестовые данные для негативного логина", indices = {0, 2})
    public Object[][] loginData() {
        return new Object[][]{
                {"", password, "Epic sadface: Username is required"},
                {user, "", "Epic sadface: Password is required"},
                {"test", "test", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Description("Проверка логина с не валидными кредами")
    @Epic("E2E")
    @Feature("Логин в SauceDemo негатив")
    @Story("Негативный логин")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("NL")
    @Issue("NL-B")
    @Owner("Вейт Владимир")
    @Test(dataProvider = "Тестовые данные для негативного логина", testName = "Негативный логин ",
            description = "Ввод невалидный значений с помощью метода датапровайдер")

    public void negativeLogin(String user, String password, String errorMessage) {
        log.info("Check negative login");
        getLoginPage().open()
                .login(user, password);
        assertEquals(getLoginPage().errorMessage(), errorMessage);
    }
}
