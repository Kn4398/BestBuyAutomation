package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {
    WebDriver driver;

    By cardNumberField = By.id("cardNumber");
    By cardNameField = By.id("cardName");
    By cardExpiryField = By.id("cardExpiry");
    By cardCVVField = By.id("cardCVV");
    By submitPaymentButton = By.id("submitPayment");

    By paymentErrorMessage = By.xpath("//div[contains(text(),'Payment failed')]");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterCardDetails(String cardNumber, String cardName, String cardExpiry, String cardCVV) {
        driver.findElement(cardNumberField).sendKeys(cardNumber);
        driver.findElement(cardNameField).sendKeys(cardName);
        driver.findElement(cardExpiryField).sendKeys(cardExpiry);
        driver.findElement(cardCVVField).sendKeys(cardCVV);
    }

    public void submitPayment() {
        driver.findElement(submitPaymentButton).click();
    }

    public boolean isPaymentSuccessful() {
        return driver.getTitle().contains("Payment Success");
    }

    public boolean isPaymentErrorDisplayed() {
        return driver.findElement(paymentErrorMessage).isDisplayed();
    }

    public boolean isInvalidCardNumberErrorDisplayed() {
        return driver.findElement(paymentErrorMessage).getText().contains("Invalid card number");
    }

    public boolean isExpiredCardErrorDisplayed() {
        return driver.findElement(paymentErrorMessage).getText().contains("Card expired");
    }
}
