
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.ConstructorOrMethod;
import org.testng.*;
import org.testng.annotations.DataProvider;
import org.testng.internal.ConstructorOrMethod;
import com.mycompany.mavenproject2.reporting.Reporter;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author ClideP
 */

public class Listener implements ITestListener, ISuiteListener, IInvokedMethodListener
{

public Reporter report;
    public Listener() throws Exception {
      report = new Reporter("OMF Test");
    }



    @Override
    public void onStart(ITestContext testContext){
//        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+ testName + "//testRep.html");
//        report = new ExtentReports();
//        report.attachReporter(htmlReporter);
    }


    @Override
    public void onTestSuccess(ITestResult result){

//       test = report.createTest(result.getName());
//        test.log(Status.PASS, result.getName());
    }


    @Override
    public void onTestFailure(ITestResult result){
//
//        test = report.createTest(result.getName());
//        test.log(Status.FAIL, result.getThrowable().getMessage());
    }


    @Override
    public void onFinish(ITestContext testContext){

        report.onFinish();
    }


    
}
