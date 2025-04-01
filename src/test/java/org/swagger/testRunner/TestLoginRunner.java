package org.swagger.testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\PS\\BDD-Basics-Cucumber\\features\\SwagLabLogin.feature",
        glue = "org.swagger.stepDefinition",
        plugin = {"pretty", "html:target/cucumber-report"},
        tags = "@SmokeTest"
)
public class TestLoginRunner {

}
