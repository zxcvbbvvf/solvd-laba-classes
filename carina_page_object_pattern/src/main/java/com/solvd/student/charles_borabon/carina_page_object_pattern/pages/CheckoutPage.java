package com.solvd.student.charles_borabon.carina_page_object_pattern.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Locators
    private By firstNameField = By.name("firstname");
    private By lastNameField = By.name("lastname");
    private By streetAddressField = By.name("street[0]");
    private By cityField = By.name("city");
    private By stateDropdown = By.name("region_id");
    private By zipField = By.name("postcode");
    private By countryDropdown = By.name("country_id");
    private By phoneField = By.name("telephone");
    private By shippingMethodTableRate = By.cssSelector("input[value='flatrate_flatrate']");
    private By nextButton = By.cssSelector("button.continue");
    private By placeOrderButton = By.cssSelector("button[title='Place Order']");
    private By orderSuccessMessage = By.cssSelector("h1");
    private By orderNumber = By.cssSelector(".checkout-success strong");

    public void enterShippingDetails(String firstName, String lastName, String street, String city, String state, String zip, String country, String phone) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(streetAddressField).sendKeys(street);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(stateDropdown).sendKeys(state);
        driver.findElement(zipField).sendKeys(zip);
        driver.findElement(countryDropdown).sendKeys(country);
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void selectShippingMethod() {
        // Wait for shipping method option to appear
        wait.until(ExpectedConditions.elementToBeClickable(shippingMethodTableRate)).click();
    }

    public void proceedToPayment() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }

    public void placeOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton)).click();
    }

    public boolean isOrderConfirmationDisplayed() {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(orderSuccessMessage, "Thank you for your purchase!"));
    }

    public String getOrderNumber() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(orderNumber)).getText();
    }
}