package runners.Pet;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src\\test\\resources\\features\\Pet\\get_pet_findByStatus.feature",
        glue = "stepDefinitions.Pet")
public class get_pet_findByStatus_Runner {
}
