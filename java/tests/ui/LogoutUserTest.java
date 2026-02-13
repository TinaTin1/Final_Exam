package tests.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.HomePage;

import java.time.Duration;

public class LogoutUserTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver, wait);
        homePage = new HomePage(driver);
        driver.manage().window().maximize();
    }

    @Test
    public void logoutUser() {
        homePage.openHomePage();
        Assert.assertEquals(homePage.getPageTitle(), "Automation Exercise");

        loginPage.clickSignupLogin();
        Assert.assertTrue(loginPage.isLoginFormVisible());

        loginPage.login("21100199@ibsu.edu.ge", "123456789");
        Assert.assertTrue(loginPage.isLoggedInAsVisible());

        loginPage.clickLogoutButton();
        Assert.assertTrue(loginPage.isLoginFormVisible());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
