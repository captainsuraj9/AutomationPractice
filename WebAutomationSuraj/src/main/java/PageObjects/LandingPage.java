/**
 * 
 */
package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage 
{
	public WebDriver driver;
	By signIn=By.cssSelector("a[href*='my-account']");
	public LandingPage(WebDriver driver) 
	{
		this.driver=driver;
	}
	public WebElement getSignIn() 
	{
		 return driver.findElement(signIn);
		 		
	}

}
