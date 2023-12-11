package web.co.com.saucedemo.userinterfaces;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.targets.BaseTarget;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.targets.Target.the;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CheckoutPage {

    public static final Target LBL_PRODUCT_NAME = the("Product name")
            .locatedBy("(//div[@class='inventory_item_name'])[{0}]");

    public static final Target LBL_PRODUCT_DESCRIPTION = the("Product description")
            .locatedBy("(//div[@class='inventory_item_desc'])[{0}]");

    public static final Target LBL_PRICE_PRODUCT = the("Price of the product")
            .locatedBy("(//div[@class='inventory_item_price'])[{0}]");

    public static final Target BTN_CHECKOUT = the("checkout button")
            .locatedBy("[class*='checkout_button']");

    public static final Target LBL_ITEM_TOTAL = the("checkout button")
            .located(By.className("summary_subtotal_label"));

    public static final Target BTN_FINISH = BaseTarget.the("Finish button")
            .locatedBy("[class*='cart_button']");
}
