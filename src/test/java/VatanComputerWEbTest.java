import PageObjectModel.*;
import Utilities.Driver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VatanComputerWEbTest extends AbstractClass {
    Login_Page login_page = new Login_Page();
    Search_Page search_page = new Search_Page();
    Payment_Page payment_page = new Payment_Page();
    Logout_Page logout_page = new Logout_Page();
    static WebDriver driver;

    @BeforeAll  // her şeyden önce yapılacaklar
    public static void beforeAll() {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
    }

    @Test
    @Order(1)
    public void loginTest() {
        driver.get("https://www.vatanbilgisayar.com/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        login_page.clickLoginButton();
        login_page.typeemailTextBox();
        login_page.typepassTextBox();
        login_page.loginPageButton();
        login_page.assertLogin();
    }

    @Test
    @Order(2)
    public void searchVerifyTest() {
        String mySearch = "play station 4";
        search_page.typeSearchBar(mySearch);
        search_page.clickSarchButton();
        search_page.searchVerifyTest(mySearch);
    }

    @Test
    @Order(3)
    public void paymentVerifyTest() {
        payment_page.clickCheaperButton();
        payment_page.cheaperProductSelect();
        payment_page.paymentVerifyTest();
    }

    @Test
    @Order(4)
    public void logoutTest() {
        logout_page.goBackPage();
        logout_page.clickAccountButton();
        logout_page.clickLogoutButton();
    }

    @AfterAll // her şeyden sonra yapılacaklar
    public static void afterAll() {
        driver.quit();
    }

}
