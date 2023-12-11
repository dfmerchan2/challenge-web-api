package api.co.com.petstore.stepdefinitions;

import api.co.com.petstore.models.User;
import api.co.com.petstore.models.builder.UserBuilder;
import api.co.com.petstore.tasks.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static api.co.com.petstore.utilities.ActorNotepad.USER_REQUEST;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class UserOperationsStepDefinition {

    @Given("that {string} create and consult the new user in the system")
    public void thatCreateAndConsultTheNewUserInTheSystem(String actor) {
        User userRequest = UserBuilder.userRequest();
        theActorCalled(actor).remember(USER_REQUEST.getKey(), userRequest);

        theActorCalled(actor).attemptsTo(
                PostCreateUser.with(userRequest),
                GetSearchUser.with(userRequest.getUsername()));

        User userResponse = theActorCalled(actor).asksFor(GetSearchUser.getResponseBody());

        theActorCalled(actor).attemptsTo(
                ReviewUserData.with(userRequest, userResponse));

    }

    @When("Update and consult user information")
    public void updateAndConsultUserInformation() {
        User user = theActorInTheSpotlight().recall(USER_REQUEST.getKey());
        User userRequest = UserBuilder.updateUser(user);

        theActorInTheSpotlight().attemptsTo(
                UpdatedUser.with(userRequest),
                GetSearchUser.with(userRequest.getUsername()));

        User userResponse = theActorInTheSpotlight().asksFor(GetSearchUser.getResponseBody());

        theActorInTheSpotlight().attemptsTo(
                ReviewUserData.with(userRequest, userResponse));
    }

    @And("delete the user successfully")
    public void deleteTheUserSuccessfully() {
        User user = theActorInTheSpotlight().recall(USER_REQUEST.getKey());
        theActorInTheSpotlight().attemptsTo(
                DeleteUser.with(user.getUsername())
        );
    }

    @Then("search for the user should see the message {string} and a {int} code")
    public void searchForTheUserShouldSeeTheMessageAndACode(String message, Integer statusCode) {
        User user = theActorInTheSpotlight().recall(USER_REQUEST.getKey());
        theActorInTheSpotlight().attemptsTo(
                GetSearchUser.with(user.getUsername())
                        .withStatusCode(statusCode));

        theActorInTheSpotlight().should(seeThat(
                actorSee -> GetSearchUser.getMessageResponse(), equalTo(message))
        );
    }

}
