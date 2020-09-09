package StepsDefine;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        System.setProperty(chromeDriverinfo,chromePath);

        driver =new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        //driver.manage().window().maximize();
    }

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

    @Then("close the bot finally")
    public void close_the_bot_finally() throws InterruptedException {
        driver.findElement(By.xpath("//i[@class='fa fa-times']")).click();
        Thread.sleep(3000);
        driver.close();
    }
}
