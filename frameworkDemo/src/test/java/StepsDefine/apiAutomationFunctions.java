package StepsDefine;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.joda.time.DateTime;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import org.testng.Assert;

import java.time.*;
import java.time.format.DateTimeFormatter;


import java.io.IOException;
import java.util.*;

import static java.lang.System.*;
import static java.time.format.DateTimeFormatter.ofPattern;
import static org.codehaus.groovy.runtime.DefaultGroovyMethods.collect;
import static org.codehaus.groovy.vmplugin.v8.PluginDefaultGroovyMethods.mapToObj;


public class apiAutomationFunctions extends AllVariables {
    public Response resp = null;
    public String sAuthorization = null;
    public String sBackendID = null;

    @Given("Send getAPI Request for account")
    public void Send_getAPI_Request_for_account() {
        resp = (Response) RestAssured.given()
                .baseUri(hellosignUrl)
                .auth().oauth2(OauthToken)
                .get("/v3/account");
    }

    @Given("Send getAPI request for account with {string}")
    public void Send_getAPI_request_for_account_with(String authcode) {
        if (authcode.equalsIgnoreCase("valid")) {
            resp = (Response) RestAssured.given()
                    .baseUri(hellosignUrl)
                    .auth().oauth2(OauthToken)
                    .get("/v3/account");
        } else {
            resp = (Response) RestAssured.given()
                    .baseUri(hellosignUrl)
                    .auth().oauth2(OauthTokenw)
                    .get("/v3/account");
        }
    }

    @Then("validate {int}")
    public void validate(Integer response_code) {
        Integer strResponseCode = resp.getStatusCode();
        if (!strResponseCode.equals(response_code)) {
            out.println("SHARP did not get expected response code");
        } else {
            out.println("SHARP got response code as " + strResponseCode + " which is expected");
        }
        resp.then().assertThat().statusCode(response_code);
    }

    @Then("validate response code")
    public void validate_response_code() {
        Integer strResponseCode = resp.getStatusCode();
        if (strResponseCode != 200) {
            out.println("SHARP did not get successful response");
            resp.then().assertThat().statusCode(200);
        } else {
            out.println("SHARP got successful response with code : 200");
        }
    }

    @And("verify response body for Get Account")
    public void verify_response_body_for_Get_Account() throws IOException {
        verify_body("Get User Account");
    }

    @And("verify response body for verify account")
    public void verify_response_body_for_verify_account() throws IOException {
        verify_body("Verify User Account");
    }

    @And("verify response body for Get Team")
    public void verify_response_body_for_Get_Team() throws IOException {
        verify_body("Get Team");
    }

    @And("verify response body for {string}")
    public void verify_response_body_for_endpoint(String strendPoint) throws IOException {
        if (strendPoint.equalsIgnoreCase("login")) {
            verify_body("Get Login Detail");
        } else if (strendPoint.equalsIgnoreCase("check user")) {
            verify_body("Validate user detail");
        } else if (strendPoint.equalsIgnoreCase("validate user for different udid")) {
            verify_body("validate user for different udid");
        } else if (strendPoint.equalsIgnoreCase("validate error msg for invalid email")) {
            verify_body("validate error msg for invalid email");
        } else if (strendPoint.equalsIgnoreCase("validate user with login udid")) {
            verify_body("validate user with login udid");
        } else if (strendPoint.equalsIgnoreCase("validate user for different email")) {
            verify_body("validate user for different email");
        }
    }

    @And("verify response body for {string} with {string}")
    public void verify_response_body_for_endpoint_with_resourcecd(String strendPoint, String strResourceCd) throws IOException {
        if (strendPoint.equalsIgnoreCase("tech profile")) {
            verify_body("Validate Tech Profile for " + strResourceCd);
        }
    }

    @And("verify response body for detailed notes attachment with {string}")
    public void verify_response_body_for_detailed_notes_attachment(String strAttachmentId) throws IOException {
        verify_body("Validate Detailed Notes Attachment for " + strAttachmentId);
    }

    @And("verify response body for FCR attachment with {string}")
    public void verify_response_body_for_FCR_attachment(String strAttachmentId) throws IOException {
        verify_body("Validate FCR Attachment for " + strAttachmentId);
    }

    @And("validate response body for Release Notes")
    public void validate_response_body_for_Release_Notes() throws IOException {
        Integer intRespCode = resp.getStatusCode();
        if (intRespCode != 200) {
            out.println("SHARP: Verify data function is not executed as API didn't return 200 code.");
        } else {
            verify_body("validate response body for Release Notes");
        }
    }

    @And("validate response body for user details")
    public void validate_response_body_for_user_details() throws IOException {
        Integer intRespCode = resp.getStatusCode();
        if (intRespCode != 200) {
            out.println("SHARP: Verify data function is not executed as API didn't return 200 code.");
        } else {
            verify_body("validate response body for user details");
        }
    }

    @And("validate response body for correct user and permission")
    public void validate_response_body_for_correct_user_and_permission() throws IOException {
        Integer intRespCode = resp.getStatusCode();
        if (intRespCode != 200) {
            out.println("SHARP: Verify data function is not executed as API didn't return 200 code.");
        } else {
            verify_body("validate response body for correct user and permission");
        }
    }

    @And("validate response body for correct role details")
    public void validate_response_body_for_correct_role_details() throws IOException {
        Integer intRespCode = resp.getStatusCode();
        if (intRespCode != 200) {
            out.println("SHARP: Verify data function is not executed as API didn't return 200 code.");
        } else {
            verify_body("validate response body for correct role details");
        }
    }

    @And("validate response body for correct EmergencyCallOut details")
    public void validate_response_body_for_correct_EmergencyCallOut_details() throws IOException {
        Integer intRespCode = resp.getStatusCode();
        if (intRespCode != 200) {
            out.println("SHARP: Verify data function is not executed as API didn't return 200 code.");
        } else {
            verify_body("validate response body for correct EmergencyCallOut details");
        }
    }


    @Given("Send post API Request to verify account")
    public void Send_post_API_Request_to_verify_account() throws JSONException {
        resp = (Response) RestAssured.given()
                .baseUri(hellosignUrl)
                .multiPart("email_address", "aashish.kumar@sofbang.com")
                .auth().oauth2(OauthToken)
                .when()
                .post("/v3/account/verify");
    }

    @Given("Send get API Request for wrong user")
    public void Send_get_API_Request_for_wrong_user() {
        resp = (Response) RestAssured.given()
                .baseUri(hellosignUrl)
                .auth().oauth2(OauthTokenw)
                .get("/v3/account");
    }

    @Given("Send get API Request to verify team details")
    public void Send_get_API_Request_to_verify_team_details() {
        resp = (Response) RestAssured.given()
                .baseUri(hellosignUrl)
                .auth().oauth2(OauthToken)
                .get("/v3/team");
    }

