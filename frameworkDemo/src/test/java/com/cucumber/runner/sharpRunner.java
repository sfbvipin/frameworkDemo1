package com.cucumber.runner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;


//@RunWith(Cucumber.class)
@io.cucumber.testng.CucumberOptions(
        features={"classpath:features"}
        ,glue= {"StepsDefine","cucumberHooks"}
        ,monochrome=true
        ,tags = "@GetAPI"
        ,plugin = {"cucumberHooks.customReportListener"})

@Test
public class sharpRunner extends AbstractTestNGCucumberTests{
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

