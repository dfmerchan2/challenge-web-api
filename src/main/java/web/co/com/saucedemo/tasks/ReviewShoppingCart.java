package web.co.com.saucedemo.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import web.co.com.saucedemo.interactions.ValidateProductInformation;
import web.co.com.saucedemo.userinterfaces.CheckoutPage;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class ReviewShoppingCart implements Task {

    private final Map<Integer, List<String>> listProducts;

    @Override
    @Step("{0} check the products added to the shopping cart")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ValidateProductInformation.toBuy(listProducts),
                Click.on(CheckoutPage.BTN_CHECKOUT)
        );
    }

    public static Performable withAddedProducts(Map<Integer, List<String>> listProducts) {
        return instrumented(ReviewShoppingCart.class, listProducts);
    }
}