    @Given("Hit post API request for {string} with {string}")
    public void Hit_post_API_request(String strEndPoint, String strauthcode) throws JSONException {
        String sAuthCode = null;
        if (strauthcode.equalsIgnoreCase("valid")) {
            sAuthCode = EmersonOauthToken;
        } else {
            sAuthCode = OauthTokenw;
        }

        if (strEndPoint.equalsIgnoreCase("login")) {
            Map<String, String> requestHeaders = new HashMap<>();
            requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
            requestHeaders.put("credentials", EmersonCredentials);
            requestHeaders.put("Content-Type", "application/json");
            requestHeaders.put("Authorization", sAuthCode);

            JSONObject requestParams = new JSONObject();
            requestParams.put("UDID", "112");
            requestParams.put("logout", "false");

            resp = (Response) RestAssured.given()
                    .baseUri(EmersonUrl)
                    .headers(requestHeaders)
                    .body(requestParams.toString())
                    .when()
                    .post(SESMobileLogin);
        } else if (strEndPoint.equalsIgnoreCase("check user")) {
            Map<String, String> requestHeaders = new HashMap<>();
            requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
            requestHeaders.put("accsToken", "Basic eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbiI6ImV5SnJhV1FpT2lJd01tOW1aRWRFVFhSeVFWOUhlV2xXT1hoQlZHUnJNVUYwU0dZd0xXMU1TM0I1YjNGaU9ESmhTVEZKSWl3aVlXeG5Jam9pVWxNeU5UWWlmUS5leUoyWlhJaU9qRXNJbXAwYVNJNklrRlVMalp5YjJGb056TlpSWFJqVlZkeFZ6ZHFhV1ZCYVdjMU5HWkRaa1ZwTkdOd1ZGZEdjVEJhVWt4elJXTXViMkZ5YkRaeWNHUjJXVXhDTTNCNmVXd3ljRFlpTENKcGMzTWlPaUpvZEhSd2N6b3ZMMlZ0WlhKemIyNHViMnQwWVM1amIyMGlMQ0poZFdRaU9pSm9kSFJ3Y3pvdkwyVnRaWEp6YjI0dWIydDBZUzVqYjIwaUxDSnpkV0lpT2lKSFlYVnlZWFl1Vm1GamFHaGhibWxBUlcxbGNuTnZiaTVqYjIwaUxDSnBZWFFpT2pFMk1ETTNNVFEzTWpBc0ltVjRjQ0k2TVRZd016Y3hPRE15TUN3aVkybGtJam9pTUc5aE5HMXhjemx2TVdkRlVFZEtaMU15Y0RjaUxDSjFhV1FpT2lJd01IVTFPSEEwYVc5NGFtNXpha1V6Y1RKd055SXNJbk5qY0NJNld5SnZabVpzYVc1bFgyRmpZMlZ6Y3lKZGZRLlEzTFpvd01JamhZeVBxVUpBaXhMLThVQWZQLV9QZnBQWHlJRUtQS0tBVEpJX2FybmY4WDJYd1FPeXFHWjZxdkoyUjhzU1lfOWpaRWhXUUc3alI3RkQ4OGl5eFp2M1ZzaDlCX0xoZU1ZREsxa2tZWFRyMWdQOUs5VmJzWFV6Mng1R2lzTEZXc3FaUzYxM2FxcUYtT2lpc0NQcEpmY0RSS0tpSW9ZQTQzTWNDS3lvZ1NaWG1hRXRkb0hLNEtMTU9HVzkzczk5NVZIM2VyMXZMaTFWdWhLUkVGemtuTVpMSENjbF9uMXdkX0Z6Umc2elg2cHdEeENTZm1Gd29XeFZsWFI2aldDemdUZDJPWlIwd2g1UGRQNHg1RFUtM2VqWG54LWhfUExrZXI0dmRSaW1ORnBjN19vOTljM3lYM1RKQjYwN2hNZFlKM2pwSWw4cFRkbTJwR2NpdyIsImlhdCI6MTYwMzcxNDcyMSwiZXhwIjoxNjM1MjUwNzIxfQ.LXuRIgJ2qGt_zEl5JwWx0xlvSz1bhlimloshNOa9bvBdSnXiTkMgyg8aXx3L5n-sB_Safu73cq53kaa5Vi-sho5_r7AsJe6o4WKzS3E1SNBHhH2wOHMJdAyQMM8nTTr0VT-XM8syhUYZ4KkFuVg9SjEgSWGsgR27tia9cgdB2Cy_nELgWqA_BNiT7mfjn4AGaMdmgFS_oJj2yE1U_HAB6YP-mpmbqNJfV-0nqImDkYcP9asLXs1AcQAsu8Nol5XhO5Q47TQIDgv3Zg1tnh39DbdzuHWOuW4qMzh7FY0QBkJH3XhmBVh1lfsVq9srA5nDdfWgt75cdhEII9stSSPhPQ");
            requestHeaders.put("Content-Type", "application/json");
            requestHeaders.put("Authorization", sAuthCode);

            JSONObject requestParams = new JSONObject();
            requestParams.put("UDID", "112");
            requestParams.put("emailID", "aashish.kumar@emerson.com");

            resp = (Response) RestAssured.given()
                    .baseUri(EmersonUrl)
                    .headers(requestHeaders)
                    .body(requestParams.toString())
                    .when()
                    .post(SESMobileCheckUser);
        }
    }

    @Given("With {string}")
    public void with_authorize(String strAuthorization) throws JSONException {
        sAuthorization = strAuthorization;
    }

    @Given("With {string} and {string}")
    public void with_authorize_and_backendID(String strAuthorization, String strBackendID) throws JSONException {
        sAuthorization = strAuthorization;
        sBackendID= strBackendID;
    }


