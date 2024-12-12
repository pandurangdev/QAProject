package com.ect.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataClass 
{
    Properties pro;

    public ConfigDataClass()
    {
        File src = new File("./Configuration/config.properties");
        try {
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis); // Load the properties file
        } catch (FileNotFoundException e) {
            System.out.println("Config file not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error loading config file: " + e.getMessage());
        }
    }
    public String getBrowser()
    {
      return pro.getProperty("browser");	
    }
    public String getURL()
    {
    	return pro.getProperty("url");
    }
}
