package web.co.com.saucedemo.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Step;
import web.co.com.saucedemo.interactions.ValidateProductInformation;
import web.co.com.saucedemo.userinterfaces.CheckoutPage;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class ReviewPaymentSummary implements Task {

    private final Map<Integer, List<String>> listProducts;

    @Override
    @Step("{0} review the purchase summary")
    public <T extends Actor> void performAs(T actor) {

        double itemTotal = listProducts.values()
                .stream().mapToDouble(i -> Double.parseDouble(i.get(2))).sum();

        actor.attemptsTo(
                ValidateProductInformation.toBuy(listProducts),
                Ensure.that(CheckoutPage.LBL_ITEM_TOTAL).text().contains(String.valueOf(itemTotal)),
                Scroll.to(CheckoutPage.BTN_FINISH),
                Click.on(CheckoutPage.BTN_FINISH)
        );
    }

    public static Performable toFinalizeThePurchase(Map<Integer, List<String>> listProducts) {
        return instrumented(ReviewPaymentSummary.class, listProducts);
    }
}
