package PageObjectModel;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page extends AbstractClass{
     WebDriver driver;
    public Login_Page() {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "type")
    private WebElement loginButton;
    @FindBy(css = ".dropdown-menu-home > li:nth-of-type(1) > a")
    private WebElement loginChooseButton;
    @FindBy(id = "email")
    private WebElement emailBox;
    @FindBy(id = "pass")
    private WebElement passBox;
    @FindBy(id ="login-button")
    private WebElement loginPageButton;

    String email = "hehokaw569@cyclesat.com";
    String pass = "test12345678";

    public void clickLoginButton(){
        clickFunction(loginButton);
        clickFunction(loginChooseButton);
    }
    public void typeemailTextBox (){
        clickFunction(emailBox);
        sendKeysFunction(emailBox,email);
    }
    public void typepassTextBox (){
        clickFunction(passBox);
        sendKeysFunction(passBox,pass);
    }
    public void loginPageButton(){
        clickFunction(loginPageButton);
    }
    public void assertLogin(){
        Assertion(loginButton, "HESABIM");
    }

}


