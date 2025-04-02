package org.swagger.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\PS\\BDD-Basics-Cucumber\\src\\test\\resources\\features\\OrderConfirmation.feature",
        glue = {"org.swagger.stepDefinition.orderConfirmationStep","org.swagger.stepDefinition.orderConfirmationStep.checkOutSteps"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/report.html",  // Ensure unique directory
                "json:target/cucumber-reports/cucumber.json" // Use a unique path for JSON
        }
)
public class TestOrderConfirmation {
}
