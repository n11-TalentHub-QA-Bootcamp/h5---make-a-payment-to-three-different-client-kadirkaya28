package ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MakePaymentPageElements {
    public static final Target PHONE_INPUT_FIELD = Target.the("phone input in payment page")
            .located(By.id("com.experitest.ExperiBank:id/phoneTextField"));
    public static final Target NAME_INPUT_FIELD = Target.the("name input in payment page")
            .located(By.id("com.experitest.ExperiBank:id/nameTextField"));
    public static final Target AMOUNT_SLIDER_BAR = Target.the("amount slider bar in payment page")
            .located(By.id("com.experitest.ExperiBank:id/amount"));
    public static final Target SELECT_COUNTRY_BTN = Target.the("select country button in payment page")
            .located(By.id("com.experitest.ExperiBank:id/countryButton"));
    public static final Target SEND_PAYMENT_BTN = Target.the("send payment button")
            .located(By.id("com.experitest.ExperiBank:id/sendPaymentButton"));
    public static final Target COUNTRY_LIST = Target.the("county list")
            .locatedBy("#text1");
    public static final Target CONFIRM_SEND_BTN = Target.the("confirm send money button")
            .located(By.id("android:id/button1"));
}
