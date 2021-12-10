package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderAddress 
{
	public WebDriver driver;
	By addNewAddressBtn=By.cssSelector("a[title='Add']");
	By proceedToCheckoutBtn=By.name("processAddress");
	public OrderAddress(WebDriver driver) 
	{
		this.driver=driver;
	}
	public WebElement getproceedToCheckoutBtn()
	{
		return driver.findElement(proceedToCheckoutBtn);
	}
}