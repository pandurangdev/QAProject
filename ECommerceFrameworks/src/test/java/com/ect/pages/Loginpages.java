package com.ect.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class Loginpages
{
	WebDriver driver;
	public Loginpages(WebDriver idriver)
	{
		this.driver=idriver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@id=\"navbarText\"]/ul/li[2]/a") WebElement logimage;
	@FindBy(id="email") WebElement email;
	@FindBy(id="password") WebElement pass;
	@FindBy(id="customerloginForm") WebElement sub;	
	@FindBy(xpath="//*[@id=\"dropdownMenuButton\"]")WebElement logoutimage;
	@FindBy(xpath="//*[@id=\"navbarText\"]/ul/li[2]/div/div/a[2]") WebElement logout;
	public void portalLogin(String username,String password)
	{
		logimage.click();
		email.sendKeys(username);
		pass.sendKeys(password);
		sub.click();
		
		
	}
	public void logout()
	{
		logoutimage.click();
		logout.click();
	}
	

}
