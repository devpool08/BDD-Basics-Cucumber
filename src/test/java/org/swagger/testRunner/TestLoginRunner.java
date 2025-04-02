package org.swagger.testRunner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "C:\\PS\\BDD-Basics-Cucumber\\src\\test\\resources\\features\\SwagLabLogin.feature",
        glue = "org.swagger.stepDefinition.loginSteps",
        tags = "@SmokeTest",
        plugin = {
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class TestLoginRunner extends AbstractTestNGCucumberTests {

}
