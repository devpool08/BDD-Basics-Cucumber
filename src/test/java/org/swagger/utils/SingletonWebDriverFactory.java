package org.swagger.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SingletonWebDriverFactory {
    private static volatile SingletonWebDriverFactory factory;
    private static final ThreadLocal<WebDriver> local = new ThreadLocal<>();

    private SingletonWebDriverFactory() {
    }

    private void setDriver(String browser) {
        switch ((browser)) {
            case "chrome":
                local.set(new ChromeDriver());
                break;
            case "firefox":
                local.set(new FirefoxDriver());
                break;
            case "edge":
                local.set(new EdgeDriver());
                break;
            default:
                throw new InvalidWebDriverException("Invalid browser name: " + browser);
        }
    }

    public WebDriver getDriver() {
        return local.get();
    }

    public static SingletonWebDriverFactory getInstance(String browser) {
        if (factory == null) {
            synchronized (SingletonWebDriverFactory.class) {
                if (factory == null) {
                    factory = new SingletonWebDriverFactory();
                }
            }
        }
        if (local.get() == null) {
            factory.setDriver(browser);
        }
        return factory;
    }

    public void quitDriver() {
        WebDriver driver = local.get();
        if (driver != null) {
            driver.quit();
            local.remove();
        }
    }
}