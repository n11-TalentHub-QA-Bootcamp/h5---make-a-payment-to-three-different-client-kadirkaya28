package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import ui.LoginPageElements;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginApp implements Task {
    private String username = "";
    private String password = "";

    public LoginApp(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    @Step("{0} user login with username and password")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LoginPageElements.VERSION_WARNING_BOX_OK_BTN, isClickable()).forNoMoreThan(5).seconds(),
                Click.on(LoginPageElements.VERSION_WARNING_BOX_OK_BTN),
                WaitUntil.the(LoginPageElements.PASSWORD_INPUT_FIELD, isClickable()).forNoMoreThan(5).seconds(),
                Click.on(LoginPageElements.USERNAME_INPUT_FIELD),
                SendKeys.of(this.username).into(LoginPageElements.USERNAME_INPUT_FIELD),
                SendKeys.of(this.password).into(LoginPageElements.PASSWORD_INPUT_FIELD),
                Click.on(LoginPageElements.LOGIN_BTN)
        );
    }

    public static LoginApp LoginWithUsernameAndPassword(String username, String password){
        return instrumented(LoginApp.class,username,password);
    }
}
