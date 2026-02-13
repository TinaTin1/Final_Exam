package tests.ui;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class RegisterTest extends BaseTest {

    @Test
    public void registerNewUser() {

        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        Assert.assertTrue(homePage.getPageTitle().contains("Automation"));

        LoginPage loginPage = new LoginPage(driver, wait);

        loginPage.clickSignupLogin();
        loginPage.enterNameAndEmail("Tinatin Babunashvili", "21100199@ibsu.edu.ge");
        loginPage.clickSignupButton();
        Assert.assertTrue(loginPage.isAccountInformationVisible());

        loginPage.fillAccountInformation(
                "123456789", "6", "July", "2003",
                "Tinatin", "Babunashvili", "Automation", "Address", "Georgia",
                "State", "Tbilisi", "123456789", "1234567890"
        );

        loginPage.clickCreateAccount();
        Assert.assertTrue(loginPage.isAccountCreatedVisible());

        loginPage.clickContinue();
        Assert.assertTrue(loginPage.isLoggedInAsVisible());

        loginPage.clickDeleteAccount();
        Assert.assertTrue(loginPage.isAccountDeletedVisible());
    }
}
