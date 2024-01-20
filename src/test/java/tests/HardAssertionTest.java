package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class HardAssertionTest {

    @Test
    public void test01(){
        WebDriver driver = Driver.getDriver();

        driver.get(ConfigReader.getProperty("toUrl"));

        Assert.assertTrue(driver.getTitle().contains("Test"));

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.testotomasyonu.com/");

        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();

        Assert.assertTrue(testOtomasyonuPage.searchBox.isEnabled());

        testOtomasyonuPage.searchBox.sendKeys(ConfigReader.getProperty("toSearchWord")+ Keys.ENTER);

        Assert.assertFalse(testOtomasyonuPage.foundProductsElements.isEmpty());

        testOtomasyonuPage.searchBox.sendKeys("Nutella"+ Keys.ENTER);

        Assert.assertTrue(testOtomasyonuPage.foundProductsElements.isEmpty());
        Driver.closeDriver();


    }
}
