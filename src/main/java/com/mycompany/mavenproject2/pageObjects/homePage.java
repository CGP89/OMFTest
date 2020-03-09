/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.pageObjects;
import com.mycompany.mavenproject2.DriverUtility;
import com.mycompany.mavenproject2.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 *
 * @author ClideP
 */
public class homePage extends DriverUtility
{
      public boolean result;

    //remove if not needed
    Utility util;
    public homePage() throws Exception
            { 
    super();
        PageFactory.initElements(driver, this);

        //remove if not needed
        result = true;
        util = new Utility();
}

    @FindBy(xpath = "//a[@href='personal-loans']")
    @CacheLookup
    private WebElement personalLoansBtn;
    
    @FindBy(xpath = "//div[contains(@class,'repCalc50k')]")
    @CacheLookup
    private WebElement Calc50k;
    
    @FindBy(xpath = "//div[contains(@class,'repCalc84m')]")
    @CacheLookup
    private WebElement Calc84m;
    
      @FindBy(xpath = "//span[@id='paymin']")
    @CacheLookup
    private WebElement minAmount;
        
      @FindBy(xpath = "//span[@id='paymax']")
    @CacheLookup
    private WebElement maxAmount;
    
    
      @FindBy(xpath = "  //a[text()='View Breakdown']")
    @CacheLookup
    private WebElement viewBreakdownBtn;
      
            @FindBy(xpath = "//h3[text()='Capital']")
    @CacheLookup
    private WebElement capital;

   @FindBy(xpath = "//h3[text()='Term']")
    @CacheLookup
    private WebElement term;

      
    public boolean navigateToHomePage(String site){
        driver.navigate().to(site);
       return true;
    }
    public boolean validatePersonalLoansBtn(){
        if (!waitForElement(personalLoansBtn))
        {
            return false;
        }
        return true;
    }
    
    public boolean navigateToPersonalLoans(){
        if (!clickElement(personalLoansBtn))
        {
            return false;
        }
        return true;
    }
        public boolean validate50Kbtn(){
        if (!waitForElement(Calc50k))
        {
            return false;
        }
        return true;
    }
                public boolean click50Kbtn(){
        if (!clickElement(Calc50k))
        {
            return false;
        }
        return true;
    }
                
       public boolean click84Monthsbtn(){
        if (!clickElement(Calc84m))
        {
            return false;
        }
        return true;
    }
       
       public boolean validateMinAmounts(){
           if (!getText(minAmount).contains("R1,463.04"))
           {
               return false;
           }
           return true;
       }
       
              public boolean validateMaxAmounts(){
           if (!getText(maxAmount).contains("R1,642.59"))
           {
               return false;
           }
           return true;
       }
              public boolean clickBreakdown(){
                  
                  if (!clickElement(viewBreakdownBtn))
                  {
                      return false;
                  }
                  return true;
              }
              
              public boolean validateBreakdown(){
                  if (!waitForElement(term))
                  {
                    return false;  
                  }
                 if (!waitForElement(capital))
                  {
                    return false;  
                  }
                  return true;
              }
}
