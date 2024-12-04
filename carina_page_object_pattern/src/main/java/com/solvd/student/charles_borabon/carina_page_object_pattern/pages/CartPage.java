package com.solvd.student.charles_borabon.carina_page_object_pattern.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Check if a product is in the cart
    public boolean isProductInCart(String productName) {
        By productInCart = By.cssSelector(".product-item-name a");
        List<WebElement> products = driver.findElements(productInCart);
        for (WebElement product : products) {
            if (product.getText().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    // Proceed to checkout
    public CheckoutPage proceedToCheckout() {
        By proceedToCheckoutButton = By.cssSelector("button.action.primary.checkout");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton)).click();
        return new CheckoutPage(driver);
    }
}