package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import ui.HomePageElements;

public class AvailableBalance implements Question<Float> {
    @Override
    public Float answeredBy(Actor actor){
        //Your balance is: 100.00$
        //String ifadenin bakiye kısmını parçalıyor.
        String balanceScreen = HomePageElements.BALANCE.resolveFor(actor).getText();
        return Float.parseFloat(balanceScreen.substring(balanceScreen.indexOf(":")+1,balanceScreen.length()-1).trim());
    }

    public static AvailableBalance isCorrectAvailableBalance(){
        return new AvailableBalance();
    }
}
