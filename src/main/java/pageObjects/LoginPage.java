package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    By emailField = By.id("email");
    By passwordField = By.id("password");
    By loginButton = By.id("signIn");

    By errorMessage = By.cssSelector(".error-message");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public boolean isErrorMessageDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }
}
