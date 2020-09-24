package StepsDefine;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONException;

import java.io.IOException;


public class apiAutomationFunctions extends AllVariables {
    public Response resp=null;

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

    @And ("verify response body")
    public void verify_response_body() throws IOException {
        System.out.println("Response Body: "  + resp.prettyPrint());

//        String is_locked = resp.jsonPath().get("account.is_locked").toString();
//        System.out.println("is_locked :" + is_locked);
//
//        String locale = resp.jsonPath().get("account.locale").toString();
//        System.out.println("locale :" + locale);
//
//        String email_Address = resp.jsonPath().get("account.email_address").toString();
//        System.out.println("email_Address :" + email_Address);
//
//        String api_signature = resp.jsonPath().get("account.quotas.api_signature_requests_left").toString();
//        System.out.println("api_signature_requests_left :" + api_signature);
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

