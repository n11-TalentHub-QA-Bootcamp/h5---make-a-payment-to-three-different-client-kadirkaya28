package ui;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPageElements {
    public static final Target VERSION_WARNING_BOX_OK_BTN = Target.the("version warning box ok button in login page")
            .located(By.id("android:id/button1"));
    public static final Target USERNAME_INPUT_FIELD = Target.the("login page username input field")
            .located(By.id("com.experitest.ExperiBank:id/usernameTextField"));
    public static final Target PASSWORD_INPUT_FIELD = Target.the("login page password input field")
            .located(By.id("com.experitest.ExperiBank:id/passwordTextField"));
    public static final Target LOGIN_BTN = Target.the("login button in login page")
            .located(By.id("com.experitest.ExperiBank:id/loginButton"));
    public static final Target USERNAME_AND_PASSWORD_ERROR_TOAST = Target.the("username and password error toast message")
            .locatedBy("/hierarchy/android.widget.Toast");
}
