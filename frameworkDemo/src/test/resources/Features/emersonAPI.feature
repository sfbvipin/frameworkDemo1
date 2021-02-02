#Owner        : SHARP
#Author       : QA Team
#Description  : This is feature file for Emerson API Automation
@EmersonAPI
Feature: Feature to test Emerson API cases


  @Regression @API @Emerson @TC_Emerson_API_001
  Scenario Outline: API: Hit post request for Emerson to validate response code
    Given Hit post API request for "<endPoint>" with "<authcode>"
    Then validate <response_code>

    Examples:
      | endPoint    | authcode  | response_code |
      | login       | valid     | 200           |
      | login       | invalid   | 401           |
      | check user  | valid     | 200           |
      | check user  | invalid   | 401           |

  @Regression @API @Emerson @TC_Emerson_API_002
  Scenario Outline: API: Hit post request for Emerson Login to validate response body
    Given Hit post API request for "<endPoint>" with "<authcode>"
    Then validate <response_code>
    And verify response body for "<endPoint>"

    Examples:
      | endPoint    | authcode  | response_code |
      | login       | valid     | 200           |
      | check user  | valid     | 200           |


  @Regression @API @Emerson @TC_Emerson_API_003
  Scenario Outline: Hit Get request for Emerson to validate tech profile
    Given With "<authorization>"
    And Hit get API for "<endPoint>" with "<resourceCd>"
    Then validate <response_code>


    Examples:
      | endPoint    | resourceCd  | response_code | authorization |
      | tech profile| 348         | 200           | authorize     |
      | tech profile| 112         | 200           | authorize     |
      | tech profile| 341         | 401           | unauthorize   |
      | tech profile| 34807       | 500           | authorize     |
      | tech profile| 000         | 500           | authorize     |

  @Regression @API @Emerson @TC_Emerson_API_004
  Scenario Outline: Hit Get request for Emerson to validate tech profile
    Given With "<authorization>"
    And Hit get API for "<endPoint>" with "<resourceCd>"
    Then validate <response_code>
    And verify response body for "<endPoint>" with "<resourceCd>"


    Examples:
      | endPoint    | resourceCd  | response_code | authorization |
      | tech profile| 348         | 200           | authorize     |
      | tech profile| 343         | 200           | authorize     |
      | tech profile| 112         | 200           | authorize     |
      | tech profile| 34807       | 500           | authorize     |
      | tech profile| 000         | 500           | authorize     |

  @Regression @API @Emerson @TC_Emerson_API_005
 Scenario Outline: Hit Post request for validating user profile
    Given With "<authorization>"
    And Hit post API check user with "<emailid>" and "<udid>"
    Then validate <response_code>
    And verify response body for "<scenario>"


    Examples:
      | emailid                   | response_code | authorization | udid  | scenario |
      | aashish.kumar@emerson.com | 200           | authorize     | 112   | validate user for different udid |
      | aashish.kumar@emerson.co  | 200           | authorize     | 112   | validate error msg for invalid email |
      | aashish.kumar@emerson.com | 200           | authorize     | 45200301-5a75-490c-9f57-1beef4baeef9   | validate user with login udid |
      | khushboo.joshi@emerson.com| 200           | authorize     | 112   | validate user for different email |
