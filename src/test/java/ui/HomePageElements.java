package ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePageElements {
    public static final Target LOGOUT_BTN = Target.the("home page logout button")
            .located(By.id("com.experitest.ExperiBank:id/logoutButton"));
    public static final Target MAKE_A_PAYMENT_BTN = Target.the("make a payment button in home page")
            .located(By.id("com.experitest.ExperiBank:id/makePaymentButton"));
    public static final Target MY_AMOUNT_TEXT = Target.the("My amount text in home page")
            .located(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.widget.TextView"));
    public static final Target BALANCE = Target.the("user account balance")
            .located(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.widget.TextView"));
}
