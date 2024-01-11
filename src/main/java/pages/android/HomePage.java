package pages.android;

import core.utils.AndroidCore.AndroidDriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.Page;

public class HomePage {

    private String titleXpath = "//android.view.ViewGroup/android.widget.TextView";
    private String immediateButtonID = "com.meritnation.store.testingapp:id/btn1";
    private String flexibleButtonID = "com.meritnation.store.testingapp:id/btn2";
    private String versionCodeID ="com.meritnation.store.testingapp:id/ver_code";
    private String versionNameID ="com.meritnation.store.testingapp:id/ver_name";
    private String resultText ="com.meritnation.store.testingapp:id/txt";

    public HomePage(Page page) {
    }

    public WebElement getTitle() {
        return (AndroidDriverSetup.getAndroidDriver().findElement(By.xpath(titleXpath)));
    }

    public WebElement getVersionCode() {
        return (AndroidDriverSetup.getAndroidDriver().findElement(By.id(versionCodeID)));
    }

    public WebElement getVersionName() {
        return (AndroidDriverSetup.getAndroidDriver().findElement(By.id(versionNameID)));
    }

    public WebElement getButton(String num) {
        return (AndroidDriverSetup.getAndroidDriver().findElement(By.id("com.meritnation.store.testingapp:id/btn"+num)));
    }

    public WebElement getImmediateButton() {
        return (AndroidDriverSetup.getAndroidDriver().findElement(By.id(immediateButtonID)));
    }

    public WebElement getFlexibleButton() {
        return (AndroidDriverSetup.getAndroidDriver().findElement(By.id(flexibleButtonID)));
    }

    public WebElement getResult() {
        return (AndroidDriverSetup.getAndroidDriver().findElement(By.id(resultText)));
    }

    public void backButton() {
         AndroidDriverSetup.getAndroidDriver().navigate().back();
    }
}
