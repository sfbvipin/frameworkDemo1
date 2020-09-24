package com.cucumber.runner;


import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



//import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.AbstractTestNGCucumberTests;




//@RunWith(Cucumber.class)
@io.cucumber.testng.CucumberOptions(
        features={"classpath:features"}
        ,glue= {"StepsDefine","cucumberHooks"}
        ,monochrome=true
        ,tags = "@TC_HCM_004"
        ,plugin = {"cucumberHooks.customReportListener"})

@Test
public class sharpRunner extends AbstractTestNGCucumberTests{

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
	






























































