package org.swagger.stepDefinition.orderConfirmationStep;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.swagger.base.BaseStep;
import org.swagger.pages.CheckoutInfoFillFormPage;
import org.swagger.pages.FinalPage;
import org.swagger.pages.OverviewPage;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;


@SuppressWarnings({"FieldCanBeLocal", "unused",})
public class SwaggerOrderConfirmationStep extends BaseStep {
    private CheckoutInfoFillFormPage checkoutInfoFillFormPage;
    private OverviewPage overviewPage;
    private FinalPage finalPage;

    @Given("I am in the Checkout form page")
    public void iAmInTheCheckoutFormPage() {
        setUp();
        checkoutInfoFillFormPage = new CheckoutInfoFillFormPage(driver);
        assertEquals("Checkout: Your Information", checkoutInfoFillFormPage.isCheckoutInfoPresent());
    }

    @When("I am filling the Checkout form and proceed")
    public void iAmFillingTheCheckoutFormAndProceed() {
        assertTrue(checkoutInfoFillFormPage.
                inputFirstName(RandomStringUtils.randomAlphabetic(6)), "Error in Filling first name");
        assertTrue(checkoutInfoFillFormPage.
                inputLastName(RandomStringUtils.randomAlphabetic(6)), "Error in Filling last name");
        assertTrue(checkoutInfoFillFormPage.
                inputPostalCode(RandomStringUtils.randomNumeric(5)), "Error in Filling postal code");
    }

    @Then("I should see theOverview page")
    public void iShouldSeeTheOrderConfirmationPage() {
        overviewPage = new OverviewPage(driver);
        assert overviewPage.clickOnFinishButton() : "Error while clicking finish button";
    }

    @And("I should see the message")
    public void iShouldSeeTheMessage() {
        finalPage = new FinalPage(driver);
        String orderConfirmationMessage = finalPage.getThankYouMessage();
        assertEquals("THANK YOU FOR YOUR ORDER", orderConfirmationMessage);
        tearDown();
    }
}
