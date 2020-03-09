package com.mycompany.mavenproject2.reporting;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Me;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import java.io.IOException;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 *
 * @author ClideP
 */
public class Reporter implements ITestListener
{
//MediaStorageManagerFactory media;
    static ExtentTest test;
    static ExtentReports report;
    ExtentHtmlReporter htmlReporter;


    public Reporter(String testName) {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+ "//Reports//" + testName + "Report.html");
        report = new ExtentReports();
        report.attachReporter(htmlReporter);
        htmlReporter.config().setReportName(testName);
//media = new MediaStorageManagerFactory();
    }

    public void startTest(String testName){
        test = report.createTest(testName);
    }


    public void getResult(ITestResult result, String shotPath) throws IOException {
        //Catches failed methods and logs it to the extent report
        if (result.getStatus() == ITestResult.FAILURE){
        test.log(Status.FAIL, result.getThrowable().getMessage());
        }

    }

    public void stepLog(String message){

        test.log(Status.INFO, message);

    }

    public void testPass(String message, String shotPath){
        try {
        test.addScreenCaptureFromPath(shotPath, message);
        }catch (Exception e){e.getMessage();}

        test.log(Status.PASS, message);
        test.log(Status.PASS, message);

    }

    public void testFail(String message){

        test.log(Status.FAIL, message);

    }

    public void onFinish(){

        report.flush();

    }

}
