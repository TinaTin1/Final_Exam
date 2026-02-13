package tests.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

public class VerifyAllProductsTest {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.manage().window().maximize();
    }

    @Test
    public void verifyAllProductsAndProductDetailPage() {
        homePage.openHomePage();
        Assert.assertEquals(homePage.getPageTitle(), "Automation Exercise");

        driver.findElement(By.xpath("//a[contains(text(),'Products')]")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("products"));

        Assert.assertFalse(driver.findElements(By.cssSelector(".features_items .product-image-wrapper")).isEmpty());

        driver.findElement(By.xpath("(//a[contains(text(),'View Product')])[1]")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("product_details"));

        Assert.assertTrue(driver.findElement(By.cssSelector(".product-information h2")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Category')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Rs.')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//b[contains(text(),'Availability')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//b[contains(text(),'Condition')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//b[contains(text(),'Brand')]")).isDisplayed());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
