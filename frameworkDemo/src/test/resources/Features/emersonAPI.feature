#Owner        : SHARP
#Author       : QA Team
#Description  : This is feature file for Emerson API Automation
@EmersonAPI
Feature: Feature to test Emerson API cases


  @API @Emerson @TC_Emerson_API_001
  Scenario Outline: API: Hit post request for Emerson to validate response code
    Given Hit post API request for "<endPoint>" with "<authcode>"
    Then validate <response_code>

    Examples:
      | endPoint    | authcode  | response_code |
      | login       | valid     | 200           |
      | login       | invalid   | 401           |
      | check user  | valid     | 200           |
      | check user  | invalid   | 401           |

  @API @Emerson @TC_Emerson_API_002
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
    And Hit get API for "<endPoint>" with "<resourceId>"
    Then validate <response_code>


    Examples:
      | endPoint    | resourceId  | response_code | authorization |
      | tech profile| 348         | 200           | authorize     |
      | tech profile| 112         | 200           | authorize     |
      | tech profile| 341         | 401           | unauthorize   |
      | tech profile| 34807       | 500           | authorize     |
      | tech profile| 000         | 500           | authorize     |


  @Regression @API @Emerson @TC_Emerson_API_004 @Rutika @GetAPI
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

  @API @Emerson @TC_Emerson_API_005 @Rutika @PostAPI
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


  @API @Emerson @TC_Emerson_API_006 @Rutika @PostAPI
  Scenario Outline: Hit Post request for updating UDID
    Given With "<authorization>"
    And Hit post API update with "<emailid>" "<udid>" "<currentAppVersion>" and "<logout>"
    Then validate <response_code>
    And verify response body for "<scenario>"


    Examples:
      | emailid                     | response_code | authorization | udid  | scenario                        | currentAppVersion   |  logout    |
      | khushboo.joshi@emerson.com  | 200           | authorize     | 1121  | update UDID                     |                     |  false     |
      | khushboo.joshi@emerson.co   | 404           | authorize     | 1121  | update UDID with invalid email  |                     |  false     |
      | khushboo.joshi@emerson.com  | 200           | authorize     | 1121  | update UDID with logout         |                     |  true      |
      | khushboo.joshi@emerson.co   | 404           | authorize     | 1121  | update UDID with logout and invalid email|            |  true      |


  @API @Emerson @TC_Emerson_API_007 @Rutika @PostAPI
  Scenario Outline: Hit Post request for login API SESBackend
    Given With "<authorization>"
    And Hit post API login with "<udid>" "<logout>" "<username>" and "<password>"
    Then validate <response_code>
    And verify response body for "<scenario>"


    Examples:
      | username          | response_code | authorization | udid  | scenario                        | password   |  logout    |
      | khushboo.joshi    | 200           | authorize     | 1121  | Login Positive                  | Emerson8   |  false     |
      | khushboo.jos      | 500           | authorize     | 1121  | Login with invalid email        | Emerson8   |  false     |
      | khushboo.joshi    | 500           | authorize     | 1121  | Login with incorrect password   | Emerson    |  false     |
      | khushboo.joshi    | 200           | authorize     | 1121  | login when logout is true       | Emerson8   |  true      |


  @Regression @API @Emerson @TC_Emerson_API_008 @Rutika @GetAPI
  Scenario Outline: Hit Get request for Emerson to fetch feedbacks
    Given With "<authorization>"
    And Hit get API to fetch feedbacks with "<modifiedon>"
    Then validate <response_code>
    And verify all data is greater than "<modifiedon>"

    Examples:
      | modifiedon                           | response_code | authorization |
      | 2020-12-28T10:57:56.000Z             | 200           | authorize     |
      | 2020-15-28T10:57:56.000Z             | 500           | authorize     |
      | 2025-12-28T10:57:56.000Z             | 500           | authorize     |
      |                                      | 200           | authorize     |



  @Regression @API @Emerson @TC_Emerson_API_009 @Rutika @GetAPI
  Scenario Outline: Hit Get request for Emerson to fetch Emergency call out details
    Given With "<authorization>"
    And Hit get API for Emergency call out details
    Then validate <response_code>
    And validate response body for correct EmergencyCallOut details


    Examples:
      | response_code | authorization |
      | 200           | authorize     |
      | 401           | unauthorize   |


  @API @Emerson @TC_Emerson_API_010 @Rutika @PostAPI
  Scenario Outline: Hit Post request for creation of Emergency Call Out in OSC
    Given With "<authorization>"
    And Hit post API EmergencyCallOutInOSC with "<incidentid>" "<field_job_status>" "<business_group>" "<business_unit>" "<field_job_type>" "<field_job_group>" "<field_job_name>" "<service_engineer_name>" "<requested_date>" "<scheduled_date>" "<debrief_submission_date>" "<emergency_callout>" "<activity_id>"
    Then validate <response_code>
    And verify response body for "<scenario>"


    Examples:
      | incidentid | response_code | authorization |field_job_status | business_group | business_unit  | field_job_type | field_job_group | field_job_name | service_engineer_name| requested_date |    scheduled_date    | debrief_submission_date | emergency_callout | activity_id |     Scenario                 |
      | 1207991    | 200           | authorize     |      436        |      435       |     398        |      386       |                 |  OIC Test FJ3  |          343         |  2021-01-08    | 2021-01-09T09:58:19Z |         null            |          1        |   9823456   | Happy flow                   |
      |            | 500           | authorize     |      436        |      435       |     398        |      386       |                 |  OIC Test FJ3  |          343         |  2021-01-08    | 2021-01-09T09:58:19Z |         null            |          1        |   9823456   | Blank Incident ID            |
      | 1207991    | 500           | authorize     |      430        |      435       |     398        |      386       |                 |  OIC Test FJ3  |          343         |  2021-01-08    | 2021-01-09T09:58:19Z |         null            |          1        |   9823456   | Invalid field job status     |
      | 1207991    | 500           | authorize     |      436        |      430       |     398        |      386       |                 |  OIC Test FJ3  |          343         |  2021-01-08    | 2021-01-09T09:58:19Z |         null            |          1        |   9823456   | Invalid business_group       |
      | 1207991    | 500           | authorize     |      436        |      435       |     390        |      386       |                 |  OIC Test FJ3  |          343         |  2021-01-08    | 2021-01-09T09:58:19Z |         null            |          1        |   9823456   | Invalid business_unit        |
      | 1207991    | 500           | authorize     |      436        |      435       |     398        |      386       |                 |  OIC Test FJ3  |                      |  2021-01-08    | 2021-01-09T09:58:19Z |         null            |          1        |   9823456   | No service_engineer_name     |
      | 1207991    | 500           | authorize     |      436        |      435       |     398        |      386       |                 |  OIC Test FJ3  |          343         |  2021-15-08    | 2021-01-09T09:58:19Z |         null            |          1        |   9823456   | Invalid requested_date       |
      | 1207991    | 500           | authorize     |      436        |      435       |     398        |      386       |                 |  OIC Test FJ3  |          343         |  2021-01-08    | 2021-01-09T09:58:19Z |         null            |          8        |   9823456   | Invalid emergency_callout    |
      | 1207991    | 500           | authorize     |      436        |      435       |     398        |      386       |                 |  OIC Test FJ3  |          343         |  2021-01-08    | 2021-01-09T09:58:19Z |         null            |          1        |   0823456   | Invalid activity_id          |
      | 1207991    | 500           | authorize     |      436        |      435       |     398        |      386       |                 |  OIC Test FJ3  |          343         |  2021-01-08    | 2021-01-09T09:58:19Z |                         |          1        |   9823456   | No debrief_submission_date   |


  @API @Emerson @TC_Emerson_API_011 @Rutika @PostAPI
  Scenario Outline: Hit Post request for submitting feedback
    Given With "<authorization>"
    And Hit post API feedback with "<id>" "<rating>" "<qid>" "<resource_id>" "<user_email>" "<user_location>" "<comments>" "<feedback_date>" "<review_date>" "<reviewed_by>" "<is_reviewed>" "<createdby>" "<createdon>" "<modifiedby>" "<modifiedon>"
    Then validate <response_code>
    And verify response body for "<scenario>"


    Examples:
      | response_code | authorization | id | rating | qid |resource_id |       user_email             | user_location  | comments       | feedback_date | review_date | reviewed_by | is_reviewed | createdby |             createdon           | modifiedby |           modifiedon            |
      | 200           | authorize     | 95 |   3    | 3   |  128999    | gurkeerat.singh@sofbang.com  |   null         | test comments2 |     null      |    null     |      2      |    null     |     1     | 27-OCT-20 12:00:00.000000000 AM |      1     | 27-DEC-20 12:00:00.000000000 AM |
      | 500           | authorize     | 95 |        | 3   |  128999    | gurkeerat.singh@sofbang.com  |   null         | test comments2 |     null      |    null     |      2      |    null     |     1     | 27-OCT-20 12:00:00.000000000 AM |      1     | 27-DEC-20 12:00:00.000000000 AM |
      | 500           | authorize     | 95 |   3    | 3   |  128999    | gurkeerat.singh@sofbang.com  |   null         | test comments2 |     null      |    null     |      2      |    null     |     aa    | 27-OCT-20 12:00:00.000000000 AM |      1     | 27-DEC-20 12:00:00.000000000 AM |
      | 500           | authorize     | 95 |   3    | 3   |  128999    | gurkeerat.singh@sofbang.com  |   null         | test comments2 |     null      |    null     |      2      |    null     |     1     | 27-OCT-20 12:00:00.000000000 AM |      aa    | 27-DEC-20 12:00:00.000000000 AM |
      | 200           | authorize     | 95 |   3    | 3   |  128999    | khushboo.joshi@sofbang.com   |   null         | test comments2 |     null      |    null     |      2      |    null     |     1     | 27-OCT-20 12:00:00.000000000 AM |      1     | 27-DEC-20 12:00:00.000000000 AM |
      | 200           | authorize     | 95 |   3    | 3   |  128999    | gurkeerat.singh@sofbang.co   |   null         | test comments2 |     null      |    null     |      2      |    null     |     1     | 27-OCT-20 12:00:00.000000000 AM |      1     | 27-DEC-20 12:00:00.000000000 AM |
      | 200           | authorize     | 95 |   3    | 3   |  128999    | gurkeerat.singh@sofbang.com  |   null         | test comments2 |     null      |    null     |      2      |    null     |     1     | 58-OCT-20 12:00:00.000000000 AM |      1     | 27-DEC-20 12:00:00.000000000 AM |
      | 200           | authorize     | 95 |   3    | 3   |  128999    | gurkeerat.singh@sofbang.com  |   null         | test comments2 |     null      |    null     |      2      |    null     |     1     | 27-OCT-20 12:00:00.000000000 AM |      1     | 32-DEC-20 12:00:00.000000000 AM |
      | 200           | authorize     | AA |   3    | 3   |  128999    | gurkeerat.singh@sofbang.com  |   null         | test comments2 |     null      |    null     |      2      |    null     |     1     | 27-OCT-20 12:00:00.000000000 AM |      1     | 27-DEC-20 12:00:00.000000000 AM |
      | 200           | authorize     | 95 |   3    | 3   |  128900    | gurkeerat.singh@sofbang.com  |   null         | test comments2 |     null      |    null     |      2      |    null     |     1     | 27-OCT-20 12:00:00.000000000 AM |      1     | 27-DEC-20 12:00:00.000000000 AM |


  @Regression @API @Emerson @TC_Emerson_API_012 @Rutika @GetAPI
  Scenario Outline: Hit Get request for Emerson to fetch Allowances
    Given With "<authorization>"
    And Hit get API to fetch allowances for "<modifiedDate>"
    Then validate <response_code>


    Examples:
      | modifiedDate                      |  response_code | authorization |
      | 14-Jan-2020 01:24:51.429000000 PM |    200         | authorize     |
      | 32-Jan-2020 01:24:51.429000000 PM |    500         | authorize     |
      | 14-Jan-2022 01:24:51.429000000 PM |    200         | authorize     |
      | 14-Jan-2020 71:24:51.429000000 PM |    500         | authorize     |


  @Regression @API @Emerson @TC_Emerson_API_013 @Rutika @GetAPI
  Scenario Outline: Hit Get request for Emerson to fetch languages
    Given With "<authorization>"
    And Hit get API to fetch languages for "<isEnabled>"
    Then validate <response_code>
    And validate response matches the value of "<isEnabled>"


    Examples:
      | isEnabled | response_code | authorization |
      | true      |      200      | authorize     |
      | false     |      200      | authorize     |
      |           |      200      | authorize     |


  @Regression @API @Emerson @TC_Emerson_API_014 @Rutika @GetAPI
  Scenario Outline: Hit Get request for Emerson to fetch languageKeyMapping
    Given With "<authorization>"
    And Hit get API to fetch languageKeyMapping with "<LangID>"
    Then validate <response_code>
    And validate response is received for "<LangID>"

    Examples:
      | LangID    | response_code | authorization |
      | 13        |      200      | authorize     |
      | AA        |      500      | authorize     |
      |           |      500      | authorize     |
      | 100       |      200      | authorize     |


  @Regression @API @Emerson @TC_Emerson_API_015 @Rutika @GetAPI
  Scenario Outline: Hit Get request for Emerson to fetch lookups
    Given With "<authorization>"
    And Hit get API to fetch lookups with "<modifiedDate>"
    Then validate <response_code>
    And validate response data is greater than or equal to "<modifiedDate>"

    Examples:
      |       modifiedDate        | response_code | authorization |
      | 2020-02-03T10:39:25.000Z  |      200      | authorize     |
      | 2020-14-03T10:39:25.000Z  |      500      | authorize     |
      | 2025-02-03T10:39:25.000Z  |      500      | authorize     |
      |                           |      200      | authorize     |


  @Regression @API @Emerson @TC_Emerson_API_016 @Rutika @GetAPI
  Scenario Outline: Hit Get request for Emerson to fetch Detailed notes attachment
    Given With "<authorization>"
    And Hit get API to fetch detailed notes attachment for "<endPoint>" with "<attachment_id>"
    Then validate <response_code>
    And verify response body for detailed notes attachment with "<attachment_id>"

    Examples:
      | endPoint                  |       attachment_id       | response_code | authorization |
      | Detailed notes attachment |            9              |      200      | authorize     |
      | Detailed notes attachment |     15748581879668350     |      200      | authorize     |
      | Detailed notes attachment |           -9              |      200      | authorize     |
      | Detailed notes attachment |           10              |      200      | authorize     |
      | Detailed notes attachment |                           |      404      | authorize     |



  @Regression @API @Emerson @TC_Emerson_API_017 @Rutika @GetAPI
  Scenario Outline: Hit Get request for Emerson to fetch FCR Attachment details
    Given With "<authorization>"
    And Hit get API to fetch FCR Attachment details with "<attachment_id>"
    Then validate <response_code>
    And verify response body for FCR attachment with "<attachment_id>"

    Examples:
      |       attachment_id       | response_code | authorization |
      |            1              |      200      | authorize     |
      |     15743362115738766     |      200      | authorize     |
      |           -1              |      200      | authorize     |
      |           10              |      200      | authorize     |
      |                           |      404      | authorize     |


  @Regression @API @Emerson @TC_Emerson_API_018 @Rutika @GetAPI
  Scenario Outline: Hit Get request for Emerson to fetch User and Permission
    Given With "<authorization>"
    And Hit get API to fetch User and Permission
    Then validate <response_code>
    And validate response body for correct user and permission

    Examples:
      | response_code | authorization |
      |      200      | authorize     |
      |      401      | unauthorize   |


  @Regression @API @Emerson @TC_Emerson_API_019 @Rutika @GetAPI
  Scenario Outline: Hit Get request for Emerson to fetch Task list
    Given With "<authorization>"
    And Hit get API to fetch task list with "<fromDate>" and "<toDate>"
    Then validate <response_code>

    Examples:
      |       fromDate            |          toDate           | response_code | authorization |
      | 2020-12-22T08:38:01.280Z  | 2021-04-06T08:38:01.280Z  |      200      | authorize     |
      | 2021-12-22T08:38:01.280Z  | 2020-04-06T08:38:01.280Z  |      200      | authorize     |
      | -2020-12-22T08:38:01.280Z | -2021-04-06T08:38:01.280Z |      200      | authorize     |
      | 0000-12-22T08:38:01.280Z  | 2021-04-06T08:38:01.280Z  |      200      | authorize     |
      | 2020-12-22T08:38:01.280Z  | 0000-04-06T08:38:01.280Z  |      200      | authorize     |


  @Regression @API @Emerson @TC_Emerson_API_020 @Rutika @GetAPI
  Scenario Outline: Hit Get request for Emerson to fetch Deleted Records
    Given With "<authorization>"
    And Hit get API to fetch deleted records with "<updateDate>"
    Then validate <response_code>
    And validate Deletion Date in response body is greater than or equal to "<updateDate>"

    Examples:
      |       updateDate    | response_code | authorization |
      | 2021-01-28 17:12:35 |      200      | authorize     |
      | 2022-01-28 17:12:35 |      200      | authorize     |
      | 2021-52-28 17:12:35 |      500      | authorize     |
      |                     |      200      | authorize     |
      | 2021-01-52 17:12:35 |      500      | authorize     |
      | 2021-01-28 17:12:75 |      500      | authorize     |

  @Regression @API @Emerson @TC_Emerson_API_021 @Rutika @GetAPI
  Scenario Outline: Hit Get request for Emerson to fetch Release Notes
    Given With "<authorization>"
    And Hit get API to fetch Release Notes
    Then validate <response_code>
    And validate response body for Release Notes

    Examples:
      | response_code | authorization |
      |      200      | authorize     |
      |      401      | unauthorize   |

  @Regression @API @Emerson @TC_Emerson_API_022 @Rutika @GetAPI
  Scenario Outline: Hit Get request for Emerson to fetch ActivitiesOSC
    Given With "<authorization>"
    And Hit get API to fetch ActivitiesOSC with "<fromDate>"
    Then validate <response_code>
    And validate response body is greater than or equal to "<fromDate>"

    Examples:
      |       fromDate            | response_code | authorization |
      | 2020-01-01T00:43:24.326Z  |      200      | authorize     |
      | 2030-01-01T00:43:24.326Z  |      200      | authorize     |
      | 2020-81-01T00:43:24.326Z  |      500      | authorize     |
      | 2020-01-01T00:78:24.326Z  |      500      | authorize     |
      |                           |      500      | authorize     |
      | -2020-01-01T00:43:24.326Z |      500      | authorize     |


  @Regression @API @Emerson @TC_Emerson_API_023 @Rutika @GetAPI
  Scenario Outline: Hit Get request for Emerson to fetch Deleted Debrief Items
    Given With "<authorization>"
    And Hit get API to fetch Deleted Debrief Items for "<CreatedBy>"
    Then validate <response_code>
    And validate response data is for user "<CreatedBy>"

    Examples:
      | CreatedBy | response_code | authorization |
      |   726     |      200      | authorize     |
      |   726     |      401      | unauthorize   |
      |   10      |      200      | authorize     |
      |           |      404      | authorize     |
      |  -726     |      200      | authorize     |


  @Regression @API @Emerson @TC_Emerson_API_024 @Rutika @GetAPI
  Scenario Outline: Hit Get request for Emerson to fetch Report Attribute Attachments
    Given With "<authorization>"
    And Hit get API to fetch Report Attribute Attachments for "<RA_PK_ID>"
    Then validate <response_code>
    And validate response data is for ID "<RA_PK_ID>"

    Examples:
      |      RA_PK_ID        | response_code | authorization |
      |   15728840491614660  |      200      | authorize     |
      |         10           |      200      | authorize     |
      |  -15728840491614660  |      200      | authorize     |
      |                      |      200      | authorize     |
      |         AA           |      200      | authorize     |


  @Regression @API @Emerson @TC_Emerson_API_025 @Rutika @GetAPI
  Scenario Outline: Hit Get request for Emerson to fetch TimeZones
    Given With "<authorization>"
    And Hit get API to fetch TimeZones with "<modifiedDate>"
    Then validate <response_code>
    And validate response data is greater than or equal to date "<modifiedDate>"

    Examples:
      |       modifiedDate        | response_code | authorization |
      | 2021-01-09T08:35:18.777Z  |      200      | authorize     |
      | 2030-01-09T08:35:18.777Z  |      500      | authorize     |
      | 2021-81-09T08:35:18.777Z  |      500      | authorize     |
      | 2021-01-09T08:75:18.777Z  |      500      | authorize     |
      |                           |      200      | authorize     |
      | -2020-01-01T00:43:24.326Z |      500      | authorize     |


  @Regression @API @Emerson @TC_Emerson_API_026 @Rutika @GetAPI
  Scenario Outline: Hit Get request for Emerson to fetch Roles
    Given With "<authorization>"
    And Hit get API to fetch Roles
    Then validate <response_code>
    And validate response body for correct role details

    Examples:
      | response_code | authorization |
      |      200      | authorize     |
      |      401      | unauthorize   |


  @Regression @API @Emerson @TC_Emerson_API_027 @Rutika @GetAPI
  Scenario Outline: Hit Get request for Emerson to fetch Users
    Given With "<authorization>"
    And Hit get API to fetch Users
    Then validate <response_code>
    And validate response body for user details

    Examples:
      | response_code | authorization |
      |      200      | authorize     |
      |      401      | unauthorize   |

  @Regression @API @Emerson @TC_Emerson_API_028 @Rutika @GetAPI
  Scenario Outline: Hit Get request for Emerson to fetch Task Details
    Given With "<authorization>"
    And Hit get API to fetch task details with "<fromDate>" and "<toDate>"
    Then validate <response_code>

    Examples:
      |       fromDate            |          toDate           | response_code | authorization |
      | 2020-10-19T03:53:35.787Z  | 2020-11-19T03:53:35.787Z  |      200      | authorize     |
      | 2030-10-19T03:53:35.787Z  | 2035-11-19T03:53:35.787Z  |      200      | authorize     |
      | -2020-10-19T03:53:35.787Z | -2020-11-19T03:53:35.787Z |      500      | authorize     |
      | 2020-71-19T03:53:35.787Z  | 2020-81-19T03:53:35.787Z  |      500      | authorize     |
      |                           |                           |      200      | authorize     |
      |            AA             |            BB             |      500      | authorize     |


  @Regression @API @Emerson @TC_Emerson_API_029 @Rutika @GetAPI
  Scenario Outline: Hit Get request for Emerson to fetch Address
    Given With "<authorization>"
    And Hit get API to fetch address with "<is_enabled>" and "<modifiedon>"
    Then validate <response_code>

    Examples:
      | is_enabled   |          modifiedon       | response_code | authorization |
      |   true       | 2020-02-23T10:42:00.000z  |      200      | authorize     |
      |   true       | -2020-02-23T10:42:00.000z |      500      | authorize     |
      |   true       | 2020-22-23T10:42:00.000z  |      500      | authorize     |
      |   true       |                           |      200      | authorize     |
      |   false      | 2020-02-23T10:42:00.000z  |      200      | authorize     |
      |   false      | -2020-02-23T10:42:00.000z |      500      | authorize     |
      |   false      | 2020-22-23T10:42:00.000z  |      500      | authorize     |
      |   false      |                           |      200      | authorize     |
      |              | 2020-02-23T10:42:00.000z  |      200      | authorize     |
      |              |                           |      200      | authorize     |


  @Regression @API @Emerson @TC_Emerson_API_030 @Rutika @GetAPI
  Scenario Outline: Hit Get request for Emerson to fetch Work Schedules
    Given With "<authorization>"
    And Hit get API to fetch work schedules with "<date>"
    Then validate <response_code>
