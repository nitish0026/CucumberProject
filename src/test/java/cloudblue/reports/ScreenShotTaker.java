package cloudblue.reports;

import cloudblue.utility.browser.Browser;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import cloudblue.utility.LogStatus;
import cloudblue.utility.LogUtil;

public class ScreenShotTaker{
	private LogUtil logUtil;
	public ScreenShotTaker(){
		 logUtil = new LogUtil();
	}

	public String takeBase64ScreenShot(){
		if(Browser.getEventDriver() == null ){
			logUtil.log(LogStatus.WARN,"Driver object is: " + Browser.getEventDriver());
			return null;
		} else{
			return ((TakesScreenshot)Browser.getEventDriver()).getScreenshotAs(OutputType.BASE64);
		}
	}
}