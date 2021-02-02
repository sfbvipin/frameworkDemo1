package StepsDefine;

import cucumberHooks.addonFunctions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang.ObjectUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class apiAutomationFunctions extends AllVariables {
    public Response resp=null;
    public String sAuthorization = null;
    @Given("Send getAPI Request for account")
    public void Send_getAPI_Request_for_account() {
        resp=(Response) RestAssured.given()
                .baseUri(hellosignUrl)
                .auth().oauth2(OauthToken)
                .get("/v3/account");
    }

    @Given("Send getAPI request for account with {string}")
    public void Send_getAPI_request_for_account_with(String authcode)
    {
        if (authcode.equalsIgnoreCase("valid")) {
            resp=(Response) RestAssured.given()
                    .baseUri(hellosignUrl)
                    .auth().oauth2(OauthToken)
                    .get("/v3/account");
        } else {
            resp=(Response) RestAssured.given()
                    .baseUri(hellosignUrl)
                    .auth().oauth2(OauthTokenw)
                    .get("/v3/account");
        }
    }

    @Then ("validate {int}")
    public void validate(Integer response_code) {
        Integer strResponseCode = resp.getStatusCode();
        if (!strResponseCode.equals(response_code)){
            System.out.println("SHARP did not get expected response code");
        } else {
            System.out.println("SHARP got response code as " + strResponseCode +" which is expected");
        }
        resp.then().assertThat().statusCode(response_code);
    }

    @Then ("validate response code")
    public void validate_response_code() {
        Integer strResponseCode = resp.getStatusCode();
        if (strResponseCode != 200){
            System.out.println("SHARP did not get successful response");
            resp.then().assertThat().statusCode(200);
        } else {
            System.out.println("SHARP got successful response with code : 200");
        }
    }

    @And("verify response body for Get Account")
    public void verify_response_body_for_Get_Account() throws IOException{
        verify_body("Get User Account");
    }

    @And("verify response body for verify account")
    public void verify_response_body_for_verify_account() throws IOException{
        verify_body("Verify User Account");
    }

    @And("verify response body for Get Team")
    public void verify_response_body_for_Get_Team() throws IOException{
        verify_body("Get Team");
    }

    @And("verify response body for {string}")
    public void verify_response_body_for_endpoint(String strendPoint) throws IOException{
        if(strendPoint.equalsIgnoreCase("login")) {
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
    public void verify_response_body_for_endpoint_with_resourcecd(String strendPoint, String strResourceCd) throws IOException{
        if(strendPoint.equalsIgnoreCase("tech profile") ) {
            verify_body("Validate Tech Profile for " + strResourceCd);
        }
    }


    @Given ("Send post API Request to verify account")
    public void Send_post_API_Request_to_verify_account() throws JSONException {
        resp=(Response) RestAssured.given()
                .baseUri(hellosignUrl)
                .multiPart("email_address","aashish.kumar@sofbang.com")
                .auth().oauth2(OauthToken)
                .when()
                .post("/v3/account/verify");
    }

    @Given ("Send get API Request for wrong user")
    public void Send_get_API_Request_for_wrong_user() {
        resp=(Response) RestAssured.given()
                .baseUri(hellosignUrl)
                .auth().oauth2(OauthTokenw)
                .get("/v3/account");
    }

    @Given ("Send get API Request to verify team details")
    public void Send_get_API_Request_to_verify_team_details() {
        resp=(Response) RestAssured.given()
                .baseUri(hellosignUrl)
                .auth().oauth2(OauthToken)
                .get("/v3/team");
    }

    @Given ("Hit post API request for {string} with {string}")
    public void Hit_post_API_request(String strEndPoint, String strauthcode) throws JSONException {
        String sAuthCode = null;
        if (strauthcode.equalsIgnoreCase("valid")){
            sAuthCode = EmersonOauthToken;
        } else {
            sAuthCode = OauthTokenw;
        }

        if(strEndPoint.equalsIgnoreCase("login")) {
            Map<String,String> requestHeaders = new HashMap<>();
            requestHeaders.put("oracle-mobile-backend-id",EmersonBackendId);
            requestHeaders.put("credentials",EmersonCredentials);
            requestHeaders.put("Content-Type","application/json");
            requestHeaders.put("Authorization",sAuthCode);

            JSONObject requestParams = new JSONObject();
            requestParams.put("UDID", "112");
            requestParams.put("logout", "false");

            resp=(Response) RestAssured.given()
                    .baseUri(EmersonUrl)
                    .headers(requestHeaders)
                    .body(requestParams.toString())
                    .when()
                    .post(SESMobileLogin);
        } else if (strEndPoint.equalsIgnoreCase("check user")) {
            Map<String,String> requestHeaders = new HashMap<>();
            requestHeaders.put("oracle-mobile-backend-id",EmersonBackendId);
            requestHeaders.put("accsToken","Basic eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbiI6ImV5SnJhV1FpT2lJd01tOW1aRWRFVFhSeVFWOUhlV2xXT1hoQlZHUnJNVUYwU0dZd0xXMU1TM0I1YjNGaU9ESmhTVEZKSWl3aVlXeG5Jam9pVWxNeU5UWWlmUS5leUoyWlhJaU9qRXNJbXAwYVNJNklrRlVMalp5YjJGb056TlpSWFJqVlZkeFZ6ZHFhV1ZCYVdjMU5HWkRaa1ZwTkdOd1ZGZEdjVEJhVWt4elJXTXViMkZ5YkRaeWNHUjJXVXhDTTNCNmVXd3ljRFlpTENKcGMzTWlPaUpvZEhSd2N6b3ZMMlZ0WlhKemIyNHViMnQwWVM1amIyMGlMQ0poZFdRaU9pSm9kSFJ3Y3pvdkwyVnRaWEp6YjI0dWIydDBZUzVqYjIwaUxDSnpkV0lpT2lKSFlYVnlZWFl1Vm1GamFHaGhibWxBUlcxbGNuTnZiaTVqYjIwaUxDSnBZWFFpT2pFMk1ETTNNVFEzTWpBc0ltVjRjQ0k2TVRZd016Y3hPRE15TUN3aVkybGtJam9pTUc5aE5HMXhjemx2TVdkRlVFZEtaMU15Y0RjaUxDSjFhV1FpT2lJd01IVTFPSEEwYVc5NGFtNXpha1V6Y1RKd055SXNJbk5qY0NJNld5SnZabVpzYVc1bFgyRmpZMlZ6Y3lKZGZRLlEzTFpvd01JamhZeVBxVUpBaXhMLThVQWZQLV9QZnBQWHlJRUtQS0tBVEpJX2FybmY4WDJYd1FPeXFHWjZxdkoyUjhzU1lfOWpaRWhXUUc3alI3RkQ4OGl5eFp2M1ZzaDlCX0xoZU1ZREsxa2tZWFRyMWdQOUs5VmJzWFV6Mng1R2lzTEZXc3FaUzYxM2FxcUYtT2lpc0NQcEpmY0RSS0tpSW9ZQTQzTWNDS3lvZ1NaWG1hRXRkb0hLNEtMTU9HVzkzczk5NVZIM2VyMXZMaTFWdWhLUkVGemtuTVpMSENjbF9uMXdkX0Z6Umc2elg2cHdEeENTZm1Gd29XeFZsWFI2aldDemdUZDJPWlIwd2g1UGRQNHg1RFUtM2VqWG54LWhfUExrZXI0dmRSaW1ORnBjN19vOTljM3lYM1RKQjYwN2hNZFlKM2pwSWw4cFRkbTJwR2NpdyIsImlhdCI6MTYwMzcxNDcyMSwiZXhwIjoxNjM1MjUwNzIxfQ.LXuRIgJ2qGt_zEl5JwWx0xlvSz1bhlimloshNOa9bvBdSnXiTkMgyg8aXx3L5n-sB_Safu73cq53kaa5Vi-sho5_r7AsJe6o4WKzS3E1SNBHhH2wOHMJdAyQMM8nTTr0VT-XM8syhUYZ4KkFuVg9SjEgSWGsgR27tia9cgdB2Cy_nELgWqA_BNiT7mfjn4AGaMdmgFS_oJj2yE1U_HAB6YP-mpmbqNJfV-0nqImDkYcP9asLXs1AcQAsu8Nol5XhO5Q47TQIDgv3Zg1tnh39DbdzuHWOuW4qMzh7FY0QBkJH3XhmBVh1lfsVq9srA5nDdfWgt75cdhEII9stSSPhPQ");
            requestHeaders.put("Content-Type","application/json");
            requestHeaders.put("Authorization",sAuthCode);

            JSONObject requestParams = new JSONObject();
            requestParams.put("UDID", "112");
            requestParams.put("emailID", "aashish.kumar@emerson.com");

            resp=(Response) RestAssured.given()
                    .baseUri(EmersonUrl)
                    .headers(requestHeaders)
                    .body(requestParams.toString())
                    .when()
                    .post(SESMobileCheckUser);
        }
    }

    @Given ("With {string}")
    public void with_authorize(String strAuthorization) throws JSONException {
        sAuthorization = strAuthorization;
    }


    @And ("Hit get API for {string} with {string}")
    public void Hit_get_API_request(String strEndPoint, String strResourceCd) throws JSONException {
        String sResourceCd = null;
        sResourceCd = strResourceCd;

        Map<String,String> requestHeaders = new HashMap<>();
        requestHeaders.put("oracle-mobile-backend-id",EmersonBackendId);
        requestHeaders.put("accsToken",EmersonAccToken);
        requestHeaders.put("Content-Type","application/json");
        if (sAuthorization.equalsIgnoreCase("authorize")){
            requestHeaders.put("Authorization",EmersonOauthToken);
        }

        String strTechProfileUrl = SESMobileTechProfile + "?resourceId=" + sResourceCd;
        resp=(Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .get(strTechProfileUrl);

        System.out.println(resp.prettyPrint());
    }

    @And ("Hit post API check user with {string} and {string}")
    public void hit_post_api_check_user(String emailId, String udid) throws JSONException {

        Map<String,String> requestHeaders = new HashMap<>();
        requestHeaders.put("oracle-mobile-backend-id",EmersonBackendId);
        requestHeaders.put("accsToken",EmersonAccToken);
        requestHeaders.put("Content-Type","application/json");
        if (sAuthorization.equalsIgnoreCase("authorize")){
            requestHeaders.put("Authorization",EmersonOauthToken);
        }

        JSONObject requestParams = new JSONObject();
        requestParams.put("UDID", udid);
        requestParams.put("emailID", emailId);

        resp=(Response) RestAssured.given()
                .baseUri(EmersonUrl)
                .headers(requestHeaders)
                .body(requestParams.toString())
                .when()
                .post("/SESMobileBackendAPI/user/validate");

        System.out.println(resp.prettyPrint());
    }


    public void verify_body(String strTestCase)  throws IOException{
        System.out.println("SHARP got Response Body: "  + resp.prettyPrint());
        Integer j = 0;
        String strMainValues = null;
        strMainValues = cucumberHooks.addonFunctions.validateResponse(strTestCase);
        String[] strKeyValuePair = strMainValues.split(":");
        String[] strKeys = strKeyValuePair[0].split(";");
        String[] strValues = strKeyValuePair[1].split(";");
        Integer intCount = strKeyValuePair[0].split(";").length;
        String strExpVal = null;
        System.out.println("SHARP : Total number of attributes to compare is " + intCount);
        for(j=0;j<=intCount-1;j++) {
            if (resp.jsonPath().get(strKeys[j]) == null){
                strExpVal = "null";
            } else {
                strExpVal = resp.jsonPath().get(strKeys[j]).toString();
            }
            cucumberHooks.addonFunctions.compareString(strValues[j],strExpVal);
        }
    }
}

