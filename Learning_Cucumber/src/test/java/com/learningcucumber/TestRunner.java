package com.learningcucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/resources/features",
		glue = "com.learningcucumber"
		)

public class TestRunner extends AbstractTestNGCucumberTests{

}
