package org.swagger.stepDefinition.checkOutSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.swagger.base.BaseStep;
import org.swagger.pages.CheckOutPage;
import org.swagger.pages.InventoryPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SwaggerCheckoutStep extends BaseStep {
    private   InventoryPage inventoryPage;
    private CheckOutPage checkOutPage;
    @Given("I am in the Inventory Page")
    public void iAmInTheInventoryPage() {
        setUp();
        inventoryPage = new InventoryPage(driver);
        System.out.println(inventoryPage.getLabel());
    }
    @And("I am sorting the items by their price")
    public void iAmSortingTheItemsByTheirPrice() {
        inventoryPage.sortByPriceLowToHigh();
    }
    @When("I add a product in to the cart")
    public void iAddAProductInTheCart() {
        inventoryPage.addProductToCart();
    }
    @Then("I should see the Cart Page")
    public void iShouldSeeTheCartPage() {
        assertTrue(inventoryPage.verifyProductCart(), "Product is not in cart");
        checkOutPage = new CheckOutPage(driver);
        assertEquals(checkOutPage.isItemPresent(), "Sauce Labs Onesie");
        tearDown();
    }

}
