package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TestOtomasyonuPage {

    public TestOtomasyonuPage() {
        PageFactory.initElements(Driver.getDriver(), this);
        System.out.println();
    }


    @FindBy(id = "global-search")
    public WebElement searchBox;

    @FindBy(className = "product-count-text")
    public  WebElement foundTextElement;

    @FindBy(xpath = "//*[@class='product-box my-2  py-1']")
    public List<WebElement> foundProductsElements;

    @FindBy(xpath = "//*[@*=' heading-sm mb-4']")
    public WebElement productNameElement;

    @FindBy(xpath = "//*[@*='e-cart'][1]")
    public WebElement accountLinkElement;

    @FindBy(id = "email")
    public WebElement emailElement;

    @FindBy(id = "password")
    public WebElement passwordElement;

    @FindBy(id = "submitlogin")
    public WebElement loginElement;

    @FindBy(xpath = "//span[.='Logout']")
    public WebElement logOutElement;


}
