package web.co.com.saucedemo.userinterfaces;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.targets.BaseTarget.the;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class InformationPage {

    public static final Target TXT_FIRST_NAME = the("Username field")
            .located(By.id("first-name"));

    public static final Target TXT_LAST_NAME = the("Last name field")
            .located(By.id("last-name"));

    public static final Target TXT_POSTAL_CODE = the("postal code field")
            .located(By.id("postal-code"));

    public static final Target BTN_CONTINUE = the("Continue button")
            .locatedBy("[class*='cart_button']");

}
