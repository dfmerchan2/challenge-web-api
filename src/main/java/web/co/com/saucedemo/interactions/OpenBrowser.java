package web.co.com.saucedemo.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import web.co.com.saucedemo.userinterfaces.LoginPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class OpenBrowser implements Interaction {

    private LoginPage loginPage;

    @Override
    @Step("{0} open the browser with the url #url")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn(loginPage)
        );
    }

    public static Performable inSauceDemo() {
        return instrumented(OpenBrowser.class);
    }
}
