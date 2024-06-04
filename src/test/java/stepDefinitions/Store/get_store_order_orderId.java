package stepDefinitions.Store;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import stepDefinitions.coreStepDefinitions;
import utils.Store;

public class get_store_order_orderId extends coreStepDefinitions {

    private Store store = new Store();
    String endpoint = store.endpointOrder;
    private Response response;

    // =====================================================
    // SCENARIO : Successfully Find purchase order by ID
    // =====================================================
    @Given("I have a valid ID as {int}")
    public void iHaveAValidIdAs(int id){
        store.id = id;
    }

    @When("I send a GET request with the order ID in the path")
    public void iSendAGETRequestWithTheOrderIDInThePath() {
        requestGetPath(endpoint, String.valueOf(store.id));
    }

    @Then("the response status code for get the order should be {int}")
    public void theResponseStatusCodeForGetTheOrderShouldBe(int statusCode) {
        verifyStatusCode(statusCode);
    }
}
