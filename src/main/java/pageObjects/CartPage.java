package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

    By addToCartButton = By.id("addToCart");
    By cartIcon = By.id("cart-icon");
    By productInCart = By.xpath("//div[@class='product-name']");

    By removeProductButton = By.xpath("//button[@class='remove-product']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToCart() {
        driver.findElement(addToCartButton).click();
    }

    public boolean isProductInCart(String productName) {
        return driver.findElement(productInCart).getText().contains(productName);
    }

    public void removeProduct(String productName) {
        driver.findElement(removeProductButton).click();
    }

    public void openCart() {
        driver.findElement(cartIcon).click();
    }
}
