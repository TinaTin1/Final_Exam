package tests.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

public class SearchProductTest {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.manage().window().maximize();
    }

    @Test
    public void searchProduct() {
        homePage.openHomePage();
        Assert.assertEquals(homePage.getPageTitle(), "Automation Exercise");

        driver.findElement(By.xpath("//a[contains(text(),'Products')]")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("products"));

        driver.findElement(By.id("search_product")).sendKeys("Blue Top");
        driver.findElement(By.id("submit_search")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'Searched Products')]")).isDisplayed());
        Assert.assertFalse(driver.findElements(By.cssSelector(".features_items .product-image-wrapper")).isEmpty());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
