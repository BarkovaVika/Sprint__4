package praktikum;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class MainPage {
    protected WebDriver driver;

    // кнопка принятия сookies
    private final By сookiesButton = By.xpath(".//button[@id='rcc-confirm-button']");
    // верхняя кнопка "Заказать"
    private final By topOrderButton = By.cssSelector(".Button_Button__ra12g");
    // нижняя кнопка "Заказать"
    private final By bottomOrderButton = By.xpath(".//button[contains(@class,'Button_Middle')]");
    public static String MAIN_PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    private static final String FAQ_QUESTION_PATTERN = ".//div[contains(@id, 'accordion__heading') and contains(text(), '%s')]";
    private static final String FAQ_ANSWER_PATTERN = ".//div[contains(@class, 'accordion__panel')]/p[contains(text(), '%s')]";


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage openMainPage() {
        driver.get(MAIN_PAGE_URL);
        return this;
    }

    public void сookieButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(сookiesButton));
        driver.findElement(сookiesButton).click();
    }

    public void topOrderButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(topOrderButton));
        driver.findElement(topOrderButton).click();
    }

    public void bottomOrderButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(bottomOrderButton));
        WebElement element = driver.findElement(bottomOrderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(bottomOrderButton).click();
    }

    public void matchQuestionAnswer (String questionMessage, String expectedAnswer) {
        String questionLocator = String.format(FAQ_QUESTION_PATTERN, questionMessage);
        WebElement questionElement = driver.findElement(By.xpath(questionLocator));
        scrollToElement(questionElement);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(questionLocator)));
        questionElement.click();

        // Находим элемент с ответом
        String answerLocator = String.format(FAQ_ANSWER_PATTERN, expectedAnswer);
        WebElement answerElement = driver.findElement(By.xpath(answerLocator));

        // Проверяем текст ответа
        if (answerElement.getText().contains(expectedAnswer)) {
            System.out.println("Ответ соответствует вопросу: " + expectedAnswer);
        } else {
            System.out.println("Ответ не соответствует вопросу: " + expectedAnswer);
        }
    }
    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
}