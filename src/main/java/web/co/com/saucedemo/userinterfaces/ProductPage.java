package web.co.com.saucedemo.userinterfaces;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.targets.BaseTarget.the;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductPage {

    public static final Target LBL_PRODUCT_DESCRIPTION = the("Button to add the product to the cart")
            .locatedBy("//a[contains(.,'{0}')]//following-sibling::div");

    public static final Target BTN_ADD_TO_CART = the("Button to add the product to the cart")
            .locatedBy("//a[contains(.,'{0}')]/../following-sibling::div//button");

    public static final Target LBL_PRICE_THE_PRODUCT = the("Price of the selected product")
            .locatedBy("//a[contains(.,'{0}')]/../following-sibling::div//div");

    public static final Target QUANTITY_PRODUCTS = the("Price of the selected product")
            .locatedBy("[class*=' shopping_cart_badge']");

    public static final Target BTN_CART = the("Shopping cart button")
            .located(By.className("shopping_cart_link"));

}