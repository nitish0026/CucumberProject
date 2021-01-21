
package cloudblue.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfig implements IReader {
    private Properties properties;
    private String currentDirPath = System.getProperty("user.dir");

    private void initPropertiesFile(String filename) {
        if (isDefaultProperties(filename)) {
            properties = getDataFromProperties(currentDirPath + "\\src\\test\\resources\\config.properties");
        } else {
            properties = getDataFromProperties(filename);
        }
    }

    public ReadConfig() {
        initPropertiesFile("");
    }

    public ReadConfig(String file) {
        initPropertiesFile(file);
    }

    private Properties getDataFromProperties(String filename) {
        String path = ReferencePath.config;//try to make it generic
        Properties prop = new Properties();
        try {
            InputStream inputStream = new FileInputStream(new File(path));
            prop.load(inputStream);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return prop;
    }

    private boolean isDefaultProperties(String filename) {
        if ("".equalsIgnoreCase(filename)) {
            return true;
        }
        return false;
    }

    @Override
    public String getApplicationUrl() {
        return properties.getProperty("ApplicationUrl");
    }

    @Override
    public String getBrowser() {
        return properties.getProperty("BrowserName", "chrome");
    }

    @Override
    public String getDriver() {
        return currentDirPath + properties.getProperty("Driver");
    }

    public String getReportConfigPath() {
        return currentDirPath + properties.getProperty("reportConfigPath");
    }

    public String getEnvironment() {
        return properties.getProperty("environment");
    }
}
