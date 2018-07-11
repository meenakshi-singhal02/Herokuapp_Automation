package herokuapp.backbase.reporting;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;

public class ReportManager {


	/**
	 * The ExtentReports extent
	 */
	private static ExtentReports extent;

	/**
	 * This method gets the reporter instance setting the filepath and network
	 * mode
	 * 
	 * @param filePath
	 *            the filepath to store report
	 * @return
	 */
	public synchronized static ExtentReports getReporter(String filePath) {
		if (extent == null) {
			extent = new ExtentReports(filePath, true, NetworkMode.OFFLINE);
		}
		return extent;
	}

	public synchronized static ExtentReports getReporter() {
		return extent;
	}
}