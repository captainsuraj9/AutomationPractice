package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectedTshirtPageOpened 
{
	public WebDriver driver;
	By addTshirtCountBtn=By.className("icon-plus");
	By addToCartBtn=By.id("add_to_cart");
	By proceedToCheckoutBtn=By.cssSelector("a[href*='controller=order']");

	public SelectedTshirtPageOpened(WebDriver driver) 
	{
		this.driver=driver;
	}

	public WebElement getAddTshirtCountBtn()
	{
		return driver.findElement(addTshirtCountBtn);
	}
	
	public WebElement getAddToCartBtn()
	{
		return driver.findElement(addToCartBtn);
	}
	public WebElement getProceedToCheckoutBtn()
	{
		return driver.findElement(proceedToCheckoutBtn);
	}


}