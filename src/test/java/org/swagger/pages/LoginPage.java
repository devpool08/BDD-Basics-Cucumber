package org.swagger.pages;


import org.swagger.base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


@SuppressWarnings("unused")
public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement usernameInput;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement error;

    public boolean inputUserName(String name) {
        try {

            wait.until(ExpectedConditions.visibilityOf(usernameInput));
            usernameInput.sendKeys(name);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean inputPassword(String password) {
        try {
            wait.until(ExpectedConditions.visibilityOf(passwordInput));
            passwordInput.sendKeys(password);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean clickEnter() {
        try {
            wait.until(ExpectedConditions.visibilityOf(passwordInput));
            passwordInput.sendKeys(Keys.RETURN);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public String getErrorMessege() {
        try{
            wait.until(ExpectedConditions.visibilityOf(error));
            return error.getText();
        } catch (Exception e) {
            return null;
        }
    }
}
