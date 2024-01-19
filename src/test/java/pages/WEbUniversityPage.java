package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utilities.Driver;

public class WEbUniversityPage {
    public WEbUniversityPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//h1[.='LOGIN PORTAL']")
    public WebElement loginPortalElement;

    @FindBy(id = "text")
    public WebElement userNameElement;


}
