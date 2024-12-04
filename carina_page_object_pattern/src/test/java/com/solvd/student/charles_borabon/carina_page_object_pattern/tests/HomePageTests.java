package com.solvd.student.charles_borabon.carina_page_object_pattern.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.solvd.student.charles_borabon.carina_page_object_pattern.pages.CartPage;
import com.solvd.student.charles_borabon.carina_page_object_pattern.pages.CheckoutPage;
import com.solvd.student.charles_borabon.carina_page_object_pattern.pages.HomePage;
import com.solvd.student.charles_borabon.carina_page_object_pattern.pages.LoginPage;
import com.solvd.student.charles_borabon.carina_page_object_pattern.pages.RegistrationPage;
import com.solvd.student.charles_borabon.carina_page_object_pattern.pages.SearchResultsPage;
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

    @Test(priority = 1)
    public void verifyHomepageAccessibility() {
        Assert.assertTrue(homePage.isLogoDisplayed(), "Logo is not displayed.");
        Assert.assertTrue(homePage.isNavigationBarDisplayed(), "Navigation bar is not displayed.");
    }

    @Test(priority = 2)
    public void verifyUserRegistration() {
        RegistrationPage registrationPage = homePage.navigateToRegistrationPage();
        registrationPage.registerNewUser("test2", "smith", "test2smith@example.com", "Password123!");
        Assert.assertTrue(registrationPage.isAccountCreated(), "Account was not created successfully.");
    }

    @Test(priority = 3)
    public void verifyLoginFunctionality() {
        LoginPage loginPage = homePage.navigateToLoginPage();
        loginPage.login("test2smith@example.com", "Password123!");
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login was not successful.");
    }

    @Test(priority = 4)
    public void verifySearchFunctionality() {
        SearchResultsPage searchResultsPage = homePage.searchForProduct("yoga pant");
        Assert.assertTrue(searchResultsPage.areResultsRelevant("Yoga Pant"), "Search results are not relevant.");
    }

    @Test(priority = 5)
    public void verifyAddToCartFunctionality() {
        SearchResultsPage searchResultsPage = homePage.searchForProduct("Cronus Yoga Pant");
        searchResultsPage.selectProduct("Cronus Yoga Pant")
                         .addToCart("33", "Blue");
        CartPage cartPage = homePage.navigateToCart();
        Assert.assertTrue(cartPage.isProductInCart("Cronus Yoga Pant"), "Product was not added to the cart.");
    }

    @Test(priority = 6)
    public void verifyCheckoutProcess() {
        // Sign In
        LoginPage loginPage = homePage.navigateToLoginPage();
        loginPage.login("test2smith@example.com", "Password123!");
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login was not successful.");

        // Search and Add to Cart
        SearchResultsPage searchResultsPage = homePage.searchForProduct("Cronus Yoga Pant");
        searchResultsPage.selectProduct("Cronus Yoga Pant")
                        .addToCart("33", "Blue");

        // Proceed to Checkout
        CheckoutPage checkoutPage = homePage.navigateToCheckout();
        checkoutPage.enterShippingDetails("John", "Doe", "123 Main St", "New York", "NY", "10001", "US", "1234567890");
        checkoutPage.selectShippingMethod();
        checkoutPage.proceedToPayment();
        checkoutPage.placeOrder();

        // Validate Order Confirmation
        Assert.assertTrue(checkoutPage.isOrderConfirmationDisplayed(), "Order confirmation was not displayed.");
        String orderNumber = checkoutPage.getOrderNumber();
        Assert.assertNotNull(orderNumber, "Order number is missing.");
        System.out.println("Order successfully placed. Order Number: " + orderNumber);
    }

    @Test(priority = 7)
    public void verifyCategoryNavigation() {
        // Navigate to Men > Tops
        homePage.navigateToCategory("Men", "Tops");
    
        // Validate the category page is displayed correctly
        Assert.assertTrue(homePage.isCategoryDisplayed("Tops"), "The Tops category page was not displayed.");
    }
}