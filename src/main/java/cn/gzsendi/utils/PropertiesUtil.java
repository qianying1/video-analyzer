package cn.gzsendi.utils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * properties文件操作工具类,没时间写了,只提供简单的读写操作
 * @Author Nacht
 * Created on 03/12/2018
 */
public class PropertiesUtil {
    public static String getProperty(String filePath,String propertyName) throws IOException {
        Properties properties = new Properties();
         // 使用InPutStream流读取properties文件
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        properties.load(bufferedReader);
        bufferedReader.close();
        return properties.getProperty(propertyName);
    }
    public static void setProperty(String filePath,String propertyKey,String propertyValue) throws IOException {
        Properties properties = new Properties();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        properties.load(bufferedReader);
        properties.setProperty(propertyKey,propertyValue);
        properties.store(new FileOutputStream(new File(filePath)),"last modify: "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        bufferedReader.close();
    }
}
