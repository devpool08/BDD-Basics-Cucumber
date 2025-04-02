package org.swagger.stepDefinition.loginSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.swagger.base.BaseStep;
import org.swagger.pages.LoginPage;

import static org.junit.Assert.assertEquals;

public class SwaggerInvalidLoginStep extends BaseStep {
    private LoginPage loginPage;
    @Given("I open the url of Swag Lab")
    public void openChromeBrowser() {
        setUp();
        openPage(properties.getProperty("SWAGGER_LOGIN_URL"));
    }
    @When("I Enter Invalid Credentials and click log in button int the Login Page")
    public void navigateToSwagLabsLoginPageAndEnterInvalidCredentials() {
        loginPage= new LoginPage(driver);
        loginPage.inputUserName("invalid_user");
        loginPage.inputPassword("invalid_password");
        loginPage.clickEnter();
    }
    @Then("I should see the error message")
    public void iShouldSeeTheErrorMessage() {
        String errorMessage = loginPage.ErrorMessege();
        assertEquals("Epic sadface: Username and password do not match any user in this service", errorMessage);
        tearDown();
    }
}
