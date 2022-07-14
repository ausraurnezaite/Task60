package com.coherensolutions.traning.automation.java.web.urnezaite;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerClass extends BaseTest implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getTestContext().getName() + "_" + result.getName());
        captureScreenshot(result.getTestContext().getName() + "_" + result.getName() + ".png");
    }
}