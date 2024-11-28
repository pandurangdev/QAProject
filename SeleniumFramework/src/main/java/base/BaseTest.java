package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.dockerjava.transport.DockerHttpClient.Request.Method;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
public class BaseTest {
    // Static variables
    public static WebDriver driver;
    public static ExtentSparkReporter sparkReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;
    @BeforeTest
    public void beforeTestMethod() {
        // Manual path for report file
        String reportPath = "C:\\Users\\Asus\\OneDrive\\Desktop\\TestReports\\testreports.html";
        // Initialize ExtentSparkReporter
        sparkReporter = new ExtentSparkReporter(reportPath);
        // Configuring the Report Appearance
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle("Automation Execution Report");
        sparkReporter.config().setReportName("Test Execution Report");
        // Initialize ExtentReports and attach the reporter
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        // Setting system information
        extent.setSystemInfo("OS", "Windows 11");
        extent.setSystemInfo("Tester", "Pandurang Padghan");
        extent.setSystemInfo("Browser", "Firefox");
    }
    @BeforeMethod
    @Parameters("browser")
    public void beforeMethodMethod(String browser,Method testMethod) {
    	//logger=extent.createTest(testMethod.getName());
        logger = extent.createTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        setupDriver(browser);
    }
    @AfterMethod
    public void afterMethod(ITestResult result) 
    {
        // Quit the driver after each test method
        if (result.getStatus()==ITestResult.FAILURE) 
        {
        	logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"-Test Case Failed",ExtentColor.RED));
        	logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+"-Test Case Failed",ExtentColor.RED));
        }
        else if(result.getStatus()==ITestResult.SKIP)
        {
        	logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+"-Test Case Skipped",ExtentColor.ORANGE));

        }
        else if(result.getStatus()==ITestResult.SUCCESS)
        {
        	logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+"-Test Case PASS",ExtentColor.GREEN));

        }
        driver.quit();
    }
    @AfterTest
    public void afterTestMethod() {
        // Flush the report at the end of the test suite
        if (extent != null) {
            extent.flush();
        }
    }
    public void setupDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
    }
}
