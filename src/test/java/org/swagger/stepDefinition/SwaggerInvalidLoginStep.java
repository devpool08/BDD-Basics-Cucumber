package org.swagger.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.swagger.base.BaseStep;
import org.swagger.pages.LoginPage;

import static org.junit.Assert.assertEquals;

public class SwaggerInvalidLoginStep extends BaseStep {
    private LoginPage loginPage;
    @Given("I open chrome browser for invalid login")
    public void openChromeBrowser() {
        setUp();
    }
    @When("I navigate to SwagLabs login page And Enter Invalid Credentials")
    public void navigateToSwagLabsLoginPageAndEnterInvalidCredentials() {
        loginPage= new LoginPage(driver);
        openPage(properties.getProperty("SWAGGER_LOGIN_URL"));
        loginPage.inputUserName("invalid_user");
        loginPage.inputPassword("invalid_password");
        loginPage.clickEnter();
    }
    @Then("I should see the error message")
    public void iShouldSeeTheErrorMessage() {
        String errorMessage = loginPage.ErrorMessege();
        assertEquals("Epic sadface: Username and password do not match any user in this service", errorMessage);
    }
    @And("I close the browser for invalid login")
    public void closeBrowser() {
        tearDown();
    }
}
