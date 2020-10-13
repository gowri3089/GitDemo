package stepDefinitions;

import io.cucumber.java.Before;

public class Hooks {
    @Before ("@DeletePlace")
    public void beforeScenario() throws Throwable {
        //write code only of place_id is null
        if(placeValidations.place_id == null)
        //call the variable with the class name since the variable is declared static. If not static object name will be used to call.
        {
            placeValidations m = new placeValidations(); //code to get place_id
            m.add_place_payload("Gowri", "Hindi", "Moberly Lane");
            m.user_calls_something_api_with_something_http_request("addPlaceAPI", "POST");
            m.verify_placeid_created_maps_to_something_using_something("Gowri", "getPlaceAPI");
        }
    }
}
