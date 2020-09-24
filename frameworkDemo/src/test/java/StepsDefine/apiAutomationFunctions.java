package StepsDefine;

import cucumberHooks.addonFunctions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONException;

import java.io.IOException;
import java.util.Arrays;


public class apiAutomationFunctions extends AllVariables {
    public Response resp=null;

    public String strTestCaseName = null;

    @Given("Create getAPI Request for account")
    public void Create_getAPI_Request_for_account() {
        resp=(Response) RestAssured.given()
                .auth().oauth2(OauthToken)
                .get(hellosignUrl+"/v3/account");
    }


    @And ("send get request for useraccount")
    public void send_get_request_for_useraccount() {

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
        System.out.println("SHARP got Response Body: "  + resp.prettyPrint());
        Integer j = 0;
        String strMainValues = null;
        strMainValues = cucumberHooks.addonFunctions.validateResponse("Get User Account");
        String[] strKeyValuePair = strMainValues.split(":");
        String[] strKeys = strKeyValuePair[0].split(";");
        String[] strValues = strKeyValuePair[1].split(";");
        Integer intCount = strKeyValuePair[0].split(";").length;
        System.out.println(intCount);
        for(j=0;j<=intCount-1;j++) {
            cucumberHooks.addonFunctions.compareString(strValues[j],resp.jsonPath().get(strKeys[j]).toString());
        }

    }

    @And("verify response body for Get Team")
    public void verify_response_body_for_Get_Team() throws IOException{
        System.out.println("SHARP got Response Body: "  + resp.prettyPrint());
        Integer j = 0;
        String strMainValues = null;
        strMainValues = cucumberHooks.addonFunctions.validateResponse("Get Team");
        String[] strKeyValuePair = strMainValues.split(":");
        String[] strKeys = strKeyValuePair[0].split(";");
        String[] strValues = strKeyValuePair[1].split(";");
        Integer intCount = strKeyValuePair[0].split(";").length;
        System.out.println(intCount);
        for(j=0;j<=intCount-1;j++) {
            cucumberHooks.addonFunctions.compareString(strValues[j],resp.jsonPath().get(strKeys[j]).toString());
        }

    }

    @Given ("Create post API Request to verify account")
    public void Create_post_API_Request_to_verify_account() throws JSONException {
        String payload = "{\n" +
                "    \"email_address\": \"aashish.kumar@sofbang.com\"\n" +
                "}";

        System.out.println("Payload: "  + payload);
        resp=(Response) RestAssured.given()
                .baseUri(hellosignUrl)
                .body(payload)
                .auth().oauth2(OauthToken)
                .when()
                .post("/v3/account/verify");

        System.out.println("Response Body: "  + resp.prettyPrint());
    }

    @Given ("Create get API Request for wrong user")
    public void Create_get_API_Request_for_wrong_user() {
        resp=(Response) RestAssured.given()
                .auth().oauth2(OauthTokenw)
                .get(hellosignUrl+"/v3/account");
    }

    @Given ("Create get API Request to verify team details")
    public void Create_get_API_Request_to_verify_team_details() {
        resp=(Response) RestAssured.given()
                .auth().oauth2(OauthToken)
                .get(hellosignUrl+"/v3/team");
    }
}

