package web.co.com.saucedemo.interactions;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import web.co.com.saucedemo.userinterfaces.ProductPage;

import java.util.*;
import java.util.stream.IntStream;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static web.co.com.saucedemo.utilities.ActorNotepad.DATA_PRODUCT;

@AllArgsConstructor
public class SelectProduct implements Interaction {

    private final List<String> listProducts;

    @Override
    @Step("{0} select the products to buy")
    public <T extends Actor> void performAs(T actor) {
        Map<Integer, List<String>> dataProducts = new LinkedHashMap<>();
        IntStream.range(0, listProducts.size())
                .forEach(i -> {
                            List<String> data = new ArrayList<>();
                            String product = listProducts.get(i);
                            data.add(product);
                            data.add(ProductPage.LBL_PRODUCT_DESCRIPTION.of(product).resolveFor(actor).getText());
                            data.add(ProductPage.LBL_PRICE_THE_PRODUCT.of(product).resolveFor(actor).getText().replace("$", ""));
                            dataProducts.put(i, data);
                            actor.attemptsTo(
                                    Click.on(ProductPage.BTN_ADD_TO_CART.of(product))
                            );
                        }
                );
        actor.remember(DATA_PRODUCT.getKey(), dataProducts);
    }

    public static Performable toBuy(List<String> listProducts) {
        return instrumented(SelectProduct.class, listProducts);
    }
}
