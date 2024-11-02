package tests.mainpage;
import org.junit.Test;
import praktikum.MainPage;
import tests.BaseUITest;
import static org.junit.Assert.assertTrue;


public class AcceptCookiesTest extends BaseUITest {


    @Test
    public void сookiesButtonNotDisplayedTest() {
                MainPage mainPage = new MainPage(driver);
                mainPage.openMainPage();
                mainPage.isDisplayedCookieButton();
                boolean isDisplayedCookiesButton = mainPage.isDisplayedCookieButton();
                assertTrue(isDisplayedCookiesButton);
        }
    }

