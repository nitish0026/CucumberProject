package cloudblue.runner.uxone;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src\\test\\java\\cloudblue\\featureFile\\uxone\\customerCreationInL2.feature"},
        glue = {"cloudblue.stepDefinitions"},
        plugin = {"cloudblue.stepDefinitions.CucumberListener",})

    public class CustomerUxOneL2Runner {

    }
