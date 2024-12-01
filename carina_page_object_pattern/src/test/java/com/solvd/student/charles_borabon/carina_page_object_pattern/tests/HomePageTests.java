package com.solvd.student.charles_borabon.carina_page_object_pattern.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.solvd.student.charles_borabon.carina_page_object_pattern.pages.HomePage;
import com.solvd.student.charles_borabon.carina_page_object_pattern.utils.DriverManager;

public class HomePageTests {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.getDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }


    //test methods

    @Test(priority = 1)
    public void testSignInNavigation() {
        homePage.navigateToSignIn();
        Assert.assertTrue(driver.getTitle().contains("Customer Login"));
    }

    @Test(priority = 2)
    public void testCreateAccountNavigation() {
        homePage.navigateToCreateAccount();
        Assert.assertTrue(driver.getTitle().contains("Create New Customer Account"));
    }

    @Test(priority = 3)
    public void testSearchProduct() {
        homePage.searchProduct("Yoga");
        Assert.assertTrue(driver.getPageSource().contains("Yoga"));
    }

    @Test(priority = 4)
    public void testSearchBarVisibility() {
        Assert.assertTrue(homePage.isSearchBarVisible(), "Search bar is not visible.");
    }

    @Test(priority = 5)
    public void testYogaCollectionText() {
        Assert.assertTrue(driver.getPageSource().contains("New Luma Yoga Collection"), 
                          "'New Luma Yoga Collection' text is not found on the home page.");
    }

    @Test(priority = 6)
    public void testWhatsNewNavigation() {
        WebElement whatsNewLink = driver.findElement(By.linkText("What's New"));
        whatsNewLink.click();
        Assert.assertTrue(driver.getTitle().contains("What's New"), 
                          "Navigation to 'What's New' page failed.");
    }

    @Test(priority = 7)
    public void testCartEmptyState() {
        WebElement cartLink = driver.findElement(By.linkText("My Cart"));
        cartLink.click();
        Assert.assertTrue(driver.getPageSource().contains("You have no items in your shopping cart"), 
                          "Cart is not empty as expected.");
    }

    @Test(priority = 8)
    public void testFooterLinkNavigation() {
        WebElement privacyPolicyLink = driver.findElement(By.linkText("Privacy and Cookie Policy"));
        privacyPolicyLink.click();
        Assert.assertTrue(driver.getTitle().contains("Privacy Policy"), 
                          "Privacy Policy page did not open.");
    }

    @Test(priority = 9)
    public void testSignInUrl() {
        homePage.navigateToSignIn();
        Assert.assertTrue(driver.getCurrentUrl().contains("customer/account/login"), 
                          "Sign In URL is not correct.");
    }

    @Test(priority = 10)
    public void testPageReloadTitle() {
        String originalTitle = driver.getTitle();
        driver.navigate().refresh();
        Assert.assertEquals(driver.getTitle(), originalTitle, 
                            "Page title changed after reload.");
    }
}
