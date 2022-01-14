package interactions;


import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;
import ui.MakePaymentPageElements;

import java.util.List;
import java.util.Objects;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectCountry implements Interaction {
    private String country = "";

    public SelectCountry(String country) {
        this.country = country;
    }

    @Override
    @Step("{0} select country")
    public <T extends Actor> void performAs(T actor) {
        List<WebElementFacade> countries = MakePaymentPageElements.COUNTRY_LIST.resolveAllFor(actor);

        /*
        countries.stream().filter(countryElement -> countryElement.getText().equals(country))
                .forEach(WebElementFacade::click);
        */

        for (WebElementFacade countryElement : countries){
            if (Objects.equals(countryElement.getText(),country)) {
                countryElement.click();
                break;
            }
        }
    }

    public static Interaction with(String country) {
        return instrumented(SelectCountry.class,country);
    }
}
