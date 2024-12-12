package com.ect.testcases;
import org.testng.annotations.Test;
import com.ect.pages.BaseClass;
import com.ect.pages.Loginpages;
import com.ect.pages.SearchPage;
public class SearchTestCase extends BaseClass 
{
	@Test
	public void searchProduct()
	{
		lp=new Loginpages(driver);
		lp.portalLogin(username, password);
		SearchPage sp=new SearchPage(driver);
		sp.searchProduct();
	}

}
