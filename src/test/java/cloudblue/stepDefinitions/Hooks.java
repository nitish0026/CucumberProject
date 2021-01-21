package cloudblue.stepDefinitions;

import cloudblue.utility.ReadConfig;
import cloudblue.utility.dataProvider.DataReader;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {
    DataReader dataReader;
    ReadConfig readConfig = new ReadConfig();

    @Before
    public void setUp(Scenario scenario) throws IOException {
        System.out.println(scenario.getName());
//        ReportManager manager = new ReportManager();
//        manager.extentHtmlReporter();
        String environment = readConfig.getEnvironment();
        DataReader dataReader;
        switch (environment.toLowerCase()) {
            case "qa":
                dataReader = new DataReader(DataReader.Environment.QA, scenario.getName().replace(" ", ""));
                break;
            case "staging":
                dataReader = new DataReader(DataReader.Environment.Stag, scenario.getName().replace(" ", ""));
                break;
            case "prod":
                dataReader = new DataReader(DataReader.Environment.Prod, scenario.getName().replace(" ", ""));
                break;

        }

    }


    @After
    public void tearDown(Scenario scenario) {

    }


}


