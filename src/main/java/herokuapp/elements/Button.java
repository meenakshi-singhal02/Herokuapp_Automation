package herokuapp.elements;

import org.openqa.selenium.By;


/**
 * Button Specific implementation for WebElements
 *
 */
public class Button extends Element {
	

	/**
	 * Constructor invoking super.
	 * @param by : The by reference to set.
	 */
	public Button(By by) {
		super(by);
		// TODO Auto-generated constructor stub
	}

	/**
	 * constructor invoking super.
	 * 
	 * @param locator
	 *            : The locator to set.
	 * @param locatorType
	 *            : The locatorType to set.
	 */
	public Button(String locator, LocatorType locatorType) {
		super(locator,locatorType);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Performs the submit operation over any webelement
	 */
	public void submit() {
		getElement();
		element.submit();
	}

}
