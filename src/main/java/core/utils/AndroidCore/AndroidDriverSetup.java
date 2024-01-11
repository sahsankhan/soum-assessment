package core.utils.AndroidCore;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndroidDriverSetup {
    private static ThreadLocal<AndroidDriver<AndroidElement>> androidDriver = new ThreadLocal<>();

    public static synchronized void androidDriver(String port) throws IOException {
        AndroidDriver<AndroidElement> driver;
            driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:" + port + "/wd/hub"), CapabilitiesGenerator.getAndroidCapabilities());
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        androidDriver.set(driver);
        System.out.println("Android driver selected:\n");
    }

    public static void quitAndroidDriver() {
        try {
            AndroidDriverSetup.getAndroidDriver().removeApp("io.appium.uiautomator2.server");
            AndroidDriverSetup.getAndroidDriver().removeApp("io.appium.uiautomator2.server.test");
            AndroidDriverSetup.getAndroidDriver().removeApp("io.appium.settings");
            AndroidDriverSetup.getAndroidDriver().removeApp("io.appium.unlock");
            AppiumServerRunner.stopServer();
            if (AndroidDriverSetup.androidDriver.get() != null) {
                androidDriver.get().quit();
                androidDriver = null;
            } else {
                System.out.println("TestCases Flow");
            }
        } catch (Exception e) {
            System.out.println("Error While Executing the  Quite Driver");
        }
    }

    public static AndroidDriver<AndroidElement> getAndroidDriver() {
        if (androidDriver.get() != null) {
            return androidDriver.get();
        } else {
            System.out.println("TestCases Flow");
            throw new IllegalStateException("Driver has not been initialized. " +
                    "Please use OS platform tag on test scenario and call WebDriverFactory before use this method");
        }
    }
}