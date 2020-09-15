package StepsDefine;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class genericFunctions extends AllVariables {
    AllVariables alv= new AllVariables();
    WebDriver driver =null;




    @Given("firefox browser is open")
    public void firefox_browser_is_open() {
        System.out.println(browserOpenMessage);
        System.setProperty(geckoDriverinfo , firfoxPath);

        driver =new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        //driver.manage().window().maximize();
    }

    @Given("chrome browser is open")
    public void chrome_browser_is_open() {
        System.out.println(browserOpenMessage);
        System.setProperty(chromeDriverinfo, chromePath);

        driver =new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        //driver.manage().window().maximize();
    }

/*    public String capture() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File Dest = new File("src/test/resources/FailedCaseImages/" + System.currentTimeMillis()
                + ".png");
        String filepath = Dest.getAbsolutePath();
        FileUtils.copyFile(scrFile, Dest);
        return filepath;
    }*/

    @And("user will be on exelon homepage")
    public void user_will_be_on_exelon_homepage() throws InterruptedException {
        System.out.println(browserHomePageMessage);
        driver.navigate().to(exelonUrl);
        Thread.sleep(10000);
    }

    @When("user will locate the chatbot icon")
    public void user_will_locate_the_chatbot_icon() throws InterruptedException {
        System.out.println("Inside Step:-user able to locate chat bot");
        Thread.sleep(3000);
    }

    @And("click on exelon chatbot icon")
    public void click_on_exelon_chatbot_icon() throws InterruptedException {
        System.out.println("Inside Step:-user clicked on chatbot icon");
        driver.findElement(By.xpath(ChatbotIcon)).click();
        Thread.sleep(3000);
    }

    @Then("chatbot will be open")
    public void chatbot_will_be_open() throws InterruptedException {
        System.out.println("Inside Step:-chatbot opens up");
        WebElement status=driver.findElement(By.xpath(ChatbotConnected));
        System.out.println(status.isDisplayed());
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


    @And("user click no thanks i will continue")
    public void  user_click_no_thanks_i_will_continue() throws InterruptedException
    {
        driver.findElement(By.xpath(MenuOptionNoThanksContinue)).click();
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

    @Then("select and click pay via virtual assistance")
    public void select_and_click_pay_via_virtual_assistance() throws InterruptedException
    {
        driver.findElement(By.xpath(payviavirtual)).click();
        Thread.sleep(3000);
    }

    @And("click on sign in")
    public void click_on_sign_in() throws InterruptedException
    {
        driver.findElement(By.xpath(signin)).click();
        Thread.sleep(5000);
    }

    @Then("user will redirect to login page")
    public void user_will_redirect_to_login_page() throws InterruptedException {
        // driver.navigate().to(AllVariables.signurl);
        Set<String> handle=driver.getWindowHandles();
        Iterator<String> it= handle.iterator();
        String parantwindow=it.next();
        System.out.println(parantwindow);
        String childwindow=it.next();
        System.out.println(childwindow);
        driver.switchTo().window(childwindow);
        Thread.sleep(5000);
    }

    @When("user enters login id")
    public void user_enters_login_id() throws InterruptedException
    {
        driver.findElement(By.name("username")).sendKeys("PATTI@47");
        Thread.sleep(2000);
    }

    @And("user enters password")
    public void user_enters_password() throws InterruptedException
    {
        driver.findElement(By.name("password")).sendKeys("Password1");
        Thread.sleep(2000);
    }

    @Then("click on sign in for Authentication")
    public void click_on_sign_in_for_Authentication() throws InterruptedException {

        driver.findElement(By.xpath(signinforauth)).click();
        Thread.sleep(3000);
        driver.switchTo().activeElement().click();
    }
    @And("user accept the authorization request")
    public void user_accept_the_authorization_request() throws InterruptedException {

        driver.findElement(By.xpath(acceptauth)).click();
        Thread.sleep(3000);

    }

    @Then("navigate back to chat bot")
    public void navigate_back_to_chat_bot() throws InterruptedException {
        driver.close();
        System.out.println("user is back on home page");
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
}
