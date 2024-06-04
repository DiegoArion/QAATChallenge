package stepDefinitions.Store;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import stepDefinitions.coreStepDefinitions;
import utils.Store;

public class post_store_order extends coreStepDefinitions {

    private Store store = new Store();
    String endpoint = store.endpointOrder;
    private Response response;

    // =====================================================
    // SCENARIO : Successfully place and order for a pet
    // =====================================================
    @Given("I have and valid store order data")
    public void iHaveAndValidStoreOrderData(){
        store.createDefaultStoreObject();
    }

    @When("I send a POST request with the store order data in the body")
    public void iSendAPOSTRequestWithTheStoreOrderDataInTheBody() {
        requestPostBody(endpoint, store.accessStoreSchema());
    }

    @Then("the response status code for post the order should be {int}")
    public void theResponseStatusCodeForPostTheOrderShouldBe(int statusCode) {
        verifyStatusCode(statusCode);
    }

}
