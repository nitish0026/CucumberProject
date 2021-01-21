package cloudblue.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LogUtil {
	static{System.setProperty("logback.configurationFile", System.getProperty("user.dir")+"//logback.xml");}
	Logger log = null;
	
	public LogUtil(){
		 try {
			log = LoggerFactory.getLogger(Class.forName(Thread.currentThread().getStackTrace()[2].getClassName()));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			log = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
		}
	}
	public void log(LogStatus LogStatus, String msg){
		if(LogStatus.equals(cloudblue.utility.LogStatus.INFO)){
			log.info(msg);
		}
		else if(LogStatus.equals(cloudblue.utility.LogStatus.DEBUG)){
			log.debug(msg);
		}
		else if(LogStatus.equals(cloudblue.utility.LogStatus.TRACE)){
			log.trace(msg);
		}
		else if(LogStatus.equals(cloudblue.utility.LogStatus.ERROR)){
			log.error(msg);
		}
		else if(LogStatus.equals(cloudblue.utility.LogStatus.WARN)){
			log.warn(msg);
		}
		
	}
	
	public void log(LogStatus LogStatus, String msg, Throwable throwable){
		if(LogStatus.equals(cloudblue.utility.LogStatus.INFO)){
			log.info(msg,throwable);
		}
		else if(LogStatus.equals(cloudblue.utility.LogStatus.DEBUG)){
			log.debug(msg,throwable);
		}
		else if(LogStatus.equals(cloudblue.utility.LogStatus.TRACE)){
			log.trace(msg,throwable);
		}
		else if(LogStatus.equals(cloudblue.utility.LogStatus.ERROR)){
			log.error(msg,throwable);
		}
		else if(LogStatus.equals(cloudblue.utility.LogStatus.WARN)){
			log.warn(msg,throwable);
		}
		
	}
}
