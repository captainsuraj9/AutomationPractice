package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderSuccessful 
{
	public WebDriver driver;
	By orderStatusEle=By.className("cheque-indent");
	By orderTextEle=By.className("box");
	By accountNameLnk=By.className("account");
	public OrderSuccessful(WebDriver driver) 
	{
		this.driver=driver;
	}
	public WebElement getOrderStatusEle()
	{
		return driver.findElement(orderStatusEle);
	}
	public WebElement getOrderTextEle()
	{
		return driver.findElement(orderTextEle);
	}
	public WebElement getAccountNameLnk()
	{
		return driver.findElement(accountNameLnk);
	}

}
