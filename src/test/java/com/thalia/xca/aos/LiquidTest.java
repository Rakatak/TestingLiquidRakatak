package com.thalia.xca.aos;

import static org.junit.Assert.assertTrue;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import com.thalia.xca.aos.prop.AbstractExcAction;
import com.thalia.xca.aos.prop.AndroidCapabilities;

public class LiquidTest {
	
	private AndroidDriver<MobileElement> wd;
	private AndroidCapabilities aCap;

    @Before
    public void setUp() throws Exception {
    	aCap = new AndroidCapabilities();
    	wd = aCap.setCap();
    }
    
    @Test
    public void registerTest() throws Exception {
    	
    	MobileElement element;
    	
    	element = wd.findElementById("com.example.rakatak.liquidrakatak:id/startbutton");
    	
    	element = wd.findElementByName("Start Pouring	");
    }
    
    
    
    
    
    
    
 
    
    @Test
    public void countrySelectionTest() throws Exception {

    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
								    	
		    	eName = "eu.thalia.app:id/accountsettings_item";
				element = wd.findElementById(eName);		
				element.click();
				Thread.sleep(1000);
			
				eName = "eu.thalia.app:id/prefs_mandant_and_username";
				element = wd.findElementById(eName);
		    	Thread.sleep(500);
		    	
		    	assertTrue("User preferences doesn't match the shop selection", element.getAttribute("name").contains("Deutschland"));	
		    }
    	};	
    	action.performAction();
    }
      
}
