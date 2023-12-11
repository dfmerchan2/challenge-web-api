package web.co.com.saucedemo.userinterfaces;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

import static net.serenitybdd.screenplay.targets.Target.the;
import static org.openqa.selenium.By.id;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class LoginPage extends PageObject {

    public static final Target TXT_USUARIO = the("User input field")
            .located(id("user-name"));
    public static final Target TXT_PASSWORD = the("Key entry field")
            .located(id("password"));
    public static final Target BTN_LOGIN = the("Login button")
            .located(id("login-button"));

}
