package org.swagger.stepDefinition.loginSteps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.swagger.base.BaseStep;
import org.swagger.pages.InventoryPage;
import org.swagger.pages.LoginPage;


@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class SwaggerLoginStep extends BaseStep {
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    @Given("I open the url")
    public void i_open_chrome_browser() {
        setUp();
        openPage(properties.getProperty("SWAGGER_LOGIN_URL"));
    }

    @When("I Enter Credentials and click log in button int the Login Page")
    public void i_navigate_to_swag_labs_login_page_and_enter_credentials() {
        loginPage = new LoginPage(driver);
        loginPage.inputUserName(properties.getProperty("VALID_USER_NAME"));
        loginPage.inputPassword(properties.getProperty("VALID_PASSWORD"));
        loginPage.clickEnter();
    }

    @Then("I should see the Inventory Page")
    public void i_should_see_the_home_page() {
        inventoryPage = new InventoryPage(driver);
        assert inventoryPage.getLabel().equals("Products"):"ERROR";
        tearDown();
    }

}
