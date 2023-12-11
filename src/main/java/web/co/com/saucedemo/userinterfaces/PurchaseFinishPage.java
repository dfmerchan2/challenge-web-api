package web.co.com.saucedemo.userinterfaces;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.targets.BaseTarget.the;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PurchaseFinishPage {

    public static final Target LBL_MESSAGE_SUCCESSFUL_PURCHASE = the("Successful purchase message")
            .located(By.className("complete-header"));

}
