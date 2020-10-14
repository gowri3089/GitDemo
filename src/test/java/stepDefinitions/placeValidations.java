package stepDefinitions;

import io.cucumber.gherkin.internal.com.eclipsesource.json.Json;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class placeValidations extends Utils {
    RequestSpecification res;
    ResponseSpecification responsespec;
    Response response1;
    static String place_id; //when declared static the variable can be accessed across the TC, else will become null for next TC
    TestDataBuild data = new TestDataBuild();
    @Given("^Add Place payload with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void add_place_payload(String name, String language, String address) throws Throwable{
         res=given().log().all().spec(requestSpecifictaion())
                .body(data.addplacePayload(name, language, address))   ;
    }

    @When("^User calls \"([^\"]*)\" API with \"([^\"]*)\" http request$")
    public void user_calls_something_api_with_something_http_request(String resource, String method) throws Throwable {
       //Constructor will be called with value of resource which we pass in feature file
        APIResources resourceAPI = APIResources.valueOf(resource);
        System.out.println(resourceAPI.getResource()); //will print the resource URL
        responsespec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        if (method.equalsIgnoreCase("POST"))
            response1 = res.when().post(resourceAPI.getResource());
        else if(method.equalsIgnoreCase("GET"))
            response1 = res.when().get(resourceAPI.getResource());
    }

    @Then("^the API call is success with Status code 200$")
    public void the_api_call_is_success_with_status_code_200() throws Throwable {
    assertEquals(response1.getStatusCode(),200);
    //.then().spec(responsespec).extract().response();
    }

    @And("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
    public void something_in_response_body_is_something(String strArg1, String strArg2) throws Throwable {

        assertEquals(getJsonPath(response1,strArg1),strArg2);
    }

    @And("^verify place_id created maps to \"([^\"]*)\" using \"([^\"]*)\"$")
    public void verify_placeid_created_maps_to_something_using_something(String actualname, String resource) throws Throwable {
        place_id=getJsonPath(response1,"place_id");
        res=given().log().all().spec(requestSpecifictaion()).queryParam("place_id",place_id);
        user_calls_something_api_with_something_http_request(resource, "GET");
        String expectedname = getJsonPath(response1,"name");
        assertEquals(actualname,expectedname);
    }
    @Given("DeletePlace payload")
    public void delete_place_payload() throws IOException {
       res= given().spec(requestSpecifictaion()).body(data.deletePlacePayload(place_id));
    }
}
