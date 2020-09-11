
#Author=Vipin
#Date=14/08/2020
#Description=Creating the automation demo POC
Feature: Feature to test exelon homepage in firefox


@Regression1 @Exelon @TC_Exel_001
  Scenario: Firefox: Open exelon web application, load chatbot and navigate through menu
    Given firefox browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click on menu icon
    Then click on more button in bot
    And select solar and click in bot
    Then click on home and business in bot
    And click on private solar option
    Then select yes for confirmation
    And select no Thanks to close chat
    And click on close chat icon
    Then select yes to close chat


@Regression1 @Exelon @TC_Exel_002
  Scenario: Chrome: Open exelon web application, load chatbot and navigate through menus
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click on menu icon
    Then click on more button in bot
    And select solar and click in bot
    Then click on home and business in bot
    And click on private solar option
    Then select yes for confirmation
    And select no Thanks to close chat
    And click on close chat icon
    Then select yes to close chat
    
    
 @Regression1 @Exelon @Sanity @TC_Exel_003
  Scenario: Chrome: Open chat bot and pay bill via virtual payment method
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then select and click on  bill and paymenets
    And click on paying your bill
    Then select and click pay via virtual assistance
    And click on sign in
    Then user will redirect to login page
    When user enters login id
    And user enters password
    Then click on sign in for Authentication
    And user accept the authorization request
    Then navigate back to chat bot
    And select any of the registered address for payment
    Then Select no thanks to terminate chat
    And click yes
    Then select no thanks to close the chat
    And click on close chat icon
    Then select yes to close chat
    
   @Regression1 @Exelon @Sanity @TC_Exel_004
    Scenario: Firefox: Open chat bot and pay bill via virtual payment method
      Given firefox browser is open
      And user will be on exelon homepage
      When user will locate the chatbot icon
      And click on exelon chatbot icon
      Then chatbot will be open
      And user click no thanks i will continue
      Then select and click on  bill and paymenets
      And click on paying your bill
      Then select and click pay via virtual assistance
      And click on sign in
      Then user will redirect to login page
      When user enters login id
      And user enters password
      Then click on sign in for Authentication
      And user accept the authorization request
      Then navigate back to chat bot
      And select any of the registered address for payment
      Then Select no thanks to terminate chat
      And click yes
      Then select no thanks to close the chat
      And click on close chat icon
      Then select yes to close chat

  @Regression1 @Exelon @TC_Exel_005
  Scenario: Firefox: Open chat bot and start service
    Given firefox browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click on menu icon
    Then click on Start Stop or Move Service
    And user select Start Service
    And click yes
    And click on close chat icon
    Then select yes to close chat

  @Regression1 @Exelon @TC_Exel_006
  Scenario: Firefox: Open chat bot and move service
    Given firefox browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click on menu icon
    Then click on Start Stop or Move Service
    Then user select Move Service
    And click yes
    And click on close chat icon
    Then select yes to close chat

  @Regression @Exelon @TC_Exel_007
  Scenario: Firefox: Open chat bot and navigate for Covid-19 assistance
    Given firefox browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click on menu icon
    Then click on Covid-19 Assistance
    And click yes
    And click on close chat icon
    Then select yes to close chat