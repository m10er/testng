package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TestOtomasyonuFormPage {
    public TestOtomasyonuFormPage() {
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath = "//select[@class='form-control']")
    public List<WebElement> dropdownMenuElementList;

    @FindBy(id = "gridCheck5")
    public WebElement sirtAgrisiElement;

    @FindBy(id = "gridCheck4")
    public WebElement carpintiElement;


}
