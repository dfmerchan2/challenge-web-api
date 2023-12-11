package api.co.com.petstore.tasks;

import io.restassured.http.ContentType;
import lombok.RequiredArgsConstructor;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.thucydides.core.annotations.Step;

import static api.co.com.petstore.utilities.EndPoints.USER;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.apache.http.HttpStatus.SC_OK;

@RequiredArgsConstructor
public class DeleteUser implements Task {

    private int statusCode = SC_OK;
    private final String username;

    @Override
    @Step("{0} delete the created user #username")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(USER.getValue())
                        .with(
                                request -> request
                                        .contentType(ContentType.JSON)
                                        .pathParam("username", username)
                                        .log().all())
        );
        SerenityRest.lastResponse().print();
        actor.should(seeThatResponse(response -> response.statusCode(statusCode)));
    }

    public static DeleteUser with(String username) {
        return instrumented(DeleteUser.class, username);
    }

    public DeleteUser withStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }
}
