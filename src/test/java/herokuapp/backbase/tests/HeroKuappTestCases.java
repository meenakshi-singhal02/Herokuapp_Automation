package herokuapp.backbase.tests;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import herokuapp.backbase.pages.HomePage;
import herokuapp.backbase.setup.BaseTest;
import herokuapp.backbase.utils.LoadProperties;
import herokuapp.backbase.utils.VerifyFunctions;

public class HeroKuappTestCases extends BaseTest {
	
	public static  Properties propData;
	public static LoadProperties properties;
	public static HomePage homepg;
	
	/**
	 * loading data once 
	 * 
	 * @return null
	 */
	static
	{
		try {
			 properties = new LoadProperties();
			 propData = properties.loadProperties("Data");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * verify new computer added
	 * 
	 * @return null
	 */
	@Test(priority=1)
	public void verifyNewComputerAddedSuccessfully()
	{
		homepg = new HomePage(driver);
		homepg.addANewComputer(propData,true);
	}
	
	/**
	 * verify search
	 * 
	 * @return null
	 */
	@Test(priority=2)
	public void verifySearch()
	{
		homepg = new HomePage(driver);
		homepg.searchForComputer(propData, true);
	}
	
	/**
	 * verify computer detail updated successfully
	 * 
	 * @return null
	 */
	@Test(priority=3)
	public void verifyComputerDetailsUpdatedSuccessFully()
	{
		homepg = new HomePage(driver);
		homepg.updateAComputer(propData, true);
	}
	
	/**
	 * verify computer delete successfully
	 * 
	 * @return null
	 */
	@Test(priority=4)
	public void verifyComputerDeletedSuccessfully()
	{
		homepg = new HomePage(driver);
		homepg.deleteAComputer(propData, true);
	}


}