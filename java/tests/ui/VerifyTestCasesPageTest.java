package tests.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

public class VerifyTestCasesPageTest {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.manage().window().maximize();
    }

    @Test
    public void verifyTestCasesPage() {
        homePage.openHomePage();
        Assert.assertEquals(homePage.getPageTitle(), "Automation Exercise");

        driver.findElement(By.xpath("//a[contains(text(),'Test Cases')]")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("test_cases"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
