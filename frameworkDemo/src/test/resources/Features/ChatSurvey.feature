#Author=Parul
#Date=23/09/2020
#Description=Creating the automation PHI-R2

Feature: Exelon-PHI-ACE feature file

  @Regression @Exelon @ACE @TC_Exel_577766
  Scenario Outline: Firefox: (Chat Survey) : Initiate bot, click Survey from bot and select YES
    Given firefox browser is open
    When user will be on "<opcoName>"
    When user will locate the chatbot icon
    And click on exelon chatbot icon
    Then chatbot will be open
    And user click no thanks i will continue
    Then click on downed power lines
    Then click no thanks
    And click Yes
    When click take feedback survey
    #When click on ACE chatbot icon
    #And click on ACE no thanks I will continue without signing in
    #Then click ACE downed power line
    #And click ACE no thanks
    #Then click ACE Yes
    #When click ACE take feedback survey
    #And click ACE four
    #Then click ACE yes for additional comments
    #When type ACE comment
    #And click ACE Send

    Examples:
      | opcoName |
      | ace      |
      | dpl      |
      | pepco    |

  @Regression @Exelon @DPL @TC_Exel_579101
  Scenario: Firefox: DPL (Chat Survey) : Initiate bot, click Survey from bot and select YES
    Given firefox browser is open
    And user will be on DPL homepage
    When click on DPL chatbot icon
    And click on DPL no thanks I will continue without signing in
    Then click DPL downed power line
    And click DPL no thanks
    Then click DPL Yes
    When click DPL take feedback survey
    And click DPL four
    Then click DPL yes for additional comments
    When type DPL comment
    And click DPL Send

  @Regression @Exelon @Pepco @TC_Exel_579119
  Scenario: Firefox: Pepco (Chat Survey) : Initiate bot, click Survey from bot and select YES
    Given firefox browser is open
    And user will be on Pepco homepage
    When user will locate the Pepco chatbot icon
    And click on Pepco chatbot icon
    When click on Pepco no thanks I will continue without signing in
    Then click Pepco downed power line
    And click Pepco no thanks
    Then click Pepco Yes
    When click Pepco take feedback survey
    And click Pepco four
    Then click Pepco yes for additional comments
    When type Pepco comment
    And click Pepco Send


  @Regression @Exelon @ACE @TC_Exel_577767
  Scenario: Firefox: ACE (Chat Survey) : Initiate bot, click Survey from bot and after select YES click Start another chatGiven firefox browser is open
    Given firefox browser is open
    And user will be on ACE homepage
    When click on ACE chatbot icon
    And click on ACE no thanks I will continue without signing in
    Then click ACE downed power line
    And click ACE no thanks
    Then click ACE Yes
    When click ACE take feedback survey
    And click ACE four
    Then click ACE yes for additional comments
    When type ACE comment
    And click ACE Send
    Then click ACE start another chat

  @Regression @Exelon @ACE @TC_Exel_577771
  Scenario: Firefox: ACE (Chat Survey) : Initiate bot, click Survey from bot and after select YES click Contact Us
    Given firefox browser is open
    And user will be on ACE homepage
    When click on ACE chatbot icon
    And click on ACE no thanks I will continue without signing in
    Then click ACE downed power line
    And click ACE no thanks
    Then click ACE Yes
    When click ACE take feedback survey
    And click ACE four
    Then click ACE yes for additional comments
    When type ACE comment
    And click ACE Send
    Then click ACE contact us

  @Regression @Exelon @ACE @TC_Exel_577772
  Scenario: Firefox: ACE (Chat Survey) : Initiate bot, click Survey from bot and after select YES click End chat with login with Oauth
    Given firefox browser is open
    And user will be on ACE homepage
    When click on ACE chatbot icon
    And click on ACE no thanks I will continue without signing in
    Then click ACE Billing and Payment
    When click ACE Account balance
    Then click ACE Oauth Sign in
    Then user will redirect to ACE login page
    When user enters ACE login id
    And user enters ACE password
    Then click on ACE sign in for Authentication
    And user accept the ACE authorization request
    Then navigate back to ACE chat bot
    When User click on ACE no thanks i just needed my balance
    Then click ACE Yes for answer after account balance
    When click ACE take feedback survey
    And click ACE four
    When user click ACE no for user comments
    Then click ACE End chat


  @Regression @Exelon @ACE @TC_Exel_577773
  Scenario: Firefox: ACE (Chat Survey) : Initiate bot, click Survey from bot and after select YES click End chat with web login or logout
    Given firefox browser is open
    And user will be on ACE homepage
    When click on ACE chatbot icon
    And click on ACE no thanks I will continue without signing in
    Then click ACE downed power line
    And click ACE no thanks
    Then click ACE Yes
    When click ACE take feedback survey
    And click ACE four
    Then click ACE yes for additional comments
    When type ACE comment
    And click ACE Send
    Then click ACE End chat


