/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;


import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 *
 * @author ClideP
 */
public class DriverUtility extends Utility
{
            private String browserType;
        public static WebDriver driver;
        public WebDriverWait wait;
        public static  String site = "";

public DriverUtility(){
System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe"); 
System.setProperty("webdriver.firefox.driver", "C:\\selenium\\geckodriver.exe");
}

 public void Start() throws IOException {

     try
     {
                   System.out.println(getTime());
            browserType = getProperty("Browser");
            if (browserType.equalsIgnoreCase("chrome"))
            {
                ChromeOptions chromeOptions = new ChromeOptions();
                this.driver = new ChromeDriver(chromeOptions);}
            else if (browserType.equalsIgnoreCase("firefox"))
            {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                this.driver = new FirefoxDriver(firefoxOptions);
            }
            else if (browserType.equalsIgnoreCase("edge"))
            {
                EdgeOptions edgeOptions = new EdgeOptions();
                this.driver = new EdgeDriver(edgeOptions);
            }


        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,30);  
     } catch (Exception e)
     {
        System.out.println(e);
     }


        }

        public WebElement findLocator(By locator){
            return driver.findElement(locator);
        }

        public String screenShot(){
        TakesScreenshot shot = (TakesScreenshot) driver;
        String s =  shot.getScreenshotAs(OutputType.BASE64); //"data:image/png;base64," +
        return s;
        }

        public void website(String website) {
            driver.get(website);
        }

    public boolean waitForElement(WebElement element){
        try
        {
                  WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));  
        } catch (Exception e)
        {
            return false;
        }

        return true;
    }

    public boolean waitForElementClickable(WebElement element){
        
        try
        {
               WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.elementToBeClickable(element)); 
        } catch (Exception e)
        {
            return false;
        }
return true;
    }
    
        public boolean clickElement(WebElement element){
        
        try
        {
               WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.elementToBeClickable(element)).click(); 
        } catch (Exception e)
        {
            return false;
        }
return true;
    }
        
                public String getText(WebElement element){
        String text;
        try
        {
               WebDriverWait wait = new WebDriverWait(driver, 10);
    text = wait.until(ExpectedConditions.visibilityOf(element)).getText(); 
        } catch (Exception e)
        {
            return "";
        }
return text;
    }
}
