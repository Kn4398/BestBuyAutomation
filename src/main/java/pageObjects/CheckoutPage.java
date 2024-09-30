package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    WebDriver driver;

    // Locators for the checkout page elements
    By firstNameField = By.id("firstName");
    By lastNameField = By.id("lastName");
    By addressField = By.id("address");
    By zipCodeField = By.id("zipCode");
    By submitOrderButton = By.id("submitOrder");

    By orderConfirmationMessage = By.xpath("//h1[contains(text(),'Order Confirmed')]");

    // Constructor
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to fill out the checkout form
    public void fillCheckoutForm(String firstName, String lastName, String address, String zipCode) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(zipCodeField).sendKeys(zipCode);
    }

    // Method to submit the checkout form
    public void submitCheckout() {
        driver.findElement(submitOrderButton).click();
    }

    // Method to check if the order was placed successfully
    public boolean isOrderPlaced() {
        return driver.findElement(orderConfirmationMessage).isDisplayed();
    }

    // Method to submit the checkout without filling any field
    public void submitCheckoutWithoutFilling() {
        driver.findElement(submitOrderButton).click();
    }

    // Method to check if field validation errors are displayed
    public boolean isFieldValidationErrorsDisplayed() {
        // Assuming error messages appear in some form of alert or near the fields
        return driver.findElements(By.cssSelector(".error-message")).size() > 0;
    }
}
