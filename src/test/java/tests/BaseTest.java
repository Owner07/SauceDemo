package tests;

import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import lombok.extern.log4j.Log4j2;
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

import java.util.Collections;
import java.util.HashMap;

@Log4j2
@Listeners({TestListener.class, AllureTestNg.class})
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
        log.info("Initialization browser");
        if(browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            HashMap<String, Object> chromePrefs = new HashMap<>();
            chromePrefs.put("credentials_enable_service", false);
            chromePrefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", chromePrefs);
            options.addArguments("--incognito");
            options.addArguments("--headless");
            options.addArguments("--disable-blink-features=AutomationControlled");
            options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            options.setExperimentalOption("useAutomationExtension", false);
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
            options1.addArguments("--headless");
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

    @Description("Выход из драйвера")
    @Epic("E2E")
    @Story("Закрытие драйвера")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Вейт Владимир")
//    @AfterMethod(alwaysRun = true, description = "Обязательное закрытие драйвера")
//    public void tearDown(ITestResult result) {
//        log.info("Closed browser");
//        DriverManager.quitDriver();
//    }

    protected LoginPage getLoginPage() {
        return loginPage.get();
    }

    protected ProductsPage getProductsPage() {
        return productsPage.get();
    }

    protected CartPage getCartPage() {
        return cartPage.get();
    }
    @Description("Удачный логин")
    @Epic("E2E")
    @Story("Выход из браузера")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Вейт Владимир")
    public ProductsPage loginGood() {
        log.info("Opening browser");
        getLoginPage().open();
        getLoginPage().login("standard_user", "secret_sauce");
        return new ProductsPage(DriverManager.getDriver());
    }

    public CartPage inCart() {
        log.info("Opening page in cart");
        getProductsPage().clickBadge();
        return new CartPage(DriverManager.getDriver());
    }

    public ProductsPage addProdBase() {
        log.info("Adding products in cart");
        getProductsPage().clicklButtonAdd();
        return new ProductsPage(DriverManager.getDriver());
    }
}
