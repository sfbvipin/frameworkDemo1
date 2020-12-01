#Owner        : SHARP
#Author       : Parul; Sohail
#Description  : This is feature file for Exelon Customer Chat Survey Flow

Feature: Exelon-PHI feature file

  @Regression @ChatSurvey @Exelon @TC_Excel_599301
  Scenario Outline: Firefox: (Chat Survey): Initiate bot, opt "YES" under resolved End flow and type feedback as comment
    Given firefox browser is open
    When user will be on "<opcoName>"
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then click on downed power lines
    And click no thanks
    Then click Yes
    And click survey rating as "<SurveyRating>"
    Then click Leave comment
    And type "<comment>"
    Then click Send
    And click on close chat icon
    Then select yes to close chat

    Examples:
      | opcoName | SurveyRating | comment   |
      | ace      | five         | Feedback comment by SHARP |
      | dpl      | four         | SHARP entered comment     |
      | pepco    | three        | SHARP typed comment       |
      | ace      | one          | SHARP Comments            |
      | dpl      | two          | SHARP typed test comment  |


  @Regression @ChatSurvey @Exelon @TC_Excel_599309
  Scenario Outline: Firefox: (Chat Survey):Initiate bot, opt "YES" under resolved End flow and select End chat after providing feedback with/without web login
    Given firefox browser is open
    When user will be on "<opcoName>"
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then click on downed power lines
    And click no thanks
    Then click Yes
    And click survey rating as "<SurveyRating>"
    Then click Leave comment
    And type "<comment>"
    Then click Send
    And click on close chat icon
    Then select yes to close chat
#    Then click End chat
#    And validate if correct End chat text is displayed without oauth login

    Examples:
      | opcoName | SurveyRating | comment   |
      | ace      | five         | Feedback comment by SHARP |
      | dpl      | four         | SHARP entered comment     |
      | pepco    | three        | SHARP typed comment       |


  @Regression @ChatSurvey @Exelon @ACE @TC_Excel_599311
  Scenario Outline: Firefox: (Chat Survey): Initiate bot, opt "YES" under resolved End flow and select End chat after providing feedback with Oauth login
    Given firefox browser is open
    When user will be on "<opcoName>"
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then select and click on  bill and paymenets
    And User click on account Balance
    Then click Oauth Sign in
    Then user will redirect to login page
    When user login with "<loginid>" and "<password>"
    Then click on sign in for Authentication
    And user accept the authorization request
    Then navigate back to chat bot
    And Select account from multiple account
    When User click on no thanks i just needed my balance
    And click yes
    And click survey rating as "<SurveyRating>"
    Then click Leave comment
    And type "<comment>"
    Then click Send
#    Then click End chat
#    And validate if correct End chat text is displayed after oauth login
    And click on close chat icon
    Then select yes to close chat


    Examples:
      | opcoName | SurveyRating | comment                   | loginid     | password  |
      | ace      | five         | Feedback comment by SHARP | SPARKINSON  | Password1 |
      | dpl      | four         | SHARP entered comment     | SPARKINSON  | Password1 |
      | pepco    | three        | SHARP typed comment       | SPARKINSON  | Password1 |