import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utils.ConfigReader;


@CucumberOptions(features = {"ConfigReader.getProperty(\"featurefiledirpath\")"},
        glue={"stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber.html", "json:target/Cucumber.json"}
)
public class Runner  extends AbstractTestNGCucumberTests {
}
