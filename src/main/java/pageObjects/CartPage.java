package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

    // Locators for the cart page elements
    By addToCartButton = By.id("addToCart");
    By cartIcon = By.id("cart-icon");
    By productInCart = By.xpath("//div[@class='product-name']");

    By removeProductButton = By.xpath("//button[@class='remove-product']");

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to add a product to the cart
    public void addProductToCart() {
        driver.findElement(addToCartButton).click();
    }

    // Method to check if a product is in the cart
    public boolean isProductInCart(String productName) {
        return driver.findElement(productInCart).getText().contains(productName);
    }

    // Method to remove a product from the cart
    public void removeProduct(String productName) {
        driver.findElement(removeProductButton).click();
    }

    // Method to navigate to the cart
    public void openCart() {
        driver.findElement(cartIcon).click();
    }
}
