#Owner        : SHARP
#Author       : QA Team
#Description  : This is feature file for Hello Sign API Automation

Feature: Feature to test Hello Sign API cases

  @Regression @Basic1 @API @HelloSIgn @TC_HCM_001
  Scenario Outline: API: send get request for user account
    Given Send getAPI request for account with "<authcode>"
    Then validate <response_code>

    Examples:
      | authcode    | response_code |
      | valid       | 200           |
      | invalid     | 401           |

  @Regression @Basic1 @API @HelloSIgn @TC_HCM_002
  Scenario: API: send get request for user account with correct credentials
    Given Send getAPI Request for account
    Then validate response code
    And verify response body for Get Account

  @Regression @Basic1 @API @HelloSIgn @TC_HCM_003
  Scenario: API: verify user account
    Given Send post API Request to verify account
    Then validate response code
    And verify response body for verify account

  @Regression @Basic1 @API @HelloSIgn @TC_HCM_004
  Scenario: API: send get request for user account wrong credentials
    Given Send get API Request for wrong user
    Then validate response code
    And verify response body for Get Account

  @Regression @Basic1 @API @HelloSIgn @TC_HCM_005
  Scenario: API: Verify team details
    Given Send get API Request to verify team details
    Then validate response code
    And verify response body for Get Team
