package com.solvd.student.charles_borabon.carina_page_object_pattern.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    // Locators
    private By logo = By.cssSelector(".logo");
    private By navBar = By.id("store.menu");
    private By searchBar = By.id("search");
    private By searchButton = By.cssSelector("button.action.search");
    private By signInLink = By.linkText("Sign In");
    private By registrationLink = By.linkText("Create an Account");

    public HomePage(WebDriver driver) {
        this.driver = driver;
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