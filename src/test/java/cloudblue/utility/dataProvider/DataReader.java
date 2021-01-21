package cloudblue.utility.dataProvider;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataReader
{


    public enum Environment{
        QA,Stag,Prod
    };
    static Properties prop;
    public DataReader(Environment env,String scenarioName) {
        try {
            String testClassFolderPath = "src/test/resources/testdata/" + env + "/" + scenarioName + ".properties";
            FileInputStream fileInputStream = new FileInputStream(testClassFolderPath);
            prop = new Properties();
            prop.load(fileInputStream);
        }
        catch(Exception e)
        {
        }
    }

    public static String get(String key)
    {
        return  prop.getProperty(key);
    }

}
