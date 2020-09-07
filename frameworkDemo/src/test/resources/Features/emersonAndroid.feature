#Author=Vipin
#Date=17/08/2020
#Description=Creating the automation demo POC
Feature: feature to test emerson android apk



 
@Regression @Emerson @TC_Emer_I_001
  Scenario: Check if can open install and run emerson apk
    Given application is invoked
    And user will enter the login id
    When user enters the password 
    And click on login button
    Then application will be open