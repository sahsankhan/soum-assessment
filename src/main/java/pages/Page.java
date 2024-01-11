package pages;

import core.utils.ConfigUtil;
import pages.android.HomePage;
import java.util.Properties;

public class Page {

    public static Properties myProp = ConfigUtil.getConfig("config");
    public static Properties androidconfig = ConfigUtil.getConfig("androidconfig");

    private final HomePage homePage = new HomePage(this);
    protected HomePage getHomePage() {return homePage;}
}
