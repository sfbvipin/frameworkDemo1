package StepsDefine;

import java.util.Iterator;
import java.util.Set;

public class AllVariables {
	public static String chromePath = "src\\test\\resources\\Drivers\\chromedriver.exe";
    public static String firfoxPath = "src\\test\\resources\\Drivers\\geckodriver.exe";
    public static String exelonUrl = "https://aztest.atlanticcityelectric.com/MyAccount/CustomerSupport/Pages/ContactUs.aspx";
    public static String signurl  ="https://stage-apigateway-east.exeloncorp.com/auth/oauth/v2/authorize/login?action=display&sessionID=477be947-4a4b-4aaf-94fc-04067f5dcca3&sessionData=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.ew0KICAgICJzZXNzaW9uIjogew0KICAgICAgICAic2Vzc2lvbklEIjoiNDc3YmU5NDctNGE0Yi00YWFmLTk0ZmMtMDQwNjdmNWRjY2EzIiwNCiAgICAgICAgImV4cCI6MTU5OTExOTk2OCwNCiAgICAgICAgImN1cnJlbnRfdXNlcm5hbWUiOiIiLA0KICAgICAgICAiY3VycmVudF91c2VyX2NvbnNlbnQiOiJub25lIiwNCiAgICAgICAgImN1cnJlbnRfdXNlcl9yb2xlIjoiIiwNCiAgICAgICAgImN1cnJlbnRfdXNlcl9hY3IiOiIwIiwNCiAgICAgICAgImN1cnJlbnRfdXNlcl9hdXRoVGltZSI6IjAiLA0KICAgICAgICAic2FsdCI6IiIsDQogICAgICAgICJ0aGlyZF9wYXJ0eV9zc29fdG9rZW4iOiIiLA0KICAgICAgICAidGhpcmRfcGFydHlfc3NvX3Rva2VuX3R5cGUiOiIiDQogICAgfSwNCiAgICAicmVxdWVzdF9jb25zZW50Ijogew0KICAgICAgICAiY2xpZW50X25hbWUiOiJXZWIrLStBQ0VTdGFnZSIsDQogICAgICAgICJzY29wZV92ZXJpZmllZCI6Im9vYiINCiAgICB9LA0KICAgICJyZXF1ZXN0X3BhcmFtZXRlcnMiOiB7DQogICAgICAgICJkaXNwbGF5IjoicGFnZSIsDQogICAgICAgICJwcm9tcHQiOiJsb2dpbitjb25zZW50IiwNCiAgICAgICAgImlkX3Rva2VuX2hpbnQiOiIiLA0KICAgICAgICAibG9naW5faGludCI6IiIsDQogICAgICAgICJhY3JfdmFsdWVzIjoiIiwNCiAgICAgICAgImNsaWVudF9pZCI6IjFmMTkwM2E5LTQ5NmEtNDU5NS05YjhjLWZkNGRlNTI3ZTY3YSIsDQogICAgICAgICJub25jZSI6IiIsDQogICAgICAgICJzY29wZSI6IiIsDQogICAgICAgICJtYXhfYWdlIjogIiINCiAgICB9DQp9.Uafe_6C9_gA7Kzen7PEoVFqW3QVqOQ63wBtD44yX2aA";
    public static String geckoDriverinfo = "webdriver.gecko.driver";
    public static String chromeDriverinfo = "webdriver.chrome.driver";

    public static String browserOpenMessage = "Browser Launched: Proceeding to internal steps";
    public static String browserHomePageMessage = "Home Page Launched";

    public static String ChatbotIcon = "//img[@class='oda-chat-button-icon']";
    public static String ChatbotConnected = "//div[@class='oda-chat-connection-status oda-chat-connected']";
    public static String MenuOption = "//a[contains(text(),'Menu')]";
    public static String MenuOptionBillingandPayment = "//a[contains(text(),'Billing and Payment')]";
    public static String MenuOptionOutage = "//a[contains(text(),'Outage')]";
    public static String MenuOptionDownedPowerLine = "//a[contains(text(),'Downed Power Line')]";
    public static String MenuOptionFindAccountNumber = "//a[contains(text(),'Find Account Number')]";
    public static String MenuOptionStartStopOrMoveService = "//a[contains(text(),'Start, Stop or Move Service')]";
    public static String MenuOptionCovid19Assistance = "//a[contains(text(),'Covid-19 Assistance')]";
    public static String MenuOptionWaystoSave = "//a[contains(text(),'Ways to Save')]";
    public static String MenuOptionMore = "//a[contains(text(),'More')]";
    public static String MenuOptionSolar = "//div[contains(text(),'Solar')]";
    public static String MenuOptionHomeBusiness = "//div[contains(text(),'Home and Business')]";
    public static String MenuOptionPrivateSolar = "//div[contains(text(),'Private Solar')]";
    public static String MenuOptionCommunitySolar = "//div[contains(text(),'Community Solar')]";
    public static String MenuOptionNoThanks = "//div[12]//div[1]//div[2]//div[1]//div[2]//a[2]//div[1]";
    public static String PopUpYes = "//div[contains(text(),'Yes')]";
    public static String MenuOptionNoThanksContinue = "//div[contains(text(),'No, Thanks. I will continue without signing in')]";
    public static String closechatbot = "//i[@class='fa fa-times']";
    public static String yesbutton="//button[@id='yesButton']";

    public static String billingandpayment= "//div[contains(text(),'Billing and Payment')]";
    public static String payingyourbill="//div[contains(text(),'Paying Your Bill')]";
    public static String payviavirtual="//div[contains(text(),'Pay Via Virtual Assistant')]";
    public static String signin="//div[@class='oda-chat-card-actions']//div[@class='oda-chat-action-label'][contains(text(),'Sign In')]";
    public static String signinforauth="//button[contains(text(),'Sign In')]";
    public static String acceptauth="//button[contains(text(),'Accept')]";
    public static String registeredadd1="//div[contains(text(),'474 MAPLE AVE DIVIDING CREEK NJ 08315')]";
    public static String nothanks2="//div[13]//div[1]//div[2]//div[1]//div[2]//a[2]//div[1]";
    public static String clickyes="//div[contains(text(),'Yes')]";
    public static String nothanks3="//div[17]//div[1]//div[2]//div[1]//div[2]//a[2]//div[1]";
    public static String startService="//div[contains(text(),'Start Service')]";
    public static String moveService="//div[contains(text(),'Move Service')]";

}
