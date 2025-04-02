package org.swagger.testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\PS\\BDD-Basics-Cucumber\\src\\test\\resources\\features\\SwagLabLogin.feature",
        glue = "org.swagger.stepDefinition.loginSteps",
        plugin = {"pretty", "html:target/cucumber-report"},
        tags = "@SmokeTest"
)
public class TestLoginRunner {

}
