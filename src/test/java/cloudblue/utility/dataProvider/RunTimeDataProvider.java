package cloudblue.utility.dataProvider;

import java.util.HashMap;

public class RunTimeDataProvider
{

    static HashMap<String,String> hashMap=new HashMap<>();
    public static  void store(String key, String value) throws ClassNotFoundException {
        hashMap.putIfAbsent(Class.forName(Thread.currentThread().getStackTrace()[2].getClassName()).getSimpleName().toLowerCase()+"_"+key,value);
    }
    public static  String get(String key)
    {
        return hashMap.get(key);
    }
}
