package stepDefinitions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.javacrumbs.jsonunit.assertj.JsonAssertions;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class coreStepDefinitions {

    public String hostEndpoint = "https://petstore3.swagger.io/api/v3/";
    private Response response;

    // CONNECTION ==========================================
    public boolean verifyEndpointConnection(String endpoint){
        try {
            Response response = RestAssured.given()
                    .baseUri(hostEndpoint)
                    .when()
                    .options(endpoint);
            int statusCode = response.getStatusCode();
            return statusCode == 200 || statusCode == 204;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // REQUESTS ==========================================
    public void requestPutBody(String endpoint, String petSchema){
        response = given()
                .baseUri(hostEndpoint)
                .contentType(ContentType.JSON)
                .body(petSchema)
                .put(endpoint);
    }
    public void requestPostBody(String endpoint, String petSchema){
        response = given()
                .baseUri(hostEndpoint)
                .contentType(ContentType.JSON)
                .body(petSchema)
                .post(endpoint);
    }
    public void requestGet(String endpoint){
        response = RestAssured.given()
                .baseUri(hostEndpoint)
                .when()
                .get(endpoint);
    }
    public void requestGetParams(String endpoint, String key, String value){
        response = RestAssured.given()
                .baseUri(hostEndpoint)
                .queryParam(key,value)
                .when()
                .get(endpoint);
    }
    public void requestGetPath(String endpoint, String path){
        response = RestAssured.given()
                .baseUri(hostEndpoint)
                .pathParams("value", path)
                .when()
                .get(endpoint + "{value}");
    }
    public void requestPostPathQuery(String endpoint, String id, HashMap<String, String> querys){
        response = RestAssured.given()
                .baseUri(hostEndpoint)
                .queryParam("name", querys.get("value1"))
                .queryParam("status", querys.get("value2"))
                .pathParams("value", id)
                .when()
                .get(endpoint + "{value}");
    }
    public void requestDeletePath(String endpoint, String path){
        response = RestAssured.given()
                .baseUri(hostEndpoint)
                .pathParams("value", path)
                .when()
                .get(endpoint + "{value}");
    }

    // COMPARE ==========================================
    public void compareResponseBodyJsonFile(String urlValidateSchema){
        String expectedJson;
        try {
            expectedJson = new String(Files.readAllBytes(Paths.get(urlValidateSchema)));
            String actualJson = response.getBody().asString();
            JsonAssertions.assertThatJson(actualJson).isEqualTo(expectedJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void compareResponseBodyJsonSchema(String jsonSchema){
        String jsonResponse = response.getBody().asString();
        System.out.println(jsonSchema);
        try {
            // Comparar ambos JSON utilizando JSONAssert
            JSONAssert.assertEquals(jsonSchema, jsonResponse, JSONCompareMode.STRICT);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    // VERIFY ==========================================
    public void verifyStatusCode(int statusCode ){
        response.then().statusCode(statusCode);
    }

}
