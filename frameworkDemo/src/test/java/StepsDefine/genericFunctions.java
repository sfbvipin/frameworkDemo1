package StepsDefine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.github.sukgu.Shadow;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.SECONDS;


public class genericFunctions extends AllVariables {
    AllVariables alv= new AllVariables();
    public static WebDriver driver =null;
    public static final String TASKLIST = "tasklist";
    public static final String KILL = "taskkill /F /IM ";
    private WebDriver driver1 = null;

    @Given("firefox browser is open")
    public void firefox_browser_is_open() throws Exception {
        fnKillProcess("geckodriver.exe");
        fnKillProcess("firefox.exe");
        System.setProperty(geckoDriverinfo , firfoxPath);
        driver =new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        //driver.manage().window().maximize();

        System.out.println(browserOpenMessage);
    }

    @Given("chrome browser is open")
    public void chrome_browser_is_open() throws Exception {
        fnKillProcess("chromedriver.exe");
        System.setProperty(chromeDriverinfo, chromePath);
        driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, SECONDS);

        System.out.println(browserOpenMessage);
    }


    @And("user will be on exelon homepage")
    public void user_will_be_on_exelon_homepage() throws InterruptedException {
        System.out.println(browserHomePageMessage);
        driver.navigate().to(exelonUrl);
        //driver.navigate().to(ACEUrl);
        Thread.sleep(12000);
    }

    @When("user will locate the chatbot icon")
    public void user_will_locate_the_chatbot_icon() throws InterruptedException {
        wait_for_time(ChatbotIcon,12000);
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
        wait_for_time(ChatbotIcon,8000);
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
        wait_for_time(ChatbotConnected,8000);
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
        Thread.sleep(5000);
    }
    @Then("click on more button")
    public void click_on_more_button() throws InterruptedException {
        wait_for_time(OptionMore,5000);
        driver.findElement(By.xpath(OptionMore)).click();
        Thread.sleep(5000);
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
        wait_for_time(MenuOptionNoThanksContinue,10000);
        driver.findElement(By.xpath(MenuOptionNoThanksContinue)).click();
        Thread.sleep(5000);
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

    @And("click on sign in on chatbot")
    public void click_on_sign_in_on_chatbot() throws InterruptedException
    {
        driver.findElement(By.xpath(signin1)).click();
        Thread.sleep(8000);
    }

    @Then("user will redirect to login page")
    public void user_will_redirect_to_login_page() throws InterruptedException {
        //wait_for_time(websigninusername,16000);
        Set<String> handle=driver.getWindowHandles();
        Iterator<String> it= handle.iterator();
        String parantwindow=it.next();
        System.out.println("SHARP: Inside Step, Parent Window handler is " + parantwindow);
        String childwindow=it.next();
        System.out.println("SHARP: Inside Step, Child Window handler is " + childwindow);
        driver.switchTo().window(childwindow);

        wait_for_time(websigninusername,16000);
        //Wait_Until_element_Visibility(websigninusername);
    }

    @When("user enters login id")
    public void user_enters_login_id() throws InterruptedException
    {
        wait_for_time(username,12000);
        driver.findElement(By.xpath(username)).sendKeys(strUserName);
    }

    @And("user enters password")
    public void user_enters_password() throws InterruptedException
    {
        wait_for_time(passwordforweb,2000);
        driver.findElement(By.xpath(passwordforweb)).sendKeys(strPassword);
        Thread.sleep(2000);
    }

    @When ("user enter {string} and {string}")
    public void user_enters_login_password(String str1, String str2) throws InterruptedException {
        wait_for_time(webusername,10000);
        driver.findElement(By.xpath(webusername)).sendKeys(str1);
        Wait_Until_element_Visibility(password);
        driver.findElement(By.xpath(password)).sendKeys(str2);
    }

    @When ("user login with {string} and {string}")
    public void user_login_with_login_password(String str1, String str2) throws InterruptedException {
        wait_for_time(username1,10000);
        driver.findElement(By.xpath(username1)).sendKeys(str1);
        Wait_Until_element_Visibility(password1);
        driver.findElement(By.xpath(password1)).sendKeys(str2);
    }

    @When ("user enters {string} and {string} on login page")
    public void user_enters_login_password_on_login_page(String str1, String str2) throws InterruptedException {
        wait_for_time(username3,10000);
        driver.findElement(By.xpath(username3)).sendKeys(str1);
        Wait_Until_element_Visibility(password3);
        driver.findElement(By.xpath(password3)).sendKeys(str2);
    }

    @Then("click on sign in for Authentication")
    public void click_on_sign_in_for_Authentication() throws InterruptedException {
        wait_for_time(btnSignIn,4000);
        try {
            driver.findElement(By.xpath(btnSignIn)).click();
        }catch (NoSuchElementException exception) {
            wait_for_time(signinforauth, 4000);
            driver.findElement(By.xpath(signinforauth)).click();
        }

        Thread.sleep(13000);
        driver.switchTo().activeElement().click();
    }

    @And("user accept the authorization request")
    public void user_accept_the_authorization_request() throws InterruptedException {
        wait_for_time(acceptauth,4000);
        try {
            driver.findElement(By.xpath(acceptauth)).click();
            Thread.sleep(3000);
        }catch (NoSuchElementException exception) {
            System.out.println("SHARP: Accept button is not located, still proceeding to next step");
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
        driver.findElement(By.xpath(NoThanks2)).click();
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
        try {
            driver.findElement(By.xpath(endChatButton)).click();
        }catch (NoSuchElementException exception) {
            driver.findElement(By.xpath(yesbutton)).click();
        }

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

    @Then ("click on Account Management")
    public void click_on_Account_Management() throws InterruptedException {
        driver.findElement(By.xpath(MenuOptionAccountManagement)).click();
        Thread.sleep(3000);
    }

    @Then("click on find account number")
    public void click_on_find_account_number() throws InterruptedException {
        driver.findElement(By.xpath(FindAccountNumber)).click();
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

    @Then ("click on Check Eligibility")
    public void click_on_Check_Eligibility() throws InterruptedException{
        driver.findElement(By.xpath(checkEligibility)).click();
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

    @And("user click yes")
    public void user_click_yes() throws InterruptedException {
        driver.findElement(By.xpath(Yes2)).click();
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

    @Then("click budget billing FAQ")
    public void click_budget_billing_FAQ()throws InterruptedException {
        driver.findElement(By.xpath(budgetbillingFAQ)).click();
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
        Thread.sleep(5000);
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
        wait_for_time(downedpowerlines,5000);
        driver.findElement(By.xpath(downedpowerlines)).click();
        Thread.sleep(3000);
    }

    @Then("click on menu downed power lines")
    public void click_on_menu_Downed_power_lines() throws InterruptedException {
        wait_for_time(MenuOptionDownedPowerLine,5000);
        driver.findElement(By.xpath(MenuOptionDownedPowerLine)).click();
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
        List<WebElement> ele1 = driver.findElements(By.xpath(websigninusername));
        System.out.println("SHARP: Element count for " +websigninusername+ " is :" +ele1.size());
        List<WebElement> ele2 = driver.findElements(By.xpath(websigninusername2));
        System.out.println("SHARP: Element count for " +websigninusername2+ " is :" +ele2.size());
        if (ele1.size() > 0) {
            driver.findElement(By.xpath(websigninusername)).sendKeys(strUserName);
        } else if (ele2.size() > 0) {
            driver.findElement(By.xpath(websigninusername2)).sendKeys(strUserName);
        }
    }

    @And ("user enters password for web")
    public void user_enters_password_for_web() throws InterruptedException{
        List<WebElement> ele1 = driver.findElements(By.xpath(passwordforweb));
        System.out.println("SHARP: Element count for " +passwordforweb+ " is :" +ele1.size());
        List<WebElement> ele2 = driver.findElements(By.xpath(passwordforweb2));
        System.out.println("SHARP: Element count for " +passwordforweb2+ " is :" +ele2.size());
        if (ele1.size() > 0) {
            driver.findElement(By.xpath(passwordforweb)).sendKeys(strPassword);
        } else if (ele2.size() > 0) {
            driver.findElement(By.xpath(passwordforweb2)).sendKeys(strPassword);
        }
        Thread.sleep(3000);
    }

    @Then ("user click on web sign in")
    public void user_click_on_web_sign_in() throws InterruptedException {
        List<WebElement> ele1 = driver.findElements(By.xpath(websignbutton));
        System.out.println("SHARP: Element count for " +websignbutton+ " is :" +ele1.size());
        List<WebElement> ele2 = driver.findElements(By.xpath(websignbutton2));
        System.out.println("SHARP: Element count for " +websignbutton2+ " is :" +ele2.size());
        if (ele1.size() > 0) {
            driver.findElement(By.xpath(websignbutton)).click();
        } else if (ele2.size() > 0) {
            driver.findElement(By.xpath(websignbutton2)).click();
        }
        Thread.sleep(3000);
    }

    @And ("user will be on exelon web homepage")
    public void  user_will_be_on_exelon_web_homepage() throws InterruptedException {
        driver.switchTo().activeElement().click();
        Thread.sleep(3000);
    }

    @Then ("user will click on contact us")
    public void user_will_click_on_contact_us() throws InterruptedException {
        List<WebElement> ele1 = driver.findElements(By.xpath(contactus));
        System.out.println("SHARP: Element count for " +contactus+ " is :" +ele1.size());
        List<WebElement> ele2 = driver.findElements(By.xpath(contactus2));
        System.out.println("SHARP: Element count for " +contactus2+ " is :" +ele2.size());
        if (ele1.size() > 0) {
            driver.findElement(By.xpath(contactus)).click();
        } else if (ele2.size() > 0) {
            driver.findElement(By.xpath(contactus2)).click();
        }
        Thread.sleep(3000);
    }

    @And ("User click on account Balance")
    public void User_click_on_account_Balance() throws InterruptedException {
        driver.findElement(By.xpath(Accountbalancebutton)).click();
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
    }
    @When ("user enters web login id")
    public void user_enters_web_login_id() throws InterruptedException {
    	driver.findElement(By.xpath(websigninusername)).sendKeys(strUserName);
    	Thread.sleep(3000);
    }
    @And ("user enters web password")
    public void user_enters_web_password() throws InterruptedException {
    	driver.findElement(By.xpath(passwordforweb)).sendKeys(strPassword);
    	Thread.sleep(2000);
    }


    @When ("user enters {string} and {string}")
    public void user_enters(String str1, String str2) throws InterruptedException {

        wait_for_time(username,10000);
        //Wait_Until_element_Visibility(websigninusername);
        driver.findElement(By.xpath(username)).sendKeys(str1);
        Wait_Until_element_Visibility(password);
        driver.findElement(By.xpath(password)).sendKeys(str2);
    }

    @Then("user enters login id for web {string}")
    public void user_enters_login_id_for_web(String opcoName)throws InterruptedException {
        Thread.sleep(5000);
        if (opcoName.equalsIgnoreCase("ace")) {
            driver.findElement(By.xpath(username2)).sendKeys("RDBMSM");
            Thread.sleep(3000);
        } else if (opcoName.equalsIgnoreCase("dpl")) {
            driver.findElement(By.xpath(username2)).sendKeys("WAYDIXIE");
            Thread.sleep(3000);
        } else if (opcoName.equalsIgnoreCase("pepco")) {
            driver.findElement(By.xpath(username2)).sendKeys("MERRILLDEMIAN");
            Thread.sleep(3000);
        }
    }

    @And("user enters password for web {string}")
    public void user_enters_password_for_web(String opcoName) throws InterruptedException {
        Thread.sleep(5000);
        if (opcoName.equalsIgnoreCase("ace")) {
            driver.findElement(By.xpath(password2)).sendKeys("Password1");
            Thread.sleep(3000);
        } else if (opcoName.equalsIgnoreCase("dpl")) {
            driver.findElement(By.xpath(password2)).sendKeys("Password1");
            Thread.sleep(3000);
        } else if (opcoName.equalsIgnoreCase("pepco")) {
            driver.findElement(By.xpath(password2)).sendKeys("Password1");
            Thread.sleep(3000);
        }
    }

    @And ("user enters {string}")
    public void user_enter(String str2) throws InterruptedException {
        driver.findElement(By.xpath(passwordforweb)).sendKeys(str2);
        Thread.sleep(3000);
    }

    @Then("click SIGNIN button")
    public void click_SIGNIN_button() throws InterruptedException, IOException {
        Wait_Until_element_Visibility(btnSignIn);
        driver.findElement(By.xpath(btnSignIn)).click();
        Thread.sleep(8000);
    }

    @Then("click continue button")
    public void click_continue_button() throws InterruptedException, IOException {
        Wait_Until_element_Visibility(btnContinue);
        driver.findElement(By.xpath(btnContinue)).click();
        Thread.sleep(8000);
    }

    @And("click SIGNIN")
    public void click_SIGNIN() throws InterruptedException {
        Wait_Until_element_Visibility(signIn);
        driver.findElement(By.xpath(signIn)).click();
    }

    @Then("user click on sign in")
    public void user_click_on_sign_in () throws InterruptedException {
        driver.findElement(By.xpath(websigninone)).click();
        Thread.sleep(50000);
    }

    @And("user click signout")
    public void user_click_signout() throws InterruptedException, IOException {
        //Wait_Until_element_Visibility(signout);
        wait_for_time(signout,12000);
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

    @And("click survey rating as {string}")
    public void click_survey_rating_as(String strrating) throws InterruptedException {
        if(strrating.equalsIgnoreCase("one")){
            driver.findElement(By.xpath(surveyRating1)).click();
        } else if (strrating.equalsIgnoreCase("two")) {
            driver.findElement(By.xpath(surveyRating2)).click();
        } else if (strrating.equalsIgnoreCase("three")) {
            driver.findElement(By.xpath(surveyRating3)).click();
        } else if (strrating.equalsIgnoreCase("four")) {
            driver.findElement(By.xpath(surveyRating4)).click();
        } else if (strrating.equalsIgnoreCase("five")) {
            driver.findElement(By.xpath(surveyRating5)).click();
        }
        Thread.sleep(5000);
    }

    @Then("user will redirect to Move service page")
    public void user_will_redirect_to_move_Service_page() throws InterruptedException {
        Set<String> handle=driver.getWindowHandles();
        Iterator<String> it= handle.iterator();
        String parantwindow=it.next();
        System.out.println("SHARP Inside Step: Parent Window handler is " + parantwindow);
        String childwindow=it.next();
        System.out.println("SHARP Inside Step: Child Window handler is " + childwindow);
        driver.switchTo().window(childwindow);
        wait_for_time(moveServiceWindow,16000);
        String strtext = driver.findElement(By.xpath(moveServiceWindow)).getText();
        System.out.println(strtext);
        assert strtext.equalsIgnoreCase(strMoveWindow);
        driver.close();
        driver.switchTo().window(parantwindow);
    }

    @Then("click Deposits")
    public void click_Deposits() throws InterruptedException {
        driver.findElement(By.xpath(Deposits2)).click();
        Thread.sleep(5000);
    }

    @And("validate if deposits with correct text is displayed as per {string}")
    public void validate_if_popup_with_correct_text_is_displayed_as_per(String opcoName) throws InterruptedException {
        Thread.sleep(5000);
        if (opcoName.equalsIgnoreCase("ace")) {
            String strdeposittext = driver.findElement(By.xpath(Actualdeposittext)).getText();
            System.out.println(strdeposittext);
            assert strdeposittext.equalsIgnoreCase(ExpectedACEdeposittext);
        } else if (opcoName.equalsIgnoreCase("dpl")) {
            Thread.sleep(5000);
            String strdeposittext = driver.findElement(By.xpath(Actualdeposittext)).getText();
            System.out.println(strdeposittext);
            assert strdeposittext.equalsIgnoreCase(ExpectedDPLdeposittext);
        } else if (opcoName.equalsIgnoreCase("pepco")) {
            Thread.sleep(5000);
            String strdeposittext = driver.findElement(By.xpath(Actualdeposittext)).getText();
            System.out.println(strdeposittext);
            assert strdeposittext.equalsIgnoreCase(ExpectedPEPCOdeposittext);
        }
        Thread.sleep(5000);
    }

    @And("Select account from multiple account")
    public void Select_account_from_multiple_account() throws InterruptedException {
        wait_for_time(Selectaccountfrommultipleaccount,10000);
        driver.findElement(By.xpath(Selectaccountfrommultipleaccount)).click();
        Thread.sleep(10000);
    }

    @Then("Validate Deposits link as per {string}")
    public void Validate_Deposits_link_as_per(String opcoName) throws InterruptedException {
        Thread.sleep(5000);
        if (opcoName.equalsIgnoreCase("ace")) {
            String FAQDepositLink = driver.findElement(By.xpath(depositlink)).getAttribute("href");
            System.out.println(FAQDepositLink);
            Thread.sleep(5000);
            assert FAQDepositLink.equalsIgnoreCase(ExpectedACEdepositFAQlink);
        } else if (opcoName.equalsIgnoreCase("dpl")) {
            Thread.sleep(5000);
            String FAQDepositLink = driver.findElement(By.xpath(depositlink)).getAttribute("href");
            System.out.println(FAQDepositLink);
            assert FAQDepositLink.equalsIgnoreCase(ExpectedDPLdepositFAQlink);
        } else if (opcoName.equalsIgnoreCase("pepco")) {
            Thread.sleep(5000);
            String FAQDepositLink = driver.findElement(By.xpath(depositlink)).getAttribute("href");
            System.out.println(FAQDepositLink);
            assert FAQDepositLink.equalsIgnoreCase(ExpectedPEPCOdepositFAQlink);
        }
    }

    @And("type utterance for deposits")
    public void type_utterance_for_deposits() throws InterruptedException {
        driver.findElement(By.xpath(typeutterance)).sendKeys("How is my deposit amount determined");
        Thread.sleep(3000);
    }

    @Then("click Leave comment")
    public void click_Leave_comment() throws InterruptedException {
        driver.findElement(By.xpath(Leavecommentforfeedback)).click();
        Thread.sleep(5000);
    }

    @And("type {string}")
    public void type_comment(String strComments) throws InterruptedException {
        driver.findElement(By.xpath(inputtext)).sendKeys(strComments);
        Thread.sleep(5000);
    }

    @Then("click Oauth Sign in")
    public void click_Oauth_Sign_in() throws InterruptedException {
        driver.findElement(By.xpath(clickOauthignn)).click();
        Thread.sleep(5000);
    }

    @When("User click on no thanks i just needed my balance")
    public void User_click_on_no_thanks_i_just_needed_my_balance() throws InterruptedException {
        driver.findElement(By.xpath(nothanksijustneededmybalance)).click();
        Thread.sleep(5000);
    }

    @Then("click Refunds")
    public void click_Refunds() throws InterruptedException {
        driver.findElement(By.xpath(Refunds)).click();
        Thread.sleep(15000);
    }

    @And("click No Thanks")
    public void click_No_Thanks() throws InterruptedException {
        driver.findElement(By.xpath(NoThanks)).click();
        Thread.sleep(3000);
    }

    @And("validate if Refunds with correct text is displayed as per {string}")
    public void validate_if_Refunds_with_correct_text_is_displayed_as_per(String opcoName) throws InterruptedException {
        Thread.sleep(5000);
        if (opcoName.equalsIgnoreCase("ace")) {
            String strRefundstext = driver.findElement(By.xpath(ActualRefundstext)).getText();
            System.out.println(strRefundstext);
            Thread.sleep(5000);
            assert strRefundstext.equalsIgnoreCase(ExpectedACERefundstext);
        } else if (opcoName.equalsIgnoreCase("dpl")) {
            Thread.sleep(5000);
            String strRefundstext = driver.findElement(By.xpath(ActualRefundstext)).getText();
            System.out.println(strRefundstext);
            Thread.sleep(5000);
            assert strRefundstext.equalsIgnoreCase(ExpectedDPLRefundstext);
        } else if (opcoName.equalsIgnoreCase("pepco")) {
            Thread.sleep(5000);
            String strRefundstext = driver.findElement(By.xpath(ActualRefundstext)).getText();
            System.out.println(strRefundstext);
            Thread.sleep(5000);
            assert strRefundstext.equalsIgnoreCase(ExpectedPEPCORefundstext);
        }
        Thread.sleep(5000);
    }

    @Then("Validate Refunds link as per {string}")
    public void Validate_Refunds_link_as_per(String opcoName) throws InterruptedException {
        Thread.sleep(5000);
        if (opcoName.equalsIgnoreCase("ace")) {
            String FAQRefundsLink = driver.findElement(By.xpath(Refundslink)).getAttribute("href");
            System.out.println(FAQRefundsLink);
            Thread.sleep(10000);
            assert FAQRefundsLink.equalsIgnoreCase(ExpectedACERefundsFAQlink);
        } else if (opcoName.equalsIgnoreCase("dpl")) {
            Thread.sleep(5000);
            String FAQRefundsLink = driver.findElement(By.xpath(Refundslink)).getAttribute("href");
            System.out.println(FAQRefundsLink);
            assert FAQRefundsLink.equalsIgnoreCase(ExpectedDPLRefundsFAQlink);
        } else if (opcoName.equalsIgnoreCase("pepco")) {
            Thread.sleep(5000);
            String FAQRefundsLink = driver.findElement(By.xpath(Refundslink)).getAttribute("href");
            System.out.println(FAQRefundsLink);
            assert FAQRefundsLink.equalsIgnoreCase(ExpectedPEPCORefundsFAQlink);
        }

    }

    @Given("create connection")
    public void create_connection() throws Exception {
        fnKillProcess("chromedriver.exe");
        fnKillProcess("FieldService-Elec.exe");
        System.setProperty(chromeDriverinfo, chromePath);

        ChromeOptions opt = new ChromeOptions();
        opt.setBinary(emersonFileService);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("chromeOptions", opt);
        capabilities.setBrowserName("chrome");
        driver = new ChromeDriver(opt);
        Thread.sleep(10000);

        Shadow shadowDom = new Shadow(driver);
//        WebElement username = shadowDom.findElement("login-box");
        List<WebElement> elements = shadowDom.findElements("*");
        System.out.println("Number of elements:" + elements.size());
        wait_for_time("//ion-split-pane[@class='split-pane-visible']",2000);
        wait_for_time("//div[@id='initial-loader']",2000);

//        for (int m=0; m<elements.size();m++) {
//            System.out.println(m + "th Elements has tag name : " + elements.get(m).getTagName() + " and class name is : " + elements.get(m).getAttribute("className"));
//         }
//
//
        driver.findElement(By.xpath(ionicUsername)).sendKeys("Test");
        driver.findElement(By.xpath(ionicPassword)).sendKeys("Test");
        driver.findElement(By.xpath(submitButtonSpan)).click();
        Thread.sleep(8000);
        driver.findElement(By.xpath(ionicUname)).sendKeys("SHARP has entered the desired text");
        driver.findElement(By.xpath(submitButton1)).click();
        Thread.sleep(8000);


//        System.out.println(username.getClass().toString());
//        WebElement ele1 = username.findElement(By.id("login_username"));
//        ele1.sendKeys("Test");
//        username.sendKeys("Test");
//
//        for (int i = 0; i < elements.size(); i++) {
//            System.out.println(i + "th Elements has tag name : " + elements.get(i).getTagName() + " and class name is : " + elements.get(i).getAttribute("className"));
//            System.out.println(i + "th Elements are below");
//            WebElement sr = expandRootElement(elements.get(i));
//
//            try {
//                List<WebElement> elements2 = sr.findElements(By.cssSelector("*"));
//                System.out.println("Number of elements:" + elements2.size());
//                for (int j = 0; j < elements2.size(); j++) {
//                    System.out.println("    " + j + "th Elements has tag name : " + elements2.get(j).getTagName() + " and class name is : " + elements2.get(j).getAttribute("className"));
//                    WebElement sr1 = expandRootElement(elements2.get(j));
//                    try {
//                        List<WebElement> elements3 = sr1.findElements(By.cssSelector("*"));
//                        System.out.println("    " + "Number of elements in j :" + elements3.size());
//                        for (int k = 0; k < elements3.size(); k++) {
//                            System.out.println("         " + k + "th Elements has tag name : " + elements3.get(k).getTagName() + " and class name is : " + elements3.get(k).getAttribute("className"));
//                            WebElement s1 = expandRootElement(elements3.get(k));
//                            try {
//                                List<WebElement> elements4 = s1.findElements(By.cssSelector("*"));
//                                System.out.println("         " + "Number of elements in k :" + elements4.size());
//                                for (int l = 0; l < elements4.size(); l++) {
//                                    System.out.println("              " + l + "th Elements has tag name : " + elements4.get(l).getTagName() + " and class name is : " + elements4.get(l).getAttribute("className"));
//                                    WebElement s2 = expandRootElement(elements4.get(l));
//                                    try {
//                                        List<WebElement> elements5 = s2.findElements(By.cssSelector("*"));
//                                        System.out.println("              " + "Number of elements in l :" + elements5.size());
//
//                                        for (int m = 0; m < elements5.size(); m++) {
//                                            System.out.println("              " + m + "th Elements has tag name : " + elements5.get(m).getTagName() + " and class name is : " + elements5.get(m).getAttribute("className"));
//                                            WebElement s3 = expandRootElement(elements5.get(m));
//                                            try {
//                                                List<WebElement> elements6 = s3.findElements(By.cssSelector("*"));
//                                                System.out.println("              " + "Number of elements in m :" + elements6.size());
//                                            } catch (NullPointerException npe) {
//                                                System.out.println("              " + m + " : does not have any element");
//                                            }
//                                        }
//                                    } catch (NullPointerException npe) {
//                                        System.out.println("              " + l + " : does not have any element");
//                                    }
//                                }
//                            } catch (NullPointerException npe) {
//                                System.out.println("         " + k + " : does not have any element");
//                            }
//                        }
//                    } catch (NullPointerException npe) {
//                        System.out.println("    " + j + " - does not have any element");
//                    }
//                }
//            } catch (NullPointerException npe) {
//                System.out.println(i + " - does not have any element");
//            }


//        WebElement r = driver.findElement(By.tagName("body"));
//        WebElement shadowR = expandRootElement(r);
//        WebElement root = shadowR.findElement(By.cssSelector("app-root"));
//        WebElement shadowRoot = expandRootElement(root);
//        WebElement root1 = shadowRoot.findElement(By.cssSelector("app-login"));
//        WebElement shadowRoot1 = expandRootElement(root1);
//        WebElement root2 = shadowRoot1.findElement(By.cssSelector("div[id='background-content']"));
//        WebElement shadowRoot2 = expandRootElement(root2);
//        WebElement root3 = shadowRoot2.findElement(By.cssSelector("ion-card-content"));
//        WebElement shadowRoot3 = expandRootElement(root3);
//        WebElement root4 = shadowRoot3.findElement(By.cssSelector("div[class=item-native]"));
//        WebElement shadowRoot4 = expandRootElement(root4);
//        String actualHeading = shadowRoot4.findElement(By.cssSelector("input[@id='login_username']")).getText();
//        System.out.println(actualHeading);

//        }
    }


    @Given("Launch Application")
    public void launch_application() throws Exception {
        fnKillProcess("chromedriver.exe");
        System.setProperty(chromeDriverinfo, chromePath);
        driver = new ChromeDriver();
        //driver.navigate().to("http://localhost:4200");
        driver.navigate().to("capacitor-electron://-");
        //driver.navigate().to(emersonFileService);
        Thread.sleep(8000);
        System.out.println(browserOpenMessage);
        driver.findElement(By.xpath(ionicUsername)).sendKeys("Test");
        driver.findElement(By.xpath(ionicPassword)).sendKeys("Test");
        driver.findElement(By.xpath(submitButtonSpan)).click();
        Thread.sleep(8000);
        driver.findElement(By.xpath(ionicUname)).sendKeys("SHARP has entered the desired text");
        driver.findElement(By.xpath(submitButton1)).click();
        Thread.sleep(8000);

    }

    public WebElement expandRootElement(WebElement element){
        try {
            WebElement ele = (WebElement) ((JavascriptExecutor) driver)
                    .executeScript("return arguments[0].shadowRoot",element);
            return ele;
        } catch (NullPointerException npe) {
            return element;
        }
    }


    public void wait_for_time(String strXpath, Integer intTime) throws InterruptedException{
        List<WebElement> ele = driver.findElements(By.xpath(strXpath));
        System.out.println("SHARP: Element count for " +strXpath+ " is :" +ele.size());
        if (ele.size() == 0) {
            Thread.sleep(intTime);
        }
    }

    public void Wait_Until_element_Visibility(String xpath)  throws InterruptedException{
        List<WebElement> ele = driver.findElements(By.xpath(xpath));
        System.out.println("SHARP: Element count for " +xpath+ " is :" +ele.size());
        if (ele.size() == 0) {
            Thread.sleep(10000);
        }
    }

    public void fnKillProcess(String strProcessName) throws Exception {
        String processName = strProcessName;
        if (isProcessRunning(processName)) {
            Runtime.getRuntime().exec(KILL + processName);
            System.out.println(processName + " is running, hence SHARP closed the process");
        } else {
            System.out.println(processName + " is not running, SHARP proceeding to next step.");
        }
    }

    public static boolean isProcessRunning(String serviceName) throws Exception {
        Process p = Runtime.getRuntime().exec(TASKLIST);
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                p.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            //System.out.println(line);
            if (line.contains(serviceName)) {
                return true;
            }
        }
        return false;
    }



}
