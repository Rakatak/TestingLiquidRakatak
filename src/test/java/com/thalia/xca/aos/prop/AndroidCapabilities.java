package com.thalia.xca.aos.prop;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidCapabilities {
	
    public AndroidCapabilities (){
    }
    
	public AndroidDriver<MobileElement> setCap() throws InterruptedException, IOException{

		AndroidDriver<MobileElement> wd = null;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "Cubot");
    	capabilities.setCapability("app", "/Users/Rakatak/Eclipse-Projects/LiquidRakatak/app/build/outputs/apk/app-debug.apk");
    	
		wd = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

        wd.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

        return wd;          

	}
}
