package com.solvd.student.charles_borabon.carina_page_object_pattern.pages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
    @FindBy(linkText="Sigh In")
    private WebElement signInLink;

    @FindBy(linkText="Create an Account")
    private WebElement createAccountLink;

    @FindBy(name="q")
    private WebElement searchField;

    @FindBy(xpath="//button[@title='Search']")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://magento.softwaretestingboard.com/");
    }

    public LoginPage clickSignIn() {
        signInLink.click();
        return new LoginPage(getDriver());
    }

    public void search(String query) {
        searchField.sendKeys(query);
        searchButton.click();
    }
}
