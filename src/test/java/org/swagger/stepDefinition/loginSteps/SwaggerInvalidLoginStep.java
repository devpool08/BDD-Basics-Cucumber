package org.swagger.stepDefinition.loginSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.swagger.base.BaseStep;
import org.swagger.pages.LoginPage;

import static org.junit.Assert.assertTrue;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class SwaggerInvalidLoginStep extends BaseStep {
    private LoginPage loginPage;

    @Given("I open the url of Swag Lab")
    public void openChromeBrowser() {
        setUp();
        openPage(properties.getProperty("SWAGGER_LOGIN_URL"));
    }

    @When("I enter {string} and {string} and click the login button in the Login Page")
    public void navigateToSwagLabsLoginPageAndEnterInvalidCredentials(String username, String password) {
        loginPage = new LoginPage(driver);
        loginPage.inputUserName(username);
        loginPage.inputPassword(password);
        loginPage.clickEnter();
    }

    @Then("I should see the error message")
    public void iShouldSeeTheErrorMessage() {
        String errorMessage = loginPage.getErrorMessege();
        assertTrue("Epic sadface: Username and password do not match any user in this service", errorMessage.contains("Epic sadface: Username and password do not match any user in this service"));
        tearDown();
    }
}