    @And("Hit get API for {string} with {string}")
    public void Hit_get_API_request(String strEndPoint, String strResourceCd) throws JSONException {
        String sResourceCd = null;
        sResourceCd = strResourceCd;

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
        requestHeaders.put("accsToken", EmersonAccToken);
        requestHeaders.put("Content-Type", "application/json");
        if (sAuthorization.equalsIgnoreCase("authorize")) {
            requestHeaders.put("Authorization", EmersonOauthToken);
        }

        String strTechProfileUrl = SESMobileTechProfile + "?resourceId=" + sResourceCd;
        resp = (Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .get(strTechProfileUrl);

        out.println(resp.prettyPrint());
    }

    @And("Hit post API check user with {string} and {string}")
    public void hit_post_api_check_user(String emailId, String udid) throws JSONException {

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
        requestHeaders.put("accsToken", EmersonAccToken);
        requestHeaders.put("Content-Type", "application/json");
        if (sAuthorization.equalsIgnoreCase("authorize")) {
            requestHeaders.put("Authorization", EmersonOauthToken);
        }

        JSONObject requestParams = new JSONObject();
        requestParams.put("UDID", udid);
        requestParams.put("emailID", emailId);

        resp = (Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .body(requestParams.toString())
                .when()
                .post("/SESMobileBackendAPI/user/validate");

        out.println(resp.prettyPrint());
    }


    public void verify_body(String strTestCase) throws IOException {
        out.println("SHARP got Response Body: " + resp.prettyPrint());
        Integer j = 0;
        String strMainValues = null;
        strMainValues = cucumberHooks.addonFunctions.validateResponse(strTestCase);
        String[] strKeyValuePair = strMainValues.split(":");
        String[] strKeys = strKeyValuePair[0].split(";");
        String[] strValues = strKeyValuePair[1].split(";");
        Integer intCount = strKeyValuePair[0].split(";").length;
        String strExpVal = null;
        out.println("SHARP : Total number of attributes to compare is " + intCount);
        for (j = 0; j <= intCount - 1; j++) {
            if (resp.jsonPath().get(strKeys[j]) == null) {
                strExpVal = "null";
            } else {
                strExpVal = resp.jsonPath().get(strKeys[j]).toString();
            }
            cucumberHooks.addonFunctions.compareString(strValues[j], strExpVal);
        }
    }


    @And("Hit post API update with {string} {string} {string} and {string}")
    public void hit_post_api_update(String emailId, String udid, String currentAppVersion, String logout) throws JSONException {

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
        requestHeaders.put("accsToken", EmersonAccToken);
        requestHeaders.put("Content-Type", "application/json");
        if (sAuthorization.equalsIgnoreCase("authorize")) {
            requestHeaders.put("Authorization", EmersonOauthToken);
        }

        JSONObject requestParams = new JSONObject();
        requestParams.put("UDID", udid);
        requestParams.put("emailID", emailId);
        requestParams.put("currentAppVersion", currentAppVersion);
        requestParams.put("logout", logout);

        resp = (Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .body(requestParams.toString())
                .when()
                .post(SESMobileUpdateUDID);

        out.println(resp.prettyPrint());
    }

    @And("Hit post API login with {string} {string} {string} and {string}")
    public void hit_post_api_login(String udid, String logout, String username, String password) throws JSONException {

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
        requestHeaders.put("credentials", EmersonCredentials2);
        requestHeaders.put("Content-Type", "application/json");
        if (sAuthorization.equalsIgnoreCase("authorize")) {
            requestHeaders.put("Authorization", EmersonOauthToken);
        }

        JSONObject requestParams = new JSONObject();
        requestParams.put("udid", udid);
        requestParams.put("logout", logout);
        requestParams.put("username", username);
        requestParams.put("password", password);

        resp = (Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .body(requestParams.toString())
                .when()
                .post(SESMobileLogin);

        out.println(resp.prettyPrint());
    }


    @And("Hit get API to fetch feedbacks with {string}")
    public void Hit_get_API_to_fetch_feedbacks(String strModifiedOn) throws JSONException {

        String sModifiedOn = null;
        sModifiedOn = strModifiedOn;

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
        requestHeaders.put("accsToken", EmersonAccToken);
        requestHeaders.put("Content-Type", "application/json");
        if (sAuthorization.equalsIgnoreCase("authorize")) {
            requestHeaders.put("Authorization", EmersonOauthToken);
        }

        String strFeedbackUrl = SESMobileFeedback + "?MODIFIEDON=" + sModifiedOn;
        resp = (Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .get(strFeedbackUrl);

        out.println(resp.prettyPrint());
    }

    @And("verify all data is greater than {string}")
    public void verify_all_data_is_greater_than(String strModifiedOn) throws JSONException {

        Integer intRespCode = resp.getStatusCode();
        if (intRespCode != 200) {
            out.println("SHARP: Verify data function is not executed as API didn't return 200 code.");
        } else {
            String sModifiedOn = null;
            sModifiedOn = strModifiedOn.trim();
            String ModifiedOn = null;
            int count = 0;
            String Validate = null;
            JSONObject json = new JSONObject(resp.prettyPrint());
            JSONArray response = json.getJSONArray("data");

            LocalDateTime currentDate = LocalDateTime.parse(DateTime.now().toString(), ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSz"));

            if (sModifiedOn.length() == 0) {
                for (int i = 0; i < response.length(); i++) {

                    ModifiedOn = response.getJSONObject(i).getString("MODIFIEDON");
                    LocalDateTime ResponseModifiedOn = LocalDateTime.parse(ModifiedOn, ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSz"));

                    if (ResponseModifiedOn.compareTo(currentDate) > 0) {
                        count++;
                    }
                }
            } else {
                LocalDateTime InputModifiedOn = LocalDateTime.parse(sModifiedOn, ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSz"));
                for (int i = 0; i < response.length(); i++) {


                    ModifiedOn = response.getJSONObject(i).getString("MODIFIEDON");
                    LocalDateTime ResponseModifiedOn = LocalDateTime.parse(ModifiedOn, ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSz"));


                    if (ResponseModifiedOn.compareTo(InputModifiedOn) < 0) {
                        count++;
                    }
                }
            }
            if (count > 0) {
                //System.out.println("APi is giving "+count+ " incorrect responses");
                Validate = "APi is giving " + count + " incorrect responses";
            } else {
                //System.out.println("All responses are correct");
                Validate = "All responses are correct";
            }

            assert Validate.equalsIgnoreCase("All responses are correct");
        }
    }


    @And("Hit get API for Emergency call out details")
    public void Hit_get_API_for_Emergency_call_out() throws JSONException {

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
        requestHeaders.put("Content-Type", "application/json");
        if (sAuthorization.equalsIgnoreCase("authorize")) {
            requestHeaders.put("Authorization", EmersonOauthToken);
        }

        resp = (Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .get(SESMobileEmergencyCallOut);

        out.println(resp.prettyPrint());
    }

    @And("Hit post API EmergencyCallOutInOSC with {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void hit_post_api_emergencyCallOutInOSC(String incident_id, String field_job_status, String business_group, String business_unit, String field_job_type, String field_job_group, String field_job_name, String service_engineer_name, String requested_date, String scheduled_date, String debrief_submission_date, String emergency_callout, String activity_id) throws JSONException {

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
        requestHeaders.put("Content-Type", "application/json");
        if (sAuthorization.equalsIgnoreCase("authorize")) {
            requestHeaders.put("Authorization", EmersonOauthToken);
        }

        JSONObject requestParams = new JSONObject();
        requestParams.put("incident_id", incident_id);
        requestParams.put("field_job_status", field_job_status);
        requestParams.put("business_group", business_group);
        requestParams.put("business_unit", business_unit);
        requestParams.put("field_job_type", field_job_type);
        requestParams.put("field_job_group", field_job_group);
        requestParams.put("field_job_name", field_job_name);
        requestParams.put("service_engineer_name", service_engineer_name);
        requestParams.put("requested_date", requested_date);
        requestParams.put("scheduled_date", scheduled_date);
        requestParams.put("debrief_submission_date", debrief_submission_date);
        requestParams.put("emergency_callout", emergency_callout);
        requestParams.put("activity_id", activity_id);

        resp = (Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .body(requestParams.toString())
                .when()
                .post(SESMobileEmergencyCallOutInOSC);

        out.println(resp.prettyPrint());
    }


    @And("Hit post API feedback with {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void hit_post_api_feedback(String id, String rating, String qid, String resource_id, String user_email, String user_location, String comments, String feedback_date, String review_date, String reviewed_by, String is_reviewed, String createdby, String createdon, String modifiedby, String modifiedon) throws JSONException {

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
        requestHeaders.put("Content-Type", "application/json");
        requestHeaders.put("accsToken", EmersonAccToken);
        if (sAuthorization.equalsIgnoreCase("authorize")) {
            requestHeaders.put("Authorization", EmersonOauthToken);
        }

        JSONObject requestParams1 = new JSONObject();
        requestParams1.put("id", id);
        requestParams1.put("rating", rating);
        requestParams1.put("qid", qid);
        requestParams1.put("resource_id", resource_id);
        requestParams1.put("user_email", user_email);
        requestParams1.put("user_location", user_location);
        requestParams1.put("comments", comments);
        requestParams1.put("feedback_date", feedback_date);
        requestParams1.put("review_date", review_date);
        requestParams1.put("reviewed_by", reviewed_by);
        requestParams1.put("is_reviewed", is_reviewed);
        requestParams1.put("createdby", createdby);
        requestParams1.put("createdon", createdon);
        requestParams1.put("modifiedby", modifiedby);
        requestParams1.put("modifiedon", modifiedon);

        List<JSONObject> jsonArrayPayload = new ArrayList<>();
        jsonArrayPayload.add(requestParams1);

        resp = (Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .body(jsonArrayPayload)
                .when()
                .post(SESMobileFeedback);

        out.println(resp.prettyPrint());
    }


    @And("Hit get API to fetch allowances for {string}")
    public void Hit_get_API_to_fetch_allowance_for(String strModifiedDate) throws JSONException {

        String sModifiedDate = null;
        sModifiedDate = strModifiedDate;


        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
        requestHeaders.put("accsToken", EmersonAccToken);
        requestHeaders.put("Content-Type", "application/json");
        if (sAuthorization.equalsIgnoreCase("authorize")) {
            requestHeaders.put("Authorization", EmersonOauthToken);
        }

        String strAllowanceUrl = SESMobileAllowance + "?modifiedDate=" + sModifiedDate;
        resp = (Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .get(strAllowanceUrl);

        out.println(resp.prettyPrint());
    }

    @And("Hit get API to fetch languages for {string}")
    public void Hit_get_API_to_fetch_languages(String strIsEnabled) throws JSONException {

        String sIsEnabled = null;
        sIsEnabled = strIsEnabled;


        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
        requestHeaders.put("accsToken", EmersonAccToken);
        requestHeaders.put("Content-Type", "application/json");
        if (sAuthorization.equalsIgnoreCase("authorize")) {
            requestHeaders.put("Authorization", EmersonOauthToken);
        }

        String strLanguageUrl = SESMobileLanguage + "?isEnabled=" + sIsEnabled;
        resp = (Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .get(strLanguageUrl);

        out.println(resp.prettyPrint());
    }

    @And("validate response matches the value of {string}")
    public void validate_response_matches_the_value_of_isEnbaled(String strisEnabled) throws JSONException {

        String sIsEnabled = null;
        sIsEnabled = strisEnabled.trim();
        String respIsEnabled = null;
        int count = 0;
        boolean result;
        String Validate = null;
        JSONObject json = new JSONObject(resp.prettyPrint());
        JSONArray response = json.getJSONArray("data");

        if (sIsEnabled.length() == 0) {
            for (int i = 0; i < response.length(); i++) {
                respIsEnabled = response.getJSONObject(i).getString("ISENABLED");
                result = ((respIsEnabled != "true") || (respIsEnabled != "false"));
                if (result = false) {
                    count++;
                }
            }
        } else {
            for (int i = 0; i < response.length(); i++) {
                respIsEnabled = response.getJSONObject(i).getString("ISENABLED");
                result = respIsEnabled != sIsEnabled;
                if (result = false) {
                    count++;
                }
            }
        }
        if (count > 0) {
            //System.out.println("APi is giving "+count+ " incorrect responses");
            Validate = "APi is giving " + count + " incorrect responses";
        } else {
            Validate = "All responses are correct";
        }

        assert Validate.equalsIgnoreCase("All responses are correct");
    }


    @And("Hit get API to fetch lookups with {string}")
    public void Hit_get_API_to_fetch_lookups(String strmodifiedDate) throws JSONException {

        String smodifiedDate = null;
        smodifiedDate = strmodifiedDate;


        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
        requestHeaders.put("accsToken", EmersonAccToken);
        if (sAuthorization.equalsIgnoreCase("authorize")) {
            requestHeaders.put("Authorization", EmersonOauthToken);
        }

        String strLookupsUrl = SESMobileLookups + "?modifiedDate=" + smodifiedDate;
        resp = (Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .get(strLookupsUrl);

        out.println(resp.prettyPrint());
    }

    @And("validate response data is greater than or equal to {string}")
    public void validate_response_data_greater_than_or_equal_to_ModifiedDate(String strModifiedDate) throws JSONException {

        Integer intRespCode = resp.getStatusCode();
        if (intRespCode != 200) {
            out.println("SHARP: Verify data function is not executed as API didn't return 200 code.");
        } else {
            String sModifiedDate = null;
            sModifiedDate = strModifiedDate.trim();
            String ModifiedDate = null;
            int count = 0;
            String Validate = null;

            JSONObject json = new JSONObject(resp.prettyPrint());
            JSONObject jsonobj = json.getJSONObject("data");
            JSONArray response = jsonobj.getJSONArray("data");

            LocalDateTime currentDate = LocalDateTime.parse(DateTime.now().toString(), ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSz"));

            if (sModifiedDate.length() == 0) {
                for (int i = 0; i < response.length(); i++) {
                    ModifiedDate = response.getJSONObject(i).getString("ModifiedDate");
                    LocalDateTime ResponseModifiedDate = LocalDateTime.parse(ModifiedDate, ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSz"));
                    if (ResponseModifiedDate.compareTo(currentDate) > 0) {
                        count++;
                    }
                }
            } else {
                LocalDateTime InputModifiedOn = LocalDateTime.parse(sModifiedDate, ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSz"));
                for (int i = 0; i < response.length(); i++) {
                    ModifiedDate = response.getJSONObject(i).getString("ModifiedDate");
                    LocalDateTime ResponseModifiedOn = LocalDateTime.parse(ModifiedDate, ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSz"));
                    if (ResponseModifiedOn.compareTo(InputModifiedOn) < 0) {
                        count++;
                    }
                }
            }
            if (count > 0) {
                Validate = "APi is giving " + count + " incorrect responses";
            } else {
                Validate = "All responses are correct";
            }
            assert Validate.equalsIgnoreCase("All responses are correct");
        }
    }


    @And("Hit get API to fetch languageKeyMapping with {string}")
    public void Hit_get_API_to_fetch_languageKeyMapping(String strLangID) throws JSONException {

        String sLangID = null;
        sLangID = strLangID;


        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
        requestHeaders.put("accsToken", EmersonAccToken);
        requestHeaders.put("Content-Type", "application/json");
        if (sAuthorization.equalsIgnoreCase("authorize")) {
            requestHeaders.put("Authorization", EmersonOauthToken);
        }

        String strLanguageKeyMappingUrl = SESMobileLanguageKeyMapping + "?LangID=" + sLangID;
        resp = (Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .get(strLanguageKeyMappingUrl);

        out.println(resp.prettyPrint());
    }

    @And("validate response is received for {string}")
    public void validate_response_is_received_for_langID(String strLangID) throws JSONException {

        Integer intRespCode = resp.getStatusCode();
        if (intRespCode != 200) {
            out.println("SHARP: Verify data function is not executed as API didn't return 200 code.");
        } else {
            int sLangID = Integer.parseInt(strLangID);
            int LANG_ID;
            int count = 0;
            String Validate = null;


            JSONObject json = new JSONObject(resp.prettyPrint());
            JSONArray response = json.getJSONArray("data");

            for (int i = 0; i < response.length(); i++) {
                LANG_ID = response.getJSONObject(i).getInt("LANG_ID");
                if (LANG_ID != sLangID) {
                    count++;
                }
            }

            if (count > 0) {
                Validate = "APi is giving " + count + " incorrect responses";
            } else {
                Validate = "All responses are correct";
            }
            assert Validate.equalsIgnoreCase("All responses are correct");
        }
    }

    @And("Hit get API to fetch detailed notes attachment for {string} with {string}")
    public void Hit_get_API_to_fetch_detailed_notes_attachment(String strendPoint, String strattachmentId) throws JSONException {

        String sendPoint = null;
        sendPoint = strendPoint;

        String sattachmentId = null;
        sattachmentId = strattachmentId;


        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
        requestHeaders.put("accsToken", EmersonAccToken);
        requestHeaders.put("Content-Type", "application/json");
        if (sAuthorization.equalsIgnoreCase("authorize")) {
            requestHeaders.put("Authorization", EmersonOauthToken);
        }

        String strDetailedNotesAttachmentUrl = SESMobileDetailedNotesAttachment + "?attachment_id=" + sattachmentId;
        resp = (Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .get(strDetailedNotesAttachmentUrl);

        out.println(resp.prettyPrint());
    }


    @And("Hit get API to fetch FCR Attachment details with {string}")
    public void Hit_get_API_to_fetch_FCR_Attachment_details(String strattachmentId) throws JSONException {

        String sattachmentId = null;
        sattachmentId = strattachmentId;


        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
        requestHeaders.put("accsToken", EmersonAccToken);
        requestHeaders.put("Content-Type", "application/json");
        if (sAuthorization.equalsIgnoreCase("authorize")) {
            requestHeaders.put("Authorization", EmersonOauthToken);
        }

        String strFCRAttachmentDetailsUrl = SESMobileFCRAttachment + "?attachment_id=" + sattachmentId;
        resp = (Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .get(strFCRAttachmentDetailsUrl);

        out.println(resp.prettyPrint());
    }


    @And("Hit get API to fetch User and Permission")
    public void Hit_get_API_to_fetch_User_and_Permission() throws JSONException {

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
        requestHeaders.put("accsToken", EmersonAccToken);
        requestHeaders.put("Content-Type", "application/json");
        if (sAuthorization.equalsIgnoreCase("authorize")) {
            requestHeaders.put("Authorization", EmersonOauthToken);
        }

        resp = (Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .get(SESMobileUserandPermission);

        out.println(resp.prettyPrint());
    }


    @And("Hit get API to fetch task list with {string} and {string}")
    public void Hit_get_API_to_fetch_task_list(String strFromDate, String strToDate) throws JSONException {

        String sFromDate = null;
        sFromDate = strFromDate;

        String sToDate = null;
        sToDate = strToDate;

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
        requestHeaders.put("Content-Type", "application/json");
        if (sAuthorization.equalsIgnoreCase("authorize")) {
            requestHeaders.put("Authorization", EmersonOauthToken);
        }

        String strTaskListUrl = SESMobileTaskList + "?fromDate=" + sFromDate + "&toDate=" + sToDate;
        resp = (Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .get(strTaskListUrl);

        out.println(resp.prettyPrint());
    }

    @And("Hit get API to fetch deleted records with {string}")
    public void Hit_get_API_to_fetch_deleted_records_with_updateDate(String strUpdateDate) throws JSONException {

        String sUpdateDate = null;
        sUpdateDate = strUpdateDate;

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
        requestHeaders.put("Content-Type", "application/json");
        if (sAuthorization.equalsIgnoreCase("authorize")) {
            requestHeaders.put("Authorization", EmersonOauthToken);
        }

        String strDeletedRecordsUrl = SESMobileDeletedRecords + "?updateDate=" + sUpdateDate;
        resp = (Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .get(strDeletedRecordsUrl);

        out.println(resp.prettyPrint());
    }

    @And("validate Deletion Date in response body is greater than or equal to {string}")
    public void validate_Deletion_Date_in_response_body_is_greater_than_or_equal_to_UpdateDate(String strUpdateDate) throws JSONException {

        Integer intRespCode = resp.getStatusCode();
        if (intRespCode != 200) {
            out.println("SHARP: Verify data function is not executed as API didn't return 200 code.");
        } else {
            String sUpdateDate = null;
            sUpdateDate = strUpdateDate.trim();
            String Deletion_Date = null;
            int count = 0;
            String Validate = null;
            Date current_Date = null;

            JSONObject json = new JSONObject(resp.prettyPrint());
            JSONObject jobj = json.getJSONObject("data");
            JSONArray response = jobj.getJSONArray("Record_Deletion");

            if (response.length() == 0) {
                out.println("SHARP: Cannot validate response body as it is empty");
            } else {
                LocalDateTime InputUpdateDate = LocalDateTime.parse(sUpdateDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                for (int i = 0; i < response.length(); i++) {
                    Deletion_Date = response.getJSONObject(i).getString("Deletion_Date");
                    LocalDateTime ResponseDeletionDate = LocalDateTime.parse(Deletion_Date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    if ((ResponseDeletionDate).isBefore(InputUpdateDate)) {
                        count++;
                    }
                }
            }
            if (count > 0) {
                Validate = "APi is giving " + count + " incorrect responses";
            } else {
                Validate = "All responses are correct";
            }
            assert Validate.equalsIgnoreCase("All responses are correct");
        }

    }


    @And("Hit get API to fetch Release Notes")
    public void Hit_get_API_to_fetch_Release_Notes() throws JSONException {

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
        requestHeaders.put("Content-Type", "application/json");
        requestHeaders.put("accsToken", EmersonAccToken);
        if (sAuthorization.equalsIgnoreCase("authorize")) {
            requestHeaders.put("Authorization", EmersonOauthToken);
        }

        resp = (Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .get(SESMobileReleaseNotes);

        out.println(resp.prettyPrint());
    }


    @And("Hit get API to fetch ActivitiesOSC with {string}")
    public void Hit_get_API_to_fetch_ActivitiesOSC_with_fromDate(String strFromDate) throws JSONException {

        String sFromDate = null;
        sFromDate = strFromDate;


        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
        requestHeaders.put("Content-Type", "application/json");
        if (sAuthorization.equalsIgnoreCase("authorize")) {
            requestHeaders.put("Authorization", EmersonOauthToken);
        }

        String strActivitiesOSCUrl = SESMobileActivitiesOSC + "?fromDate=" + sFromDate;
        resp = (Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .get(strActivitiesOSCUrl);

        out.println(resp.prettyPrint());
    }

    @And("validate response body is greater than or equal to {string}")
    public void validate_response_body_is_greater_than_or_equal_to(String strFromDate) throws JSONException {

        Integer intRespCode = resp.getStatusCode();
        if (intRespCode != 200) {
            out.println("SHARP: Verify data function is not executed as API didn't return 200 code.");
        } else {
            String sFromDate = null;
            sFromDate = strFromDate;
            String FromDate = null;
            int count = 0;
            String Validate = null;

            JSONObject json = new JSONObject(resp.prettyPrint());
            JSONArray response = json.getJSONArray("data");

            if (response.length() == 0) {
                out.println("SHARP: Verify data function is not executed as response body is empty.");
            } else {
                LocalDateTime InputFromdate = LocalDateTime.parse(sFromDate, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSz"));
                for (int i = 0; i < response.length(); i++) {
                    FromDate = response.getJSONObject(i).getString("Start_time");
                    LocalDateTime ResponseFromDate = LocalDateTime.parse(FromDate, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSz"));


                    if (ResponseFromDate.compareTo(InputFromdate) < 0) {
                        count++;
                    }
                }
            }
            if (count > 0) {
                //System.out.println("APi is giving "+count+ " incorrect responses");
                Validate = "APi is giving " + count + " incorrect responses";
            } else {
                //System.out.println("All responses are correct");
                Validate = "All responses are correct";
            }

            assert Validate.equalsIgnoreCase("All responses are correct");
        }
    }

    @And("Hit get API to fetch Deleted Debrief Items for {string}")
    public void hit_get_API_to_fetch_Deleted_Debrief_Items_for_user(String strCreatedBy) throws JSONException {

        String sCreatedBy = null;
        sCreatedBy = strCreatedBy;

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
        requestHeaders.put("Content-Type", "application/json");
        requestHeaders.put("accsToken", EmersonAccToken);
        if (sAuthorization.equalsIgnoreCase("authorize")) {
            requestHeaders.put("Authorization", EmersonOauthToken);
        }

        String strDeleteDebriefItemsUrl = SESMobileDeleteDebriefItems + sCreatedBy + "/deleteDebriefItems";
        resp = (Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .get(strDeleteDebriefItemsUrl);

        out.println(resp.prettyPrint());
    }

    @And("validate response data is for user {string}")
    public void validate_response_data_is_for_user(String strCreatedBy) throws JSONException {

        Integer intRespCode = resp.getStatusCode();
        if (intRespCode != 200) {
            out.println("SHARP: Verify data function is not executed as API didn't return 200 code.");
        } else {
            String sCreadtedBy = null;
            sCreadtedBy = strCreatedBy;
            String CreatedBy = null;
            int count = 0;
            String Validate = null;
            boolean flag;

            JSONObject json = new JSONObject(resp.prettyPrint());
            JSONArray response = json.getJSONArray("data");

            if (response.length() == 0) {
                out.println("SHARP: Validate response body is not executed as response body is empty");
            } else {
                for (int i = 0; i < response.length(); i++) {
                    CreatedBy = response.getJSONObject(i).getString("createdBy");
                    flag = (CreatedBy != sCreadtedBy);
                    if (flag = false) {
                        count++;
                    }
                }
            }
            if (count > 0) {
                Validate = "APi is giving " + count + " incorrect responses";
            } else {
                Validate = "All responses are correct";
            }
            assert Validate.equalsIgnoreCase("All responses are correct");
        }
    }

    @And("Hit get API to fetch Report Attribute Attachments for {string}")
    public void Hit_get_API_to_fetch_Report_Attribute_Attachments_for(String strRA_PK_ID) throws JSONException {

        String sRA_PK_ID = null;
        sRA_PK_ID = strRA_PK_ID;

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
        requestHeaders.put("Content-Type", "application/json");
        requestHeaders.put("accsToken", EmersonAccToken);
        if (sAuthorization.equalsIgnoreCase("authorize")) {
            requestHeaders.put("Authorization", EmersonOauthToken);
        }

        String strReportAttributeAttachmentUrl = SESMobileReportAttributeAttachment + "?RA_PK_ID=" + sRA_PK_ID;
        resp = (Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .get(strReportAttributeAttachmentUrl);

        out.println(resp.prettyPrint());
    }

    @And("validate response data is for ID {string}")
    public void validate_response_data_is_for_ID(String strRA_PK_ID) throws JSONException {

        Integer intRespCode = resp.getStatusCode();
        if (intRespCode != 200) {
            out.println("SHARP: Verify data function is not executed as API didn't return 200 code.");
        } else {
            String sRA_PK_ID = null;
            sRA_PK_ID = strRA_PK_ID;
            String RA_PK_ID = null;
            int count = 0;
            String Validate = null;
            boolean flag;

            JSONObject json = new JSONObject(resp.prettyPrint());
            JSONArray response = json.getJSONArray("data");

            if (response.length() == 0) {
                out.println("SHARP: Validate response body is not executed as response body is empty");
            } else {
                for (int i = 0; i < response.length(); i++) {
                    RA_PK_ID = response.getJSONObject(i).getString("RA_PK_ID");
                    flag = (RA_PK_ID != sRA_PK_ID);
                    if (flag = false) {
                        count++;
                    }
                }
            }
            if (count > 0) {
                Validate = "APi is giving " + count + " incorrect responses";
            } else {
                Validate = "All responses are correct";
            }
            assert Validate.equalsIgnoreCase("All responses are correct");
        }
    }

    @And("Hit get API to fetch TimeZones with {string}")
    public void Hit_get_API_to_fetch_TimeZones_with(String strModifiedDate) throws JSONException {

        String sModifiedDate = null;
        sModifiedDate = strModifiedDate;

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
        requestHeaders.put("Content-Type", "application/json");
        requestHeaders.put("accsToken", EmersonAccToken);
        if (sAuthorization.equalsIgnoreCase("authorize")) {
            requestHeaders.put("Authorization", EmersonOauthToken);
        }

        String strTimeZoneUrl = SESMobileTimeZone + "?modifiedDate=" + sModifiedDate;
        resp = (Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .get(strTimeZoneUrl);

        out.println(resp.prettyPrint());
    }


    @And("validate response data is greater than or equal to date {string}")
    public void validate_response_data_is_greater_than_or_equal_to_date(String strModifiedDate) throws JSONException {

        Integer intRespCode = resp.getStatusCode();
        if (intRespCode != 200) {
            out.println("SHARP: Verify data function is not executed as API didn't return 200 code.");
        } else {
            String sModifiedDate = null;
            sModifiedDate = strModifiedDate.trim();
            out.println("Given Modified date is: " + sModifiedDate);
            String ModifiedDate = null;
            int count = 0;
            String Validate = null;
            JSONObject json = new JSONObject(resp.prettyPrint());
            JSONArray response = json.getJSONArray("data");

            LocalDateTime currentDate = LocalDateTime.parse(DateTime.now().toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSz"));
            out.println("Current date is: " + currentDate);
            if (sModifiedDate.length() == 0) {
                out.println("inside for loop");
                for (int i = 0; i < response.length(); i++) {

                    ModifiedDate = response.getJSONObject(i).getString("Modified_Date");
                    out.println("response date is: " + ModifiedDate);
                    if (ModifiedDate != "null") {
                        LocalDateTime ResponseModifiedDate = LocalDateTime.parse(ModifiedDate, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSz"));
                        out.println("localdate input is: " + ResponseModifiedDate);
                        if (ResponseModifiedDate.compareTo(currentDate) > 0) {
                            count++;
                        }
                    } else {
                        out.println("SHARP: Cannot compare date as Modified date is null in response data.");
                    }
                }
            } else {
                LocalDateTime InputModifiedDate = LocalDateTime.parse(sModifiedDate, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSz"));
                for (int i = 0; i < response.length(); i++) {


                    ModifiedDate = response.getJSONObject(i).getString("Modified_Date");
                    LocalDateTime ResponseModifiedDate = LocalDateTime.parse(ModifiedDate, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSz"));


                    if (ResponseModifiedDate.compareTo(InputModifiedDate) < 0) {
                        count++;
                    }
                }
            }
            if (count > 0) {
                Validate = "APi is giving " + count + " incorrect responses";
            } else {
                Validate = "All responses are correct";
            }

            assert Validate.equalsIgnoreCase("All responses are correct");
        }
    }

    @And("Hit get API to fetch Roles")
    public void Hit_get_API_to_fetch_Roles() throws JSONException {

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
        requestHeaders.put("Content-Type", "application/json");
        requestHeaders.put("accsToken", EmersonAccToken);
        if (sAuthorization.equalsIgnoreCase("authorize")) {
            requestHeaders.put("Authorization", EmersonOauthToken);
        }

        resp = (Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .get(SESMobileRoles);

        out.println(resp.prettyPrint());
    }

    @And("Hit get API to fetch Users")
    public void Hit_get_API_to_fetch_Users() throws JSONException {

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
        requestHeaders.put("Content-Type", "application/json");
        requestHeaders.put("accsToken", EmersonAccToken);
        if (sAuthorization.equalsIgnoreCase("authorize")) {
            requestHeaders.put("Authorization", EmersonOauthToken);
        }

        resp = (Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .get(SESMobileUsers);

        out.println(resp.prettyPrint());
    }

    @And("Hit get API to fetch task details with {string} and {string}")
    public void Hit_get_API_to_fetch_task_details(String strFromDate, String strToDate) throws JSONException {

        String sFromDate = null;
        sFromDate = strFromDate;

        String sToDate = null;
        sToDate = strToDate;

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
        requestHeaders.put("Content-Type", "application/json");
        if (sAuthorization.equalsIgnoreCase("authorize")) {
            requestHeaders.put("Authorization", EmersonOauthToken);
        }

        String strTaskDetailsUrl = SESMobileTaskDetails + "?fromDate=" + sFromDate + "&toDate=" + sToDate;
        resp = (Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .get(strTaskDetailsUrl);

        out.println(resp.prettyPrint());
    }

    @And("Hit get API to fetch address with {string} and {string}")
    public void Hit_get_API_to_fetch_address(String strisEnabled, String strModifiedOn) throws JSONException {

        String sisEnabled = null;
        sisEnabled = strisEnabled;

        String sModifiedOn = null;
        sModifiedOn = strModifiedOn;

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
        requestHeaders.put("accsToken", EmersonAccToken);
        requestHeaders.put("Content-Type", "application/json");
        if (sAuthorization.equalsIgnoreCase("authorize")) {
            requestHeaders.put("Authorization", EmersonOauthToken);
        }

        String strAddressUrl = SESMobileAddress + "?IS_ENABLED=" + sisEnabled + "&MODIFIEDON=" + sModifiedOn;
        resp = (Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .get(strAddressUrl);

        out.println(resp.prettyPrint());
    }

//    @And("validate response body for address is greater than or equal to {string}")
//    public void validate_response_body_for_address_is_greater_than_or_equal_to(String strModifiedDate) throws JSONException {
//
//        Integer intRespCode = resp.getStatusCode();
//        if(intRespCode!=200){
//            out.println("SHARP: Verify data function is not executed as API didn't return 200 code.");
//        }
//        else {
//            String sModifiedDate=null;
//            sModifiedDate = strModifiedDate.trim();
//            out.println("Given Modified date is: "+sModifiedDate);
//            String ModifiedDate = null;
//            int count=0;
//            String Validate=null;
//            JSONObject json = new JSONObject(resp.prettyPrint());
//            JSONArray response = json.getJSONArray("data");
//
//            LocalDateTime currentDate = LocalDateTime.parse(DateTime.now().toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSz"));
//            if (sModifiedDate.length()==0)
//            {
//                for(int i=0;i<response.length();i++){
//                    ModifiedDate=response.getJSONObject(i).getString("MODIFIEDON");
//                    if(ModifiedDate!="null") {
//                        LocalDateTime ResponseModifiedDate = LocalDateTime.parse(ModifiedDate, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSz"));
//                        if (ResponseModifiedDate.compareTo(currentDate)>0 )
//                        {
//                            count++;
//                        }
//                }
//                        else{
//                    out.println("SHARP: Cannot compare date as Modified date is null in response data.");
//                }}
//            }
//            else {
//                LocalDateTime InputModifiedDate = LocalDateTime.parse(sModifiedDate, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSz"));
//                for (int i = 0; i < response.length(); i++) {
//                    ModifiedDate = response.getJSONObject(i).getString("MODIFIEDON");
//                    if(ModifiedDate!="null") {
//                    LocalDateTime ResponseModifiedDate = LocalDateTime.parse(ModifiedDate, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSz"));
//                    if (ResponseModifiedDate.compareTo(InputModifiedDate) < 0) {
//                        count++;
//                    }
//                }
//                else{
//                    out.println("SHARP: Cannot compare date as Modified date is null in response data.");
//                }}
//            }
//            if (count>0)
//            {
//                Validate="APi is giving "+count+ " incorrect responses";
//            }
//            else
//            {
//                Validate="All responses are correct";
//            }
//
//            assert Validate.equalsIgnoreCase("All responses are correct");
//        }
//    }


    @And("Hit get API to fetch work schedules with {string}")
    public void Hit_get_API_to_fetch_work_schedules(String strDate) throws JSONException {

        String sDate = null;
        sDate = strDate;

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
        if (sAuthorization.equalsIgnoreCase("authorize")) {
            requestHeaders.put("Authorization", EmersonOauthToken);
        }

        String strWorkSchedulesUrl = SESMobileWorkSchedules + "?date=" + sDate;
        resp = (Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .get(strWorkSchedulesUrl);

        out.println(resp.prettyPrint());
    }

    @And("Hit get API to fetch clarity lov with {string}")
    public void Hit_get_API_to_fetch_clarity_lov(String strModifiedDate) throws JSONException {

        String sModifiedDate = null;
        sModifiedDate = strModifiedDate;

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
        requestHeaders.put("accsToken", EmersonAccToken);
        requestHeaders.put("Content-Type", "application/json");
        if (sAuthorization.equalsIgnoreCase("authorize")) {
            requestHeaders.put("Authorization", EmersonOauthToken);
        }

        String strClarityLovUrl = SESMobileClarityLov + "?modifiedDate=" + sModifiedDate;
        resp = (Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .get(strClarityLovUrl);

        out.println(resp.prettyPrint());
    }

    @And("validate response data for clarity lov")
    public void validate_response_data_for_clarity_lov() throws IOException {
        verify_body("validate response data for clarity lov");
    }

    @And("Hit get API to fetch analyticsReportDays")
    public void Hit_get_API_to_fetch_analyticsReportDays() throws JSONException {

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
        requestHeaders.put("Content-Type", "application/json");
        if (sAuthorization.equalsIgnoreCase("authorize")) {
            requestHeaders.put("Authorization", EmersonOauthToken);
        }

        resp = (Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .get(SESMobileanalyticsReportDays);

        out.println(resp.prettyPrint());
    }

    @And("Hit get API to fetch User Preferences")
    public void Hit_get_API_to_fetch_User_Preferences() throws JSONException {

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
        requestHeaders.put("Content-Type", "application/json");
        requestHeaders.put("accsToken", EmersonAccToken);
        if (sAuthorization.equalsIgnoreCase("authorize")) {
            requestHeaders.put("Authorization", EmersonOauthToken);
        }

        resp = (Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .get(SESMobileUserPreferences);

        out.println(resp.prettyPrint());
    }

    @And("validate response body for User Preferences")
    public void validate_response_body_for_User_Preferences() throws IOException {
        Integer intRespCode = resp.getStatusCode();
        if (intRespCode != 200) {
            out.println("SHARP: Verify data function is not executed as API didn't return 200 code.");
        } else {
            out.println("inside else");
            verify_body("validate response body for User Preferences");
        }
    }

    @And("Hit get API for Analytics Report Days")
    public void Hit_get_API_for_Analytics_Report_Days() throws JSONException {

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
        requestHeaders.put("Content-Type", "application/json");
        if (sAuthorization.equalsIgnoreCase("authorize")) {
            requestHeaders.put("Authorization", EmersonOauthToken);
        }

        resp = (Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .get(SESMobileAnalyticsReportDays);

        out.println(resp.prettyPrint());
    }

    @And("validate response body for correct Analytics Report Days")
    public void validate_response_body_for_correct_Analytics_Report_Days() throws IOException, JSONException {
        Integer intRespCode = resp.getStatusCode();
        String responsedays = null;
        String Validate = null;
        boolean flag;
        if (intRespCode != 200) {
            out.println("SHARP: Verify data function is not executed as API didn't return 200 code.");
        } else {
            JSONObject json = new JSONObject(resp.prettyPrint());
            responsedays = json.get("days").toString();

            flag = (responsedays != "3");
            if (flag = false) {
                Validate = "API is giving incorrect response";
            } else {
                Validate = "All responses are correct";
            }
            assert Validate.equalsIgnoreCase("All responses are correct");
        }
    }


    /********************************************-----SDR APIs-----******************************************/


    @And("Hit get API for all user sites")
    public void Hit_get_API_for_all_user_sites() throws JSONException {

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("Content-Type", "application/json");
        requestHeaders.put("accsToken", EmersonAccToken);
        if (sAuthorization.equalsIgnoreCase("authorize")) {
            requestHeaders.put("Authorization", EmersonOauthToken);
        }
        if (sBackendID.equalsIgnoreCase("available")){
            requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
        }

        resp = (Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .get(GetAllUserSitesUrl);

        out.println(resp.prettyPrint());
    }


    @And("Hit get API for specific user sites")
    public void Hit_get_API_for_specific_user_sites() throws JSONException {

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("Content-Type", "application/json");
        requestHeaders.put("accsToken", EmersonAccToken);
        if (sAuthorization.equalsIgnoreCase("authorize")) {
            requestHeaders.put("Authorization", EmersonOauthToken);
        }
        if (sBackendID.equalsIgnoreCase("available")){
            requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
        }

        resp = (Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .get(GetUserSitesUrl);

        out.println(resp.prettyPrint());
    }

    @And("validate response body for correct user site data")
    public void validate_response_body_for_correct_user_site_data() throws IOException {
        Integer intRespCode = resp.getStatusCode();
        if (intRespCode != 200) {
            out.println("SHARP: Verify data function is not executed as API didn't return 200 code.");
        } else {
            verify_body("validate specific user site data");
        }
    }


    @And("Hit get API for Reports Menu Cache")
    public void Hit_get_API_for_Reports_Menu_Cache() throws JSONException {

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("Content-Type", "application/json");
        requestHeaders.put("accsToken", EmersonAccToken);
        if (sAuthorization.equalsIgnoreCase("authorize")) {
            requestHeaders.put("Authorization", EmersonOauthToken);
        }
        if (sBackendID.equalsIgnoreCase("available")){
            requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
        }

        String strReportsMenuCacheUrl = ReportsCacheUrl + reportId + "/menus";
        resp = (Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .get(strReportsMenuCacheUrl);

        out.println(resp.prettyPrint());
    }

    @And("validate response body for reports menu cache")
    public void validate_response_body_for_reports_menu_cache() throws IOException {
        Integer intRespCode = resp.getStatusCode();
        if (intRespCode != 200) {
            out.println("SHARP: Verify data function is not executed as API didn't return 200 code.");
        } else {
            verify_body("validate reports menu cache");
        }
    }


    @And("Hit get API for Report Devices Cache")
    public void Hit_get_API_for_Report_Devices_Cache() throws JSONException {

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("Content-Type", "application/json");
        requestHeaders.put("accsToken", EmersonAccToken);
        if (sAuthorization.equalsIgnoreCase("authorize")) {
            requestHeaders.put("Authorization", EmersonOauthToken);
        }
        if (sBackendID.equalsIgnoreCase("available")){
            requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
        }

        String strReportsDevicesCacheUrl = ReportsCacheUrl + reportId + "/devices";
        resp = (Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .get(strReportsDevicesCacheUrl);

        out.println(resp.prettyPrint());
    }

    @And("validate response body for report devices cache")
    public void validate_response_body_for_report_devices_cache() throws IOException {
        Integer intRespCode = resp.getStatusCode();
        if (intRespCode != 200) {
            out.println("SHARP: Verify data function is not executed as API didn't return 200 code.");
        } else {
            verify_body("validate report devices cache");
        }
    }

    @And("Hit get API for Report Headers Cache")
    public void Hit_get_API_for_Report_Headers_Cache() throws JSONException {

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("Content-Type", "application/json");
        requestHeaders.put("accsToken", EmersonAccToken);
        if (sAuthorization.equalsIgnoreCase("authorize")) {
            requestHeaders.put("Authorization", EmersonOauthToken);
        }
        if (sBackendID.equalsIgnoreCase("available")){
            requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
        }

        String strReportsHeadersCacheUrl = ReportsCacheUrl + reportId + "/headers";
        resp = (Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .get(strReportsHeadersCacheUrl);

        out.println(resp.prettyPrint());
    }

    @And("validate response body for report headers cache")
    public void validate_response_body_for_report_headers_cache() throws IOException {
        Integer intRespCode = resp.getStatusCode();
        if (intRespCode != 200) {
            out.println("SHARP: Verify data function is not executed as API didn't return 200 code.");
        } else {
            verify_body("validate report headers cache");
        }
    }


    @And("Hit get API for InprogressReports Cache")
    public void Hit_get_API_for_InprogressReports_Cache() throws JSONException {

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("Content-Type", "application/json");
        requestHeaders.put("accsToken", EmersonAccToken);
        if (sAuthorization.equalsIgnoreCase("authorize")) {
            requestHeaders.put("Authorization", EmersonOauthToken);
        }
        if (sBackendID.equalsIgnoreCase("available")){
            requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
        }

        resp = (Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .get(strInprogressReportsCacheUrl);

        out.println(resp.prettyPrint());
    }

    @And("validate response body for InprogressReports Cache")
    public void validate_response_body_for_InprogressReports_Cache() throws IOException {
        Integer intRespCode = resp.getStatusCode();
        if (intRespCode != 200) {
            out.println("SHARP: Verify data function is not executed as API didn't return 200 code.");
        } else {
            verify_body("validate InprogressReports Cache");
        }
    }


    @And("Hit get API for Users Completed Reports Cache")
    public void Hit_get_API_for_Users_Completed_Reports_Cache() throws JSONException {

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("Content-Type", "application/json");
        requestHeaders.put("accsToken", EmersonAccToken);
        if (sAuthorization.equalsIgnoreCase("authorize")) {
            requestHeaders.put("Authorization", EmersonOauthToken);
        }
        if (sBackendID.equalsIgnoreCase("available")){
            requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
        }

        resp = (Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .get(strUsersCompletedReportsCacheUrl);

        out.println(resp.prettyPrint());
    }


    @And("Hit delete API to delete user sites with {string}")
    public void Hit_delete_API_to_delete_user_sites(String modifiedby) throws JSONException {

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("accsToken", EmersonAccToken);
        requestHeaders.put("Content-Type", "application/json");
        if (sAuthorization.equalsIgnoreCase("authorize")) {
            requestHeaders.put("Authorization", EmersonOauthToken);
        }
        if (sBackendID.equalsIgnoreCase("available")) {
            requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
        }

        JSONObject requestParams = new JSONObject();
        requestParams.put("MODIFIEDBY", modifiedby);

        resp = (Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .body(requestParams.toString())
                .when()
                .delete(strDeleteUserSites);

        out.println(resp.prettyPrint());
    }

    @And("verify response body for delete user sites")
    public void verify_response_body_for_delete_user_sites() throws IOException {
        Integer intRespCode = resp.getStatusCode();
        if (intRespCode != 200) {
            out.println("SHARP: Verify data function is not executed as API didn't return 200 code.");
        } else {
            verify_body("validate delete user sites");
        }
    }

    @And("Hit delete API to deactivate report")
    public void delete_API_to_deactivate_report() throws JSONException {

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("accsToken", EmersonAccToken);
        requestHeaders.put("Content-Type", "application/json");
        if (sAuthorization.equalsIgnoreCase("authorize")) {
            requestHeaders.put("Authorization", EmersonOauthToken);
        }
        if (sBackendID.equalsIgnoreCase("available")) {
            requestHeaders.put("oracle-mobile-backend-id", EmersonBackendId);
        }

        JSONObject requestParams = new JSONObject();
        //requestParams.put("MODIFIEDBY", modifiedby);

        resp = (Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .body(requestParams.toString())
                .when()
                .delete(strDeactivateReport);

        out.println(resp.prettyPrint());
    }

    @And("verify response body for deactivate report")
    public void verify_response_body_for_deactivate_report() throws IOException {
        Integer intRespCode = resp.getStatusCode();
        if (intRespCode != 200) {
            out.println("SHARP: Verify data function is not executed as API didn't return 200 code.");
        } else {
            verify_body("validate deactivate report");
        }
    }
}



