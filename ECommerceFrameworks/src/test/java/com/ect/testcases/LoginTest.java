package com.ect.testcases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.ect.pages.BaseClass;
import com.ect.pages.Loginpages;
import com.ect.utilities.ReadExcelFile;
public class LoginTest extends BaseClass {
    //WebDriver driver;
    String filename = System.getProperty("user.dir")+"\\TestData\\ETestData.xlsx";
    @Test(dataProvider = "loginDataProvider")
    public void verify(String user, String pass) throws IOException {
        Loginpages lp = new Loginpages(driver);
    	lp.portalLogin(user, pass);
        // Null check for credentials
        Assert.assertNotNull(user, "Username is null!");
        Assert.assertNotNull(pass, "Password is null!");
        if(user.equals("ravi@dhiyotech.in") && pass.equals("Demo"))
        {
        	Assert.assertTrue(true);
        	lp.logout();

        }
        else
        {
        	captureScreensShot(driver,"verify");
        	Assert.assertTrue(false);
        }
        // Perform login
        lp.portalLogin(user, pass);

    }
    @DataProvider
    public String[][] loginDataProvider() {
        int row = ReadExcelFile.getRowCount(filename, "Login");
        int col = ReadExcelFile.getColCount(filename, "Login");
        String[][] data = new String[row - 1][col];
        for (int i = 1; i < row; i++) { // Start from row 1 (skipping headers)
            for (int j = 0; j < col; j++) {
                data[i - 1][j] = ReadExcelFile.getCellValue(filename, "Login", i, j);
                }
        }
        return data;
    }
}
