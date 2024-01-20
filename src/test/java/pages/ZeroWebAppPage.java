package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class ZeroWebAppPage {
    public ZeroWebAppPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "signin_button")
    public WebElement signInButtonElement;

    @FindBy(id = "user_login")
    public WebElement loginTextBoxElement;

    @FindBy(id = "user_password")
    public WebElement passwordTextBoxElement;

    @FindBy(xpath = "//*[@name='submit']")
    public WebElement signInloginElement;

    @FindBy(xpath = "//*[@class='icon-user']")
    public WebElement loginUserIcon;

    @FindBy(id = "onlineBankingMenu")
    public  WebElement onlineBankingLinkatTopElement;

    @FindBy (id = "pay_bills_link")
    public WebElement payBillsLinkElement;

    @FindBy(partialLinkText = "Purchase Foreign Currency")
    public WebElement purchaseForeignLinkElement;

    @FindBy(id = "pc_currency")
    public WebElement pcCurrencyDropdownMenuElement;
}
