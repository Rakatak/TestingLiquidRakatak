package com.thalia.xca.aos.prop;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidCapabilities {
	
	public AndroidDriver<MobileElement> setCap() throws InterruptedException, IOException{

		final String currentUser = System.getProperty("user.name");

		AndroidDriver<MobileElement> wd = null;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "Cubot");
		
        if (!currentUser.equals("jenkins")){	
        	
	    	capabilities.setCapability("app", "/Users/Rakatak/Eclipse-Projects/LiquidRakatak/app/build/outputs/apk/app-debug.apk");
			wd = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
			
        } else {
        	
        	final String port = System.getProperty("PORT");
    		final File currentDir = new File(System.getProperty("user.dir"));

    		String jenkinsPath = currentDir + "/app/build/outputs/apk/app-debug.apk";

        	capabilities.setCapability("app", jenkinsPath);
            wd = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:" + port + "/wd/hub"), capabilities);
        }
	    
        wd.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

        return wd;          

	}
}
