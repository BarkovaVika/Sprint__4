package tests.mainpage;
import org.junit.Test;
import org.openqa.selenium.By;
import praktikum.MainPage;
import tests.BaseUITest;
import static org.junit.Assert.assertTrue;

public class AcceptCookiesTest extends BaseUITest {


    @Test
    public void сookiesButtonClickTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.сookieButtonClick();
        assertTrue("Кнопка cookies присутствует после нажатия", driver.findElements(By.id("cookiesButton")).size() == 0);
    }
}
