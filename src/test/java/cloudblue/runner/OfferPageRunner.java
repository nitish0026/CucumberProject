package cloudblue.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/cloudblue/featureFile/offers.feature"},
        glue = {"cloudblue.stepDefinitions","cloudblue.utility.steps"},
        plugin = {"cloudblue.stepDefinitions.CucumberListener"})
public class OfferPageRunner {}
