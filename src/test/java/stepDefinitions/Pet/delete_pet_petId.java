package stepDefinitions.Pet;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import stepDefinitions.coreStepDefinitions;
import utils.Pet;

public class delete_pet_petId extends coreStepDefinitions {

    private Pet pet = new Pet();
    String endpoint = pet.endpointPetid;
    private Response response;

    // =====================================================
    // SCENARIO : Successfully deletes a pet
    // =====================================================
    @Given("I have an existing pet with ID {int}")
    public void iIhaveAnExistingPetWithId(int ID){
        pet.createIdPetObject(String.valueOf(ID));
        requestPostBody(endpoint, pet.accessPetSchema());
        verifyStatusCode(200);
    }

    @When("I send a Delet request to the endpoint with same pet ID {int}")
    public void iSendADeletRequestToTheEndpointWithSamePetID(int ID) {
        requestDeletePath(endpoint, String.valueOf(ID));
    }

    @Then("the response status code for delete petId should be {int}")
    public void theResponseStatusCodeForDeletePetIdShouldBe(int statusCode) {
        verifyStatusCode(statusCode);
    }

    @And("the response body should contain pets with status {string}")
    public void theResponseBodyShouldContainPetsWithStatus(String arg0) {
    }
}
