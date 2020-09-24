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

    @Given("Send getAPI Request for account")
    public void Send_getAPI_Request_for_account() {
        resp=(Response) RestAssured.given()
                .auth().oauth2(OauthToken)
                .get(hellosignUrl+"/v3/account");
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

    @Given ("Send post API Request to verify account")
    public void Send_post_API_Request_to_verify_account() throws JSONException {
        resp=(Response) RestAssured.given()
                .baseUri(hellosignUrl)
                .multiPart("email_address","aashish.kumar@sofbang.com")
                .auth().oauth2(OauthToken)
                .when()
                .post("/v3/account/verify");

        System.out.println("Response Body: "  + resp.prettyPrint());
    }

    @Given ("Send get API Request for wrong user")
    public void Send_get_API_Request_for_wrong_user() {
        resp=(Response) RestAssured.given()
                .auth().oauth2(OauthTokenw)
                .get(hellosignUrl+"/v3/account");
    }

    @Given ("Send get API Request to verify team details")
    public void Send_get_API_Request_to_verify_team_details() {
        resp=(Response) RestAssured.given()
                .auth().oauth2(OauthToken)
                .get(hellosignUrl+"/v3/team");
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
        System.out.println(intCount);
        for(j=0;j<=intCount-1;j++) {
            cucumberHooks.addonFunctions.compareString(strValues[j],resp.jsonPath().get(strKeys[j]).toString());
        }
    }
}

