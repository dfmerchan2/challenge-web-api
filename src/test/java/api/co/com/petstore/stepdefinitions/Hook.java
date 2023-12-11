package api.co.com.petstore.stepdefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static api.co.com.petstore.utilities.EndPoints.END_POINTS_BASE;

public class Hook {

    @Before
    public void beforeScenario() {
        OnStage.setTheStage(
                OnlineCast.whereEveryoneCan(
                        CallAnApi.at(END_POINTS_BASE.getValue())
                )
        );
    }
}
