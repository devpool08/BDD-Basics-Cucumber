package org.swagger.testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\PS\\BDD-Basics-Cucumber\\src\\test\\resources\\features\\CheckOut.feature",
        glue = {"org.swagger.stepDefinition.checkOutSteps"},
        plugin = {"pretty", "json:target/cucumber-report.json"}
)
public class TestCheckOutRunner {
}
