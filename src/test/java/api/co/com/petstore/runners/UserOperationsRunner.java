package api.co.com.petstore.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/feature/api/user_operations.feature",
        plugin = {"pretty", "summary"},
        glue = "api.co.com.petstore.stepdefinitions",
        snippets = CAMELCASE
)
public class UserOperationsRunner {
}
