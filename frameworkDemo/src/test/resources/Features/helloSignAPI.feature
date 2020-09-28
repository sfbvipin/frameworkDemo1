#Owner        : SHARP
#Author       : QA Team
#Description  : This is feature file for Hello Sign API Automation

Feature: Feature to test Hello Sign API cases

  @Regression @Basic @API @HelloSIgn @TC_HCM_001
  Scenario: API: send get request for user account
    Given Send getAPI Request for account
    Then validate response code
    And verify response body for Get Account

  @Regression @Basic @API @HelloSIgn @TC_HCM_002
  Scenario: API: verify user account
    Given Send post API Request to verify account
    Then validate response code
    And verify response body for verify account

  @Regression @Basic @API @HelloSIgn @TC_HCM_003
  Scenario: API: send get request for user account wrong credentials
    Given Send get API Request for wrong user
    Then validate response code
    And verify response body for Get Account

  @Regression @Basic @API @HelloSIgn @TC_HCM_004
  Scenario: API: Verify team details
    Given Send get API Request to verify team details
    Then validate response code
    And verify response body for Get Team
