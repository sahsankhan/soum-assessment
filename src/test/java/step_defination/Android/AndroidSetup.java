package step_defination.Android;

import core.utils.AndroidCore.CapabilitiesGenerator;
import io.cucumber.java.*;

import java.io.IOException;
import java.util.Collection;

import static core.utils.AndroidCore.AndroidDriverSetup.androidDriver;
import static core.utils.AndroidCore.AndroidDriverSetup.quitAndroidDriver;
import static core.utils.AndroidCore.AppiumServerRunner.StartAppiumServer;
import static pages.Page.myProp;

public class AndroidSetup {
    public static String PLATFORM_NAME = myProp.getProperty("platformname").toLowerCase();
    public static String PORT = myProp.getProperty("appiumport");

    @Before
    public void BeforeLogging(Scenario scenario) throws IOException {
        Collection<String> tags = scenario.getSourceTagNames();
        CapabilitiesGenerator.scenario.set(scenario);
        CapabilitiesGenerator.tags.set(tags);

        switch (PLATFORM_NAME) {
            case "android":
                if (tags.contains("@android")) {
                        StartAppiumServer(PORT);
                         androidDriver(PORT);
                }
                break;
            default:
                throw new IllegalStateException("Please enter valid OS platform.");
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        switch (PLATFORM_NAME) {
            case "android":
                if (CapabilitiesGenerator.tags.get().contains("@final")) {
                    quitAndroidDriver();
                }
                break;
            default:
                throw new IllegalStateException("Please enter valid OS platform.");
        }
    }

}
