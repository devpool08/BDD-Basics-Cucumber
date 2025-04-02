package org.swagger.testRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "C:\\PS\\BDD-Basics-Cucumber\\src\\test\\resources\\features\\CheckOut.feature",
        glue = {"org.swagger.stepDefinition.checkOutSteps"},
        plugin = {
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class TestCheckOutRunner extends AbstractTestNGCucumberTests {
}
