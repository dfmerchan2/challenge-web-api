package web.co.com.saucedemo.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Step;
import web.co.com.saucedemo.interactions.SelectProduct;
import web.co.com.saucedemo.userinterfaces.ProductPage;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class AddProducts implements Task {

    private final List<String> listProducts;

    @Override
    @Step("{0} add the products to the shopping cart")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectProduct.toBuy(listProducts));
        actor.attemptsTo(
                Ensure.that(ProductPage.QUANTITY_PRODUCTS.resolveFor(actor).getText())
                        .isEqualTo(String.valueOf(listProducts.size())),
                Click.on(ProductPage.BTN_CART)
        );
    }

    public static Performable toShoppingCart(List<String> listProducts) {
        return instrumented(AddProducts.class, listProducts);
    }
}
