package runners.Store;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src\\test\\resources\\features\\Store\\post_store_order.feature",
        glue = "stepDefinitions.Store")
public class post_store_order_Runner {
}
