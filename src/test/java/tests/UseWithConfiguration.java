package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.awt.image.Kernel;

public class UseWithConfiguration {

    @Test
    public void test01(){

        WebDriver driver = Driver.getDriver();

        driver.get(ConfigReader.getProperty("toUrl"));

        TestOtomasyonuPage testOtomasyonuPage= new TestOtomasyonuPage();

        testOtomasyonuPage.searchBox.sendKeys(ConfigReader.getProperty("toSearchWord")+ Keys.ENTER);

        Assert.assertFalse(testOtomasyonuPage.foundProductsElements.isEmpty());

        testOtomasyonuPage.foundProductsElements.get(0).click();

        String actualProductName= testOtomasyonuPage.productNameElement.getText().toLowerCase();
        String expectedProdcutName = ConfigReader.getProperty("toSearchWord");

        Assert.assertTrue(actualProductName.contains(expectedProdcutName));

        Driver.closeDriver();

    }
}
