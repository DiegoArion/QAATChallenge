package stepDefinitions.Pet;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import stepDefinitions.coreStepDefinitions;
import utils.Pet;

public class get_pet_petId extends coreStepDefinitions {

    private Pet pet = new Pet();
    String endpoint = pet.endpointPetid;
    private Response response;

    // =====================================================
    // SCENARIO : Find pets by ID
    // =====================================================
    @Given("the API endpoint for finding pets by ID is available")
    public void theApiEndpointForFindingPetsByIdIsAvailable(){
    }

    @When("I send a GET request to endpoint with ID {int}")
    public void iSendAGETRequestToEndpointWithID(int ID) {
        requestGetPath(endpoint, String.valueOf(ID));

    }

    @Then("the response status code for petId should be {int}")
    public void theResponseStatusCodeForPetIdShouldBe(int arg0) {
    }


}
