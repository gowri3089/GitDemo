Feature: Validating Place API
   @AddPlace
  Scenario Outline: Validation of Add place functionality
    Given Add Place payload with "<name>" "<language>" "<address>"
    When User calls "addPlaceAPI" API with "POST" http request
    Then the API call is success with Status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify place_id created maps to "<name>" using "getPlaceAPI"

    Examples:
      | name      | language | address         |
      | Kalpataru | Tamil    | 2203 SE S ST    |
      | Aarna     | Kannada  | 204 Coopers way |

   @DeletePlace
  Scenario: Verify Delete Place functionality
    Given DeletePlace payload
    When User calls "delPlaceAPI" API with "POST" http request
    Then the API call is success with Status code 200
    And "status" in response body is "OK"
