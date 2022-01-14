package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import ui.LoginPageElements;

public class ShowLoginErrorMessage implements Question<String> {
    @Override
    public String answeredBy(Actor actor){
        //hata mesajının string ifadesini alıyoruz
        return LoginPageElements.USERNAME_AND_PASSWORD_ERROR_TOAST.resolveFor(actor).getText();
    }

    public static ShowLoginErrorMessage loginToastStatus(){
        return new ShowLoginErrorMessage();
    }
}
