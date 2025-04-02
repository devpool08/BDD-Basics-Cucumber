package org.swagger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.swagger.base.BasePage;

@SuppressWarnings({"unused"})
public class FinalPage extends BasePage {
    public FinalPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h2[normalize-space()='THANK YOU FOR YOUR ORDER']")
    private WebElement thankYouMessage;

    public String getThankYouMessage() {
        try{
            wait.until(ExpectedConditions.visibilityOf(thankYouMessage));
            return thankYouMessage.getText();
        } catch (Exception e) {
            return null;
        }
    }
}
