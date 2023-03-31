package PageObjectModel;

import Utilities.Driver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search_Page extends AbstractClass {
    private WebDriver driver;

    public Search_Page( ) {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "navbar-search-input")
    private WebElement typeSearch;
    @FindBy(className = "icon-search")
    private WebElement searchButton;
    @FindBy(css = "#suggestionSearchİtem > strong")
    private WebElement actualSearch;

    public void typeSearchBar(String mySearch) {
        clickFunction(typeSearch);
        sendKeysFunction(typeSearch, mySearch);
    }

    public void clickSarchButton() {
        clickFunction(searchButton);
    }

    public void searchVerifyTest(String mySearch) {
        String actualSearchText = actualSearch.getText();
        Assertion(actualSearchText.toLowerCase(), mySearch.toLowerCase());
    }
}
