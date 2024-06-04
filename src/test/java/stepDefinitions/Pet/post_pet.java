package stepDefinitions.Pet;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import stepDefinitions.coreStepDefinitions;
import utils.Pet;

import static io.restassured.RestAssured.given;

public class post_pet extends coreStepDefinitions {

    private Pet pet = new Pet();
    String endpoint = pet.endpointPet;
    private Response response;

    // =====================================================
    // SCENARIO: Successfully create a new pet to the store
    // =====================================================
    @Given("I have a valid data to create a new pet")
    public void I_have_a_valid_data_to_creat_a_new_pet(){
        pet.createDefaultPetObject();
    }

    @When("I send the POST request with the valid data")
    public void iSendThePOSTRequestWithTheValidData() {
        String petSchema = pet.accessPetSchema();
        requestPostBody(endpoint, petSchema);
    }

    @Then("the response include the valid new pet data I send")
    public void theResponseIncludeTheValidNewPetDataISend() {
        compareResponseBodyJsonFile(pet.validPetJson);
    }

    @And("the status code for the post pet is {int}")
    public void theStatusCodeForThePostPetIs(int statusCode) {
        verifyStatusCode(statusCode);
    }

    // =====================================================
    // SCENARIO: Successfully create 3 new pets to store
    // =====================================================
    @Given("I have valid data with {string}, {string}, {string}, {string}, {string}, {string}, {string} and {string} for 3 new pets")
    public void iHaveValidDataWithAndForNewPets(String id, String name, String category_id, String category_name, String photo_url, String tag_id, String tag_name, String status) {
        pet.createfullPetObject(id, name, category_id, category_name, photo_url, tag_id, tag_name, status);
    }

    @When("I send the post with all the data for each pet")
    public void iSendThePostWithAllTheDataForEachPet() {
        requestPostBody(endpoint, pet.accessPetSchema());
    }

    @Then("the response include the data of each pet")
    public void theResponseIncludeTheDataOfEachPet() {
        compareResponseBodyJsonSchema(pet.accessPetSchema());
    }

    @And("the status code for each request is {int}")
    public void theStatusCodeForEachRequestIs(int statusCode) {
        verifyStatusCode(statusCode);
    }

}
