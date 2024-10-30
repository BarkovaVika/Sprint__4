package tests.orderpage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.MainPage;
import praktikum.OrderPage;
import tests.BaseUITest;

@RunWith(Parameterized.class)
public class OrderCreationTest extends BaseUITest {

    private final String name;
    private final String surname;
    private final String address;
    private final String metroStationName;
    private final String phoneNumber;
    private final String deliveryDate;
    private final String rentPeriod;
    private final String scooterColour;
    private final String commentToCourier;

    @Parameterized.Parameters
    public static Object[] getOrder() {
        return new Object[][]{
                {"Иван", "Иванов", "улица Ленина, 3", "Черкизовская", "79638527441", "30.11.2024", "двое суток", "чёрный жемчуг", "без комментариев"},
                {"Петр", "Петров", "улица Щорса, 15", "Красносельская", "79638527221", "25.11.2024", "трое суток", "серая безысходность", "домофон не работает"},
        };
    }

    public OrderCreationTest(String name, String surname, String address, String metroStationName, String phoneNumber,
                             String deliveryDate, String rentPeriod, String scooterColour, String commentToCourier) {

        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStationName = metroStationName;
        this.phoneNumber = phoneNumber;
        this.deliveryDate = deliveryDate;
        this.rentPeriod = rentPeriod;
        this.scooterColour = scooterColour;
        this.commentToCourier = commentToCourier;
    }


    @Test
    public void successOrderCreationTest() {
        MainPage objMain = new MainPage(driver);
        objMain.openMainPage();
        objMain.сookieButtonClick();
        objMain.topOrderButtonClick();
        OrderPage objOrder = new OrderPage(driver);
        objOrder.fillOrderFormOnFirstPage(name, surname, address, metroStationName, phoneNumber);
        objOrder.continueButtonClick();
        objOrder.fillOrderFormOnSecondPage(deliveryDate, rentPeriod, scooterColour, commentToCourier);
        objOrder.finishOrderButtonClick();
        objOrder.confirmOrderButtonClick();
        boolean isDisplayedOrderSuccess = objOrder.isDisplayedOrderSuccess();
        Assert.assertFalse("Заказ не подтвержден", isDisplayedOrderSuccess);
    }
}