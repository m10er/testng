package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuFormPage;
import pages.TestOtomasyonuPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class PageClass {
    @Test
    public void test01(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.testotomasyonu.com/");
        TestOtomasyonuPage testOtomasyonuPage= new TestOtomasyonuPage();
        testOtomasyonuPage.searchBox.sendKeys("phone"+ Keys.ENTER);
        Assert.assertTrue(testOtomasyonuPage.foundProductsElements.size()>1);
        System.out.println(testOtomasyonuPage.foundTextElement.getText());
    }
    @Test
    public void test02(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.testotomasyonu.com/form");
        TestOtomasyonuFormPage testOtomasyonuFormPage = new TestOtomasyonuFormPage();
        Select selectDay =new Select(testOtomasyonuFormPage.dropdownMenuElementList.get(0));
        selectDay.selectByIndex(9);
        Select selectMonth = new Select(testOtomasyonuFormPage.dropdownMenuElementList.get(1));
        selectMonth.selectByValue("nisan");
        Select selectYear= new Select(testOtomasyonuFormPage.dropdownMenuElementList.get(2));
        selectYear.selectByVisibleText("1990");

        System.out.println( "Day="+selectDay.getFirstSelectedOption().getText()+ "" +
                "\nMonth="+selectMonth.getFirstSelectedOption().getText()+
        "\nYear"+selectYear.getFirstSelectedOption().getText());

        List<String> stringList = ReusableMethods.stringList(selectMonth.getOptions());

        Assert.assertEquals(selectMonth.getOptions().size(),13);

        System.out.println(stringList);

    }
    @Test
    public void test03(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.testotomasyonu.com/form");
        TestOtomasyonuFormPage testOtomasyonuFormPage = new TestOtomasyonuFormPage();
        ReusableMethods.waitfor(2);
        Actions actions = new Actions(driver);

        actions.scrollByAmount(0,400).perform();
        ReusableMethods.waitfor(2);

        testOtomasyonuFormPage.carpintiElement.click();
        testOtomasyonuFormPage.sirtAgrisiElement.click();

        Assert.assertTrue(testOtomasyonuFormPage.carpintiElement.isSelected());
        Assert.assertTrue(testOtomasyonuFormPage.sirtAgrisiElement.isSelected());

        Driver.closeDriver();
    }
}
