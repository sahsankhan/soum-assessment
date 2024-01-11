package core.utils.AndroidCore;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.Scenario;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Collection;

import static pages.Page.androidconfig;

public class CapabilitiesGenerator {
    public static ThreadLocal<Scenario> scenario = new ThreadLocal<>();
    public static ThreadLocal<Collection<String>> tags = new ThreadLocal<>();
    public static String App;

    public static int getAnyFreePort() throws IOException {
        ServerSocket s = new ServerSocket(0);
        return s.getLocalPort();
    }

    public static DesiredCapabilities getAndroidCapabilities() throws IOException {
        String appDir = System.getProperty("user.dir") + "/apk/";
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, androidconfig.getProperty("platformName"));
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, androidconfig.getProperty("platformVersion"));
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, androidconfig.getProperty("deviceName"));
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, androidconfig.getProperty("automationName"));
        cap.setCapability(MobileCapabilityType.APP, appDir + androidconfig.getProperty("androidapk"));
        cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, "true");
        cap.setCapability(MobileCapabilityType.ACCEPT_INSECURE_CERTS, "true");
        cap.setCapability(MobileCapabilityType.FULL_RESET, "true");
        cap.setCapability(MobileCapabilityType.NO_RESET, "false");
        return cap;
    }
}
