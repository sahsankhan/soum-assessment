package step_defination.Android;

import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Condition;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.Page;
import java.util.List;
import java.util.Map;

public class HomeSteps extends Page {
    @When("[Home Page] App should open successfully")
    public void UserIsOnHomePageTitleTestingApp()  {
        Assert.assertTrue(getHomePage().getTitle().isDisplayed());
    }

    @And("^\\[Home Page\\] Verify the Version Code (.*)$")
    public void verifyTheCode(String versionCode) {
        Assert.assertEquals(getHomePage().getVersionCode().getText(),versionCode,"Verify Version Code");
    }

    @And("^\\[Home Page\\] Verify the Version Name (.*)$")
    public void verifyTheName(String versionName) {
        Assert.assertEquals(getHomePage().getVersionName().getText(),versionName,"Verify Version Name");
        getHomePage().getVersionName().isDisplayed();
    }

    @When("\\[Home Page\\] User tap on Button (.*)$")
    public void homePageUserTapOnButtonXxx(String button) {
        getHomePage().getButton(button).click();
    }

    @Then("[Home Page] Verify the Immediate Update button is visible")
    public void homePageVerifyTheImmediateUpdateButtonIsVisible() {
        getHomePage().getImmediateButton().isDisplayed();
    }

    @When("[Home Page] User tap on Immediate Update Button")
    public void homePageUserTapOnImmediateUpdateButton() {
        getHomePage().getImmediateButton().click();
    }

    @Then("[Home Page] Verify the three button options")
    public void updatePageVerifyTheThreeButtonOptions(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> itemData : rows) {
            if (itemData.containsKey("Button1")) {
                $(getHomePage().getButton("1")).shouldHave(Condition.exactText(itemData.get("Button1")));
            }
            if (itemData.containsKey("Button2")) {
                $(getHomePage().getButton("2")).shouldHave(Condition.exactText(itemData.get("Button2")));
            }
            if (itemData.containsKey("Button3")) {
                $(getHomePage().getButton("3")).shouldHave(Condition.exactText(itemData.get("Button3")));
            }
        }
    }

    @Then("\\[Home Page\\] Verify that Result (.*) is displayed$")
    public void homePageVerifyThatResul1IsVisible(String number) {
        Assert.assertEquals(getHomePage().getResult().getText(),"RESULT "+number,"Verify Result with Number");
        getHomePage().backButton();
    }

    @When("[Home Page] User tap on Flexible Update Button")
    public void homePageUserTapOnFlexibleUpdateButton() {
        getHomePage().getFlexibleButton().click();
    }

    @Then("[Home Page] Verify the Flexible Update button is visible")
    public void homePageVerifyTheFlexibleUpdateButtonIsVisible() {
        getHomePage().getFlexibleButton().isDisplayed();
    }
}