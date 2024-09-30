package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    WebDriver driver;

    By firstNameField = By.id("firstName");
    By lastNameField = By.id("lastName");
    By addressField = By.id("address");
    By zipCodeField = By.id("zipCode");
    By submitOrderButton = By.id("submitOrder");

    By orderConfirmationMessage = By.xpath("//h1[contains(text(),'Order Confirmed')]");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillCheckoutForm(String firstName, String lastName, String address, String zipCode) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(zipCodeField).sendKeys(zipCode);
    }

    public void submitCheckout() {
        driver.findElement(submitOrderButton).click();
    }

    public boolean isOrderPlaced() {
        return driver.findElement(orderConfirmationMessage).isDisplayed();
    }

    public void submitCheckoutWithoutFilling() {
        driver.findElement(submitOrderButton).click();
    }

    public boolean isFieldValidationErrorsDisplayed() {
        return driver.findElements(By.cssSelector(".error-message")).size() > 0;
    }
}
