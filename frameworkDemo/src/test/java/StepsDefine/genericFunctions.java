package StepsDefine;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.Assertion;


public class genericFunctions extends AllVariables {
    AllVariables alv= new AllVariables();
    public static WebDriver driver =null;


    @Given("firefox browser is open")
    public void firefox_browser_is_open() {
        System.setProperty(geckoDriverinfo , firfoxPath);
        driver =new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        //driver.manage().window().maximize();

        System.out.println(browserOpenMessage);
    }

    @Given("chrome browser is open")
    public void chrome_browser_is_open() {
        System.setProperty(chromeDriverinfo, chromePath);
        driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        System.out.println(browserOpenMessage);
    }


    @And("user will be on exelon homepage")
    public void user_will_be_on_exelon_homepage() throws InterruptedException {
        System.out.println(browserHomePageMessage);
        driver.navigate().to(exelonUrl);
        Thread.sleep(12000);
    }

    @When("user will locate the chatbot icon")
    public void user_will_locate_the_chatbot_icon() throws InterruptedException {
        WebElement chatbotIcon=driver.findElement(By.xpath(ChatbotIcon));
        if (chatbotIcon.isDisplayed()){
            System.out.println("Inside Step: SHARP is able to locate chat bot");
        } else {
            System.out.println("Inside Step: SHARP is not able to locate chat bot");
        }
        Thread.sleep(3000);
    }

