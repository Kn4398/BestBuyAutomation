package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    WebDriver driver;

    // Locators for the sign-up page elements
    By emailField = By.id("email");
    By passwordField = By.id("password");
    By confirmPasswordField = By.id("confirmPassword");
    By signUpButton = By.id("signUp");

    By errorMessage = By.cssSelector(".error-message");

    // Constructor
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to sign up
    public void signUp(String email, String password, String confirmPassword) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
        driver.findElement(signUpButton).click();
    }

    // Method to check if an error message is displayed
    public boolean isErrorMessageDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }

    // Method to check if the account is created successfully
    public boolean isAccountCreated() {
        // Assuming there's a success message or redirect that can be verified
        return driver.getTitle().contains("My Account");
    }
}
