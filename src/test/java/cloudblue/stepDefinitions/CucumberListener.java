package cloudblue.stepDefinitions;

import java.io.IOException;

import cloudblue.utility.dataProvider.DataReader;
import com.aventstack.extentreports.ExtentTest;

import cloudblue.reports.ReportManager;
import cucumber.api.event.EventHandler;
import cucumber.api.event.EventListener;
import cucumber.api.event.EventPublisher;
import cucumber.api.event.TestCaseFinished;
import cucumber.api.event.TestCaseStarted;
import cucumber.api.event.TestRunFinished;
import cucumber.api.event.TestRunStarted;
import cucumber.api.event.TestSourceRead;
import cucumber.api.event.TestStepFinished;
import cucumber.api.event.TestStepStarted;

public class CucumberListener implements EventListener {
	ReportManager manager = new ReportManager();
	DataReader dataReader;
	ExtentTest test;
	private EventHandler<TestCaseStarted> testCaseStartedHandler = new EventHandler<TestCaseStarted>() {

		@Override
		public void receive(TestCaseStarted event) {
			manager.onScenarioStart(event);
		}
	};

	@Override
	public void setEventPublisher(EventPublisher publisher) {
		publisher.registerHandlerFor(TestCaseStarted.class, testCaseStartedHandler);
		publisher.registerHandlerFor(TestCaseFinished.class, testCaseFinsihedHandler);
		publisher.registerHandlerFor(TestSourceRead.class, testSourceRead);
		publisher.registerHandlerFor(TestRunStarted.class, testRunStarted);
		publisher.registerHandlerFor(TestRunFinished.class, testRunFinished);
		publisher.registerHandlerFor(TestStepFinished.class, testStepFinished);
	}

	private EventHandler<TestCaseFinished> testCaseFinsihedHandler = new EventHandler<TestCaseFinished>() {

		@Override
		public void receive(TestCaseFinished event) {
			try {
				manager.onScenarioEnd(event);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	};
	private EventHandler<TestStepStarted> testStepStarted = new EventHandler<TestStepStarted>() {

		@Override
		public void receive(TestStepStarted event) {
//			manager.onStepStart(event);
		}
	};
	
	private EventHandler<TestSourceRead > testSourceRead = new EventHandler<TestSourceRead>() {

		@Override
		public void receive(TestSourceRead event) {
			
             manager.onFeatureStart(event);
		}
	};
	
	private EventHandler<TestRunStarted> testRunStarted = new EventHandler<TestRunStarted>() {

		@Override
		public void receive(TestRunStarted event) {
			manager.extentHtmlReporter();
		}
	};
	
	private EventHandler<TestRunFinished> testRunFinished = new EventHandler<TestRunFinished>() {

		@Override
		public void receive(TestRunFinished event) {
			manager.writeReport();
		}
	};
	
	private EventHandler<TestStepFinished> testStepFinished = new EventHandler<TestStepFinished>() {

		@Override
		public void receive(TestStepFinished event) {
			try {
				manager.onStepFinish(event);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	};
}