#Feature: Exelon-PHI-DPL feature file




  @Regression @Exelon @DPL @TC_Exel_579102
  Scenario: Firefox: DPL (Chat Survey) : Initiate bot, click Survey from bot and after select YES click Start another chat
    Given firefox browser is open
    And user will be on DPL homepage
    When click on DPL chatbot icon
    And click on DPL no thanks I will continue without signing in
    Then click DPL downed power line
    And click DPL no thanks
    Then click DPL Yes
    When click DPL take feedback survey
    And click DPL four
    Then click DPL yes for additional comments
    When type DPL comment
    And click DPL Send
    Then click DPL start another chat

  @Regression @Exelon @DPL @TC_Exel_579103
  Scenario: Firefox: DPL (Chat Survey) : Initiate bot, click Survey from bot and after select YES click Contact Us
    Given firefox browser is open
    And user will be on DPL homepage
    When click on DPL chatbot icon
    And click on DPL no thanks I will continue without signing in
    Then click DPL downed power line
    And click DPL no thanks
    Then click DPL Yes
    When click DPL take feedback survey
    And click DPL four
    Then click DPL yes for additional comments
    When type DPL comment
    And click DPL Send
    Then click DPL contact us

  @Regression @Exelon @DPL @TC_Exel_579104
  Scenario: Firefox: DPL (Chat Survey) : Initiate bot, click Survey from bot and after select YES click End chat with login with Oauth
    Given firefox browser is open
    And user will be on DPL homepage
    When click on DPL chatbot icon
    And click on DPL no thanks I will continue without signing in
    Then click DPL Billing and Payment
    When click DPL Account balance
    Then click DPL Oauth Sign in
    Then user will redirect to DPL login page
    When user enters DPL login id
    And user enters DPL password
    Then click on DPL sign in for Authentication
    And user accept the DPL authorization request
    Then navigate back to DPL chat bot
    When User click on DPL no thanks i just needed my balance
    Then click DPL Yes for answer after account balance
    When click DPL take feedback survey
    And click DPL four
    When user click DPL no for user comments
    Then click DPL End chat


  @Regression @Exelon @DPL @TC_Exel_579105
  Scenario: Firefox: DPL (Chat Survey) : Initiate bot, click Survey from bot and after select YES click End chat with web login or logout
    Given firefox browser is open
    And user will be on DPL homepage
    When click on DPL chatbot icon
    And click on DPL no thanks I will continue without signing in
    Then click DPL downed power line
    And click DPL no thanks
    Then click DPL Yes
    When click DPL take feedback survey
    And click DPL four
    Then click DPL yes for additional comments
    When type DPL comment
    And click DPL Send
    Then click DPL End chat


    #Feature: Exelon-PHI-PEPCO feature file




  @Regression @Exelon @Pepco @TC_Exel_579120
  Scenario: Firefox: Pepco (Chat Survey) : Initiate bot, click Survey from bot and after select YES click Start another chat
    Given firefox browser is open
    And user will be on Pepco homepage
    When user will locate the Pepco chatbot icon
    And click on Pepco chatbot icon
    When click on Pepco no thanks I will continue without signing in
    Then click Pepco downed power line
    And click Pepco no thanks
    Then click Pepco Yes
    When click Pepco take feedback survey
    And click Pepco four
    Then click Pepco yes for additional comments
    When type Pepco comment
    And click Pepco Send
    Then click Pepco start another chat

  @Regression @Exelon @Pepco @TC_Exel_579121
  Scenario: Firefox: Pepco (Chat Survey) : Initiate bot, click Survey from bot and after select YES click Contact Us
    Given firefox browser is open
    And user will be on Pepco homepage
    When user will locate the Pepco chatbot icon
    And click on Pepco chatbot icon
    When click on Pepco no thanks I will continue without signing in
    Then click Pepco downed power line
    And click Pepco no thanks
    Then click Pepco Yes
    When click Pepco take feedback survey
    And click Pepco four
    Then click Pepco yes for additional comments
    When type Pepco comment
    And click Pepco Send
    Then click Pepco contact us

  @Regression @Exelon @Pepco @TC_Exel_579122
  Scenario: Firefox: Pepco (Chat Survey) : Initiate bot, click Survey from bot and after select YES click End chat with login with Oauth
    Given firefox browser is open
    And user will be on Pepco homepage
    When user will locate the Pepco chatbot icon
    And click on Pepco chatbot icon
    When click on Pepco no thanks I will continue without signing in
    Then click Pepco Billing and Payment
    When click Pepco Account balance
    Then click Pepco Oauth Sign in
    Then user will redirect to Pepco login page
    When user enters Pepco login id
    And user enters Pepco password
    Then click on Pepco sign in for Authentication
    And user accept the Pepco authorization request
    Then navigate back to Pepco chat bot
    When User click on Pepco no thanks i just needed my balance
    Then click Pepco Yes for answer after account balance
    When click Pepco take feedback survey
    And click Pepco four
    When user click Pepco no for user comments
    Then click Pepco End chat


  @Regression @Exelon @Pepco @TC_Exel_579123
  Scenario: Firefox: Pepco (Chat Survey) : Initiate bot, click Survey from bot and after select YES click End chat with web login or logout
    Given firefox browser is open
    And user will be on Pepco homepage
    When user will locate the Pepco chatbot icon
    And click on Pepco chatbot icon
    When click on Pepco no thanks I will continue without signing in
    Then click Pepco downed power line
    And click Pepco no thanks
    Then click Pepco Yes
    When click Pepco take feedback survey
    And click Pepco four
    Then click Pepco yes for additional comments
    When type Pepco comment
    And click Pepco Send
    Then click Pepco End chat





