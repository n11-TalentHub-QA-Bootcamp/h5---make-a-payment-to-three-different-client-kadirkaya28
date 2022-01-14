package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import questions.AvailableBalance;
import tasks.LoginApp;
import tasks.MakePayment;
import ui.HomePageElements;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class PaymentSteps {
    private float firstBalance;
    @Managed(driver = "Appium")
    public WebDriver herMobileDevice;

    String actorName="kadir";
    Actor actor = Actor.named(actorName);

    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("User logged in EriBank Application")
    public void userLoggedInEriBankApplication() {
        // emulatörü ayağa kaldıryoruz.
        actor.can(BrowseTheWeb.with(herMobileDevice));
        //Kullanıcı girişi yapıyoruz.
        actor.attemptsTo(LoginApp.LoginWithUsernameAndPassword("company","company"));
    }

    @When("User make a payment to {string} {string} {string} and {string} dollars")
    public void userMakeAPaymentToNamePhoneCountryAndAmountDollars(String name, String phone, String country, String amount) {
        //İlk bakiyemizi alıyoruz
        String balanceScreen = HomePageElements.BALANCE.resolveFor(actor).getText();
        this.firstBalance = Float.parseFloat(balanceScreen.substring(balanceScreen.indexOf(":")+2,balanceScreen.indexOf("$")));
        // Bakiyemizden belirli bir para aktaryırouz
        actor.attemptsTo(MakePayment.MakePaymentWithInformation(name,phone,country,amount)
        );
    }

    @Then("User should see their balance drop {string} dollars")
    public void userShouldSeeTheirBalanceDropDollars(String amount) {
        //Bakiyemizden aktardığımız para bakiyemizden doğru bir şekilde düşmüş mü? kontrolünü yapıyoruz
        actor.should(seeThat(AvailableBalance.isCorrectAvailableBalance(),is(firstBalance-Float.parseFloat(amount))));
    }
}
