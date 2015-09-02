package com.thalia.xca.aos.prop;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

public class CopyOfAndroidCapabilities {
	
    public String userName;
    public String userEmail;
    public String password;	
    public double screenWidth;
    public double screenHeight;
    
    public CopyOfAndroidCapabilities (){
    	this.userName = "Solidus Snake";
    	this.userEmail = "xcabasicde@thqa.de";
    	this.password = "hummel123";
    }
    
	public AndroidDriver<MobileElement> setCap() throws InterruptedException, IOException{

		AndroidDriver<MobileElement> wd = null;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        
		capabilities.setCapability("platformName", "Android");
    	capabilities.setCapability("app", "/Users/Rakatak/Eclipse-Projects/LiquidRakatak/app/build/outputs/apk/app-debug.apk");
    	
		wd = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

        wd.manage().timeouts().implicitlyWait(AppiumSetup.timeOutfirst, TimeUnit.SECONDS);

    	String[] dimensions = wd.manage().window().getSize().toString().split("\\D");
		screenWidth = (double) Integer.parseInt(dimensions[1]);
		screenHeight = (double) Integer.parseInt(dimensions[3]);
		
        return wd;          

	}

	
	public void hitGoButton(AndroidDriver<MobileElement> wd){
		
		if (screenHeight == AppiumSetup.motoHeight){
			
			wd.tap(1, 705, 1123, 500);
//			((JavascriptExecutor)wd).executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", 1.0); put("touchCount", 1.0); put("duration", 0.5); put("x", 705.9); put("y", 1123.8); }});
			
		} else if (screenHeight == AppiumSetup.galaxyHeight){
			
			wd.tap(1, (int)(screenWidth*0.9281), (int)(screenHeight*0.9585), 500);
//			((JavascriptExecutor)wd).executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", 1.0); put("touchCount", 1.0); put("duration", 0.5); put("x", screenWidth*0.9281); put("y", screenHeight*0.9585); }});
			
		} else if (screenHeight == AppiumSetup.nexusHeight){
			
			wd.tap(1, (int)(screenWidth*0.8991), (int)(screenHeight*0.8281), 500);
//			((JavascriptExecutor)wd).executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", 1.0); put("touchCount", 1.0); put("duration", 0.5); put("x", screenWidth*0.8991); put("y", screenHeight*0.8281); }});
			
		}
	}
	
	public void scrollDownMenu(AndroidDriver<MobileElement> wd) throws InterruptedException{
		
		if (screenHeight == AppiumSetup.motoHeight) {
			wd.swipe((int)(screenWidth*0.7), (int)(screenHeight*0.8), (int)(screenWidth*0.8), (int)(screenHeight*0.15), 500);
//			((JavascriptExecutor)wd).executeScript("mobile: swipe", new HashMap<String, Double>() {{ put("touchCount", 1.0); put("startX", screenWidth*0.7); put("startY", screenHeight*0.8); put("endX", screenWidth*0.8); put("endY", screenHeight*0.15); put("duration", 0.5); }});
			Thread.sleep(3000);
			wd.swipe((int)(screenWidth*0.7), (int)(screenHeight*0.8), (int)(screenWidth*0.8), (int)(screenHeight*0.15), 500);
//			((JavascriptExecutor)wd).executeScript("mobile: swipe", new HashMap<String, Double>() {{ put("touchCount", 1.0); put("startX", screenWidth*0.7); put("startY", screenHeight*0.9); put("endX", screenWidth*0.8); put("endY", screenHeight*0.2); put("duration", 0.5); }});
		} else {
			
			wd.swipe((int)(screenWidth*0.7), (int)(screenHeight*0.8), (int)(screenWidth*0.7), (int)(screenHeight*0.15), 500);
//			((JavascriptExecutor)wd).executeScript("mobile: swipe", new HashMap<String, Double>() {{ put("touchCount", 1.0); put("startX", screenWidth*0.7); put("startY", screenHeight*0.8); put("endX", screenWidth*0.7); put("endY", screenHeight*0.20); put("duration", 0.5); }});
			Thread.sleep(3000);
			wd.swipe((int)(screenWidth*0.7), (int)(screenHeight*0.8), (int)(screenWidth*0.7), (int)(screenHeight*0.15), 500);
//			((JavascriptExecutor)wd).executeScript("mobile: swipe", new HashMap<String, Double>() {{ put("touchCount", 1.0); put("startX", screenWidth*0.7); put("startY", screenHeight*0.9); put("endX", screenWidth*0.8); put("endY", screenHeight*0.2); put("duration", 0.5); }});
		}
	}
}
