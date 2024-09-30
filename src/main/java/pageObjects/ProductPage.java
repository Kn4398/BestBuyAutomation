package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    WebDriver driver;

    // Constructor
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By productItem = By.cssSelector(".product-item");

    // Actions
    public boolean isProductDisplayed() {
        return driver.findElements(productItem).size() > 0;
    }
}
