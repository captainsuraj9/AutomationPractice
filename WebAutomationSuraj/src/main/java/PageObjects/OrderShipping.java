package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderShipping 
{
	public WebDriver driver;
	By iAgreeChkbox=By.name("cgv");
	By proceedToCheckoutBtn=By.name("processCarrier");
	public OrderShipping(WebDriver driver) 
	{
		this.driver=driver;
	}
	public WebElement getproceedToCheckoutBtn()
	{
		return driver.findElement(proceedToCheckoutBtn);
	}
	public WebElement getIAgreeChkbox()
	{
		return driver.findElement(iAgreeChkbox);
	}
}
