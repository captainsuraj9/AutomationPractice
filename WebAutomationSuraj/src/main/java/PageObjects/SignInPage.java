package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage 
{
	public SignInPage(WebDriver driver) 
	{
		this.driver=driver;
	}
	public WebDriver driver;
	By email=By.id("email");
	By pwd=By.id("passwd");
	By signInBtn=By.id("SubmitLogin");
	
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getPswd()
	{
		return driver.findElement(pwd);
	}
	
	public WebElement getSignInBtn()
	{
		return driver.findElement(signInBtn);
	}

}
