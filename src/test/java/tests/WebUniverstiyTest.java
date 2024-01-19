package tests;

import org.bouncycastle.jcajce.provider.digest.Keccak;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WEbUniversityPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class WebUniverstiyTest {
    @Test
    public void negatifLoginTesti(){
        WebDriver driver = Driver.getDriver();

        //1."http://webdriveruniversity.com/" adresine gidin
            driver.get("http://webdriveruniversity.com/");

        //2."Login Portal" a  kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //3."Login Portal" a tiklayin
        WEbUniversityPage wEbUniversityPage= new WEbUniversityPage();
        wEbUniversityPage.loginPortalElement.click();

        //4.Diger window'a gecin
        ReusableMethods.changePageWithTitle(driver,"WebDriver | Login Portal");

        //5."username" ve  "password" kutularina rastgele deger yazdirin
        wEbUniversityPage.userNameElement.click();
        actions.sendKeys("muammer")
                .sendKeys(Keys.TAB)
                .sendKeys("453423rewrew")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();


        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin

        String expectedLoginText = "validation failed";
        String actualLoginText = driver.switchTo().alert().getText();

        Assert.assertEquals(actualLoginText,expectedLoginText);

        //8.Ok diyerek Popup'i kapatin

        driver.switchTo().alert().accept();

        //9.Ilk sayfaya geri donun

        ReusableMethods.changePageWithTitle(driver,"WebDriverUniversity.com");

        //10.Ilk sayfaya donuldugunu test edin
        Assert.assertEquals(driver.getCurrentUrl(), "https://webdriveruniversity.com/");

        driver.quit();

    }
}
