package stepDefinitions.Store;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import stepDefinitions.coreStepDefinitions;
import utils.Pet;
import utils.Store;

public class get_store_inventory extends coreStepDefinitions {

    private Store store = new Store();
    String endpoint = store.endpointInventory;
    private Response response;

    // =====================================================
    // SCENARIO : Successfully get pet inventory by status
    // =====================================================
    @Given("endpoint store inventory is available")
    public void endpointStoreInventoryIsAvailable(){
        if(verifyEndpointConnection(endpoint)){
            System.out.println("El endpoint " + endpoint + " está disponible.");
        }
    }

    @When("I send a GET request to endpoint store inventory")
    public void iSendAGETRequestToEndpointStoreInventory() {
        requestGet(endpoint);
    }

    @Then("the response status code for get the store inventory should be {int}")
    public void theResponseStatusCodeForGetTheStoreInventoryShouldBe(int statusCode) {
        verifyStatusCode(statusCode);
    }
}
