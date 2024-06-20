package com.example.genericutility;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersImplementation extends BaseClass implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		if (!result.isSuccess()) {

			try {

				captureScreenshot(result.getMethod().getMethodName(), "failed");
			} catch (IOException e) {

			}
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		if (result.isSuccess()) {
			try {

				captureScreenshot(result.getMethod().getMethodName(), "success");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void captureElementScreenshot(WebElement element, String testName, String resultType) {
		try {

			captureScreenshot(testName + "_element_" + element.getAttribute("name"), resultType);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {

	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
	}
}
