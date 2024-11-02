package praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;


public class OrderPage {
    protected WebDriver driver;
    public static final String MAIN_PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    public static final String ORDER_PAGE_URL = MAIN_PAGE_URL + "order";

    //поле ввода имени
    private final By nameInput = By.xpath(".//input[contains(@placeholder, 'Имя')]");
    //поле ввода фамилии
    private final By surnameInput = By.xpath(".//input[contains(@placeholder, 'Фамилия')]");
    //поле ввода адреса куда привезти заказ
    private final By addressInput = By.xpath(".//input[contains(@placeholder, 'Адрес: куда привезти заказ')]");
    //поле выбора станции метро
    private final By metroSelectInput = By.xpath(".//input[contains(@placeholder, 'Станция метро')]");
    private final By metroSearchSelect = By.className("select-search__select");
    //поле ввода номера телефона
    private final By phoneNumberInput = By.xpath(".//input[contains(@placeholder, 'Телефон: на него позвонит курьер')]");
    //поля ввода даты заказа
    private final By deliveryDateInput = By.xpath(".//input[contains(@placeholder, 'Когда привезти самокат')]");
    private final By deliveryDateDataPicker = By.xpath(".//div[contains(@class, 'datepicker__day--selected')]");
    //поля выбора срока аренды
    private final By rentPeriodInput = By.xpath(".//div[@class='Dropdown-root']");
    private final By rentPeriodSelect = By.className("Dropdown-menu");
    //чекбокс выбора цвета самоката "чёрный жемчуг"
    private final By scooterBlackInput = By.xpath(".//input[@id='black']");
    //чекбокс выбора цвета самоката "серая безысходность"
    private final By scooterGreyInput = By.xpath(".//input[@id='grey']");
    //поле ввода комментария для курьера
    private final By commentToCourierInput = By.xpath(".//input[contains(@placeholder, 'Комментарий для курьера')]");
    //окно формы оформления заказа
    private final By orderContentInput = By.xpath(".//div[@class='Order_Content__bmtHS']");
    // кнопка "Далее" в окне оформления заказа
    private final By continueButton = By.xpath(".//button[contains(@class, 'Middle') and contains(text(), 'Далее')]");
    // кнопка "Заказать" в окне оформления заказа
    private final By finishOrderButton = By.xpath(".//button[contains(@class, 'Middle') and contains(text(), 'Заказать')]");
    // кнопка "Да" в форме подтверждения оформления заказа "Хотите оформить заказ"
    private final By confirmOrderButton = By.xpath(".//button[contains(@class, 'Button_Middle') and contains(text(), 'Да')]");
    // окно с подтверждением оформления заказа с сообщением "Заказ оформлен"
    private final By orderSuccess = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");


    public OrderPage(WebDriver driver) {

        this.driver = driver;
    }

    public OrderPage openOrderPage() {
        driver.get(ORDER_PAGE_URL);
        return this;
    }

    public void setName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    public void setSurname(String surname) {
        driver.findElement(surnameInput).sendKeys(surname);
    }

    public void setAddress(String address) {
        driver.findElement(addressInput).sendKeys(address);
    }

    public void selectMetroStationByName(String metroStationName) {
        driver.findElement(metroSelectInput).sendKeys(metroStationName);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(metroSearchSelect));
        driver.findElement(metroSearchSelect).click();
    }

    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberInput).sendKeys(phoneNumber);
        driver.findElement(phoneNumberInput).click();
    }

    public void fillOrderFormOnFirstPage(String name, String surname, String address, String metroStationName, String phoneNumber) {
        setName(name);
        setSurname(surname);
        setAddress(address);
        selectMetroStationByName(metroStationName);
        setPhoneNumber(phoneNumber);
    }

    public void continueButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(continueButton));
        driver.findElement(continueButton).click();
    }

    public void selectDeliveryDate(String date) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(deliveryDateInput));
        driver.findElement(deliveryDateInput).sendKeys(date);
        driver.findElement(deliveryDateDataPicker).click();
    }

    public void selectRentPeriod(String rentPeriod) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(rentPeriodInput));
        driver.findElement(rentPeriodInput).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(rentPeriodSelect));
        driver.findElement(rentPeriodSelect).sendKeys(rentPeriod);
        driver.findElement(rentPeriodSelect).click();
    }

    public void selectScooterColour(String scooterColour) {
        if (Objects.equals(scooterColour, "чёрный жемчуг")) {
            driver.findElement(scooterBlackInput).click();
        }
        if (Objects.equals(scooterColour, "серая безысходность")) {
            driver.findElement(scooterGreyInput).click();
        }
    }

    public void setCommentToCourier(String commentToCourier) {
        driver.findElement(commentToCourierInput).sendKeys(commentToCourier);
    }

    public void fillOrderFormOnSecondPage(String deliveryDate, String rentPeriod, String scooterColour, String commentToCourier) {
        selectDeliveryDate(deliveryDate);
        selectRentPeriod(rentPeriod);
        selectScooterColour(scooterColour);
        setCommentToCourier(commentToCourier);
    }

    public void finishOrderButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(finishOrderButton));
        driver.findElement(finishOrderButton).click();
    }

    public void confirmOrderButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(confirmOrderButton));
        driver.findElement(confirmOrderButton).click();
    }

    public boolean isDisplayedOrderSuccess() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(orderSuccess));
        String orderSuccessText = driver.findElement(By.className("orderSuccess")).getText();
        WebElement orderSuccessElement = driver.findElement(By.xpath(orderSuccessText));
        if ((orderSuccessElement).getText().contains("Заказ оформлен")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isDisplayedOrderContentInput() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(orderContentInput));
        return driver.findElement(orderContentInput).isDisplayed();
    }
}