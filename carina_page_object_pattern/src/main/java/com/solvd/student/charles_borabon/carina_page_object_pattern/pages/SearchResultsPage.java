package com.solvd.student.charles_borabon.carina_page_object_pattern.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {
    private WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean areResultsRelevant(String keyword) {
        return !driver.findElements(By.partialLinkText(keyword)).isEmpty();
    }

    public SearchResultsPage selectProduct(String productName) {
        By productLink = By.cssSelector("a[href*='" + productName.toLowerCase().replace(" ", "-") + "']");
        driver.findElement(productLink).click();
        return this;
    }

    public SearchResultsPage addToCart(String size, String color) {
        By sizeOption = By.cssSelector(".swatch-attribute.size [aria-label='" + size + "']");
        By colorOption = By.cssSelector(".swatch-attribute.color [aria-label='" + color + "']");
        By addToCartButton = By.cssSelector("button.action.tocart");
        By cartSuccessMessage = By.cssSelector(".message-success");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Select size
        wait.until(ExpectedConditions.elementToBeClickable(sizeOption)).click();
        // Select color
        wait.until(ExpectedConditions.elementToBeClickable(colorOption)).click();
        // Add to cart
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
        // Wait for success message
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartSuccessMessage));
        return this;
    }
}