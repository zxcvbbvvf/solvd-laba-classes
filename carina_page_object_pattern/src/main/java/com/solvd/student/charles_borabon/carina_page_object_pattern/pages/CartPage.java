package com.solvd.student.charles_borabon.carina_page_object_pattern.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductInCart(String productName) {
        return driver.findElement(By.cssSelector(".product-item-name")).getText().contains(productName);
    }
}