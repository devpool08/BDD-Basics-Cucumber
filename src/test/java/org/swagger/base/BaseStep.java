package org.swagger.base;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.swagger.utils.SingletonWebDriverFactory;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

@Log4j2
@SuppressWarnings({"unused", "ResultOfMethodCallIgnored"})
public class BaseStep {
    public WebDriver driver;
    public SingletonWebDriverFactory factory;
    public Properties properties;
    public FileReader reader;

    @SneakyThrows
    public void setUp() {
        factory = SingletonWebDriverFactory.getInstance("chrome");
        driver = factory.getDriver();
        loadProperties();
        driver.manage().window().maximize();
        log.info("setUp completed for {}", this.getClass().getName());
    }
    public void openPage(String URL) {
        driver.get(URL);
        log.info("{} url is opened", URL);
    }
    public String captureScreenshot(String name) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
        String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + name + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);
        sourceFile.renameTo(targetFile);
        return targetFilePath;
    }
    @SneakyThrows
    public void loadProperties() {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tearDown() {
        factory.quitDriver();
        log.info("{} test Completed Successfully", this.getClass().getName());
    }

}