#    And validate response data is greater than or equal to date "<modifiedDate>"

    Examples:
      |    date     | response_code | authorization |
      | 2020-07-30  |      200      | authorize     |
      | -2020-07-30 |      400      | authorize     |
      | 2020-17-30  |      400      | authorize     |
      |             |      400      | authorize     |
      | 2030-07-30  |      200      | authorize     |


  @Regression @API @Emerson @TC_Emerson_API_031 @Rutika @GetAPI
  Scenario Outline: Hit Get request for Emerson to fetch clarity log
    Given With "<authorization>"
    And Hit get API to fetch clarity log with "<modifiedDate>"
    Then validate <response_code>
#    And validate response data is greater than or equal to date "<modifiedDate>"

    Examples:
      |    modifiedDate      | response_code | authorization |
      | 2020-11-05T08:18:04  |      200      | authorize     |
      | -2020-11-05T08:18:04 |      200      | authorize     |
      | 2020-11-05T08:18:04  |      200      | authorize     |
      |                      |      200      | authorize     |
      | 2030-11-05T08:18:04  |      200      | authorize     |



  @Regression @API @Emerson @TC_Emerson_API_032 @Rutika @GetAPI
  Scenario Outline: Hit Get request for Emerson to fetch analyticsReportDays
    Given With "<authorization>"
    And Hit get API to fetch analyticsReportDays
    Then validate <response_code>

    Examples:
      | response_code | authorization |
      |      200      | authorize     |
      |      401      | unauthorize   |


  @Regression @API @Emerson @TC_Emerson_API_033 @Rutika @GetAPI
  Scenario Outline: Hit Get request for Emerson to fetch User Prefrences
    Given With "<authorization>"
    And Hit get API to fetch User Prefrences
    Then validate <response_code>

    Examples:
      | response_code | authorization |
      |      200      | authorize     |
      |      401      | unauthorize   |