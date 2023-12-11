package web.co.com.saucedemo.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import web.co.com.saucedemo.userinterfaces.LoginPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class Authentication implements Task {

    private final String user;
    private final String password;

    @Override
    @Step("{0} authenticates with email ******* and password *******")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(user).into(LoginPage.TXT_USUARIO),
                Enter.theValue(password).into(LoginPage.TXT_PASSWORD),
                Click.on(LoginPage.BTN_LOGIN)
        );
    }

    public static Performable inSauceDemo(String user, String password) {
        return instrumented(Authentication.class, user, password);
    }
}
