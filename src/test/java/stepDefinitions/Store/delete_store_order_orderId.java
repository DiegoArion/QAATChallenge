package stepDefinitions.Store;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import stepDefinitions.coreStepDefinitions;
import utils.Store;

public class delete_store_order_orderId extends coreStepDefinitions {

    private Store store = new Store();
    String endpoint = store.endpointOrder;
    private Response response;

    // =====================================================
    // SCENARIO : Successfully place and order for a pet
    // =====================================================
    @Given("I have a valid ID from an existent order to be deleted, as {int}")
    public void iHaveAValidIdFromAnExistentOrderToBeDeletesAs(int id){
        store.id = id;
        requestGetPath(endpoint, String.valueOf(id));
        verifyStatusCode(200);
    }

    @When("I send a DELETE request with the order ID in the path")
    public void iSendADELETERequestWithTheOrderIDInThePath() {
        requestDeletePath(endpoint, String.valueOf(store.id));
    }

    @Then("the response status code for delete the order should be {int}")
    public void theResponseStatusCodeForDeleteTheOrderShouldBe(int statusCode) {
        verifyStatusCode(statusCode);
    }
}
