package com.solvd.student.charles_borabon.carina_page_object_pattern.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private WebDriver driver;

    // Locators
    private By firstNameField = By.id("firstname");
    private By lastNameField = By.id("lastname");
    private By emailField = By.id("email_address");
    private By passwordField = By.id("password");
    private By confirmPasswordField = By.id("password-confirmation");
    private By registerButton = By.cssSelector(".action.submit.primary");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void registerNewUser(String firstName, String lastName, String email, String password) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(password);
        driver.findElement(registerButton).click();
    }

    public boolean isAccountCreated() {
        return driver.findElement(By.cssSelector(".message-success")).isDisplayed();
    }
}