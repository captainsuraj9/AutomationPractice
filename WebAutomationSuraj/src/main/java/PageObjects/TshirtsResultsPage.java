package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TshirtsResultsPage 
{
	public WebDriver driver;
	By firstTShirtResult=By.cssSelector("img[src*='1-home_default.jpg']");
	public TshirtsResultsPage(WebDriver driver) 
	{
		this.driver=driver;
	}
	public WebElement getFirstTShirt()
	{
		return driver.findElement(firstTShirtResult);
	}
}
