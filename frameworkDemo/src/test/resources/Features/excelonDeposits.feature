#Owner        : SHARP
#Author       : Parul; Sohail
#Description  : This is feature file for Exelon Chatbot Deposits Flow

Feature: Exelon-PHI feature file

  @Regression @Deposits @Exelon @TC_Excel_580547
  Scenario Outline: Firefox: Deposit FAQ - Initiating the Chat-Bot: Select Deposits FAQ and check content
    Given firefox browser is open
    When user will be on "<opcoName>"
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then click on more button
    Then click Deposits
    And validate if deposits with correct text is displayed as per "<opcoName>"


    Examples:
      | opcoName |
      | ace      |
      | dpl      |
      | pepco    |

  @Regression @Deposits @Exelon @TC_Excel_580548
  Scenario Outline: Firefox: Deposit FAQ - Initiating the Chat-Bot: Select Deposits FAQ and check links are correct
    Given firefox browser is open
    When user will be on "<opcoName>"
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then click on more button
    Then click Deposits
    And validate if deposits with correct text is displayed as per "<opcoName>"
    Then Validate Deposits link as per "<opcoName>"


    Examples:
      | opcoName |
      | ace      |
      | dpl      |
      | pepco    |

  @Regression @Deposits @Exelon @TC_Excel_580550
  Scenario Outline: Firefox: Deposit FAQ - Initiating the Chat-Bot: user types Deposits FAQ utterances and check messages
    Given firefox browser is open
    When user will be on "<opcoName>"
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And type "<utterance>" for chat
    Then click Send
    And validate if deposits with correct text is displayed as per "<opcoName>"
    Then Validate Deposits link as per "<opcoName>"

    Examples:
      | opcoName |  utterance |
      | ace      |  How is my deposit amount determined   |
      | dpl      |  deposit                               |
      | pepco    |  How is my deposit amount determined   |

  @Regression @Deposits @Exelon @TC_Excel_586324
  Scenario Outline: Firefox: Deposit FAQ - Initiating the Chat-Bot: Sign in through Web and Select Deposits FAQ from options and check links are correct
    Given firefox browser is open
    When user will be on "<opcoName>"
    And user will locate the web sign In button
    Then user enters login id for web "<opcoName>"
    And user enters password for web "<opcoName>"
    Then user click on sign in
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    Then click on more button
    Then click Deposits
    And validate if deposits with correct text is displayed as per "<opcoName>"
    Then Validate Deposits link as per "<opcoName>"


    Examples:
      | opcoName |
      | ace      |
      | dpl      |
      | pepco    |
