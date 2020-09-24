#Owner        : SHARP
#Author       : QA Team
#Description  : This is feature file for Emerson Android application

Feature: Feature to test emerson android application scenarios

 
@Regression1 @Firefox @Chrome @Emerson @TC_Emer_I_001
  Scenario: Check if can open install and run emerson apk
    Given application is invoked
    And user will enter the login id
    When user enters the password 
    And click on login button
    Then application will be open