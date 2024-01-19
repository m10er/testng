package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {
    public static List<String> stringList (List<WebElement> webElements){
        List<String> stringList= new ArrayList<>();
        for (WebElement eachElement: webElements){
            stringList.add(eachElement.getText());
        }
        return stringList;
    }

    public static void waitfor( int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void changePageWithTitle(WebDriver driver, String title){
        Set<String> windowHandle = driver.getWindowHandles();
        for (String each: windowHandle){
            driver.switchTo().window(each);
            if (driver.getTitle().equals(title)){
                break;
            }
        }
    }
}
