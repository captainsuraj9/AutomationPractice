package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderConfirmation 
{
	public WebDriver driver;
	By iConfirmOrderBtn=By.cssSelector("button[class='button btn btn-default button-medium'][type='submit']");
	public OrderConfirmation(WebDriver driver) 
	{
		this.driver=driver;
	}
	public WebElement getIConfirmOrderBtn()
	{
		return driver.findElement(iConfirmOrderBtn);
	}
}