    @And("click on exelon chatbot icon")
    public void click_on_exelon_chatbot_icon() throws InterruptedException {
        WebElement chatbotI=driver.findElement(By.xpath(ChatbotIcon));
        WebDriverWait wait = new WebDriverWait(driver, 30);
        if (chatbotI.isDisplayed()){
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(ChatbotIcon))));
            driver.findElement(By.xpath(ChatbotIcon)).click();
            System.out.println("Inside Step: SHARP clicked on chatbot icon");
        } else {
            System.out.println("Inside Step: SHARP is not able to locate chatbot, finding again");
            //Thread.sleep(5000);
            if (chatbotI.isDisplayed()){
                System.out.println("Inside Step: SHARP located chatbot icon, now proceeding");
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(ChatbotIcon))));
                driver.findElement(By.xpath(ChatbotIcon)).click();
            } else {
                System.out.println("Inside Step: SHARP was not able to locate chatbot in second attempt as well");
            }
        }
        Thread.sleep(5000);
    }

    @Then("chatbot will be open")
    public void chatbot_will_be_open() throws InterruptedException {
        WebElement status=driver.findElement(By.xpath(ChatbotConnected));
        if (status.isDisplayed()){
            System.out.println("Inside Step: Chatbot is ready to proceed");
        } else {
            System.out.println("Inside Step: Chatbot is not ready, clicking again");
            Thread.sleep(5000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(ChatbotIcon))));
            driver.findElement(By.xpath(ChatbotIcon)).click();
            if (status.isDisplayed()){
                System.out.println("Inside Step: Chatbot is ready after second click, now proceeding");
            }
        }
        Thread.sleep(3000);
    }

    @And("user click on menu icon")
    public void user_click_on_menu_icon() throws InterruptedException {
        WebElement menu=driver.findElement(By.xpath(MenuOption));
        Actions a =new Actions(driver);
        a.moveToElement(menu).build().perform();
        Thread.sleep(3000);
    }

    @Then("click on more button in bot")
    public void click_on_more_button_in_bot() throws InterruptedException {
        driver.findElement(By.xpath(MenuOptionMore)).click();
        WebElement move=driver.findElement(By.xpath("//i[@class='fa fa-minus']"));
        Actions a =new Actions(driver);
        a.moveToElement(move).build().perform();
        Thread.sleep(3000);
    }
    @Then ("user selects account")
    public void user_selects_account() throws InterruptedException {
    	driver.findElement(By.xpath(selectacoount)).click();
    	Thread.sleep(3000);
    }
    @And("select solar and click in bot")
    public void select_solar_and_click_in_bot() throws InterruptedException {
        driver.findElement(By.xpath(MenuOptionSolar)).click();
        Thread.sleep(3000);
    }

    @Then("click on home and business in bot")
    public void click_on_home_and_business_in_bot() throws InterruptedException {
        driver.findElement(By.xpath(MenuOptionHomeBusiness)).click();
        Thread.sleep(3000);
    }

    @And("click on private solar option")
    public void click_on_private_solar_option() throws InterruptedException {
        driver.findElement(By.xpath(MenuOptionPrivateSolar)).click();
        Thread.sleep(3000);
    }

    @And("click on community solar option")
    public void click_on_community_solar_option() throws InterruptedException {
        driver.findElement(By.xpath(MenuOptionCommunitySolar)).click();
        Thread.sleep(3000);
    }

    @Then("select yes for confirmation")
    public void select_yes_for_confirmation() throws InterruptedException {
        driver.findElement(By.xpath(PopUpYes)).click();
        Thread.sleep(2000);
    }

    @And("select no Thanks to close chat")
    public void select_no_thanks_to_close_chat() throws InterruptedException {
        driver.findElement(By.xpath(MenuOptionNoThanks)).click();
        Thread.sleep(3000);
    }
    @Then("user click no thanks")
    public void user_click_no_thanks() throws InterruptedException {
        driver.findElement(By.xpath(MenuOptionNoThanks)).click();
        Thread.sleep(3000);
    }

    @And("user click no thanks i will continue")
    public void  user_click_no_thanks_i_will_continue() throws InterruptedException
    {
        WebElement nothanks=driver.findElement(By.xpath(MenuOptionNoThanksContinue));
        if (nothanks.isDisplayed()){
            driver.findElement(By.xpath(MenuOptionNoThanksContinue)).click();
        }
        Thread.sleep(4000);
    }

    @Then("select and click on  bill and paymenets")
    public void select_and_click_on_bill_and_paymenets() throws InterruptedException
    {
        driver.findElement(By.xpath(billingandpayment)).click();
        Thread.sleep(3000);
    }

    @And("click on paying your bill")
    public void click_on_paying_your_bill() throws InterruptedException
    {
        driver.findElement(By.xpath(payingyourbill)).click();
        Thread.sleep(3000);
    }

    @Then("select and click pay via chat")
    public void select_and_click_pay_via_chat() throws InterruptedException
    {
        driver.findElement(By.xpath(payviachat)).click();
        Thread.sleep(3000);
    }

    @And("click on sign in")
    public void click_on_sign_in() throws InterruptedException
    {
        driver.findElement(By.xpath(signin)).click();
        Thread.sleep(8000);
    }

    @Then("user will redirect to login page")
    public void user_will_redirect_to_login_page() throws InterruptedException {
        wait_for_time(webusername,16000);
        Set<String> handle=driver.getWindowHandles();
        Iterator<String> it= handle.iterator();
        String parantwindow=it.next();
        System.out.println("Inside Step: Parent Window handler is " + parantwindow);
        String childwindow=it.next();
        System.out.println("Inside Step: Child Window handler is " + childwindow);
        driver.switchTo().window(childwindow);
        wait_for_time(webusername,8000);
        Wait_Until_element_Visibility(webusername);
    }

    @When("user enters login id")
    public void user_enters_login_id() throws InterruptedException
    {
        wait_for_time(webusername,5000);
        driver.findElement(By.xpath(webusername)).sendKeys(strUserName);
    }

    @And("user enters password")
    public void user_enters_password() throws InterruptedException
    {
        wait_for_time(webpassword,2000);
        driver.findElement(By.xpath(webpassword)).sendKeys(strPassword);
        Thread.sleep(2000);
    }

    @Then("click on sign in for Authentication")
    public void click_on_sign_in_for_Authentication() throws InterruptedException {
        wait_for_time(btnSignIn,4000);
        Wait_Until_element_Visibility(btnSignIn);
        driver.findElement(By.xpath(btnSignIn)).click();
        Thread.sleep(3000);
        driver.switchTo().activeElement().click();
    }

    @And("user accept the authorization request")
    public void user_accept_the_authorization_request() throws InterruptedException {
        WebElement elem1 = driver.findElement(By.xpath(acceptauth));
        if (elem1.isDisplayed()) {
            driver.findElement(By.xpath(acceptauth)).click();
            Thread.sleep(3000);
        }
    }

    @Then ("click on sign in for web Authentication")
    public void click_on_sign_in_for_web_Authentication() {
    	driver.findElement(By.xpath(signinweb)).click();
    }

    @Then("navigate back to chat bot")
    public void navigate_back_to_chat_bot() throws InterruptedException {
        driver.close();
        System.out.println("SHARP: Automation Script is back on home page");
        Thread.sleep(2000);
        Set<String> handle=driver.getWindowHandles();
        Iterator<String> it= handle.iterator();
        String parantwindow=it.next();
        driver.switchTo().window(parantwindow);
    }

    @And("select any of the registered address for payment")
    public void select_any_of_the_registered_address_for_payment() throws InterruptedException {
        driver.findElement(By.xpath(registeredadd1)).click();
        Thread.sleep(15000);
    }

    @Then("Select no thanks to terminate chat")
    public void Select_no_thanks_to_terminate_chat() throws InterruptedException{
        driver.findElement(By.xpath(MenuOptionNoThanks)).click();
        Thread.sleep(8000);
    }

    @And("click yes")
    public void click_yes() throws InterruptedException{
        WebElement ele= driver.findElement(By.xpath(clickyes));
        Thread.sleep(8000);
        ele.click();
        Thread.sleep(5000);
    }

    @Then("select no thanks to close the chat")
    public void select_no_thanks_to_close_the_chat() throws InterruptedException {
        driver.findElement(By.xpath(nothanks3)).click();
        Thread.sleep(8000);
    }

    @And("click on close chat icon")
    public void click_on_close_chat_icon() throws InterruptedException {
        driver.findElement(By.xpath(closechatbot)).click();
        Thread.sleep(5000);
    }
    @Then("select yes to close chat")
    public void select_yes_to_close_chat() throws InterruptedException {
        driver.findElement(By.xpath(yesbutton)).click();
        Thread.sleep(3000);
        driver.close();
    }

    @Then("close the browser")
    public void close_the_browser() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Then("click on Start Stop or Move Service")
    public void click_on_start_stop_or_move_Service() throws InterruptedException {
        driver.findElement(By.xpath(MenuOptionStartStopOrMoveService)).click();
        Thread.sleep(3000);
    }

    @And("user select Start Service")
    public void user_select_start_service() throws InterruptedException {
        driver.findElement(By.xpath(startService)).click();
        Thread.sleep(3000);
    }

    @Then("user select Move Service")
    public void user_select_move_service() throws InterruptedException {
        driver.findElement(By.xpath(moveService)).click();
        Thread.sleep(3000);
    }

    @Then("click on Covid-19 Assistance")
    public void click_on_covid19_assistance() throws InterruptedException {
        driver.findElement(By.xpath(MenuOptionCovid19Assistance)).click();
        Thread.sleep(3000);
    }

    @Then("click on find account number")
    public void click_on_find_account_number() throws InterruptedException {
        driver.findElement(By.xpath(MenuOptionFindAccountNumber)).click();
        Thread.sleep(3000);
    }

    @Then("click on Outage")
    public void click_on_Outage() throws InterruptedException {
        driver.findElement(By.xpath(MenuOptionOutage)).click();
        Thread.sleep(3000);
    }

    @And ("Click on Budget Billing")
    public void Click_on_Budget_Billing() throws InterruptedException {
        driver.findElement(By.xpath(budgetbilling)).click();
        Thread.sleep(5000);
    }

    @Then ("click on learn more about budget billing")
    public void click_on_learn_more_about_budget_billing() throws InterruptedException{
        driver.findElement(By.xpath(learnmoreaboutbudgetbilling)).click();
        Thread.sleep(4000);
    }

    @And("user will type account")
    public void user_will_type_account() throws InterruptedException {
        driver.findElement(By.xpath(accounttype)).sendKeys("account");
        Thread.sleep(5000);
    }

    @Then("click on send")
    public void click_on_send() throws InterruptedException {
        driver.findElement(By.xpath(sendbutton)).click();
        Thread.sleep(5000);
    }

    @Then("user click on signup for autopay")
    public void user_click_on_signup_for_autopay()throws InterruptedException {
        driver.findElement(By.xpath(autopay)).click();
        Thread.sleep(3000);
    }

    @Then("user click on other payment")
    public void user_click_on_other_payment()throws InterruptedException {
        driver.findElement(By.xpath(otherpay)).click();
        Thread.sleep(3000);
    }

    @And("user click on pay by mail")
    public void user_click_on_pay_by_mail()throws InterruptedException {
        driver.findElement(By.xpath(paybymail)).click();
        Thread.sleep(3000);
    }

    @And("user click on pay by phone")
    public void user_click_on_pay_by_phone()throws InterruptedException {
        driver.findElement(By.xpath(paybyphone)).click();
        Thread.sleep(3000);
    }

    @And("user click on pay in person")
    public void user_click_on_pay_in_person()throws InterruptedException {
        driver.findElement(By.xpath(payinperson)).click();
        Thread.sleep(3000);
    }

    @Then("click learn about budget")
    public void click_learn_about_budget()throws InterruptedException {
        driver.findElement(By.xpath(learnbudget)).click();
        Thread.sleep(3000);
    }
    @And ("click on move service")
    public void click_on_move_service() throws InterruptedException {
    	driver.findElement(By.xpath(moveService)).click();
    	Thread.sleep(3000);
    }

    @Then("user click No")
    public void user_click_No()throws InterruptedException {
        driver.findElement(By.xpath(no)).click();
        Thread.sleep(3000);
    }

    @Then("select and click download my current bill")
    public void select_and_click_download_my_current_bill() throws InterruptedException
    {
        driver.findElement(By.xpath(downloadmycurrentbill)).click();
        Thread.sleep(3000);
    }

    @And("click on Getting your Bill")
    public void click_on_Getting_your_Bill() throws InterruptedException
    {
        driver.findElement(By.xpath(gettingyourbill)).click();
        Thread.sleep(3000);
    }

    @Then("select and click download a previous bill")
    public void select_and_click_download_a_previous_bill() throws InterruptedException
    {
        driver.findElement(By.xpath(downloadapreviousbill)).click();
        Thread.sleep(3000);
    }

    @And("Account balance")
    public void Account_balance() throws InterruptedException {
        driver.findElement(By.xpath(Accountbalancebutton)).click();
        Thread.sleep(5000);
    }

    @Then("No thanks continue without sign")
    public void No_thanks_continue_without_sign() throws InterruptedException {
        driver.findElement(By.xpath(nothanksafteraccountbalance)).click();
        Thread.sleep(3000);
        driver.close();
    }

    @And("check the given content")
    public void check_the_given_content()
    {
        String strendflowtext = driver.findElement(By.xpath(endflowxpath)).getText();
        Assert.assertEquals(endflowtext, strendflowtext);
        assert strendflowtext.equalsIgnoreCase(endflowtext);
    }

    @Then ("good bye content")
    public void  good_bye_content() {
        String strChatclosingText = driver.findElement(By.xpath(chatclosingtext)).getText();
        Assert.assertEquals(chatclosingtext, strChatclosingText);
        ExtentTest step = null;
        step.log(Status.INFO,"Assertion Passed");
    }

    @Then("click on downed power lines")
    public void click_on_downed_power_lines() throws InterruptedException {
        driver.findElement(By.xpath(downedpowerlinesfrommenu)).click();
        Thread.sleep(3000);
    }

    
    @And("type utterance")
    public void type_utterance() throws InterruptedException
    {
        driver.findElement(By.xpath(inputtext)).sendKeys("start service");
        Thread.sleep(3000);
    }

    @When ("user will locate the web sign In button")
    public void user_will_locate_the_web_sign_In_button() throws InterruptedException {
        driver.findElement(By.xpath(websignin)).click();
        Thread.sleep(5000);
    }

    @Then ("user enters login id for web")
    public void user_enters_login_id_for_web() throws InterruptedException {
        driver.findElement(By.xpath(websigninusername)).sendKeys(strUserName);
        Thread.sleep(4000);
    }

    @And ("user enters password for web")
    public void user_enters_password_for_web() throws InterruptedException{
        driver.findElement(By.xpath(passwordforweb)).sendKeys(strPassword);
        Thread.sleep(3000);
    }

    @Then ("user click on web sign in")
    public void user_click_on_web_sign_in() throws InterruptedException {
        driver.findElement(By.xpath(websignbutton)).click();
        Thread.sleep(3000);
    }

    @ And ("user will be on exelon web homepage")
    public void  user_will_be_on_exelon_web_homepage()
    {
        driver.switchTo().activeElement().click();
    }

    @Then ("user will click on contact us")
    public void user_will_click_on_contact_us() throws InterruptedException {
        driver.findElement(By.xpath(contactus)).click();
        Thread.sleep(3000);
    }

    @And ("User click on account Balance")
    public void User_click_on_account_Balance() throws InterruptedException {
        driver.findElement(By.xpath(accountbal)).click();
        Thread.sleep(2000);
    }

    @Then ("click on send icon")
    public void click_on_send_icon() throws InterruptedException {
        driver.findElement(By.xpath(sendicon)).click();
        Thread.sleep(3000);
    }
    @And ("user deny the authorization request")
    public void user_deny_the_authorization_request() throws InterruptedException  {
        wait_for_time(denybutton,5000);
        driver.findElement(By.xpath(denybutton)).click();
        Thread.sleep(3000);
    }

    @Then ("select and click on  bill and paymenets from menu")
    public void select_and_click_on_bill_and_payments_from_Menu() throws InterruptedException {
        driver.findElement(By.xpath(MenuOptionBillingandPayment)).click();
        Thread.sleep(3000);
    }

    @Then ("click on start stop move")
    public void click_on_start_stop_move() throws InterruptedException {
        driver.findElement(By.xpath(MenuOptionStartStopOrMoveService)).click();
        Thread.sleep(3000);
    }

    @And ("click on any option")
    public void click_on_any_option() throws InterruptedException {
        driver.findElement(By.xpath(moveService)).click();
        Thread.sleep(2000);
    }

    @Then ("user click move service")
    public void user_click_move_service() throws InterruptedException {
        driver.findElement(By.xpath(moveService)).click();
        Thread.sleep(2000);
    }

    @When("select and click start stop or move service")
    public void select_and_click_start_stop_or_move_service() throws InterruptedException {
        driver.findElement(By.xpath(startstopMove2)).click();
        Thread.sleep(3000);
    }

    @Then("click start service")
    public void click_start_service() throws InterruptedException
    {
        driver.findElement(By.xpath(startService)).click();
        Thread.sleep(3000);
    }


	@And ("click on start link")
	public void click_on_start_link() {
		driver.findElement(By.xpath(startServiceLink)).click();
	}

	@And ("click on stop service")
	public void click_on_stop_service() throws InterruptedException {
		driver.findElement(By.xpath(stopService)).click();
		Thread.sleep(2000);
	}


	@Then("click on the link in the move service content")
	public void click_on_the_link_in_the_move_service_content() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-250)", "");
		driver.findElement(By.xpath(moveservicelink)).click();
		Thread.sleep(2000);
	}

    @Then ("click Stop service")
    public void click_Stop_service() throws InterruptedException {
    	driver.findElement(By.xpath(stopService)).click();
    	Thread.sleep(3000);
    }
    @And ("click on stop link")
    public void click_on_stop_link() {
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	jse.executeScript("window.scrollBy(0,-250)");
    	driver.findElement(By.xpath("//a[contains(text(),'online')]")).click();
    	driver.quit();
    }
    @When ("user enters web login id")
    public void user_enters_web_login_id() throws InterruptedException {
    	driver.findElement(By.xpath(webusername)).sendKeys(strUserName);
    	Thread.sleep(3000);
    }
    @And ("user enters web password")
    public void user_enters_web_password() throws InterruptedException {
    	driver.findElement(By.xpath(webpassword)).sendKeys(strPassword);
    	Thread.sleep(2000);
    }


    @When ("user enters {string} and {string}")
    public void user_enters(String str1, String str2) throws InterruptedException {
        wait_for_time(webusername,10000);
        Wait_Until_element_Visibility(webusername);
        driver.findElement(By.xpath(webusername)).sendKeys(str1);
        Wait_Until_element_Visibility(webpassword);
        driver.findElement(By.xpath(webpassword)).sendKeys(str2);
    }

    @And ("user enters {string}")
    public void user_enter(String str2) throws InterruptedException {
        driver.findElement(By.xpath(webpassword)).sendKeys(str2);
        Thread.sleep(3000);
    }

    @Then("click SIGNIN button")
    public void click_SIGNIN_button() throws InterruptedException, IOException {
        Wait_Until_element_Visibility(btnSignIn);
        driver.findElement(By.xpath(btnSignIn)).click();
        Thread.sleep(8000);
    }

    @And("click SIGNIN")
    public void click_SIGNIN() throws InterruptedException {
        Wait_Until_element_Visibility(signIn);
        driver.findElement(By.xpath(signIn)).click();
    }

    @And("user click signout")
    public void user_click_signout() throws InterruptedException, IOException {
        Wait_Until_element_Visibility(signout);
        wait_for_time(signout,8000);
        driver.findElement(By.xpath(signout)).click();
        Thread.sleep(8000);
    }

    @Then("close window")
    public void close_window()throws InterruptedException {
        driver.close();
        driver.quit();
    }

    @When ("user will be on {string}")
    public void user_will_be_on(String opcoName) throws InterruptedException {
        if(opcoName.equalsIgnoreCase("ace")){
            driver.navigate().to(ACEUrl);
        } else if (opcoName.equalsIgnoreCase("dpl")) {
            driver.navigate().to(DPLUrl);
        } else if (opcoName.equalsIgnoreCase("pepco")) {
            driver.navigate().to(PepcoUrl);
        }
        Thread.sleep(8000);
    }

    @Then("click no thanks")
    public void click_no_thanks() throws InterruptedException {
        driver.findElement(By.xpath(nothanks)).click();
        Thread.sleep(3000);
    }
    @And("click Yes")
    public void click_Yes() throws InterruptedException {
        driver.findElement(By.xpath(Yes)).click();
        Thread.sleep(3000);
    }

    @When("click take feedback survey")
    public void click_take_feedback_survey() throws InterruptedException {
        driver.findElement(By.xpath(Takefeedbacksurvey)).click();
        Thread.sleep(5000);
    }

    @Then("user click on {string} mail icon")
    public void user_click_on_mail_icon(String stropcoName) throws InterruptedException {

        if(stropcoName.equalsIgnoreCase("ace")){
            driver.findElement(By.xpath(ACEmailicon)).click();
        } else if (stropcoName.equalsIgnoreCase("dpl")) {
            driver.findElement(By.xpath(mailicon)).click();
        } else if (stropcoName.equalsIgnoreCase("pepco")) {
            driver.findElement(By.xpath(mailicon)).click();
        }
        Thread.sleep(5000);

    }

    @And("validate if popup with correct text is displayed")
    public void validate_if_popup_with_correct_text_is_displayed(){
        String strtext = driver.findElement(By.xpath(PopUpChatTranscript)).getText();
        assert strtext.equalsIgnoreCase(mailText);
    }

    @When("input {string} format")
    public void input_email_id_format(String strid) throws InterruptedException {
        driver.findElement(By.xpath(emailid)).sendKeys(strid);
        Thread.sleep(3000);
    }

    @Then("click submit")
    public void click_submit() throws InterruptedException {
        driver.findElement(By.xpath(mailsubmit)).click();
        Thread.sleep(3000);
    }

    @And("validate if popup with correct {string} is displayed")
    public void validate_if_popup_with_correct_text_is_displayed(String strid) throws InterruptedException {
        String strtext = driver.findElement(By.xpath(PopUpMailmsg)).getText();
        assert strtext.equalsIgnoreCase(mailmsgText);

        String strtext2 = driver.findElement(By.xpath(popupmailid)).getText();
        System.out.println("Mail id printed on popup is :" + strtext2);
        assert strtext2.equalsIgnoreCase(strid);
    }

    @Then("click ok for mail confirmation")
    public void click_ok_for_mail_confirmation() throws InterruptedException {
        driver.findElement(By.xpath(mailsubmitconfirm)).click();
        Thread.sleep(3000);
    }

    @Then("click cancel")
    public void click_cancel() throws InterruptedException {
        driver.findElement(By.xpath(Cancelbutton)).click();
        Thread.sleep(3000);
    }

    @And("validate if popup with invalid is displayed")
    public void validate_if_popup_with_invalid_is_displayed() throws InterruptedException {
        String strtext = driver.findElement(By.xpath(popupinvalidmailid)).getText();
        assert strtext.equalsIgnoreCase(popupinvalidtext);
    }

    @And("type utterance for chat transcription")
    public void type_utterance_for_chat_transcription() throws InterruptedException {
        driver.findElement(By.xpath(typeutterance)).sendKeys("Record of chat conversation.");
        Thread.sleep(3000);
    }

    @And("type {string} for chat")
    public void type_utterance_for_chat(String strutterance) throws InterruptedException {
        driver.findElement(By.xpath(typeutterance)).sendKeys(strutterance);
        Thread.sleep(3000);
    }

    @Then("click Send")
    public void click_ACE_Send() throws InterruptedException {
        driver.findElement(By.xpath(sendicon)).click();
        Thread.sleep(5000);
    }

    @Then("validate response")
    public void validate_response() throws InterruptedException {
        String strtext = driver.findElement(By.xpath(odachatmessageContent)).getText();
        System.out.println(strtext);
        assert strtext.equalsIgnoreCase(strResponseUtterance);
    }

    @And("click on move link")
    public void click_on_move_link() throws InterruptedException {
        driver.findElement(By.xpath(startOnlineLink)).click();
        Thread.sleep(3000);
    }

    @Then("user will redirect to Move service page")
    public void user_will_redirect_to_move_Service_page() throws InterruptedException {
        Set<String> handle=driver.getWindowHandles();
        Iterator<String> it= handle.iterator();
        String parantwindow=it.next();
        System.out.println("Inside Step: Parent Window handler is " + parantwindow);
        String childwindow=it.next();
        System.out.println("Inside Step: Child Window handler is " + childwindow);
        driver.switchTo().window(childwindow);
        wait_for_time(moveServiceWindow,8000);
        String strtext = driver.findElement(By.xpath(moveServiceWindow)).getText();
        System.out.println(strtext);
        assert strtext.equalsIgnoreCase(strMoveWindow);
        driver.close();
        driver.switchTo().window(parantwindow);
    }

    public void wait_for_time(String strXpath, Integer intTime) throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, 90);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(strXpath))));
        WebElement selement=driver.findElement(By.xpath(strXpath));
        if (!selement.isDisplayed()){
            Thread.sleep(intTime);
        }
    }

    public void Wait_Until_element_Visibility(String xpath)  throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));
        WebElement elem = driver.findElement(By.xpath(xpath));
        if (!elem.isDisplayed()) {
            Thread.sleep(10000);
        }
    }
}
