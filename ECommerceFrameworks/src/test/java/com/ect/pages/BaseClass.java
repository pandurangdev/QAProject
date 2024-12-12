package com.ect.pages;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.ect.utilities.BrowserFactory;
import com.ect.utilities.ConfigDataClass;
import com.ect.utilities.ReadExcelFile;
public class BaseClass {
    // File path for the test data file
    String filename = System.getProperty("user.dir") + "\\TestData\\ETestData.xlsx";
    // WebDriver instance
    public WebDriver driver;
    // Configuration and Utility objects
    public ConfigDataClass config = new ConfigDataClass();
    public ReadExcelFile rf = new ReadExcelFile();
    // Page objects and credentials
    protected Loginpages lp;
    protected String username = ReadExcelFile.getCellValue(filename, "Login", 1, 0);
    protected String password = ReadExcelFile.getCellValue(filename, "Login", 1, 1);
   //Setup method to initialize the WebDriver and application
    @BeforeClass
    public void setup() {
        driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getURL());
        lp = new Loginpages(driver); // Initialize Loginpages (if required in tests)
    }
    public void captureScreensShot(WebDriver driver,String testName) throws IOException
    {
    	//Convert webdriver object to TakeScreenShot  interface
    	TakesScreenshot screenshot =((TakesScreenshot)driver);
    	//step2:call get screenshots as method to capture image file
    	File src=screenshot.getScreenshotAs(OutputType.FILE);
    	File srcpath=new File("."+"//Screenshots//"+testName+".png");
    	System.out.println("This is screenshot section");
    	//step3:copy image file to destination
    	FileUtils.copyFile(src, srcpath);
    	
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
