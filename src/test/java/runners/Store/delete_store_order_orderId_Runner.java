package runners.Store;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src\\test\\resources\\features\\Store\\delete_store_order_orderId.feature",
        glue = "stepDefinitions.Store")
public class delete_store_order_orderId_Runner {
}
