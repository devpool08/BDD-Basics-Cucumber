package org.swagger.stepDefinition;

import io.cucumber.java.en.And;
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
    @Given("I open chrome browser")
    public void i_open_chrome_browser() {
        System.out.println("ok");
        setUp();
    }

    @When("I navigate to SwagLabs login page And Enter Credentials")
    public void i_navigate_to_swag_labs_login_page_and_enter_credentials() {
        openPage(properties.getProperty("SWAGGER_LOGIN_URL"));
        loginPage = new LoginPage(driver);
        loginPage.inputUserName(properties.getProperty("VALID_USER_NAME"));
        loginPage.inputPassword(properties.getProperty("VALID_PASSWORD"));
        loginPage.clickEnter();
    }

    @Then("I should see the Home page")
    public void i_should_see_the_home_page() {
        inventoryPage = new InventoryPage(driver);
        assert inventoryPage.getLabel().equals("Products"):"ERROR";
    }

    @And("I close the browser")
    public void i_close_the_browser() {
        tearDown();
    }
}
