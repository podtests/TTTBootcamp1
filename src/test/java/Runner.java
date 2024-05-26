import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = {"src/test/resources/Login.feature"},
        glue={"stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber.html", "json:target/Cucumber.json"}
)
public class Runner  extends AbstractTestNGCucumberTests {
}
