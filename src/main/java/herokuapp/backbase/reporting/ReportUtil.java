package herokuapp.backbase.reporting;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.apache.commons.io.FileUtils;

import herokuapp.backbase.driver.DriverFactory;
import com.relevantcodes.extentreports.LogStatus;

public class ReportUtil {

	/**
	 * The WebDriver driver
	 */
	public static WebDriver driver;

	/**
	 * This method is called whenever a test case passes
	 * 
	 * @param detail
	 *            the detial for passed test case
	 */
	public static void logPass(String detail) {
		Assert.assertTrue(true, detail);
		ReportTestManager.getTest().log(LogStatus.PASS, detail);
		//ReportTestManager.getTest().addScreenCapture(captureScreenShot());
	}

	/**
	 * This method is called whenever a test case fails
	 * 
	 * @param detail
	 *            the detail for failed test case
	 */
	public static void logFail(String detail) {
		if (!(DriverFactory.getDriver() == null)) {
			ReportTestManager.getTest().log(
					LogStatus.FAIL,
					detail,
					ReportTestManager.getTest().addScreenCapture(
							captureScreenShot()));
			ReportTestManager.getTest().log(LogStatus.FAIL, detail);
		} else {
			ReportTestManager.getTest().log(LogStatus.FAIL, detail);
		}

	}

	/**
	 * This method is called whenever a test case is skipped
	 * 
	 * @param detail
	 *            the details for skipped test case
	 */
	public static void logSkipped(String detail) {
		ReportTestManager.getTest().log(LogStatus.SKIP, detail);
		// ReportTestManager.getTest().
	}

	/**
	 * This method is called whenever a test case is skipped
	 * 
	 * @param detail
	 *            the details for skipped test case
	 */
	public static void logInfo(String detail) {
		ReportTestManager.getTest().log(LogStatus.INFO, detail);
		// ReportTestManager.getTest().
	}
	
	/**
	 * This method is called to check if the element is displayed or not
	 * 
	 * @param by
	 *            reference element
	 */
	public static void isElementDisplayed(By by) {
		driver = DriverFactory.getDriver();

		if (driver.findElement(by).isDisplayed()) {
			logPass("Element Displayed Successfully");
		} else {
			logFail("Element not displayed");
		}
	}

	/**
	 * This method is called to check if any element is selected or not
	 * 
	 * @param by
	 *            reference element
	 */
	public static void isElementSelected(By by) {
		driver = DriverFactory.getDriver();

		if (driver.findElement(by).isSelected()) {
			logPass("Element is selected");
		} else {
			logFail("Element is not selected");
		}
	}

	/**
	 * This method is called to check if the element is enabled or not.
	 * 
	 * @param by
	 *            reference element
	 */
	public static void isElementEnabled(By by) {
		driver = DriverFactory.getDriver();
		if (driver.findElement(by).isEnabled()) {
			logPass("Element is Enabled");
		} else {
			logFail("Element is not enabled");
		}
	}

	/**
	 * capture the screenshot
	 * 
	 * @return the file of capture screenshot.
	 */
	public static String captureScreenShot() {
		File src = ((TakesScreenshot) DriverFactory.getDriver())
				.getScreenshotAs(OutputType.FILE);

		// now copy the screenshot to desired location using copyFile method
		String file = System.getProperty("user.dir")+"/Screenshots"
				+ System.currentTimeMillis() + ".png";
		try {
			FileUtils.copyFile(src, new File(file));
		} catch (IOException e) {
		}
		return file;
	}

}
