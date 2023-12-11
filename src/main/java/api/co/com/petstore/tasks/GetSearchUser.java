package api.co.com.petstore.tasks;

import api.co.com.petstore.models.User;
import io.restassured.http.ContentType;
import lombok.RequiredArgsConstructor;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;
import questions.ResponseBody;

import static api.co.com.petstore.utilities.EndPoints.USER;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.apache.http.HttpStatus.SC_OK;

@RequiredArgsConstructor
public class GetSearchUser implements Task {

    private int statusCode = SC_OK;
    private final String username;

    @Override
    @Step("{0} Search for the created user #username")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(USER.getValue())
                        .with(
                                request -> request
                                        .contentType(ContentType.JSON)
                                        .pathParam("username", username)
                                        .log().all())
        );
        SerenityRest.lastResponse().print();
        actor.should(seeThatResponse(response -> response.statusCode(statusCode)));
    }

    public static GetSearchUser with(String username) {
        return instrumented(GetSearchUser.class, username);
    }

    public GetSearchUser withStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public static Question<User> getResponseBody() {
        return new ResponseBody<>(User.class, "");
    }

    public static String getMessageResponse(){
        return SerenityRest.lastResponse().body().path("message");
    }
}
