
#Author=Vipin
#Date=14/08/2020
#Description=Creating the automation demo POC
Feature: Feature to test exelon homepage in firefox


@Regression @Firefox @Exelon @TC_Exel_001
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


@Regression @Chrome @Exelon @TC_Exel_002
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

  @Regression @Firefox @Exelon @Sanity @TC_Exel_003
  Scenario: Firefox: Open chat bot and pay bill via chat
    Given firefox browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then select and click on  bill and paymenets
    And click on paying your bill
    Then select and click pay via chat
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

 @Regression @Chrome @Exelon @Sanity @TC_Exel_004
  Scenario: Chrome: Open chat bot and pay bill via chat
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then select and click on  bill and paymenets
    And click on paying your bill
   Then select and click pay via chat
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


  @Regression @Firefox @Exelon @TC_Exel_005
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

  @Regression @Chrome @Exelon @TC_Exel_006
  Scenario: Chrome: Open chat bot and start service
    Given chrome browser is open
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

  @Regression @Firefox @Exelon @TC_Exel_007
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

  @Regression @Chrome @Exelon @TC_Exel_008
  Scenario: Chrome: Open chat bot and move service
    Given chrome browser is open
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

  @Regression @Firefox @Exelon @TC_Exel_009
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

  @Regression @Chrome @Exelon @TC_Exel_010
  Scenario: Chrome: Open chat bot and navigate for Covid-19 assistance
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click on menu icon
    Then click on Covid-19 Assistance
    And click yes
    And click on close chat icon
    Then select yes to close chat

  @Regression @Firefox @Exelon @TC_Exel_011
  Scenario: Firefox: Open chat bot and find account number
    Given firefox browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click on menu icon
    Then click on find account number
    And click yes
    And click on close chat icon
    Then select yes to close chat

  @Regression @Chrome @Exelon @TC_Exel_012
  Scenario: Chrome: Open chat bot and find account number
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click on menu icon
    Then click on find account number
    And click yes
    And click on close chat icon
    Then select yes to close chat

  @Regression @Firefox @Exelon @TC_Exel_013
  Scenario: Firefox: Open chat bot and click on Outage
    Given firefox browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click on menu icon
    Then click on Outage
    Then close the browser

  @Regression @Chrome @Exelon @TC_Exel_014
  Scenario: Chrome: Open chat bot and click on Outage
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click on menu icon
    Then click on Outage
    Then close the browser

  @Regression @Firefox @Exelon @TC_Exel_015
  Scenario: Firefox:initiating bot without login and click on Pay bill
    Given firefox browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then select and click on  bill and paymenets
    And click on paying your bill
    Then click on close chat icon
    And select yes to close chat

  @Regression @Chrome @Exelon @TC_Exel_016
  Scenario: Chrome:initiating bot without login and click on Pay bill
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then select and click on  bill and paymenets
    And click on paying your bill
    Then click on close chat icon
    And select yes to close chat


  @Regression @Firefox @Exelon @TC_Exel_017
  Scenario: Firefox: Initiating the Chat-Bot and user eligible for budget billing and already enrolled
    Given firefox browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click on menu icon
    Then click on more button in bot
    And Click on Budget Billing
    Then click on learn more about budget billing
    Then user will redirect to login page
    When user enters login id
    And user enters password
    Then click on sign in for Authentication
    And user accept the authorization request
    Then navigate back to chat bot

  @Regression @Chrome @Exelon @TC_Exel_018
  Scenario: Chrome: Initiating the Chat-Bot and user eligible for budget billing and already enrolled
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click on menu icon
    Then click on more button in bot
    And Click on Budget Billing
    Then click on learn more about budget billing
    Then user will redirect to login page
    When user enters login id
    And user enters password
    Then click on sign in for Authentication
    And user accept the authorization request
    Then navigate back to chat bot

  @Regression @Firefox @Exelon @TC_Exel_019 @Khushboo
  Scenario: Firefox: Initiating bot without login and click on Pay bill
    Given firefox browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then select and click on  bill and paymenets
    And click on paying your bill
    And click on close chat icon
    Then select yes to close chat

  @Regression @Chrome @Exelon @TC_Exel_020 @Khushboo
  Scenario: Chrome: Initiating bot without login and click on Pay bill
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then select and click on  bill and paymenets
    And click on paying your bill
    And click on close chat icon
    Then select yes to close chat

  @Regression @Firefox @Exelon @TC_Exel_021      @Khushboo
  Scenario: Firefox: Click on Bot and type keywords related to billing and payment
    Given firefox browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then select and click on  bill and paymenets
    And user will type account
    Then click on send
    And click on close chat icon
    Then select yes to close chat

  @Regression @Chrome @Exelon @TC_Exel_022      @Khushboo
  Scenario: Chrome: Click on Bot and type keywords related to billing and payment
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then select and click on  bill and paymenets
    And user will type account
    Then click on send
    And click on close chat icon
    Then select yes to close chat

  @Regression @Firefox @Exelon  @TC_Exel_023  @Khushboo
  Scenario: Firefox: Initiate bot without login and click Sign up for Autopay
    Given firefox browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then select and click on  bill and paymenets
    And click on paying your bill
    Then user click on signup for autopay
    And click on close chat icon
    Then select yes to close chat

  @Regression @Chrome @Exelon  @TC_Exel_024  @Khushboo
  Scenario: Chrome: Initiate bot without login and click Sign up for Autopay
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then select and click on  bill and paymenets
    And click on paying your bill
    Then user click on signup for autopay
    And click on close chat icon
    Then select yes to close chat

  @Regression @Firefox @Exelon @TC_Exel_025        @Khushboo
  Scenario: Firefox: Initiate bot without login and click Pay by mail under Other Payment Options
    Given firefox browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then select and click on  bill and paymenets
    And click on paying your bill
    Then user click on other payment
    And user click on pay by mail
    And click on close chat icon
    Then select yes to close chat

  @Regression @Chrome @Exelon @TC_Exel_026        @Khushboo
  Scenario: Chrome: Initiate bot without login and click Pay by mail under Other Payment Options
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then select and click on  bill and paymenets
    And click on paying your bill
    Then user click on other payment
    And user click on pay by mail
    And click on close chat icon
    Then select yes to close chat

  @Regression @Firefox @Exelon @TC_Exel_027     @Khushboo
  Scenario: Firefox: Initiate bot without login and click Pay by phone under Other Payment Options
    Given firefox browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then select and click on  bill and paymenets
    And click on paying your bill
    Then user click on other payment
    And user click on pay by phone
    And click on close chat icon
    Then select yes to close chat

  @Regression @Chrome @Exelon @TC_Exel_028     @Khushboo
  Scenario: Chrome: Initiate bot without login and click Pay by phone under Other Payment Options
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then select and click on  bill and paymenets
    And click on paying your bill
    Then user click on other payment
    And user click on pay by phone
    And click on close chat icon
    Then select yes to close chat

  @Regression @Firefox @Exelon @TC_Exel_029      @Khushboo
  Scenario: Firefox: Initiate bot without login and click Pay in person under Other Payment Options
    Given firefox browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then select and click on  bill and paymenets
    And click on paying your bill
    Then user click on other payment
    And user click on pay in person
    And click on close chat icon
    Then select yes to close chat

  @Regression @Chrome @Exelon @TC_Exel_030      @Khushboo
  Scenario: Chrome: Initiate bot without login and click Pay in person under Other Payment Options
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then select and click on  bill and paymenets
    And click on paying your bill
    Then user click on other payment
    And user click on pay in person
    And click on close chat icon
    Then select yes to close chat

  @Regression @Firefox @Exelon @TC_Exel_031     @Khushboo
  Scenario: Firefox: Initiate bot without login and click learn about budget billing under pay by phone
    Given firefox browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then select and click on  bill and paymenets
    And click on paying your bill
    Then user click on other payment
    And user click on pay by phone
    Then click learn about budget
    And click on close chat icon
    Then select yes to close chat

  @Regression @Chrome @Exelon @TC_Exel_032     @Khushboo
  Scenario: Chrome: Initiate bot without login and click learn about budget billing under pay by phone
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then select and click on  bill and paymenets
    And click on paying your bill
    Then user click on other payment
    And user click on pay by phone
    Then click learn about budget
    And click on close chat icon
    Then select yes to close chat

  @Regression @Firefox @Exelon @TC_Exel_033     @Khushboo
  Scenario: Firefox: Initiate bot without login and click no thanks under pay by mail
    Given firefox browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then select and click on  bill and paymenets
    And click on paying your bill
    Then user click on other payment
    And user click on pay by mail
    Then user click No
    And click on close chat icon
    Then select yes to close chat

  @Regression @Chrome @Exelon @TC_Exel_034     @Khushboo
  Scenario: Chrome: Initiate bot without login and click no thanks under pay by mail
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then select and click on  bill and paymenets
    And click on paying your bill
    Then user click on other payment
    And user click on pay by mail
    Then user click No
    And click on close chat icon
    Then select yes to close chat

  @Regression @Firefox @Exelon @Sanity @TC_Exel_035     @Parul
  Scenario: Firefox: Initiate bot without login and click Download my Current bill
    Given firefox browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then select and click on  bill and paymenets
    And click on Getting your Bill
    Then select and click download my current bill
    And click on close chat icon
    Then select yes to close chat

  @Regression @Chrome @Exelon @Sanity @TC_Exel_036     @Parul
  Scenario: Chrome: Initiate bot without login and click Download my Current bill
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then select and click on  bill and paymenets
    And click on Getting your Bill
    Then select and click download my current bill
    And click on close chat icon
    Then select yes to close chat

  @Regression @Firefox @Exelon @Sanity @TC_Exel_037     @Parul
  Scenario: Firefox: Initiate bot without login and click Download a previous bill
    Given firefox browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then select and click on  bill and paymenets
    And click on Getting your Bill
    Then select and click download a previous bill
    And click on close chat icon
    Then select yes to close chat

  @Regression @Chrome @Exelon @Sanity @TC_Exel_038     @Parul
  Scenario: Chrome: Initiate bot without login and click Download a previous bill
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then select and click on  bill and paymenets
    And click on Getting your Bill
    Then select and click download a previous bill
    And click on close chat icon
    Then select yes to close chat

  @Regression @Firefox @Exelon @Sanity @TC_Exel_039     @Parul
  Scenario: Firefox: Initiate bot without login and opt Oauth login with single account in Download my Current bill (SPARKINSON)
    Given firefox browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then select and click on  bill and paymenets
    And click on Getting your Bill
    Then select and click download my current bill
    And click on sign in
    Then user will redirect to login page
    When user enters login id
    And user enters password
    Then click on sign in for Authentication
    And user accept the authorization request
    Then navigate back to chat bot
    And click on close chat icon
    Then select yes to close chat

  @Regression @Chrome @Exelon @Sanity @TC_Exel_040     @Parul
  Scenario: Chrome: Initiate bot without login and opt Oauth login with single account in Download my Current bill (SPARKINSON)
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then select and click on  bill and paymenets
    And click on Getting your Bill
    Then select and click download my current bill
    And click on sign in
    Then user will redirect to login page
    When user enters login id
    And user enters password
    Then click on sign in for Authentication
    And user accept the authorization request
    Then navigate back to chat bot
    And click on close chat icon
    Then select yes to close chat

  @Regression @Firefox @Exelon @Sanity @TC_Exel_041     @Parul @Issue
  Scenario: Firefox: Initiate bot without login and opt Oauth login with accounts between 2 to 5 (PATTI@47)
    Given firefox browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then select and click on  bill and paymenets
    And click on Getting your Bill
    Then select and click download my current bill
    And click on sign in
    Then user will redirect to login page
    When user enters login id
    And user enters password
    Then click on sign in for Authentication
    And user accept the authorization request
    Then navigate back to chat bot
    And click on close chat icon
    Then select yes to close chat

  @Regression @Chrome @Exelon @Sanity @TC_Exel_042     @Parul @Issue
  Scenario: Chrome: Initiate bot without login and opt Oauth login with accounts between 2 to 5 (PATTI@47)
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then select and click on  bill and paymenets
    And click on Getting your Bill
    Then select and click download my current bill
    And click on sign in
    Then user will redirect to login page
    When user enters login id
    And user enters password
    Then click on sign in for Authentication
    #And user accept the authorization request : this step is required in firefox but not in chrome
    Then navigate back to chat bot
    And click on close chat icon
    Then select yes to close chat

  @Regression @Chrome @Exelon @Sanity @TC_Exel_042a     @Parul @Issue
  Scenario: Chrome: Initiate bot without login and opt Oauth login with accounts between 2 to 5 (PATTI@47)
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then select and click on  bill and paymenets
    And click on Getting your Bill
    Then select and click download my current bill
    And click on sign in
    Then user will redirect to login page
    When user enters login id
    And user enters password
    Then click on sign in for Authentication
    And user accept the authorization request
    Then navigate back to chat bot
    And click on close chat icon
    Then select yes to close chat

  @Regression @Firefox @Exelon @Sanity @TC_Exel_043     @Aashish
  Scenario: Firefox: Initiating th e Chat-Bot and select No Thanks
    Given firefox browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then click on close chat icon
    And select yes to close chat

  @Regression @Chrome @Exelon @Sanity @TC_Exel_044     @Aashish
  Scenario: Chrome: Initiating th e Chat-Bot and select No Thanks
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then click on close chat icon
    And select yes to close chat

  @Regression @Firefox @Exelon @Sanity @TC_Exel_045     @Aashish
  Scenario: Firefox: Initiating the Chat-Bot and check welcome message having Signin/No thanks #verbiage_test
    Given firefox browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    Then click on close chat icon
    And select yes to close chat

  @Regression @Chrome @Exelon @Sanity @TC_Exel_046     @Aashish
  Scenario: Chrome: Initiating the Chat-Bot and check welcome message having Signin/No thanks #verbiage_test
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    Then click on close chat icon
    And select yes to close chat

