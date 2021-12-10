package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentsPage 
{
	public WebDriver driver;
	By paymentMethodLnk=By.className("bankwire");
	public PaymentsPage(WebDriver driver) 
	{
		this.driver=driver;
	}
	public WebElement getPaymentMethodLnk()
	{
		return driver.findElement(paymentMethodLnk);
	}
}
