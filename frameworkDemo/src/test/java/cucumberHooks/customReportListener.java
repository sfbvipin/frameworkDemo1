package cucumberHooks;

import StepsDefine.genericFunctions;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestCaseStarted;
import io.cucumber.plugin.event.TestRunFinished;
import io.cucumber.plugin.event.TestRunStarted;
import io.cucumber.plugin.event.TestSourceRead;
import io.cucumber.plugin.event.TestStepFinished;
import io.cucumber.plugin.event.TestStepStarted;
import io.cucumber.plugin.event.HookTestStep;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static StepsDefine.genericFunctions.*;


public class customReportListener implements EventListener {
    private ExtentSparkReporter spark;
    private ExtentReports extent;
    Map<String, ExtentTest> feature = new HashMap<String, ExtentTest>();
    ExtentTest scenario;
    ExtentTest step;
    public String featureName = null;
    public String featureSource = null;

    public customReportListener() {
    };
    @Override
    public void setEventPublisher(EventPublisher publisher) {
// TODO Auto-generated method stub
        publisher.registerHandlerFor(TestRunStarted.class, this::runStarted);
        publisher.registerHandlerFor(TestSourceRead.class, this::featureRead);
        publisher.registerHandlerFor(TestCaseStarted.class, this::ScenarioStarted);
        publisher.registerHandlerFor(TestStepStarted.class, this::stepStarted);
        publisher.registerHandlerFor(TestStepFinished.class, this::stepFinished);
        publisher.registerHandlerFor(TestRunFinished.class, this::runFinished);
    }

    /*------------------------------------------------------------
    Function Name 	:	runStarted
    Variables		:	event
    Description	    :	This function is to start the run
    -------------------------------------------------------------*/
    private void runStarted(TestRunStarted event) {
        System.out.println("SHARP: Extent Report is initialized");
        spark = new ExtentSparkReporter("./ExtentReportResults.html");
        extent = new ExtentReports();
        //spark.config().setTheme(Theme.DARK);

        extent.attachReporter(spark);
        extent.setSystemInfo("OS", "Windows");
        extent.setSystemInfo("Environment", "QA");
        //deleteFolder(new File("src/test/resources/FailedCaseImages"));

    };

    /*------------------------------------------------------------
    Function Name 	:	runFinished
    Variables		:	event
    Description	    :	This function is to finish the run
    -------------------------------------------------------------*/
    private void runFinished(TestRunFinished event) {
        extent.flush();
    };

    /*------------------------------------------------------------
    Function Name 	:	featureRead
    Variables		:	event
    Description	    :	This function is to read the feature file
    -------------------------------------------------------------*/
    private void featureRead(TestSourceRead event) {
        featureSource = event.getUri().toString();
        featureName = featureSource.split(".*/")[1];
        System.out.println("SHARP: Extent Report is reading feature files");
        if (feature.get(featureSource) == null) {
            feature.putIfAbsent(featureSource, extent.createTest(featureName).assignAuthor("SHARP"));
        }
    };


    /*------------------------------------------------------------
    Function Name 	:	ScenarioStarted
    Variables		:	event
    Description	    :	This function is to get scenarios
    -------------------------------------------------------------*/
    private void ScenarioStarted(TestCaseStarted event) {
        System.out.println("SHARP: Extent Report is getting Scenarios from feature");
        String featureName1 = event.getTestCase().getUri().toString();
        scenario = feature.get(featureName1).createNode(event.getTestCase().getName());
    };

    /*------------------------------------------------------------
    Function Name 	:	stepStarted
    Variables		:	event
    Description	    :	This function is to start the steps
    -------------------------------------------------------------*/
    private void stepStarted(TestStepStarted event) {
        String stepName = " ";
        String keyword = "Triggered the hook :";
        if (event.getTestStep() instanceof PickleStepTestStep) {
            PickleStepTestStep steps = (PickleStepTestStep) event.getTestStep();
            stepName = steps.getStep().getText();
            keyword = steps.getStep().getKeyword();
        } else {
            HookTestStep hoo = (HookTestStep) event.getTestStep();
            stepName = hoo.getHookType().name();
        }
        step = scenario.createNode(Given.class, keyword + " " + stepName);

        Date startTime = scenario.getExtent().getReport().getEndTime();
        step.log(Status.INFO, "Test Case execution started at " + startTime.toString());
    };

    /*------------------------------------------------------------
    Function Name 	:	stepFinished
    Variables		:	event
    Description	    :	This function is to finish step and add result
    -------------------------------------------------------------*/
    private void stepFinished(TestStepFinished event)  {
        if (event.getResult().getStatus().toString() == "PASSED") {
            step.log(Status.PASS, "This step passed");
        } else if (event.getResult().getStatus().toString() == "SKIPPED")
        {
            step.log(Status.SKIP, "This step was skipped ");
        } else {
            try {
                if (featureName.contains("API")){
                    step.log(Status.FAIL, "This API automation step failed");
                } else {
                    step.log(Status.FAIL, "This step failed").addScreenCaptureFromPath(capture(driver));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Date endTime = scenario.getExtent().getReport().getEndTime();
        step.log(Status.INFO, "Test Case execution ended at " + endTime.toString());
        //addonFunctions.SendMail();
    }

    /*------------------------------------------------------------
    Function Name 	:	capture
    Variables		:	driver
    Description	    :	This function is to capture screen shot
    -------------------------------------------------------------*/
    public static String capture(WebDriver driver) throws IOException {
        System.out.println("SHARP: Extent Report is capturing screenshot");
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_hhmmssMs");
        String formattedDate = sdf.format(date);
        System.out.println("SHARP is saving screen shot for failed step with name :" + formattedDate);
        //System.currentTimeMillis()
        File Dest = new File("src/test/resources/FailedCaseImages/" + formattedDate
                + ".jpg");
        String filepath = Dest.getAbsolutePath();
        FileUtils.copyFile(scrFile, Dest);
        return filepath;
    }

    /*------------------------------------------------------------
    Function Name 	:	deleteFolder
    Variables		:	folder
    Description	    :	This function is to delete folder
    -------------------------------------------------------------*/
//    public static void deleteFolder(File folder) {
//        File[] files = folder.listFiles();
//        if(files!=null) { //some JVMs return null for empty dirs
//            for(File f: files) {
//                if(f.isDirectory()) {
//                    deleteFolder(f);
//                } else {
//                    f.delete();
//                }
//            }
//        }
//        folder.delete();
//    }
}

