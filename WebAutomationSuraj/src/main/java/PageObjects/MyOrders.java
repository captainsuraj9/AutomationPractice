package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyOrders 
{
	public WebDriver driver;
	By myOrdersLnk=By.cssSelector("a[href*='controller=history']");
	By personalInfoLnk=By.cssSelector("a[href*='controller=identity']");
	public MyOrders(WebDriver driver) 
	{
		this.driver=driver;
	}
	public WebElement getMyOrdersLnk()
	{
		return driver.findElement(myOrdersLnk);
	}
	public WebElement getPersonalInfoLnk()
	{
		return driver.findElement(personalInfoLnk);
	}
}
