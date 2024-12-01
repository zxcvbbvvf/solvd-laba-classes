package com.solvd.student.charles_borabon.carina_page_object_pattern.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.solvd.student.charles_borabon.carina_page_object_pattern.pages.HomePage;
import com.zebrunner.carina.core.IAbstractTest;

public class MagentoTests implements IAbstractTest {
    @Test
    public void testHomePageLoad() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }
}
