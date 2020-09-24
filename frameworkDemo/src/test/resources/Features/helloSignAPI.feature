#Owner        : SHARP
#Author       : QA Team
#Description  : This is feature file for Hello Sign API Automation

Feature: Feature to test Hello Sign API cases

  @Regression @API @HelloSIgn @TC_HCM_001
  Scenario: API: send get request for user account
    Given Create getAPI Request for account
    #And send get request for useraccount
    Then validate response code
    And verify response body

  @Regression @API @HelloSIgn @TC_HCM_002
  Scenario: API: verify user account
    Given Create post API Request to verify account
   # And send post request to verifyaccount
    Then validate response code
    And verify response body

  @Regression @API @HelloSIgn @TC_HCM_003
  Scenario: API: send get request for user account wrong credentials
    Given Create get API Request for wrong user
  #  And send get request for useraccount
    Then validate response code
    And verify response body

  @Regression @API @HelloSIgn @TC_HCM_004
  Scenario: API: Verify team details
    Given Create get API Request to verify team details
   # And send get request for team details
    Then validate response code
    And verify response body
