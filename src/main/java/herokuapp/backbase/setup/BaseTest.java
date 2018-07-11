package herokuapp.backbase.setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentTest;

import herokuapp.backbase.driver.DriverFactory;
import herokuapp.backbase.reporting.ReportManager;
import herokuapp.backbase.reporting.ReportTestManager;
import herokuapp.backbase.utils.LoadProperties;

public class BaseTest {

	/**
	 * The ExtentTest test
	 */
	protected ExtentTest test;
	
	/**
	 * The WebDriver driver
	 */
	protected static WebDriver driver;
	
	/**
	 * @BeforSuite: Will start the reporter for reporting purposes
	 */
	@BeforeSuite
	public void mainSetup() {
		System.out.println("Before Suite");
		ReportManager.getReporter("./Reports/Reporter.html");
	}
	
	/**
	 * @param test
	 */
	@BeforeTest
	public void instantiaze(ITestContext test) {

	}

	/**
	 * @BeforeMethod: setting up the prerequisites before running any test
	 * @param test the test to execute
	 * @param method TestMethod to start
	 */
	@BeforeMethod(alwaysRun = true)
	public void setup(ITestContext test, Method method) {
		Properties propData;
		LoadProperties properties;
		System.out.println("in before method");
		DriverFactory.initiateDriver(test.getCurrentXmlTest().getParameter(
				"browser"));
		driver=DriverFactory.getDriver();
		driver.manage().window().maximize();
		ReportTestManager.startTest(method.getName());
		System.out.println(ReportTestManager.getTest().toString());
		ReportTestManager.getTest().assignCategory(
				method.getDeclaringClass().getSimpleName());
		properties = new LoadProperties();
		 try {
			propData = properties.loadProperties("main");
			driver.get(propData.getProperty("url"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
	/**
	 * @AfterMethod: To shutdown the driver and quit the driver.
	 * @param method the TestMethod to stop.
	 * @throws InterruptedException
	 */
	@AfterMethod
	public void tearDown(ITestContext test,Method method) throws InterruptedException {
		DriverFactory.quitDriver();
		ReportTestManager.endTest();
		ReportManager.getReporter().flush();
	}

}
