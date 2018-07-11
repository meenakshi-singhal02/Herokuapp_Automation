package herokuapp.backbase.utils;

import static org.testng.Assert.assertEquals;

import herokuapp.backbase.reporting.ReportUtil;

public class VerifyFunctions {	
	
	/**
	 * verify Strings
	 * 
	 * @return null
	 */
	public void verify(String actual, String expected, String details)
	{
		if(actual.contains(expected))
		{ 
			ReportUtil.logPass(details);
			}		
		else
		{
			ReportUtil.logFail(details);
		}
	}
	
	/**
	 * verify Integer
	 * 
	 * @return null
	 */
	public void verify(int actual, int expected, String details)
	{
		if(actual==expected)
		{ 
			ReportUtil.logPass(details);
			}		
		else
		{
			ReportUtil.logFail(details);
		}
	}
	
	/**
	 * verify double
	 * 
	 * @return null
	 */
	public void verify(double actual, double expected, String details)
	{
		if(actual==expected)
		{ 
			ReportUtil.logPass(details);
			}		
		else
		{
			ReportUtil.logFail(details);
		}
	}
	
	/**
	 * verify boolean
	 * 
	 * @return null
	 */
	public void verify(Boolean actual, Boolean expected, String details)
	{
		if(actual==expected)
		{ 
			ReportUtil.logPass(details);
			}		
		else
		{
			ReportUtil.logFail(details);
		}
	}
	
	
	

}
