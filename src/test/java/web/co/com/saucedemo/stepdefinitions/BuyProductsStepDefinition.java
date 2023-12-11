package web.co.com.saucedemo.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import web.co.com.saucedemo.interactions.OpenBrowser;
import web.co.com.saucedemo.models.builder.UserBuilder;
import web.co.com.saucedemo.tasks.*;
import web.co.com.saucedemo.userinterfaces.PurchaseFinishPage;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;
import static web.co.com.saucedemo.utilities.ActorNotepad.DATA_PRODUCT;

public class BuyProductsStepDefinition {
    @Given("that {string} authenticates with user {string} and password {string}")
    public void thatAuthenticatesWithUserAndPassword(String actor, String user, String password) {
        theActorCalled(actor).attemptsTo(
                OpenBrowser.inSauceDemo(),
                Authentication.inSauceDemo(user, password)
        );
    }

    @When("add the products to the shopping cart")
    public void addTheProductsToTheShoppingCart(List<String> listProducts) {
        theActorInTheSpotlight().attemptsTo(
                AddProducts.toShoppingCart(listProducts)
        );
    }

    @And("carry out the checkout process")
    public void carryOutTheCheckoutProcess() {
        Map<Integer, List<String>> listProducts = theActorInTheSpotlight().recall(DATA_PRODUCT.getKey());
        theActorInTheSpotlight().attemptsTo(
                ReviewShoppingCart.withAddedProducts(listProducts),
                AddUserInformation.forPurchase(UserBuilder.datUser()),
                ReviewPaymentSummary.toFinalizeThePurchase(listProducts)
        );
    }

    @Then("should see the message {string} of the successful purchase")
    public void shouldSeeTheMessageOfTheSuccessfulPurchase(String message) {
        theActorInTheSpotlight().should(
                seeThat("Validating the purchase success message",
                        actor -> PurchaseFinishPage.LBL_MESSAGE_SUCCESSFUL_PURCHASE.resolveFor(actor).getText(),
                        equalTo(message)));
    }
}
