package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.CheckoutPage;

public class CheckoutTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.bestbuy.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void validCheckout() {
        driver.findElement(By.xpath("//button[text()='Checkout']")).click();
        driver.findElement(By.id("card-number")).sendKeys("4111111111111111");
        driver.findElement(By.id("expiration-date")).sendKeys("12/25");
        driver.findElement(By.id("cvv")).sendKeys("123");
        driver.findElement(By.id("submit-payment")).click();
        
        boolean isOrderConfirmed = driver.findElement(By.xpath("//h1[text()='Order Confirmation']")).isDisplayed();
        Assert.assertTrue(isOrderConfirmed, "Order confirmation failed.");
    }

    @Test
    public void invalidCheckout() {
        driver.findElement(By.xpath("//button[text()='Checkout']")).click();
        driver.findElement(By.id("card-number")).sendKeys("1234567890123456"); // Invalid card number
        driver.findElement(By.id("submit-payment")).click();
        
        boolean isErrorDisplayed = driver.findElement(By.id("payment-error")).isDisplayed();
        Assert.assertTrue(isErrorDisplayed, "Error message should be displayed for invalid payment.");
    }
    @Test
    public void validCheckoutTest() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillCheckoutForm("John", "Doe", "validAddress", "validZipCode");
        checkoutPage.submitCheckout();

        Assert.assertTrue(checkoutPage.isOrderPlaced(), "Order should be placed successfully.");
    }
    @Test
    public void invalidPaymentDetailsTest() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillPaymentDetails("InvalidCardNumber", "InvalidCVV");

        Assert.assertTrue(checkoutPage.isPaymentErrorDisplayed(), "Payment error message should be displayed.");
    }
    @Test
    public void blankCheckoutFormTest() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.submitCheckoutWithoutFilling();

        Assert.assertTrue(checkoutPage.isFieldValidationErrorsDisplayed(), "Field validation error messages should be displayed.");
    }
    

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
