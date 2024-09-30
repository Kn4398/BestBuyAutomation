package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    WebDriver driver;


    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    By productItem = By.cssSelector(".product-item");

    public boolean isProductDisplayed() {
        return driver.findElements(productItem).size() > 0;
    }
}
