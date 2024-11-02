package tests.mainpage;
import org.junit.Assert;
import org.junit.Test;
import praktikum.MainPage;
import praktikum.OrderPage;
import tests.BaseUITest;


public class OrderButtonsTest extends BaseUITest {

    @Test
    public void topOrderClickTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.topOrderButtonClick();
        OrderPage orderPage = new OrderPage(driver);
        boolean isDisplayedOrderContentInput = orderPage.isDisplayedOrderContentInput();
        Assert.assertTrue(isDisplayedOrderContentInput);
    }

    @Test
    public void bottomOrderButtonClick() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.bottomOrderButtonClick();
        OrderPage orderPage = new OrderPage(driver);
        boolean isDisplayedOrderContentInput = orderPage.isDisplayedOrderContentInput();
        Assert.assertTrue(isDisplayedOrderContentInput);
    }
}