package com.solvd.student.charles_borabon.carina_page_object_pattern.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterBillingDetails(String firstName, String lastName, String address, String city, String state, String zip, String country) {
        driver.findElement(By.id("firstname")).sendKeys(firstName);
        driver.findElement(By.id("lastname")).sendKeys(lastName);
        driver.findElement(By.id("street_1")).sendKeys(address);
        driver.findElement(By.id("city")).sendKeys(city);
        driver.findElement(By.id("region_id")).sendKeys(state);
        driver.findElement(By.id("postcode")).sendKeys(zip);
        driver.findElement(By.id("country_id")).sendKeys(country);
        driver.findElement(By.cssSelector("button.action.primary.continue")).click();
    }

    public void placeOrder() {
        driver.findElement(By.cssSelector("button.action.primary.checkout")).click();
    }

    public boolean isOrderConfirmationDisplayed() {
        return driver.findElement(By.cssSelector(".checkout-success")).isDisplayed();
    }
}