package Core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.dc;

public class Helper {
    DesiredCapabilities dc = new DesiredCapabilities();
    static AndroidDriver driver;

    public AndroidDriver apkLaunch() throws InterruptedException, MalformedURLException {
        dc.setCapability(MobileCapabilityType.UDID, "0adfed0e");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "OnePlus 7Pro");
        dc.setCapability("platformVersion", "11.0");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        Thread.sleep(6000);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), (Capabilities) dc);
        return driver;

    }
}
