package stepDefinitions.Pet;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import stepDefinitions.coreStepDefinitions;
import utils.Pet;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class put_pet extends coreStepDefinitions {

    private Pet pet = new Pet();
    String endpoint = pet.endpointPet;
    private Response response;

    // =====================================================
    // SCENARIO: Successfully update a pet
    // =====================================================
    @Given("I have the correct data to update an existing pet")
    public void iHaveTheCorrectDataToUpdateAnExistingPet(){
        pet.createDefaultPetObject();
    }

    @When("I send the PUT request with the new data")
    public void iSendThePUTRequestWithTheNewData() {
        String petSchema = pet.accessPetSchema();
        requestPutBody(endpoint, petSchema);
    }

    @Then("the response include the data I send")
    public void theResponseIncludeTheDataISend() {
        compareResponseBodyJsonFile(pet.validPetJson);
        /*
        String expectedJson;
        try {
            expectedJson = new String(Files.readAllBytes(Paths.get(pet.urlvalidPetSchemaJson)));
            String actualJson = response.getBody().asString();
            JsonAssertions.assertThatJson(actualJson).isEqualTo(expectedJson);
        } catch (IOException e) {
            e.printStackTrace();
        }

         */
    }

    @And("the status code, Successfully is {int}")
    public void theStatusCodeSuccessfullyIs(int statusCode) {
        verifyStatusCode(statusCode);
        /*
        response.then().statusCode(statusCode);
         */
    }

    // =====================================================
    // SCENARIO: Trying to update a pet with unregistered id
    // =====================================================
    @Given("I have an unregistered ID from a pet in the data like {int}")
    public void iHaveAnUnregisteredIDFromAPetInTheDataLike110(int petId) {
        pet.createIdPetObject(petId);
    }

    @When("I send the PUT request with the incorrect data")
    public void iSendThePUTRequestWithTheIncorrectData() {
        String petSchema = pet.accessPetSchema();
        response = given()
                .baseUri(hostEndpoint)
                .contentType(ContentType.JSON)
                .body(petSchema)
                .when()
                .put(endpoint);
    }

    @Then("the response body is {string}")
    public void theResponseBodyIs(String statusMessage) {
        response.then().body(equalTo(statusMessage));
    }

    @And("the status code, Pet not found is {int}")
    public void theStatusCodePetNotFoundIs(int statusCode) {
        response.then().statusCode(statusCode);
    }

    // =====================================================
    // SCENARIO: Trying to update a pet with invalid id
    // =====================================================
    @Given("I have an invalid ID like {string} in the data form a pet")
    public void iHaveAnInvalidIDInTheDataFormAPet(String petId) {
        pet.createIdPetObject(petId);
    }

    @When("I send the PUT request with the invalid ID")
    public void iSendThePUTRequestWithTheInvalidID() {
        String petSchema = pet.accessPetSchema();
        response = given()
                .baseUri(hostEndpoint)
                .contentType(ContentType.JSON)
                .body(petSchema)
                .when()
                .put(endpoint);
    }

    @And("the status code, Invalid ID Supplied is {int}")
    public void theStatusCodeIs(int statusCode) {
        response.then().statusCode(statusCode);
    }
}
