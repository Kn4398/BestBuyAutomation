package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.BasePage;
import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.ProductPage;

public class HomePageTest extends BasePage {

    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser) {
        driver = initializeDriver(browser);
        driver.get("https://www.bestbuy.com/");
    }

    @Test
    public void searchProductTest() {
        HomePage homePage = new HomePage(driver);
        homePage.searchProduct("Laptop");

        ProductPage productPage = new ProductPage(driver);
        Assert.assertTrue(productPage.isProductDisplayed(), "Products should be displayed.");
    }
    @Test
    public void searchValidProductTest() {
        HomePage homePage = new HomePage(driver);
        homePage.searchProduct("Smartphone");

        ProductPage productPage = new ProductPage(driver);
        Assert.assertTrue(productPage.isProductDisplayed(), "Product should be displayed.");
    }
    @Test
    public void searchInvalidProductTest() {
        HomePage homePage = new HomePage(driver);
        homePage.searchProduct("InvalidProduct12345");

        ProductPage productPage = new ProductPage(driver);
        Assert.assertFalse(productPage.isProductDisplayed(), "No products should be displayed.");
    }
    @Test
    public void addProductToCartTest() {
        ProductPage productPage = new ProductPage(driver);
        productPage.selectProduct("Smartphone");
        productPage.addToCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isProductInCart("Smartphone"), "Product should be added to the cart.");
    }
    @Test
    public void addOutOfStockProductToCartTest() {
        ProductPage productPage = new ProductPage(driver);
        productPage.selectProduct("OutOfStockProduct");
        productPage.addToCart();

        Assert.assertTrue(productPage.isOutOfStockErrorDisplayed(), "Error message should be displayed for out-of-stock product.");
    }
    @Test
    public void removeProductFromCartTest() {
        CartPage cartPage = new CartPage(driver);
        cartPage.removeProduct("Smartphone");

        Assert.assertFalse(cartPage.isProductInCart("Smartphone"), "Product should be removed from the cart.");
    }



    @AfterMethod
    public void teardown() {
        closeBrowser();
    }
}
