package web.co.com.saucedemo.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/feature/web/buy_products.feature",
        plugin = {"pretty", "summary"},
        glue = "web.co.com.saucedemo.stepdefinitions",
        snippets = CAMELCASE
)
public class BuyProductsRunner {

}
