package org.example.Driver.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome implements DriverStrategy{

    @Override
    public WebDriver setStrategy(){
        String path ="C:\\mytools\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",path);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension",false);
        options.addArguments("--no-sandbox");
        return new ChromeDriver(options);
    }

}
