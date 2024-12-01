package com.solvd.student.charles_borabon.carina_page_object_pattern.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.webdriver.gui.AbstractPage;

public class LoginPage extends AbstractPage {
    @FindBy(id="email")
    private WebElement emailField;

    @FindBy(id="pass")
    private WebElement passwordField;

    @FindBy(id="send2")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}
