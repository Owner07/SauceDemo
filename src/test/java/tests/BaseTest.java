package tests;

import io.qameta.allure.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;
import utils.AllureUtils;
import utils.DriverManager;
import utils.TestListener;

import java.util.HashMap;

@Listeners({TestListener.class})
public class BaseTest {
    // каждый поток будет брать экземпляр страницы
    private ThreadLocal<LoginPage> loginPage = new ThreadLocal<>();
    private ThreadLocal<ProductsPage> productsPage = new ThreadLocal<>();
    private ThreadLocal<CartPage> cartPage = new ThreadLocal<>();

    @Parameters ({"browser"})
    @BeforeMethod (alwaysRun = true, description = "Настройки для драйвера")
    @Description("Инициализация драйвера + опции")
    @Epic("E2E")
    @Story("Инициализация + опции")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Вейт Владимир")
    public void setUP(@Optional("chrome") String browser, ITestContext iTestContext) {
        if(browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            HashMap<String, Object> chromePrefs = new HashMap<>();
            chromePrefs.put("credentials_enable_service", false);
            chromePrefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", chromePrefs);
            options.addArguments("--incognito");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-infobars");
            ChromeDriver driver = new ChromeDriver(options);
            DriverManager.setDriver(driver);
            // создаем page objects и сохраняем в ThreadLocal
            loginPage.set(new LoginPage(driver));
            productsPage.set(new ProductsPage(driver));
            cartPage.set(new CartPage(driver));
            iTestContext.setAttribute("driver", driver);
        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions options1 = new EdgeOptions();
            HashMap<String, Object> edgePrefs = new HashMap<>();
            edgePrefs.put("credentials_enable_service", false);
            edgePrefs.put("profile.password_manager_enabled", false);
            options1.setExperimentalOption("prefs", edgePrefs);
            options1.addArguments("--incognito");
            options1.addArguments("--disable-notifications");
            options1.addArguments("--disable-popup-blocking");
            options1.addArguments("--disable-infobars");
            EdgeDriver driver1 = new EdgeDriver(options1);
            DriverManager.setDriver(driver1);
            // создаем page objects и сохраняем в ThreadLocal
            loginPage.set(new LoginPage(driver1));
            productsPage.set(new ProductsPage(driver1));
            cartPage.set(new CartPage(driver1));
            iTestContext.setAttribute("driver", driver1);
        }
    }

    @AfterMethod(alwaysRun = true, description = "Обязательное закрытие драйвера")
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            AllureUtils.takeScreenshot(DriverManager.getDriver());
        }
        DriverManager.quitDriver();
    }

    protected LoginPage getLoginPage() {
        return loginPage.get();
    }

    protected ProductsPage getProductsPage() {
        return productsPage.get();
    }

    protected CartPage getCartPage() {
        return cartPage.get();
    }
    @Description("Закрытие браузера")
    @Epic("E2E")
    @Story("Выход из браузера")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Вейт Владимир")
    public void loginGood() {
        getLoginPage().open();
        getLoginPage().login("standard_user", "secret_sauce");
    }

    public void inCart() {
        getProductsPage().clickBadge();
    }

    public void addProdBase() {
        getProductsPage().clicklButtonAdd();
    }
}
