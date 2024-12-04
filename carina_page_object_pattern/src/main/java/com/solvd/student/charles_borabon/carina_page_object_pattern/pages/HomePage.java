package com.solvd.student.charles_borabon.carina_page_object_pattern.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By logo = By.cssSelector(".logo");
    private By navBar = By.id("store.menu");
    private By searchBar = By.id("search");
    private By searchButton = By.cssSelector("button.action.search");
    private By signInLink = By.linkText("Sign In");
    private By registrationLink = By.linkText("Create an Account");
    private By menCategoryLink = By.linkText("Men");
    private By topsCategoryLink = By.linkText("Tops");
    private By categoryHeader = By.cssSelector("h1.page-title span");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isLogoDisplayed() {
        return driver.findElement(logo).isDisplayed();
    }

    public boolean isNavigationBarDisplayed() {
        return driver.findElement(navBar).isDisplayed();
    }

    public RegistrationPage navigateToRegistrationPage() {
        driver.findElement(registrationLink).click();
        return new RegistrationPage(driver);
    }

    public LoginPage navigateToLoginPage() {
        driver.findElement(signInLink).click();
        return new LoginPage(driver);
    }

    public SearchResultsPage searchForProduct(String productName) {
        driver.findElement(searchBar).sendKeys(productName);
        driver.findElement(searchButton).click();
        return new SearchResultsPage(driver);
    }

    public void navigateToCategory(String mainCategory, String subCategory) {
        // Click on the main category (e.g., Men)
        wait.until(ExpectedConditions.elementToBeClickable(menCategoryLink)).click();

        // Click on the subcategory (e.g., Tops)
        wait.until(ExpectedConditions.elementToBeClickable(topsCategoryLink)).click();
    }

    public boolean isCategoryDisplayed(String expectedCategoryName) {
        // Verify the category header matches the expected name
        String actualHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(categoryHeader)).getText();
        return actualHeader.equalsIgnoreCase(expectedCategoryName);
    }

    public CartPage navigateToCart() {
        driver.findElement(By.cssSelector(".showcart")).click();
        return new CartPage(driver);
    }

    public CheckoutPage navigateToCheckout() {
        navigateToCart();
        driver.findElement(By.cssSelector("button.action.primary.checkout")).click();
        return new CheckoutPage(driver);
    }
}