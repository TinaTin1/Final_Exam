package tests.ui;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;


public class HomeTest extends BaseTest {

    @Test
    public void verifyHomePage() {

        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();

        Assert.assertTrue(homePage.getPageTitle().contains("Automation"));
    }
}
