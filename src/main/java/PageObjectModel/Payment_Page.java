package PageObjectModel;

import Utilities.Driver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Payment_Page extends AbstractClass {
    private WebDriver driver;

    public Payment_Page() {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "sortOptionsDesktop")
    private WebElement sortOption;
    @FindBy(css = "#sortOptionsDesktop > [value='UP']")
    private WebElement sortOptionUp;
    @FindBy(css = ".product-list__image-safe")
    private WebElement cheaperProduct;
    @FindBy(css = ".product-list__description > .product-list__price")
    private WebElement listPrice;
    @FindBy(css = ".basketBTN")
    private WebElement sepetAddButton;
    @FindBy(css = ".btn.btn-dark-blue.goToBasket")
    private WebElement sepetGoButton;
    @FindBy(css = ".basket-ordersummary__total strong")
    private WebElement paymentPrice;
    @FindBy(css = ".icon-times-circle")
    private WebElement sepetBosaltButton;

    public void clickCheaperButton() {
        clickFunction(sortOption);
        clickFunction(sortOptionUp);
    }

    public void cheaperProductSelect() {
        clickFunction(cheaperProduct);
    }

    public void paymentVerifyTest() {
        wait.until(ExpectedConditions.elementToBeClickable(sepetAddButton));
        String price = listPrice.getText().trim();
        String newPrice = price.replace(",", ".");

        clickFunction(sepetAddButton);
        wait.until(ExpectedConditions.elementToBeClickable(sepetGoButton));
        clickFunction(sepetGoButton);

        String pricePaymentPage = paymentPrice.getText().trim();
        String newPricePaymentPage = pricePaymentPage.replace(",", ".");

        Assertions.assertEquals(Double.parseDouble(newPrice), Double.parseDouble(newPricePaymentPage));

        clickFunction(sepetBosaltButton);
    }



}

