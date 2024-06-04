package stepDefinitions.Pet;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import stepDefinitions.coreStepDefinitions;
import utils.Pet;

public class get_pet_findByStatus extends coreStepDefinitions {

    private Pet pet = new Pet();
    String endpoint = pet.endpointFindByStatus;
    private Response response;

    // =====================================================
    // SCENARIO OUTLINE: Find pets by different statuses
    // =====================================================
    @Given("the API endpoint for finding pets by status is available")
    public void theApiEndpointForFindingPetsByStatusIsAvailable(){
    }

    @When("I send a GET request to endpoint with status {string}")
    public void iSendAGETRequestToEndpointWithStatus(String status) {
        requestGetParams(endpoint, "status", status);
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int status) {
        verifyStatusCode(status);
    }

    @And("the response should contain pets with status {string}")
    public void theResponseShouldContainPetsWithStatus(String arg0) {
    }
}
