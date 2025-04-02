package org.swagger.testRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "C:\\PS\\BDD-Basics-Cucumber\\src\\test\\resources\\features\\OrderConfirmation.feature",
        glue = {"org.swagger.stepDefinition.orderConfirmationStep",
                "org.swagger.stepDefinition.orderConfirmationStep.checkOutSteps"},
        plugin = {
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class TestOrderConfirmation extends AbstractTestNGCucumberTests {
}
