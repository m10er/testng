package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class NegatifLoginTest {

    @Test
    public void test01(){
        WebDriver driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("toUrl"));

        TestOtomasyonuPage testOtomasyonuPage= new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinkElement.click();

        testOtomasyonuPage.emailElement.sendKeys("toInValidUserName");
        testOtomasyonuPage.passwordElement.sendKeys("toInValidPassword");
        testOtomasyonuPage.loginElement.click();

        Assert.assertTrue(testOtomasyonuPage.emailElement.isDisplayed());

       Driver.quitDriver();
    }

    @Test
    public void test02(){
        WebDriver driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("toUrl"));

        TestOtomasyonuPage testOtomasyonuPage= new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinkElement.click();

        testOtomasyonuPage.emailElement.sendKeys("toUserName");
        testOtomasyonuPage.passwordElement.sendKeys("toInValidPassword");
        testOtomasyonuPage.loginElement.click();

        Assert.assertTrue(testOtomasyonuPage.emailElement.isDisplayed());

        Driver.quitDriver();
    }
}
