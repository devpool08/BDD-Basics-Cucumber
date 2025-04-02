package org.swagger.testRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "C:\\PS\\BDD-Basics-Cucumber\\src\\test\\resources\\features\\SwagLabLogin.feature",
        glue = "org.swagger.stepDefinition.loginSteps",
        plugin = {
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        tags = "@RegressionTest"
)
public class TestInvalidLoginRunner extends AbstractTestNGCucumberTests {
}
