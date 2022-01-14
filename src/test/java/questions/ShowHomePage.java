package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import ui.HomePageElements;

public class ShowHomePage implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor){
        //logout butonu tıklanabilir mi? kontrolünü yapıyor.
        return HomePageElements.LOGOUT_BTN.resolveFor(actor).isClickable();
    }

    public static ShowHomePage isClickableLogoutButton(){
        return new ShowHomePage();
    }
}
