#Owner        : SHARP
#Author       : QA Team
#Description  : This is feature file for Emerson API Automation

Feature: Feature to test Emerson API cases

  @Regression @API @Emerson @EmersonAPI @TC_Emerson_API_001
  Scenario Outline: API: Hit post request for Emerson Login to validate response code
    Given Hit post API request for "<endPoint>" with "<authcode>"
    Then validate <response_code>

    Examples:
      | endPoint    | response_code | authcode  |
      | login       | 200           | valid     |
      | login       | 401           | invalid   |
      | check user  | 200           | valid     |
      | check user  | 401           | invalid   |

  @Regression @API @Emerson @EmersonAPI @TC_Emerson_API_002
  Scenario Outline: API: Hit post request for Emerson Login to validate response body
    Given Hit post API request for "<endPoint>" with "<authcode>"
    Then validate <response_code>
    And verify response body for "<endPoint>"

    Examples:
      | endPoint    | response_code | authcode  |
      | login       | 200           | valid     |
      | check user  | 200           | valid     |