package stepDefinitions.Pet;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import stepDefinitions.coreStepDefinitions;
import utils.Pet;

public class get_pet_findByTags extends coreStepDefinitions {

    private Pet pet = new Pet();
    String endpoint = pet.endpointFindByTags;
    private Response response;

    // =====================================================
    // SCENARIO: Find pets by Tag
    // =====================================================
    @Given("the API endpoint for finding pets by tags is available")
    public void theApiEndpointForFindingPetsByStatusIsAvailable(){
    }

    @When("I send a GET request to endpoint with tags {string}")
    public void iSendAGETRequestToEndpointWithStatus(String tags) {
        requestGetParams(endpoint, "tags", tags);
    }

    @Then("the response status code for findByTags endpoint should be {int}")
    public void theResponseStatusCodeForFindbytagsEndpointShouldBe(int status) {
        verifyStatusCode(status);
    }

    @And("the response should contain pets with tags {string}")
    public void theResponseShouldContainPetsWithStatus(String arg0) {
    }
}
