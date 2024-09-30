package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {
    WebDriver driver;

    // Locators for the payment page elements
    By cardNumberField = By.id("cardNumber");
    By cardNameField = By.id("cardName");
    By cardExpiryField = By.id("cardExpiry");
    By cardCVVField = By.id("cardCVV");
    By submitPaymentButton = By.id("submitPayment");

    By paymentErrorMessage = By.xpath("//div[contains(text(),'Payment failed')]");

    // Constructor
    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to enter payment details
    public void enterCardDetails(String cardNumber, String cardName, String cardExpiry, String cardCVV) {
        driver.findElement(cardNumberField).sendKeys(cardNumber);
        driver.findElement(cardNameField).sendKeys(cardName);
        driver.findElement(cardExpiryField).sendKeys(cardExpiry);
        driver.findElement(cardCVVField).sendKeys(cardCVV);
    }

    // Method to submit the payment
    public void submitPayment() {
        driver.findElement(submitPaymentButton).click();
    }

    // Method to check if the payment is successful
    public boolean isPaymentSuccessful() {
        // Assuming successful payment redirects or shows a success message
        return driver.getTitle().contains("Payment Success");
    }

    // Method to check if there's a payment error (e.g., invalid card, insufficient funds)
    public boolean isPaymentErrorDisplayed() {
        return driver.findElement(paymentErrorMessage).isDisplayed();
    }

    // Method to check if the card number is invalid
    public boolean isInvalidCardNumberErrorDisplayed() {
        // Assuming specific error message for invalid card numbers
        return driver.findElement(paymentErrorMessage).getText().contains("Invalid card number");
    }

    // Method to check for expired card error
    public boolean isExpiredCardErrorDisplayed() {
        // Assuming specific error message for expired card
        return driver.findElement(paymentErrorMessage).getText().contains("Card expired");
    }
}
