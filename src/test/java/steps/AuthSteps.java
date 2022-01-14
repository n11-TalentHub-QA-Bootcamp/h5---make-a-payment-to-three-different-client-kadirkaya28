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
import questions.ShowHomePage;
import tasks.LoginApp;
import questions.ShowLoginErrorMessage;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;


public class AuthSteps {
    @Managed(driver = "Appium")
    public WebDriver herMobileDevice;

    String actorName="kadir";
    Actor actor = Actor.named(actorName);

    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("User in the login page of Eribank Application")
    public void userInTheLoginPageOfEribankApplication() {
        // emulatörü ayağa kaldıryoruz.
        actor.can(BrowseTheWeb.with(herMobileDevice));
    }

    @When("User login with incorrect {string} for username and {string} for password")
    public void userLoginWithIncorrectForUsernameAndForPassword(String username, String password) {
        //hatalı kullanıcı bilgileri ile giriş yapmayı deniyoruz
        actor.attemptsTo(LoginApp.LoginWithUsernameAndPassword(username,password));
    }

    @Then("User should see error message")
    public void userShouldSeeErrorMessage() {
        // Invalid username or password! döndüyse giriş başarısız
        actor.should(seeThat(ShowLoginErrorMessage.loginToastStatus(),is("Invalid username or password!")));
    }

    @When("User login with correct {string} for username and {string} for password to the Eribank application")
    public void userLoginWithCorrectForUsernameAndForPasswordToTheEribankApplication(String username, String password) {
        //doğru kullanıcı bilgileri ile giriş yapmayı deniyoruz
        actor.attemptsTo(LoginApp.LoginWithUsernameAndPassword(username,password));
    }

    @Then("User should be taken to the home page")
    public void userShouldBeTakenToTheHomePage() {
        //logout butonu geldiyse giriş başarılı
        actor.should(seeThat(ShowHomePage.isClickableLogoutButton(),is(true)));
    }
}
