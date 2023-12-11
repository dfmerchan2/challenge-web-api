package api.co.com.petstore.tasks;

import api.co.com.petstore.models.User;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class ReviewUserData implements Task {

    private final User userRequest;
    private final User userResponse;

    @Override
    @Step("{0} Review user information")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Ensure.that(userRequest.getId()).isEqualTo(userResponse.getId()),
                Ensure.that(userRequest.getUsername()).isEqualTo(userResponse.getUsername()),
                Ensure.that(userRequest.getFirstName()).isEqualTo(userResponse.getFirstName()),
                Ensure.that(userRequest.getLastName()).isEqualTo(userResponse.getLastName()),
                Ensure.that(userRequest.getEmail()).isEqualTo(userResponse.getEmail()),
                Ensure.that(userRequest.getPassword()).isEqualTo(userResponse.getPassword()),
                Ensure.that(userRequest.getPhone()).isEqualTo(userResponse.getPhone()),
                Ensure.that(userRequest.getUserStatus()).isEqualTo(userResponse.getUserStatus())
        );
    }

    public static ReviewUserData with(User userRequest, User userResponse) {
        return instrumented(ReviewUserData.class, userRequest, userResponse);
    }

}
