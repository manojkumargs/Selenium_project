package com.shoecarnival.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class readconfig {
	private Properties properties;

    public readconfig() {
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("E:\\ECLIPSE WORKSPACE\\Shoe_Carnival\\src\\test\\java\\com\\shoecarnival\\utilities\\config.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String main_url() {
    	return properties.getProperty("url");
    }
    
    public String path() {
    	return properties.getProperty("extentpath");
    }
    
    public String url1() {
    	return properties.getProperty("url1");
    }
    
    public String url2() {
    	return properties.getProperty("url2");
    }
    
    public String url3() {
    	return properties.getProperty("url3");
    }
    
    public String url4() {
    	return properties.getProperty("url4");
    }
    
    public String sspath() {
    	return properties.getProperty("sspath");
    }
    
    public String dateformat() {
    	return properties.getProperty("dateformat");
    }
    
    public String testoperations() {
    	return properties.getProperty("testoperations");
    }
}
