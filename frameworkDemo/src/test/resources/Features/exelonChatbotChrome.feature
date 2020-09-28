#Owner        : SHARP
#Author       : QA Team
#Description  : This is feature file for Exelon Chatbot application

Feature: Feature to test exelon chatbot application test cases


@Regression @Basic @Chrome @Exelon @Day0 @TC_Exel_001
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

 @Regression @Basic @Chrome @Exelon @Day0 @Sanity @TC_Exel_002
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

  @Regression @Basic @Chrome @Exelon @Day0 @TC_Exel_003
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

  @Regression @Basic @Chrome @Exelon @Day0 @TC_Exel_004
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

  @Regression @Basic @Chrome @Exelon @Day0 @TC_Exel_005
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

  @Regression @Chrome @Exelon @Day1 @TC_Exel_006
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

  @Regression @Chrome @Exelon @Day1 @TC_Exel_007
  Scenario: Chrome: Open chat bot and click on Outage
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click on menu icon
    Then click on Outage
    Then close the browser

  @Regression @Chrome @Exelon @Day1 @TC_Exel_008
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


  @Regression @Chrome @Exelon @Day1 @TC_Exel_009
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

  @Regression @Chrome @Exelon @Day1 @TC_Exel_010 @Khushboo
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

  @Regression @Chrome @Exelon @Day1 @TC_Exel_011      @Khushboo
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

  @Regression @Chrome @Exelon @Day1  @TC_Exel_012  @Khushboo
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

  @Regression @Chrome @Exelon @Day1 @TC_Exel_013        @Khushboo
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

  @Regression @Chrome @Exelon @Day1 @TC_Exel_014     @Khushboo
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

  @Regression @Chrome @Exelon @Day1 @TC_Exel_015      @Khushboo
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

  @Regression @Chrome @Exelon @Day1 @TC_Exel_016     @Khushboo
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

  @Regression @Chrome @Exelon @Day1 @TC_Exel_017     @Khushboo
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

  @Regression @Chrome @Exelon @Day2 @Sanity @TC_Exel_018     @Parul
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

  @Regression @Chrome @Exelon @Day2 @Sanity @TC_Exel_019     @Parul
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

  @Regression @Chrome @Exelon @Day2 @Sanity @TC_Exel_020     @Parul
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

  @Regression @Chrome @Exelon @Day2 @Sanity @TC_Exel_021     @Parul @Issue
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

  @Regression @Chrome @Exelon @Day2 @Sanity @TC_Exel_022     @Aashish
  Scenario: Chrome: Initiating th e Chat-Bot and select No Thanks
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then click on close chat icon
    And select yes to close chat

  @Regression @Chrome @Exelon @Day2 @Sanity @TC_Exel_023     @Aashish
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
  @Regression @Chrome @Exelon @Day2 @Sanity @TC_Exel_024     @Aashish
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
  @Regression @Chrome @Exelon @Day2 @Sanity @TC_Exel_025     @Aashish
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

  @Regression @Chrome @Exelon @Day2 @Sanity @TC_Exel_026     @Aashish
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

  @Regression @Chrome @Exelon @Day2 @Sanity @TC_Exel_027     @Vipin
  Scenario: Chrome: Click on bot and select Yes under flow end message
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

  @Regression @Chrome @Exelon @Day4 @TC_Exel_529183 @TC_Exel_028     @Parul
  Scenario: Chrome: Click on Bot and type keywords related to billing and payment
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then select and click on downed power lines
    And type utterance
    Then click on send icon
    And click on close chat icon
    Then select yes to close chat

  @Regression @Chrome @Exelon @Day4 @TC_Exel_529543 @TC_Exel_029     @Parul
  Scenario: Chrome: BOT : Click on Bot and after web login opt Account balance from billing and payment options(MERRILLDEMIAN)
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the web sign In button
    Then user enters login id for web
    And user enters password for web
    Then user click on web sign in
    And user will be on exelon web homepage
    Then user will click on contact us
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then select and click on  bill and paymenets
    And User click on account Balance
    And click on close chat icon
    Then select yes to close chat

  @Regression @Chrome @Exelon @Day4 @TC_Exel_515813 @TC_Exel_030     @Parul
  Scenario: Chrome: MENU : Initiate bot and click Downed power line
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click on menu icon
    Then select and click on downed power lines
    And click on close chat icon
    Then select yes to close chat

  @Regression @Chrome @Exelon @Day4 @TC_Exel_515815 @TC_Exel_031     @Parul
  Scenario: Chrome: BOT : Initiating the Chat-Bot and select Downed Power line and check End flow
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then select and click on downed power lines
    And click on close chat icon
    Then select yes to close chat

  @Regression @Chrome @Exelon @Day4 @TC_Exel_515836 @TC_Exel_032     @Parul
  Scenario: Chrome: BOT : Initiate bot and type Downed power line keywords
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And type utterance
    Then click on send icon
    And click on close chat icon
    Then select yes to close chat

  @Regression @Chrome @Exelon @Day4 @TC_Exel_528233 @TC_Exel_033     @Parul
  Scenario: Chrome: Initiate bot without login and opt Oauth login with accounts more than 5 (2000.201)
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

  @Regression @Chrome @Exelon @Day4 @TC_Exel_528234 @TC_Exel_034     @Parul
  Scenario: Chrome: Initiate bot with login with single account user and click Download my Current bill (SPARKINSON)
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the web sign In button
    Then user enters login id for web
    And user enters password for web
    Then user click on web sign in
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    Then select and click on  bill and paymenets
    And click on Getting your Bill
    Then select and click download my current bill
    And click on close chat icon
    Then select yes to close chat

  @Regression @Chrome @Exelon @Day4 @TC_Exel_529556 @TC_Exel_035     @Parul
  Scenario: Chrome: Click on Bot and type keywords related to billing and payment
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then select and click on  bill and paymenets
    And type utterance
    Then click on send icon
    And click on close chat icon
    Then select yes to close chat

  @Regression @Chrome @Exelon @Day4 @TC_Exel_524350 @TC_Exel_036     @Parul
  Scenario: Chrome: Click on Bot and type keywords related to billing and payment
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then select and click on  bill and paymenets
    And type utterance
    Then click on send icon
    And click on close chat icon
    Then select yes to close chat

  @Regression @Chrome @Exelon @Day4 @TC_Exel_524836 @TC_Exel_037     @Parul
  Scenario: Chrome: MENU : Click on Bot and opt no for login from billing and payment options
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click on menu icon
    Then select and click on  bill and paymenets from menu
    And click on close chat icon
    Then select yes to close chat

  @Regression @Chrome @Exelon @Day4 @TC_Exel_524897 @TC_Exel_038     @Parul
  Scenario: Chrome: MENU : Click on Bot and opt Deny after Sign In  on OAuth page  for login in billing and payment
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
    And user deny the authorization request
    Then navigate back to chat bot
    And click on close chat icon
    Then select yes to close chat

  @Regression @Chrome @Exelon @Day4 @TC_Exel_524898 @TC_Exel_039     @Parul
  Scenario: Chrome: MENU : Click on Bot and check balance after successful Sign on OAuth page (SPARKINSON)
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click on menu icon
    Then select and click on  bill and paymenets from menu
    And User click on account Balance
    And click on sign in
    Then user will redirect to login page
    When user enters login id
    And user enters password
    Then click on sign in for Authentication
    And user accept the authorization request
    Then navigate back to chat bot
    And click on close chat icon
    Then select yes to close chat

  @Regression @Chrome @Exelon @Day4 @TC_Exel_524906 @TC_Exel_040     @Parul
  Scenario: Chrome: BOT : Click on Bot and check balance after successful Sign In on OAuth page (SPARKINSON)
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then select and click on  bill and paymenets
    And User click on account Balance
    And click on sign in
    Then user will redirect to login page
    When user enters login id
    And user enters password
    Then click on sign in for Authentication
    And user accept the authorization request
    Then navigate back to chat bot
    And click on close chat icon
    Then select yes to close chat

  @Regression @Chrome @Exelon @Day4 @TC_Exel_524906 @TC_Exel_041     @Vipin
  Scenario: Chrome: Initiating the Chat-Bot and select any Start/Stop/Move option and check End flow
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click on menu icon
    Then click on start stop move
    And click on any option
    And check the given content
    And click on close chat icon
    Then select yes to close chat

  @Regression @Chrome @Exelon @Day4 @TC_Exel_524906 @TC_Exel_042     @Vipin
  Scenario: Chrome: Initiating the Chat-Bot and select link in Move content
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click on menu icon
    Then click on start stop move
    And click on move service
    Then click on the link in the move service content
    And click on close chat icon
    Then select yes to close chat

  @Regression @Chrome @Exelon @Day4 @TC_Exel_524906 @TC_Exel_043     @Vipin
  Scenario: Chrome: Initiating the Chat-Bot and select link in Stop content
    Given chrome browser is open
    And user will be on exel homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click on menu icon
    Then click on start stop move
    And click on stop service
    Then click on the link in the stop service content
    And click on close chat icon
    Then select yes to close chat

  @Regression @Chrome @Exelon @Day4 @TC_Exel_515750 @TC_Exel_044     @Parul
  Scenario: Chrome: BOT : Initiating the Chat-Bot and select link in Start content
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    When select and click start stop or move service
    Then click start service
    And click on start link

  @Regression @Chrome @Exelon @Day4 @TC_Exel_515751 @TC_Exel_045     @Parul
  Scenario: Chrome: BOT : Initiating the Chat-Bot and select link in Stop content
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    When select and click start,stop or move service
    Then click Stop service
    And click on stop link

  @Regression @Chrome @Exelon @Day4 @TC_Exel_515752 @TC_Exel_046     @Parul
  Scenario: Chrome: BOT : Initiating the ChatBot and select link in Move content
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    When select and click start,stop or move service
    Then click move service
    And click on move link

  @Regression @Chrome @Exelon @Day4 @TC_Exel_515753 @TC_Exel_047     @Khushboo
  Scenario: Chrome:Initiating the Chat-Bot and select any Start/Stop/Move option and check End flow
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then user click on start/stop/move
    And user click start service
    Then user click move service
    And user click yes
    Then user click no thanks
    And click on close chat icon
    Then select yes to close chat

  @Regression @Chrome @Exelon @Day4 @TC_Exel_515759 @TC_Exel_048     @Khushboo
  Scenario: Chrome:Initiating the Chat-Bot and type start service
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then user will type start service
    And click on close chat icon
    Then select yes to close chat

  @Regression @Chrome @Exelon @Day4 @TC_Exel_515763 @TC_Exel_049     @Khushboo
  Scenario: Chrome: Initiating the ChatBot and opt stopping a service from user input (utterances) option
    Given chrome browser is open
    And user will be on exelon homepage
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then user will type stop service
    Then click on send
    And user click on stop service
    Then user click move service
    And user click yes
    Then user click no thanks
    And click on close chat icon
    Then select yes to close chat