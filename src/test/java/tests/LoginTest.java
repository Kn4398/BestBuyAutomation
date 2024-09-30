package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.BasePage;
import pageObjects.LoginPage;
import pageObjects.SignUpPage;

public class LoginTest extends BasePage {

    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser) {
        driver = initializeDriver(browser);
        driver.get("https://www.bestbuy.com/");
    }

    @Test
    public void loginTest() {
        // Add Login functionality here with Page Object
        // Assume loginPage.login(user, password);
        Assert.assertTrue(driver.getTitle().contains("Account"), "Login should be successful.");
    }
    @Test
    public void loginValidTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("validUser", "validPassword");

        Assert.assertTrue(driver.getTitle().contains("My Account"), "User should be logged in.");
    }
    @Test
    public void loginInvalidTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("invalidUser", "invalidPassword");

        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed for invalid credentials.");
    }
    @Test
    public void loginBlankCredentialsTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "");

        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed for blank credentials.");
    }
    @Test
    public void signUpValidTest() {
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.signUp("validEmail@example.com", "validPassword", "ValidName");

        Assert.assertTrue(signUpPage.isAccountCreated(), "Account should be created successfully.");
    }
    @Test
    public void signUpAlreadyRegisteredEmailTest() {
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.signUp("registeredEmail@example.com", "validPassword", "ValidName");

        Assert.assertTrue(signUpPage.isErrorMessageDisplayed(), "Error message should be displayed for already registered email.");
    }
    @Test
    public void mandatoryFieldValidationTest() {
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.signUp("", "", "");

        Assert.assertTrue(signUpPage.isFieldValidationErrorDisplayed(), "Validation error should be displayed for empty mandatory fields.");
    }




    @AfterMethod
    public void teardown() {
        closeBrowser();
    }
}
