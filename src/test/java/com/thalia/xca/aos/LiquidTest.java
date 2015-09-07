package com.thalia.xca.aos;

import static org.junit.Assert.assertTrue;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.thalia.xca.aos.prop.AndroidCapabilities;

public class LiquidTest {
	
	private AndroidDriver<MobileElement> wd;
	private AndroidCapabilities aCap;

    @Before
    public void setUp() throws Exception {
    	aCap = new AndroidCapabilities();
    	wd = aCap.setCap();
    }
    
    @After
    public void tearDown() throws Exception {
    	wd.quit();
    }
    
    @Test
    public void registerTest() throws Exception {
    	
    	MobileElement element;
    	
    	element = wd.findElementById("com.example.rakatak.liquidrakatak:id/btnStart");
    	element.click();
    	
    	element = wd.findElementById("com.example.rakatak.liquidrakatak:id/btnAccount");
    	element.click();
    	
    	element = wd.findElementById("com.example.rakatak.liquidrakatak:id/btnRegister");
    	element.click();
    	
    	element = wd.findElementById("com.example.rakatak.liquidrakatak:id/nameField");
    	element.sendKeys("Solidus Snake");
    	
    	element = wd.findElementById("com.example.rakatak.liquidrakatak:id/emailField");
    	element.sendKeys("solidus@snake.com");
    	
    	element = wd.findElementById("com.example.rakatak.liquidrakatak:id/passwordField");
    	element.sendKeys("snake!");
    	
    	element = wd.findElementById("com.example.rakatak.liquidrakatak:id/btnRegister");
    	element.click();
    	
    	element = wd.findElementById("com.example.rakatak.liquidrakatak:id/displayName");
    	final String displayName = element.getText();

    	assertTrue("The username is not correctly displayed", displayName.equals("Solidus Snake"));
    	
    	element = wd.findElementById("com.example.rakatak.liquidrakatak:id/displayEmail");
    	final String displayEmail= element.getText();
    	
    	assertTrue("The user-email is not correctly displayed", displayEmail.equals("solidus@snake.com"));
    }
}
