package com.solvd.student.charles_borabon.carina_page_object_pattern.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage {
    private WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean areResultsRelevant(String keyword) {
        return driver.findElements(By.partialLinkText(keyword)).size() > 0;
    }
}