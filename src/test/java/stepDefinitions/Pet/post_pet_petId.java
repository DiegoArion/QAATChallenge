package stepDefinitions.Pet;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import stepDefinitions.coreStepDefinitions;
import utils.Pet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class post_pet_petId extends coreStepDefinitions {

    private Pet pet = new Pet();
    String endpoint = pet.endpointPetid;
    private Response response;

    // =====================================================
    // SCENARIO : Updates a pet in the store with form data
    // =====================================================
    @Given("I have the ID from an existing pet with ID {int}")
    public void iHaveTheIdFromAnExistingPet(int ID){
        requestGetPath(endpoint, String.valueOf(ID));
        verifyStatusCode(200);
    }

    @When("I send a POST request to the endpoint with same pet ID {int} for set the name {string} and status {string}")
    public void iSendAPOSTRequestToTheEndpointWithSamePetIDForSetTheNameAndStatus(int ID, String query1, String query2) {
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("name", query1);
        queryParams.put("status", query2);
        requestPostPathQuery(endpoint, String.valueOf(ID), queryParams);
    }


    @Then("the response status code for post petId should be {int}")
    public void theResponseStatusCodeForPostPetIdShouldBe(int statusCode) {
        verifyStatusCode(statusCode);
    }

}
