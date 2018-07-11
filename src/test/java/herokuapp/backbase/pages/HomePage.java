package herokuapp.backbase.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import herokuapp.backbase.reporting.ReportUtil;
import herokuapp.backbase.utils.DateFunctions;
import herokuapp.backbase.utils.VerifyFunctions;
import herokuapp.elements.Button;
import herokuapp.elements.Element;
import herokuapp.elements.Element.LocatorType;
import herokuapp.elements.Link;
import herokuapp.elements.TextField;

public class HomePage {

	WebDriver driver;
	private static Link lnkAddANewComputer = new Link("add", LocatorType.ID);
	private static TextField txtComputerName = new TextField("name", LocatorType.ID);
	private static TextField txtIntroducedDate = new TextField("introduced", LocatorType.ID);
	private static TextField txtDiscontinuedDate = new TextField("discontinued", LocatorType.ID);	
	private static Button btnCreateThisComputer = new Button("//input[@value='Create this computer']", LocatorType.XPATH);
	private static Button btnUpdateThisComputer = new Button("//input[@value='Save this computer']", LocatorType.XPATH);
	private static Button btnDeleteThisComputer = new Button("//input[@value='Delete this computer']", LocatorType.XPATH);

	
	//Search Object
	private static TextField txtSearchBox = new TextField("searchbox", LocatorType.ID);
	private static Button btnSearchSubmit = new Button("searchsubmit", LocatorType.ID);
	
	//Alert objects	
	private static Element lbComputerNotDisplayed = new Element("//em[text()='Nothing to display']", LocatorType.XPATH);
	private static Element lbWarning = new Element("//div[@class='alert-message warning']", LocatorType.XPATH);
	
	//Table details
	private static Element lbTableDate = new Element("//table[@class='computers zebra-striped']/tbody/tr/td[2]", LocatorType.XPATH);

	public static VerifyFunctions verify;
	public static DateFunctions dateFunctions;
	
	
	
	static
	{
		try {
			 verify =new VerifyFunctions();	
			 dateFunctions = new DateFunctions();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
public HomePage(WebDriver driver)
{
	try {
		this.driver=driver;
	} catch (Exception e) {
		e.printStackTrace();
	}
}


public void addANewComputer(Properties propData, boolean bVerify)
{
try {
	searchForComputer(propData, false);
	if(!(lbComputerNotDisplayed.isDisplayed()))
	{
	selectComputer(propData.getProperty("computerName"));
	btnDeleteThisComputer.click();
	}	
	lnkAddANewComputer.click();
	txtComputerName.Type(propData.getProperty("computerName"));
	txtIntroducedDate.Type(propData.getProperty("introduceDate"));
	txtDiscontinuedDate.Type(propData.getProperty("discontinuedDate"));
	Select selectCompany = new Select(driver.findElement(By.id("company")));
	selectCompany.selectByVisibleText(propData.getProperty("companyName"));
	btnCreateThisComputer.click();
	if(bVerify)
	{
	verify.verify(lbWarning.getText(), "Computer "+ propData.getProperty("computerName")+" has been created", "Verified computer added successfully");
	}
} catch (Exception e) {
	e.printStackTrace();
}
}

public void updateAComputer(Properties propData, boolean bVerify)
{
try {
	searchForComputer(propData, false);
	if((lbComputerNotDisplayed.isDisplayed()))
	{
		verify.verify(true, false, "Please add Computer details then update");
	}
	else
	{
	selectComputer(propData.getProperty("computerName"));
	txtIntroducedDate.clearandType(propData.getProperty("updatedintroduceDate"));
	btnUpdateThisComputer.click();
	if(bVerify)
	{
	verify.verify(lbWarning.getText(), "Computer "+ propData.getProperty("computerName")+" has been updated", "Verified computer updated successfully");
	searchForComputer(propData, false);	
	
	verify.verify(lbTableDate.getText(), dateFunctions.dateConvert(propData.getProperty("updatedintroduceDate")), "Verified computer date also displayed correct in the table");
	}
	}  
} catch (Exception e) {
	e.printStackTrace();
}

}

public void deleteAComputer(Properties propData, boolean bVerify)
{
	searchForComputer(propData, false);
	if(!(lbComputerNotDisplayed.isDisplayed()))
	{
	selectComputer(propData.getProperty("computerName"));
	btnDeleteThisComputer.click();
	if(bVerify)
	{
	verify.verify(lbWarning.getText(), "Computer has been deleted", "Verified computer deleted successfully");
	}}
	else
	{
		ReportUtil.logPass("Computer not found in the list");
		System.out.println("Computer not found in the list");
	}
}

public void searchForComputer(Properties propData, Boolean bVerify)
{
	txtSearchBox.sendKeys(propData.getProperty("computerName"));
	btnSearchSubmit.click();
	if(bVerify)
	{
		Link lnkAddANewComputer = new Link(propData.getProperty("computerName"), LocatorType.LINK_TEXT);	
		verify.verify(lnkAddANewComputer.isDisplayed(), true, "Verified computer displayed successfully");
	}
}

public void selectComputer(String sComputerName)
{
	Link lnkSelectComputer = new Link(sComputerName, LocatorType.LINK_TEXT);
	lnkSelectComputer.click();
}
	
}


