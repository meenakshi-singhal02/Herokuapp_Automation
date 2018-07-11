package herokuapp.backbase.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Enum for generating Specific Driver Type.
 */
public enum DriverType implements IDriverSetup {

	FIREFOX {

		public WebDriver getDriverObject(DesiredCapabilities dc) {

			// TODO Auto-generated method stub
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/Jars/geckodriver.exe");
			return new FirefoxDriver(dc);

		}

		public DesiredCapabilities getDesiredCapabilities(DriverConfig config) {
			// TODO Auto-generated method stub
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setBrowserName("firefox");
			System.out.println(config.getExplicitWaitTimeout());
			return capabilities;
		}

	},
	CHROME {

		public WebDriver getDriverObject(DesiredCapabilities dc) {
			System.setProperty("webdriver.chrome.driver",
					"E:\\Selenium_Jars\\Drivers\\chromedriver_win32\\chromedriver.exe");
			return new ChromeDriver(dc);

		}

		public DesiredCapabilities getDesiredCapabilities(DriverConfig config) {
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			System.out.println(config.getExplicitWaitTimeout());
			return capabilities;
		}
	},

	IE {

		public WebDriver getDriverObject(DesiredCapabilities dc) {
			// TODO Auto-generated method stub
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"/Jars/IEDriverServer.exe");			
			return new InternetExplorerDriver(dc);
		}

		public DesiredCapabilities getDesiredCapabilities(DriverConfig config) {
			// TODO Auto-generated method stub
			DesiredCapabilities capabilities =  DesiredCapabilities.internetExplorer();
			//cap.setJavascriptEnabled(true);
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			capabilities.setCapability("requireWindowFocus",true);
			capabilities.setCapability("ie.ensureCleanSession",true);
			capabilities.setCapability("ignoreZoomingSetting",true);
			return capabilities;
		}
	}
}
