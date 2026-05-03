package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;
import java.util.HashMap;

public class BaseTest {

    // каждый поток имеет будет брать экземпляр LoginPage
    private ThreadLocal<LoginPage> loginPage = new ThreadLocal<>();
    private ThreadLocal<ProductsPage> productsPage = new ThreadLocal<>();
    private ThreadLocal<CartPage> cartPage = new ThreadLocal<>();

    @Parameters ({"browser"})
    @BeforeMethod (alwaysRun = true, description = "Настройки для драйвера")
    public void setUP(@Optional("chrome") String browser) {
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
            EdgeDriver driver1 = new EdgeDriver();
            DriverManager.setDriver(driver1);
            // создаем page objects и сохраняем в ThreadLocal
            loginPage.set(new LoginPage(driver1));
            productsPage.set(new ProductsPage(driver1));
            cartPage.set(new CartPage(driver1));
        }
    }

    @AfterMethod(alwaysRun = true, description = "Обязательное закрытие драйвера")
    public void tearDown() {
        DriverManager.quitDriver();  // Закрываем драйвер текущего потока
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
