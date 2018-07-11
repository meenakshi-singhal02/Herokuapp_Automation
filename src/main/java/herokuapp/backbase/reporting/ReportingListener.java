package herokuapp.backbase.reporting;

import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.internal.IResultListener;

public class ReportingListener implements IResultListener {

	/**
	 * This method is called at test start.
	 */
	public void onTestStart(ITestResult result) {
		ReportUtil.logInfo("Test Case Started");
	}

	/**
	 * This method is called on test success
	 */
	public void onTestSuccess(ITestResult result) {
		ReportUtil.logInfo("Test Case Completed");
	}

	/**
	 * This method is called on test failure
	 */
	public void onTestFailure(ITestResult result) {
		if (result.getThrowable() != null) {
			ReportUtil.logFail("Test Case Fails with following message:: "
					+ result.getThrowable().getMessage());
		}
	}

	/**
	 * This method is called when a test is skipped
	 */
	public void onTestSkipped(ITestResult result) {
		
		//Method method = null;
		// TODO Auto-generated method stub
		ReportTestManager.startTest(result.getMethod().getMethodName());
		ReportTestManager.getTest().assignCategory(
				result.getMethod().getRealClass().getSimpleName());
		System.out.println("INSIDE SKIPPED");
		ReportUtil.logSkipped("Test Case Skipped");
		ReportTestManager.endTest();
		ReportManager.getReporter().flush();
	}
	
	public void beforeSkip(Method method) {
		
	}

	/**
	 * This method is called when a test case fails but with certain success
	 * percentage
	 */
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	/**
	 * This method is called on start of test start
	 */
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	/**
	 * This method is called when a test finishes
	 */
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

	/**
	 * This method is called on configuration success
	 */
	public void onConfigurationSuccess(ITestResult itr) {
		// TODO Auto-generated method stub

	}

	/**
	 * This method is called on configuration failure
	 */
	public void onConfigurationFailure(ITestResult itr) {
		// TODO Auto-generated method stub

	}

	/**
	 * This method is called in configuration skip
	 */
	public void onConfigurationSkip(ITestResult itr) {
		// TODO Auto-generated method stub

	}

}
