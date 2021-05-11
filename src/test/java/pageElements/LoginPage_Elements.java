package pageElements;


import org.openqa.selenium.By;

import core.utilities.ElementProperties;
import core.utilities.ElementTypes;



public interface LoginPage_Elements {
	
	ElementProperties Search_Icn = new ElementProperties(
			By.cssSelector(".collapsiblelink"),
			"Search Icon", 
			ElementTypes.BUTTON,   
			"NO_FRAME");

}
