package cloudblue.runner.odin;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/cloudblue/featureFile/odin/customer.feature"},
        glue = {"cloudblue.stepDefinitions","cloudblue.utility.steps"},
        plugin = {"cloudblue.stepDefinitions.CucumberListener"}
)
public class CustomerRunner {
}
