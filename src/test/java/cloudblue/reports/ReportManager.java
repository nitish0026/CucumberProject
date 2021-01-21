package cloudblue.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import cloudblue.utility.LogStatus;
import cloudblue.utility.LogUtil;
import com.aventstack.extentreports.reporter.configuration.Theme;
import cucumber.api.PickleStepTestStep;
import cucumber.api.Result;
import cucumber.api.Result.Type;
import cucumber.api.event.TestCaseFinished;
import cucumber.api.event.TestCaseStarted;
import cucumber.api.event.TestSourceRead;
import cucumber.api.event.TestStepFinished;
import gherkin.pickles.PickleTag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ReportManager{
	private ExtentReports extentReports;
	private ExtentTest extentTest;
	private Map<String, ExtentTest> features = new HashMap<String, ExtentTest>();
	private String reportName=System.getProperty("user.dir")+"\\HtmlReport\\Report_"+new SimpleDateFormat("dd_MM").format(new Date())+".html";
	private String reportConfigFilePath = System.getProperty("user.dir")+"/src/test/resources/extent-config.xml";
	ExtentSparkReporter extentSparkReporter;
	LogUtil logUtil = new LogUtil();
	static ExtentTest scenario;
	String log;
	private ExtentTest step;//TODO remove

	/**
	 * initialize ExtentSparkReporter
	 * load extent-config.xml
	 * initialize ExtentReporter and attach ExtentSparkReporter
	 */
	public void extentHtmlReporter(){
		extentSparkReporter = new ExtentSparkReporter(reportName);
		extentSparkReporter.loadXMLConfig(reportConfigFilePath);
//		extentSparkReporter.config().setReportName("Automation Testing");
//		extentSparkReporter.config().setTheme(Theme.DARK);
		logUtil.log(LogStatus.DEBUG, "ExtentSparkReporter object created for report file: "+reportName);
		extentReports=new ExtentReports();
		//extentSparkReporter.loadXMLConfig(reportConfigFilePath);
		extentReports.attachReporter(extentSparkReporter);
		extentReports.setSystemInfo("Operating System",System.getProperty("os.name"));
		extentReports.setSystemInfo("User Name",System.getProperty("user.name"));
	}
	/**
	 *ExtentTest
	 *@param started
	 *@return
	 */
	public ExtentTest onFeatureStart(TestSourceRead started){
		String featureName = started.uri.split(".*/")[1];
		logUtil.log(LogStatus.INFO, "Feature: "+featureName+" being read from source");
		features.putIfAbsent(featureName,extentReports.createTest(featureName));
		return extentTest;
	}

	/**
	 *void
	 *@param event
	 */
	public void onScenarioStart(TestCaseStarted event){
		String featureName = event.getTestCase().getUri().toString().split(".*/")[1];
		logUtil.log(LogStatus.INFO, "\n\n\n/************************* Scenario: "+event.testCase.getName()+" EXECUTION STARTED *************************/");
		scenario = features.get(featureName).createNode(event.getTestCase().getName());
	}

	/**
	 *void
	 *@param event
	 *@throws IOException
	 */
	public void onStepFinish(TestStepFinished event) throws IOException{
		if (event.testStep instanceof PickleStepTestStep) {
			PickleStepTestStep ev = (PickleStepTestStep) event.testStep;
			step=scenario.createNode(ev.getStepText());
			step.log((Status)step.getStatus(),log,base64ScreenCapture());
		}
	}

	/**
	 *void 
	 *@param event
	 *@throws IOException
	 */
	public void onScenarioEnd(TestCaseFinished event) throws IOException{
		Result result = event.result;
		String featureName = event.getTestCase().getUri().toString().split(".*/")[1];
		//		scenario.info(logger);
		assignCategory(event);
		if(result.getStatus()==Type.FAILED){
			logUtil.log(LogStatus.ERROR, "\n\n\n/************************* Scenario: "+event.testCase.getName()+" EXECUTION FAILED *************************/"+ result.getErrorMessage());
			scenario.fail(result.getError(),base64ScreenCapture());
		}
		else if(result.getStatus()==Type.PASSED){
			logUtil.log(LogStatus.INFO, "\n\n\n/************************* Scenario: "+event.testCase.getName()+" PASSED *************************/");
		}
		else if(result.getStatus()==Type.SKIPPED){
			scenario.skip(result.getError(),base64ScreenCapture());
			logUtil.log(LogStatus.WARN, "\n\n\n/************************* Scenario: "+event.testCase.getName()+" SKIPPED *************************/");
		}
	}
	/**
	 *void 
	 */
	public void writeReport() {
		logUtil.log(LogStatus.INFO, "Flushing "+reportName);
		extentReports.flush();
	}

	/**
	 *MediaEntityModelProvider 
	 *@return
	 *@throws IOException
	 */
	public MediaEntityModelProvider base64ScreenCapture() throws IOException{
		logUtil.log(LogStatus.INFO, "Capturing Screen Base64");
		String screenshot=new ScreenShotTaker().takeBase64ScreenShot();
		if(screenshot!=null) {
			return MediaEntityBuilder.createScreenCaptureFromBase64String(new ScreenShotTaker().takeBase64ScreenShot()).build();
		}
		else
		{
			return null;
		}
	}

	/**
	 *void 
	 *@param log
	 */
	public static void log(String log){
		//logger=logger+log;
		scenario.info(log);
//		scenario.info(MarkupHelper.createTable(log));
	}

	public void assignCategory(TestCaseFinished event){
		List<PickleTag> l = event.getTestCase().getTags();
		for(PickleTag p : l){
			scenario.assignCategory(p.getName());
		}
	}
}
