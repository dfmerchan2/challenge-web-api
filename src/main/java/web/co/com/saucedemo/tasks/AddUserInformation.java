package web.co.com.saucedemo.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import web.co.com.saucedemo.models.User;
import web.co.com.saucedemo.userinterfaces.InformationPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class AddUserInformation implements Task {

    private final User user;

    @Override
    @Step("{0} enter your personal data")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(user.getFirstName()).into(InformationPage.TXT_FIRST_NAME),
                Enter.theValue(user.getLastName()).into(InformationPage.TXT_LAST_NAME),
                Enter.theValue(user.getPostalCode()).into(InformationPage.TXT_POSTAL_CODE),
                Click.on(InformationPage.BTN_CONTINUE)
        );
    }

    public static Performable forPurchase(User user) {
        return instrumented(AddUserInformation.class, user);
    }
}
