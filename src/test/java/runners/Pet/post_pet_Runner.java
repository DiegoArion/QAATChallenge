package runners.Pet;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src\\test\\resources\\features\\Pet\\post_pet.feature",
        glue = "stepDefinitions.Pet")
public class post_pet_Runner {
}
