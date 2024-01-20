package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestOtomasyonuPage;
import pages.ZeroWebAppPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class SoftAssertion {
    @Test
    public void test01(){


        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue( Driver.getDriver().getTitle().contains("Test"));

        softAssert.assertEquals( Driver.getDriver().getCurrentUrl(),"https://www.testotomasyonu.com/");


        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();

        softAssert.assertTrue(testOtomasyonuPage.searchBox.isEnabled());


        testOtomasyonuPage.searchBox.sendKeys(ConfigReader.getProperty("toSearchWord")+ Keys.ENTER);


        softAssert.assertFalse(testOtomasyonuPage.foundProductsElements.isEmpty());

        testOtomasyonuPage.searchBox.sendKeys("Nutella"+ Keys.ENTER);

        softAssert.assertTrue(testOtomasyonuPage.foundProductsElements.isEmpty());

        softAssert.assertAll();


        Driver.quitDriver();
    }
    @Test
    public void softAssertionTesti() {
        // 1. “http://zero.webappsecurity.com/” Adresine gidin
        WebDriver driver=  Driver.getDriver();
        driver.get(ConfigReader.getProperty("zeroUrl"));

        // 2. webbappsecurity ana sayafaya gittiginizi dogrulayin
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/","main page url test");

        // 3. Sign in butonuna basin
        ZeroWebAppPage zeroWebAppPage = new ZeroWebAppPage();
        zeroWebAppPage.signInButtonElement.click();

        // 4. Login kutusuna “username” yazin
        zeroWebAppPage.loginTextBoxElement.sendKeys("username");

        // 5. Password kutusuna “password” yazin
        zeroWebAppPage.passwordTextBoxElement.sendKeys("password");

        // 6. Sign in tusuna basin
        zeroWebAppPage.signInloginElement.click();

        // 7. Back tusuna basin
        driver.navigate().back();

        // 8. Giris yapilabildigi dogrulayin
        softAssert.assertTrue(zeroWebAppPage.loginUserIcon.isDisplayed());

        // 9. Online banking menusunu tiklayin
        zeroWebAppPage.onlineBankingLinkatTopElement.click();

        //10. Pay Bills sayfasina gidin
        zeroWebAppPage.payBillsLinkElement.click();

        //11. “Purchase Foreign Currency” tusuna basin
        zeroWebAppPage.purchaseForeignLinkElement.click();

        //12. Currency dropdown menusunun erisilebilir oldugunu dogrulayin
        softAssert.assertTrue(zeroWebAppPage.pcCurrencyDropdownMenuElement.isEnabled());

        //13. “Currency” dropdown menusunden Eurozone’u secin
        Select selectCurrency = new Select(zeroWebAppPage.pcCurrencyDropdownMenuElement);
        selectCurrency.selectByValue("EUR");

        //14. "Eurozone (euro)" secildigini dogrulayin
        softAssert.assertEquals(selectCurrency.getFirstSelectedOption().getText(), "Eurozone (euro)");

        //15. Dropdown menude 16 option bulundugunu dogrulayin.
        softAssert.assertEquals(selectCurrency.getOptions().size(), 16);

        //16. Dropdown menude "Canada (dollar)" bulunduğunu dogrulayin
       softAssert.assertTrue(ReusableMethods.stringList(selectCurrency.getOptions()).contains("Canada (dollar)"));

        //17. Sayfayi kapatin
        softAssert.assertAll();

        driver.quit();
    }
}
