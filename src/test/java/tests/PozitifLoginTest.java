package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class PozitifLoginTest {
     @Test
    public void test01(){

         WebDriver driver = Driver.getDriver();

         driver.get(ConfigReader.getProperty("toUrl"));

         TestOtomasyonuPage testOtomasyonuPage= new TestOtomasyonuPage();

         testOtomasyonuPage.accountLinkElement.click();

         testOtomasyonuPage.emailElement.sendKeys(ConfigReader.getProperty("toUserName"));
         testOtomasyonuPage.passwordElement.sendKeys(ConfigReader.getProperty("toPassword"));
         testOtomasyonuPage.loginElement.click();

         Assert.assertTrue(testOtomasyonuPage.logOutElement.isDisplayed());

         Driver.closeDriver();


     }
}
