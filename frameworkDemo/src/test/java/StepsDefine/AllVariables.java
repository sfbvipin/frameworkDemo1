package StepsDefine;

import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class AllVariables {
	public static String chromePath = "src\\test\\resources\\Drivers\\chromedriver.exe";
    public static String chromePath_86 = "src\\test\\resources\\Drivers\\chromedriver_86.exe";
    public static String protractorchromePath_86 = "C:\\Users\\Sohail Abbas\\AppData\\Roaming\\npm\\node_modules\\protractor\\node_modules\\webdriver-manager\\selenium\\chromedriver.exe";
    public static String firfoxPath = "src\\test\\resources\\Drivers\\geckodriver.exe";
    //public static String emersonPath = "src\\test\\resources\\Drivers\\Setup.exe";
    public static String emersonFileService = "C:\\Users\\Sohail Abbas\\AppData\\Local\\Programs\\FieldService-Elec\\FieldService-Elec.exe";
    public static String exelonUrl = "https://aztest.atlanticcityelectric.com/MyAccount/CustomerSupport/Pages/ContactUs.aspx";
    //public static String exelonUrl = "https://aztest.pepco.com/MyAccount/MyBillUsage/Pages/RatesTariffs.aspx";
    public static String signurl  ="https://stage-apigateway-east.exeloncorp.com/auth/oauth/v2/authorize/login?action=display&sessionID=477be947-4a4b-4aaf-94fc-04067f5dcca3&sessionData=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.ew0KICAgICJzZXNzaW9uIjogew0KICAgICAgICAic2Vzc2lvbklEIjoiNDc3YmU5NDctNGE0Yi00YWFmLTk0ZmMtMDQwNjdmNWRjY2EzIiwNCiAgICAgICAgImV4cCI6MTU5OTExOTk2OCwNCiAgICAgICAgImN1cnJlbnRfdXNlcm5hbWUiOiIiLA0KICAgICAgICAiY3VycmVudF91c2VyX2NvbnNlbnQiOiJub25lIiwNCiAgICAgICAgImN1cnJlbnRfdXNlcl9yb2xlIjoiIiwNCiAgICAgICAgImN1cnJlbnRfdXNlcl9hY3IiOiIwIiwNCiAgICAgICAgImN1cnJlbnRfdXNlcl9hdXRoVGltZSI6IjAiLA0KICAgICAgICAic2FsdCI6IiIsDQogICAgICAgICJ0aGlyZF9wYXJ0eV9zc29fdG9rZW4iOiIiLA0KICAgICAgICAidGhpcmRfcGFydHlfc3NvX3Rva2VuX3R5cGUiOiIiDQogICAgfSwNCiAgICAicmVxdWVzdF9jb25zZW50Ijogew0KICAgICAgICAiY2xpZW50X25hbWUiOiJXZWIrLStBQ0VTdGFnZSIsDQogICAgICAgICJzY29wZV92ZXJpZmllZCI6Im9vYiINCiAgICB9LA0KICAgICJyZXF1ZXN0X3BhcmFtZXRlcnMiOiB7DQogICAgICAgICJkaXNwbGF5IjoicGFnZSIsDQogICAgICAgICJwcm9tcHQiOiJsb2dpbitjb25zZW50IiwNCiAgICAgICAgImlkX3Rva2VuX2hpbnQiOiIiLA0KICAgICAgICAibG9naW5faGludCI6IiIsDQogICAgICAgICJhY3JfdmFsdWVzIjoiIiwNCiAgICAgICAgImNsaWVudF9pZCI6IjFmMTkwM2E5LTQ5NmEtNDU5NS05YjhjLWZkNGRlNTI3ZTY3YSIsDQogICAgICAgICJub25jZSI6IiIsDQogICAgICAgICJzY29wZSI6IiIsDQogICAgICAgICJtYXhfYWdlIjogIiINCiAgICB9DQp9.Uafe_6C9_gA7Kzen7PEoVFqW3QVqOQ63wBtD44yX2aA";

    public static String ACEUrl = "https://aztest.atlanticcityelectric.com/MyAccount/MyBillUsage/Pages/RatesTariffs.aspx";
    public static String DPLUrl = "https://aztest.delmarva.com/MyAccount/MyBillUsage/Pages/RatesTariffs.aspx";
    public static String PepcoUrl = "https://aztest.pepco.com/MyAccount/MyBillUsage/Pages/RatesTariffs.aspx";

    public static String geckoDriverinfo = "webdriver.gecko.driver";
    public static String chromeDriverinfo = "webdriver.chrome.driver";

    public static String browserOpenMessage = "SHARP: Browser Launched, Proceeding to internal steps";
    public static String browserHomePageMessage = "SHARP launched home page";

    public static String strUserName = "PATTI@47";
    public static String strPassword = "Password1";

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
    public static String OptionMore = "//div[contains(text(),'More')]";

    public static String MenuOptionNoThanksContinue = "//div[contains(text(),'No, Thanks. I will continue without signing in')]";
    public static String closechatbot = "//i[@class='fa fa-times']";
    public static String yesbutton="//button[@id='yesButton']";
    public static String endChatButton = "//button[@id='endButton']";
    public static String selectacoount="//tr[1]//td[8]//span[1]//span[1]//button[1]//span[1]";

    public static String billingandpayment= "//div[contains(text(),'Billing and Payment')]";
    public static String payingyourbill="//div[contains(text(),'Paying Your Bill')]";
    public static String payviachat="//div[contains(text(),'Pay Via Chat')]";

    //public static String signin="//div[@class='oda-chat-card-actions']//div[@class='oda-chat-action-label'][contains(text(),'Sign In')]";
    public static String signin="//div[contains(text(),'Sign In')]";

    public static String signinforauth="//button[contains(text(),'Sign In')]";
    public static String acceptauth="//button[contains(text(),'Accept')]";
    public static String registeredadd1="//div[contains(text(),'474 MAPLE AVE DIVIDING CREEK NJ 08315')]";
    public static String nothanks2="//div[13]//div[1]//div[2]//div[1]//div[2]//a[2]//div[1]";
    public static String clickyes="//div[contains(text(),'Yes')]";
    public static String nothanks3="//div[17]//div[1]//div[2]//div[1]//div[2]//a[2]//div[1]";
    public static String startService="//div[contains(text(),'Start Service')]";
    public static String moveService="//div[contains(text(),'Move Service')]";
    public static String stopService="//div[contains(text(),'Stop Service')]";
    public static String stopServiceLink="//a[contains(text(),'online')]";
    public static String moveservicelink="//li[contains(text(),'Your Pepco account number and phone number and the')]//a[contains(text(),'My Account')]";

    public static String findaccountnum="//div[contains(text(),'Find Account Number')]";
    public static String moreafternothanks="//div[contains(text(),'More')]";
    public static String startServiceLink="//a[contains(text(),'pepco.com')]";
    public static String budgetbilling="//div[contains(text(),'Budget Billing')]";
    public static String learnmoreaboutbudgetbilling="//div[contains(text(),'Learn more about Budget Billing')]";
    public static String checkEligibility="//div[contains(text(),'Check Eligibility')]";

    public static String moveServicefromnothanks="//div[5]//div[1]//div[2]//div[1]//div[2]//a[2]//div[1]";
    public static String signinafterbudgetbilling="//div[7]//div[1]//div[1]//div[1]//div[1]//div[2]//a[1]//div[1]";
    
    public static String accounttype="//textarea[@placeholder='Type a message....']";
    public static String sendbutton="//button[@class='oda-chat-footer-button oda-chat-button-send']";

    public static String autopay="//div[contains(text(),'Sign up for AutoPay')]";
    public static String otherpay="//div[contains(text(),'Learn about Other Payment Methods')]";
    public static String paybymail="//div[contains(text(),'Pay by Mail')]";
    public static String paybyphone="//div[contains(text(),'Pay by Phone')]";
    public static String payinperson="//div[contains(text(),'Pay in Person')]";
    public static String learnbudget="//div[contains(text(),'Learn about Budget Billing.')]";
    public static String budgetbillingFAQ="//div[contains(text(),'Budget Billing FAQs')]";
    public static String no="//div[contains(text(),'No, Thanks. I'm not interested in this program.')]";

    public static String startstopmove="//a[contains(text(),'Start, Stop or Move Service')]";

    public static String username="//input[@name='username']";
    public static String password="//input[@name='password']";
    public static String webusername="//div[contains(@class,'form-group')]//input[@id='Username']";
    public static String webpassword="//div[contains(@class,'form-group')]//input[@id='Password']";

    public static String username1 = "//input[@id='Username']";
    public static String password1 = "//input[@id='Password']";

    public static String downloadmycurrentbill="//div[contains(text(),'Download My Current Bill')]";
    public static String downloadapreviousbill="//div[contains(text(),'Download A Previous Bill')]";
    public static String gettingyourbill="//div[contains(text(),'Getting Your Bill')]";
    public static String nothanksafteraccountbalance="//div[@class='oda-chat-card-actions']//div[@class='oda-chat-action-label'][contains(text(),'No, Thanks. I will continue without signing in')]";
    public static String endflowtext="Did you find the answer(s) you needed today?";
    public static String endflowxpath="//span[contains(text(),'Did you find the answer')]";
    public static String chatclosingtext1="//span[contains(text(),'m glad you were able to get the help you')]";
    public static String chatclosingtext="Great! I'm glad you were able to get the help you were looking for. Is there anything else I can help you with?";
    public static String startstopMove2="//div[contains(text(),'Start, Stop or Move Service')]";
    public static String downedpowerlines="//div[contains(text(),'Downed Power Line')]";
    public static String downedpowerlinesfrommenu="//div[contains(text(),'Downed Power Line')]";
    public static String websignin="//button[@class='btn btn-accent exc-sign-in-btn']";
    public static String signinweb="//button[@class='btn btn btn-primary exc-corner-btn']";
    public static String websigninusername="//input[@id='Username']";
    public static String passwordforweb="//input[@id='Password']";
    public static String websignbutton="//button[@class='btn btn btn-accent']";
    public static String contactus="//a[@id='ctl00_ctl00_contactLink']";
    public static String Accountbalancebutton="//div[contains(text(),'Account Balance')]";
    public static String Leavecommentforfeedback = "//div[contains(text(),'Leave Comment')]";
    public static String inputtext="//textarea[@placeholder='Type a message....']";
    public static String sendicon="//button[@class='oda-chat-footer-button oda-chat-button-send']";
    public static String denybutton="//button[contains(text(),'Deny')]";
    public static String btnSignIn="//button[@class='btn btn btn-primary exc-corner-btn']";
    public static String signout="/html/body/form/div[3]/div[3]/div/header/div/button";
    public static String signIn="//div[contains(text(),'Sign In')]";
    public static String websigninone = "//button[@class='btn btn btn-accent']";

    public static String OauthToken="OTQwMjYzMjNiMjNlNGZiZDAxNjA5ZGFhZjk3N2E0ZWZiOWQyMzVjM2FjZDU0MTA5YmY0MzdjM2Q5YWVlODIxZjQ4YjhiZjdlY2U4YTRjNWNlODY1NzI3N2MyOTc3ZmU0ZWUyNzU0MmU=";
    public static String hellosignUrl="https://api.hellosign.com";
    public static String OauthTokenw="OTQwMjYzMjNiMjNlNGZiZDAxNjA5ZGFhZjk3N2E0ZWZiOWY5ODlmMjRkZDAzMzU4MWI2ZWRhNmY3ZDk2Zjk3YjFiN2IzZGMyODE5NTMxYmIwYTIzYTZlYjBmM2NmZmNiNzMVjNDQ=";

    public static String nothanks = "//div[6]//div[1]//div[2]//div[1]//div[2]//a[2]//div[1]";
    public static String Yes = "//div[8]//div[1]//div[2]//div[1]//div[2]//a[1]//div[1]";
    public static String Yes2 = "//div[6]//div[1]//div[2]//div[1]//div[2]//a[1]//div[1]";
    public static String Takefeedbacksurvey = "//div[contains(text(),'Take Feedback Survey')]";
    public static String ACEmailicon = "//body/div[2]/div[1]/div[1]/div[4]/a[1]/img[1]";
    public static String mailicon = "//body/div[3]/div[1]/div[1]/div[4]/a[1]/img[1]";
    public static String PopUpChatTranscript = "//p[contains(text(),'Want a copy of this chat transcript? Enter your email address.')]";
    public static String mailText="Want a copy of this chat transcript? Enter your email address.";
    public static String emailid = "//input[@id='emailID']";
    public static String mailsubmit =  "//button[@id='submitButton']";
    public static String PopUpMailmsg = "//p[contains(text(),'The chat transcript will be sent to')]";
    public static String mailmsgText="The chat transcript will be sent to";
    public static String popupmailid = "//p[@id='emailSentConfirm']";
    public static String mailsubmitconfirm =  "//button[@id='submitConfirmButton']";
    public static String Cancelbutton = "//button[@id='cancelButton']";
    public static String popupinvalidmailid = "//p[@id='emailInvalid']";
    public static String popupinvalidtext ="Invalid email address. Please try again.";
    public static String typeutterance = "//textarea[@placeholder='Type a message....']";
    public static String odachatmessageContent = "//div[@class='oda-chat-message-content']";
    public static String strResponseUtterance = "Want a copy of the chat transcript? You can select the icon next to the chat menu and enter your email address.";
    public static String moveServiceWindow = "//div[@class='exc-page-content']//h1[contains(text(),'Move Service')]";
    public static String strMoveWindow = "Move Service";
    public static String startOnlineLink="//a[contains(text(),'Get started online.')]";
    public static String surveyRating1 = "//span[@id='star1']";
    public static String surveyRating2 = "//span[@id='star2']";
    public static String surveyRating3 = "//span[@id='star3']";
    public static String surveyRating4 = "//span[@id='star4']";
    public static String surveyRating5 = "//span[@id='star5']";

    public static String Deposits = "//div[contains(text(),'Deposit')]";
    public static String Actualdeposittext = "//span[contains(text(),'Questions about your deposit?')]";
    public static String Selectaccountfrommultipleaccount = "//div[contains(text(),'48 BAYVIEW RD CHESAPEAKE CITY MD 21915')]";
    public static String ExpectedACEdeposittext = "Questions about your deposit? Here's a list of FAQs to help you find the information you need. If you still don't find the answer you're looking for, please call customer service at 1-800-642-3780";
    public static String ExpectedDPLdeposittext = "Questions about your deposit? Here's a list of FAQs to help you find the information you need. If you still don't find the answer you're looking for, please call customer service at 1-800-375-7117";
    public static String ExpectedPEPCOdeposittext = "Questions about your deposit? Here's a list of FAQs to help you find the information you need. If you still don't find the answer you're looking for, please call customer service at 202-833-7500";
    public static String depositlink = "//a[contains(text(),'a list of FAQs')]";
    public static String clickOauthignn = "//div[@class='oda-chat-card-actions']//div[@class='oda-chat-action-label'][contains(text(),'Sign In')]";
    public static String ExpectedACEdepositFAQlink = "https://aztest.atlanticcityelectric.com/MyAccount/CustomerSupport/Pages/FAQs.aspx";
    public static String ExpectedDPLdepositFAQlink = "https://aztest.delmarva.com/MyAccount/CustomerSupport/Pages/FAQs.aspx";
    public static String ExpectedPEPCOdepositFAQlink = "https://aztest.pepco.com/MyAccount/CustomerSupport/Pages/FAQs.aspx";
    public static String nothanksijustneededmybalance = "//div[contains(text(),'No, Thanks. I just needed my balance')]";

    public static String HelloSignEmail = "//input[@name='logIn.emailAddress']";
    public static String HelloSignbutton = "//button[@class='m-button bg-azure  hbg-castle-rock c-white progress-button state-loading']";
    public static String HelloSignPassword = "//input[@name='logIn.password']";
    public static String HelloSignAccept = "//span[@id='acceptButton']";

    public static String ionicUsername="//input[@id='login_username']";
    public static String ionicPassword="//input[@name='login_password']";
    public static String submitButtonSpan = "//ion-button[@id='login_bttn']";
    public static String ionicUname="//input[@name='username']";
    public static String submitButton1 = "//ion-button[@id='click_me_btn']";

    public static String EmersonOauthToken="Basic RTEyMTA5MjczNUFCNDU5ODk2NUE3RjE4OTlBNDZBRERfTW9iaWxlQW5vbnltb3VzX0FQUElEOmU4OTE4NWE5LTU0NjQtNDAzMi05YmU1LTI5ODgzYjY4NzRkMw==";
    public static String EmersonAccToken = "Basic eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbiI6ImV5SnJhV1FpT2lJd01tOW1aRWRFVFhSeVFWOUhlV2xXT1hoQlZHUnJNVUYwU0dZd0xXMU1TM0I1YjNGaU9ESmhTVEZKSWl3aVlXeG5Jam9pVWxNeU5UWWlmUS5leUoyWlhJaU9qRXNJbXAwYVNJNklrRlVMalp5YjJGb056TlpSWFJqVlZkeFZ6ZHFhV1ZCYVdjMU5HWkRaa1ZwTkdOd1ZGZEdjVEJhVWt4elJXTXViMkZ5YkRaeWNHUjJXVXhDTTNCNmVXd3ljRFlpTENKcGMzTWlPaUpvZEhSd2N6b3ZMMlZ0WlhKemIyNHViMnQwWVM1amIyMGlMQ0poZFdRaU9pSm9kSFJ3Y3pvdkwyVnRaWEp6YjI0dWIydDBZUzVqYjIwaUxDSnpkV0lpT2lKSFlYVnlZWFl1Vm1GamFHaGhibWxBUlcxbGNuTnZiaTVqYjIwaUxDSnBZWFFpT2pFMk1ETTNNVFEzTWpBc0ltVjRjQ0k2TVRZd016Y3hPRE15TUN3aVkybGtJam9pTUc5aE5HMXhjemx2TVdkRlVFZEtaMU15Y0RjaUxDSjFhV1FpT2lJd01IVTFPSEEwYVc5NGFtNXpha1V6Y1RKd055SXNJbk5qY0NJNld5SnZabVpzYVc1bFgyRmpZMlZ6Y3lKZGZRLlEzTFpvd01JamhZeVBxVUpBaXhMLThVQWZQLV9QZnBQWHlJRUtQS0tBVEpJX2FybmY4WDJYd1FPeXFHWjZxdkoyUjhzU1lfOWpaRWhXUUc3alI3RkQ4OGl5eFp2M1ZzaDlCX0xoZU1ZREsxa2tZWFRyMWdQOUs5VmJzWFV6Mng1R2lzTEZXc3FaUzYxM2FxcUYtT2lpc0NQcEpmY0RSS0tpSW9ZQTQzTWNDS3lvZ1NaWG1hRXRkb0hLNEtMTU9HVzkzczk5NVZIM2VyMXZMaTFWdWhLUkVGemtuTVpMSENjbF9uMXdkX0Z6Umc2elg2cHdEeENTZm1Gd29XeFZsWFI2aldDemdUZDJPWlIwd2g1UGRQNHg1RFUtM2VqWG54LWhfUExrZXI0dmRSaW1ORnBjN19vOTljM3lYM1RKQjYwN2hNZFlKM2pwSWw4cFRkbTJwR2NpdyIsImlhdCI6MTYwMzcxNDcyMSwiZXhwIjoxNjM1MjUwNzIxfQ.LXuRIgJ2qGt_zEl5JwWx0xlvSz1bhlimloshNOa9bvBdSnXiTkMgyg8aXx3L5n-sB_Safu73cq53kaa5Vi-sho5_r7AsJe6o4WKzS3E1SNBHhH2wOHMJdAyQMM8nTTr0VT-XM8syhUYZ4KkFuVg9SjEgSWGsgR27tia9cgdB2Cy_nELgWqA_BNiT7mfjn4AGaMdmgFS_oJj2yE1U_HAB6YP-mpmbqNJfV-0nqImDkYcP9asLXs1AcQAsu8Nol5XhO5Q47TQIDgv3Zg1tnh39DbdzuHWOuW4qMzh7FY0QBkJH3XhmBVh1lfsVq9srA5nDdfWgt75cdhEII9stSSPhPQ";
    public static String EmersonUrl= "https://E121092735AB4598965A7F1899A46ADD.mobile.ocp.oraclecloud.com:443/mobile/custom/";
    public static String EmersonBackendId = "1d477b06-a3fe-45ed-a1c7-8c062209b886";
    public static String EmersonCredentials = "YWFzaGlzaC5rdW1hcjpTZmJAMTEyMg==";
    public static String SESMobileLogin = "SESMobileBackendAPI/login";
    public static String SESMobileCheckUser = "SESMobileBackendAPI/user/validate";
    public static String SESMobileTechProfile = "SESMobileBackendAPI/user/techprofile";

}
