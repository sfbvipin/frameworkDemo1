#Owner        : SHARP
#Author       : Parul; Sohail
#Description  : This is feature file for Exelon Customer Refund Flow

Feature: Exelon-PHI feature file

  @Regression @Exelon @TC_Excel_580566
  Scenario Outline: Firefox: Refunds FAQ - Initiating the Chat-Bot: Select Refunds FAQ and check content
    Given firefox browser is open
    When user will be on "<opcoName>"
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then click on more button
    Then click Refunds
    And validate if Refunds with correct text is displayed as per "<opcoName>"
    Then close the browser


    Examples:
      | opcoName |
      | ace      |
      | dpl      |
      | pepco    |

  @Regression @Exelon @TC_Excel_580567
  Scenario Outline: Firefox: Refunds FAQ - Initiating the Chat-Bot: Select Refunds FAQ and check links are correct
    Given firefox browser is open
    When user will be on "<opcoName>"
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then click on more button
    Then click Refunds
    And validate if Refunds with correct text is displayed as per "<opcoName>"
    Then Validate Refunds link as per "<opcoName>"
    Then close the browser


    Examples:
      | opcoName |
      | ace      |
      | dpl      |
      | pepco    |

  @Regression @Exelon @TC_Excel_580569
  Scenario Outline: Firefox: Refunds FAQ - Initiating the Chat-Bot: user types Refunds FAQ utterances and check messages
    Given firefox browser is open
    When user will be on "<opcoName>"
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And type "<utterance>" for chat
    Then click Send
    And validate if Refunds with correct text is displayed as per "<opcoName>"
    Then close the browser

    Examples:
      | opcoName |  utterance                             |
      | ace      |  How is my refund amount determined    |
      | dpl      |  refund                                |
      | pepco    |  How i can refund                      |

  @Regression @Exelon @TC_Excel_586334
  Scenario Outline: Firefox: Refunds FAQ - Initiating the Chat-Bot: Sign in through Web and Select Refunds FAQ from options and check links are correct
    Given firefox browser is open
    When user will be on "<opcoName>"
    And user will locate the web sign In button
    When user login with "<loginid>" and "<password>"
    Then user click on sign in
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    Then click on more button
    Then click Refunds
    And validate if Refunds with correct text is displayed as per "<opcoName>"
    Then Validate Refunds link as per "<opcoName>"
    Then close the browser


    Examples:
      | opcoName | loginid        | password  |
      | ace      | RDBMSM         | Password1 |
      | dpl      | WAYDIXIE       | Password1 |
      | pepco    | MERRILLDEMIAN  | Password1 |

