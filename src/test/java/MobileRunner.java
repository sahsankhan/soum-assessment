import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(io.cucumber.junit.Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features.app.android/HomePage.feature"},
        glue = {"src/test/java/step_defination"},
        plugin = { "pretty", "html:target/cucumber-reports" },
        monochrome = true,
        tags = "@homePage")

public class MobileRunner {
}