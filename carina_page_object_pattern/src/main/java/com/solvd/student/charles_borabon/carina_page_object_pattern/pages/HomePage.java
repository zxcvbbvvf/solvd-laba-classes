package com.solvd.student.charles_borabon.carina_page_object_pattern.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    @FindBy(linkText = "Sign In")
    private WebElement signInLink;

    @FindBy(linkText = "Create an Account")
    private WebElement createAccountLink;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToSignIn() {
        signInLink.click();
    }

    public void navigateToCreateAccount() {
        createAccountLink.click();
    }

    public void searchProduct(String query) {
        searchInput.sendKeys(query);
        searchButton.click();
    }
}