package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartSummary 
{
	public WebDriver driver;
	By proceedToCheckoutBtn=By.cssSelector("a[href*='order&step=1']");
	public ShoppingCartSummary(WebDriver driver) 
	{
		this.driver=driver;
	}
	public WebElement getProceedToCheckoutBtn()
	{
		return driver.findElement(proceedToCheckoutBtn);
	}

}