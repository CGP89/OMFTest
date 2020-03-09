/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.mavenproject2.reporting.Reporter;
import com.mycompany.mavenproject2.pageObjects.homePage;
import com.mycompany.mavenproject2.DriverUtility;
import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 *
 * @author ClideP
 */
public class TestOMF extends DriverUtility
{
        Reporter report;
    String site;
homePage home;


    public TestOMF() throws Exception {
        report = new Reporter("Test");
        Start();
        site = getProperty("testUrl");
    }
    
    @BeforeMethod
    public void setUp() throws Exception{
        //EXAMPLE
   home = new homePage();
    }
    
    
    @Test (priority = 1)
    public void HomeTest() throws IOException, InterruptedException {
        //EXAMPLE
        report.startTest("Navigation");
        home.navigateToHomePage(site);
        report.stepLog("navigated to " + site);

        Assert.assertTrue(home.validatePersonalLoansBtn());
        report.testPass("Successfully navigated to Home Page", screenShot());

    }
        @Test (priority = 2)
    public void personalLoans() throws IOException, InterruptedException {
        //EXAMPLE
        report.startTest("Personal Loans");
        home.navigateToPersonalLoans();
        report.stepLog("navigated to " + "Personal Loans page");

        Assert.assertTrue(home.validate50Kbtn());
        report.testPass("Successfully navigated to Personal Loans Page", screenShot());

    }
    
            @Test (priority = 3)
    public void validateAmounts() throws IOException, InterruptedException {
        //EXAMPLE
        report.startTest("Validate Amounts");
        home.click50Kbtn();
        home.click84Monthsbtn();
        
       
        report.stepLog("navigated to " + "Personal Loans page");

        Assert.assertTrue(home.validateMinAmounts() &&  home.validateMaxAmounts());
        report.testPass("Successfully calculated amounts", screenShot());

    }
                @Test (priority = 4)
    public void validateBreakdown() throws IOException, InterruptedException {
        //EXAMPLE
        report.startTest("Validate Breakdown");
  home.clickBreakdown();
 
        
       
        report.stepLog("Validated Breakdown ");

        Assert.assertTrue( home.validateBreakdown());
        report.testPass("Successfully validated Breakdown", screenShot());

    }
    
        @AfterMethod
    public void teardown(ITestResult result) throws IOException, InterruptedException
    {
        report.getResult(result, screenShot());
  
    }

    @AfterClass
    public void teardown2() {
              report.onFinish();
        driver.quit();
    }
}
