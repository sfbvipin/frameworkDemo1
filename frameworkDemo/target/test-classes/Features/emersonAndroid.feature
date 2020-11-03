#Owner        : SHARP
#Author       : QA Team
#Description  : This is feature file for Emerson application

Feature: Feature to test emerson application scenarios

 
@Regression1 @Android @Emerson @TC_Emer_I_001
  Scenario: Check if can open install and run emerson apk
    Given application is invoked
    And user will enter the login id
    When user enters the password 
    And click on login button
    Then application will be open

  @Regression1 @Ionic @Emerson @TC_Emer_I_002
  Scenario: Firefox: (Chat Survey) : Initiate bot, click Survey from bot and select YES
#    Given create connection
    Given Launch Application