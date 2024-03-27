package com.LMSAPI.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
		plugin= {"pretty", "html:target/cucumberreport.html", "html:target/ExtentReports/Ds-algo.html",
				"rerun:target/failedrerun.txt", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
				monochrome = true,
				tags = "",
				features= {"src/test/resources/Feature/Test"},
				glue = {"BearerAuth"})
public class UserAPIRunner {
	

}
