package cloudblue.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src\\test\\java\\cloudblue\\featureFile\\odin"},
        glue = {"cloudblue.stepDefinitions"},
        plugin = {"cloudblue.stepDefinitions.CucumberListener",})//{ "pretty","html:target/cucumber-html-report","json:target/cucumber.json","junit:target/cucumber.xml","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class PostRunner {

}
