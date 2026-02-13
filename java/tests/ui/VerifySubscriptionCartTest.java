package tests.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

public class VerifySubscriptionCartTest {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.manage().window().maximize();
    }

    @Test
    public void verifySubscriptionInCartPage() {
        homePage.openHomePage();
        Assert.assertEquals(homePage.getPageTitle(), "Automation Exercise");

        driver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'Subscription')]")).isDisplayed());

        driver.findElement(By.id("susbscribe_email")).sendKeys("21100199@ibsu.edu.ge");
        driver.findElement(By.id("subscribe")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'You have been successfully subscribed!')]")).isDisplayed());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
