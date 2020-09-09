package StepsDefine;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmersonAndroidFuctions {
AndroidDriver driver;
	@Given("application is invoked")
	public AndroidDriver<AndroidElement> application_is_invoked() throws MalformedURLException {
		File f =new File("src/main/java/EmersonApp");
		File fs=new File(f,"fieldService.apk");
		
		DesiredCapabilities dcap =new DesiredCapabilities();
		dcap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		dcap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
		dcap.setCapability(MobileCapabilityType.DEVICE_NAME, "pixel 2");
		dcap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		
		dcap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		
		AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement> (new URL("http://localhost:4723/wd/hub"),dcap);
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		return driver;
		
		
	}

	@And("user will enter the login id")
	public void user_will_enter_the_login_id() throws InterruptedException  {
		
		MobileElement login=(MobileElement) driver.findElement(By.xpath("//android.webkit.WebView[@content-desc=\"Ionic App\"]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.widget.EditText"));
		login.sendKeys("pulkit.agarwal");
	    Thread.sleep(3000);
	}

	@When("user enters the password")
	public void user_enters_the_password() throws InterruptedException {
		MobileElement pass=(MobileElement) driver.findElement(By.xpath("//android.webkit.WebView[@content-desc=\"Ionic App\"]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.widget.EditText"));
		pass.sendKeys("Emerson18");
		Thread.sleep(3000);
	}

	@And("click on login button")
	public void click_on_login_button() throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.Button[@content-desc='SIGN IN ']")).click();
		Thread.sleep(3000);
	}

	@Then("application will be open")
	public void application_will_be_open() {
	    System.out.println("Login Successfully");
	}
		
	
		
		

	}


