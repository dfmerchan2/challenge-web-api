package web.co.com.saucedemo.interactions;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Step;
import web.co.com.saucedemo.userinterfaces.CheckoutPage;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class ValidateProductInformation implements Interaction {

    private final Map<Integer, List<String>> listProducts;

    @Override
    @Step("{0} validate the information of the products to be purchased")
    public <T extends Actor> void performAs(T actor) {
        listProducts
                .forEach((key, value) -> actor.attemptsTo(
                        Ensure.that(CheckoutPage.LBL_PRODUCT_NAME.of(String.valueOf(key + 1))).text()
                                .isEqualTo(value.get(0)),
                        Ensure.that(CheckoutPage.LBL_PRODUCT_DESCRIPTION.of(String.valueOf(key + 1))).text()
                                .isEqualTo(value.get(1)),
                        Ensure.that(CheckoutPage.LBL_PRICE_PRODUCT.of(String.valueOf(key + 1))).text()
                                .contains(value.get(2))
                ));
    }

    public static Performable toBuy(Map<Integer, List<String>> listProducts) {
        return instrumented(ValidateProductInformation.class, listProducts);
    }
}
