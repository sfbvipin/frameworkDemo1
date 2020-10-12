#Author=Parul
#Date=17/09/2020
#Description=Creating the automation PHI-R2

  Feature: Exelon-PHI-ACE feature file

  @Regression @Exelon @ChatTranscription @TC_Exel_574921
  Scenario Outline: Firefox: Initiate bot and click mail icon
    Given firefox browser is open
    When user will be on "<opcoName>"
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    Then user click on "<opcoName>" mail icon
    And validate if popup with correct text is displayed
    And close the browser

    Examples:
      | opcoName |
      | ace      |
      | dpl      |
      | pepco    |

    @Regression @Exelon @ChatTranscription @TC_Exel_574922
    Scenario Outline: Firefox: Initiate bot and type utterance related to chat transcription
      Given firefox browser is open
      When user will be on "<opcoName>"
      When user will locate the chatbot icon
      And click on exelon chatbot icon
      Then chatbot will be open
      And type utterance for chat transcription
      Then click Send
      #Then validate response
      And close the browser

      Examples:
        | opcoName |
        | ace      |
        | dpl      |
        | pepco    |

    @Regression @Exelon @ChatTranscription @TC_Exel_574926
    Scenario Outline: Firefox: Initiate bot, click mail icon and click submit with valid email id format
      Given firefox browser is open
      When user will be on "<opcoName>"
      When user will locate the chatbot icon
      And click on exelon chatbot icon
      Then chatbot will be open
      Then user click on "<opcoName>" mail icon
      And validate if popup with correct text is displayed
      When input "<email_id>" format
      Then click submit
      And validate if popup with correct "<email_id>" is displayed
      Then click ok for mail confirmation
      And close the browser

      Examples:
        | opcoName | email_id                 |
        | ace      | sohail.abbas@sofbang.com |
        | dpl      | sohail.abbas@sofbang.com |
        | pepco    | sohail.abbas@sofbang.com |


    @Regression @Exelon @ChatTranscription @TC_Exel_574927
    Scenario Outline: Firefox: Initiate bot, click mail icon and click submit with invalid/blank email id
      Given firefox browser is open
      When user will be on "<opcoName>"
      When user will locate the chatbot icon
      And click on exelon chatbot icon
      Then chatbot will be open
      Then user click on "<opcoName>" mail icon
      And validate if popup with correct text is displayed
      When input "<email_id>" format
      Then click submit
      And validate if popup with invalid is displayed
      And close the browser

      Examples:
        | opcoName | email_id                 |
        | ace      | sohail.abbas@sofbang#com |
        | dpl      | sohail.abbassofbang.com  |
        | pepco    | sohail.abbas@sofbang_com |

    @Regression @Exelon @ChatTranscription @TC_Exel_575075
    Scenario Outline: Firefox: Initiate bot, click mail icon and click cancel with valid/invalid/blank email id
      Given firefox browser is open
      When user will be on "<opcoName>"
      When user will locate the chatbot icon
      And click on exelon chatbot icon
      Then chatbot will be open
      Then user click on "<opcoName>" mail icon
      And validate if popup with correct text is displayed
      Then click cancel
      And close the browser

      Examples:
        | opcoName |
        | ace      |
        | dpl      |
        | pepco    |

