#Author=Vipin
#Date=14/08/2020
#Description=Creating the automation demo POC
Feature: feature to test exelon virtual payment in web

  Scenario: Firefox: Open exelon web application, load chatbot and navigate through menu
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
    When user click yes for confirmation
    Then Select no thanks to terminate chat
    And click yes
    Then select no thanks to close the chat
    And click on close chat icon
    Then select yes to close chat
