package PageObjectModel;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Logout_Page extends AbstractClass {
    WebDriver driver;

    public Logout_Page() {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "type")
    private WebElement clickAccountButton;
    @FindBy(css = ".dropdown-menu-home > li:nth-of-type(6) > a")
    private WebElement logoutButton;

    public void goBackPage(){
        driver.navigate().back();
    }
    public void clickAccountButton() {
        clickFunction(clickAccountButton);
    }

    public void clickLogoutButton() {
        clickFunction(logoutButton);
        wait.until(ExpectedConditions.elementToBeClickable(clickAccountButton));
    }

}
