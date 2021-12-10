package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalInfo 
{
	public WebDriver driver;
	By firstNameEdt=By.id("firstname");
	By confirmPswdEdt=By.id("old_passwd");
	By saveBtn=By.name("submitIdentity");
	By sucessMsgEle=By.cssSelector("p[class='alert alert-success']");	
	public PersonalInfo(WebDriver driver) 
	{
		this.driver=driver;
	}
	public WebElement getFirstNameEdt()
	{
		return driver.findElement(firstNameEdt);
	}
	public WebElement getConfirmPswdEdt()
	{
		return driver.findElement(confirmPswdEdt);
	}
	public WebElement getSaveBtn()
	{
		return driver.findElement(saveBtn);
	}
	public WebElement getSucessMsgEle()
	{
		return driver.findElement(sucessMsgEle);
	}
}
