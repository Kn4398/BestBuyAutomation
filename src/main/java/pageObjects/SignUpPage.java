package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    WebDriver driver;

    By emailField = By.id("email");
    By passwordField = By.id("password");
    By confirmPasswordField = By.id("confirmPassword");
    By signUpButton = By.id("signUp");

    By errorMessage = By.cssSelector(".error-message");

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void signUp(String email, String password, String confirmPassword) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
        driver.findElement(signUpButton).click();
    }

    public boolean isErrorMessageDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }

    public boolean isAccountCreated() {
        return driver.getTitle().contains("My Account");
    }
}