#      ---- wait to be added for checking the verbiage------
#  (Hello! I’m Atlantic City Electric's virtual assistant.
#  Before we get started, sign in to your online account for the optimal experience. Simply start another
#  chat after you sign in, and I can help you from there. You can also continue without signing in.
#  [Following as buttons]Sign InNo, Thanks. I will continue without signing in)
  @Regression @Firefox @Exelon @Sanity @TC_Exel_047     @Aashish
  Scenario: Firefox: Initiating the Chat-Bot and select SignIn
    Given firefox browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And click on sign in
    Then user will redirect to login page
    When user enters login id
    And user enters password
    Then click on sign in for Authentication
    And user accept the authorization request
    Then navigate back to chat bot
    And click on close chat icon
    Then select yes to close chat

  @Regression @Chrome @Exelon @Sanity @TC_Exel_048     @Aashish
  Scenario: Chrome: Initiating the Chat-Bot and select SignIn
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And click on sign in
    Then user will redirect to login page
    When user enters login id
    And user enters password
    Then click on sign in for Authentication
    And user accept the authorization request
    Then navigate back to chat bot
    And click on close chat icon
    Then select yes to close chat

  #------  Wait to be added for checking the verbiage --------
  #(Hello! I’m Atlantic City Electric's virtual assistant.
  #What can I help you with today? You can choose a topic to get started, or type in a direct question.)
  @Regression @Firefox @Exelon @Sanity @TC_Exel_049     @Aashish
  Scenario: Firefox: Initiating the Chat-Bot, navigate to account balance without sign in
    Given firefox browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then select and click on  bill and paymenets
    And Account balance
    Then click on close chat icon
    And select yes to close chat

  @Regression @Chrome @Exelon @Sanity @TC_Exel_050     @Aashish
  Scenario: Chrome: Initiating the Chat-Bot, navigate to account balance without sign in
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then select and click on  bill and paymenets
    And Account balance
    Then click on close chat icon
    And select yes to close chat

  @Regression @Firefox @Exelon @Sanity @TC_Exel_051     @Aashish
  Scenario: Firefox: Initiating the Chat-Bot, navigate to Account Balance, sigin with mutliple Accounts
    Given firefox browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then select and click on  bill and paymenets
    And Account balance
    And click on sign in
    Then user will redirect to login page
    When user enters login id
    And user enters password
    Then click on sign in for Authentication
    And user accept the authorization request
    Then navigate back to chat bot

  @Regression @Chrome @Exelon @Sanity @TC_Exel_052     @Aashish
  Scenario: Chrome: Initiating the Chat-Bot, navigate to Account Balance, sigin with mutliple Accounts
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then select and click on  bill and paymenets
    And Account balance
    And click on sign in
    Then user will redirect to login page
    When user enters login id
    And user enters password
    Then click on sign in for Authentication
    And user accept the authorization request
    Then navigate back to chat bot

  @Regression @Firefox @Exelon @Sanity @TC_Exel_053     @Vipin
  Scenario: Firefox: Click on bot and select multiple option under flow end message
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
    And check the given content
    Then select yes for confirmation
    Then good bye content
    And select no Thanks to close chat
    And click on close chat icon
    Then select yes to close chat

  @Regression @Chrome @Exelon @Sanity @TC_Exel_054     @Vipin
  Scenario: Chrome: Click on bot and select multiple option under flow end message
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
    And check the given content
    Then select yes for confirmation
    Then good bye content
    And select no Thanks to close chat
    And click on close chat icon
    Then select yes to close chat