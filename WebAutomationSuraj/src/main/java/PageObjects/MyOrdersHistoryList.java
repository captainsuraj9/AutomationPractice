package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyOrdersHistoryList 
{
	public WebDriver driver;
	By myOrdersTblFirstCol=By.className("history_link bold footable-first-column");
	By myOrdersTbl=By.id("order-list");
	public MyOrdersHistoryList(WebDriver driver) 
	{
		this.driver=driver;
	}
	public WebElement getMyOrdersTblFirstCol()
	{
		return driver.findElement(myOrdersTblFirstCol);
	}
	public WebElement getMyOrdersTbl()
	{
		return driver.findElement(myOrdersTbl);
	}
}
