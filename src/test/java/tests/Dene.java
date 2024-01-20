package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;

public class Dene {
    @Test
    public void test01(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://demo.guru99.com/test/guru99home/");
        WebElement iframe = driver.findElement(By.xpath("//*[@wmode='transparent']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//*[@title='Play']")).click();
    }
}
