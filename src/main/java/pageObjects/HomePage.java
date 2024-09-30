package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By searchBar = By.id("search-input");
    By searchButton = By.className("search-button");

    public void searchProduct(String productName) {
        driver.findElement(searchBar).sendKeys(productName);
        driver.findElement(searchButton).click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
