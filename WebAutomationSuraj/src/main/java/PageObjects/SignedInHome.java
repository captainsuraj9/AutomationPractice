package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignedInHome 
{
	public WebDriver driver;
	By signOutLnk=By.cssSelector("a[href*='mylogout=']");
	By tShirtsLnk=By.cssSelector("a[title='T-shirts'][href*='id_category=5']");
	By usernameLnk=By.cssSelector("a[href*='=my-account']");
	
	public SignedInHome(WebDriver driver) 
	{
		this.driver=driver;
	}

	public WebElement getSignOutLnk()
	{
		return driver.findElement(signOutLnk);
	}
	
	public WebElement getTShirtsLnk()
	{
		return driver.findElement(tShirtsLnk);
	}
	
	public WebElement getUsernameLnk()
	{
		return driver.findElement(usernameLnk);
	}
	
}
