package web.co.com.saucedemo.stepdefinitions;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;

import static web.co.com.saucedemo.utilities.DriverManager.getBrowser;
import static web.co.com.saucedemo.utilities.DriverManager.getWebDriver;

public class Hook {

    @Before
    public void beforeScenario() {
        String browser = getBrowser();
        WebDriverManager.getInstance(browser).setup();
        OnStage.setTheStage(
                Cast.whereEveryoneCan(BrowseTheWeb.with(getWebDriver(browser)))
        );
    }
}
