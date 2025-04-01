package org.swagger.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\PS\\BDD-Basics-Cucumber\\features\\SwagLabInvalidLogin.feature",
        glue = "org.swagger.stepDefinition",
        plugin = {"pretty", "html:target/cucumber-report"}
)
public class TestInvalidLoginRunner {
}
