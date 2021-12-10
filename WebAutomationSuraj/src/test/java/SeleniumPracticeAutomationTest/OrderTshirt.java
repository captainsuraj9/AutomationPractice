package SeleniumPracticeAutomationTest;

import java.io.IOException;
import java.util.List;
import java.util.function.ToIntFunction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.MyOrders;
import PageObjects.MyOrdersHistoryList;
import PageObjects.OrderAddress;
import PageObjects.OrderConfirmation;
import PageObjects.OrderShipping;
import PageObjects.OrderSuccessful;
import PageObjects.PaymentsPage;
import PageObjects.SelectedTshirtPageOpened;
import PageObjects.ShoppingCartSummary;
import PageObjects.SignInPage;
import PageObjects.SignedInHome;
import PageObjects.TshirtsResultsPage;
import Resources.Base;

public class OrderTshirt extends Base 
{
	public static Logger log=LogManager.getLogger(OrderTshirt.class.getName());
	@BeforeTest
	public void beforeTest() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	JavascriptExecutor executor;
	@Test(dataProvider="getData")
	public void orderTshirt(String username,String password,String quantity) throws IOException, InterruptedException 
	{
		LandingPage lp=new LandingPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(lp.getSignIn()));
		Assert.assertTrue(lp.getSignIn().isDisplayed());
		log.info("Landing page is displayed");
		lp.getSignIn().click();
		SignInPage sp=new SignInPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(sp.getEmail()));
		sp.getEmail().sendKeys(username);
		sp.getPswd().sendKeys(password);
		sp.getSignInBtn().click();
		log.info("Entered credentials and SignIn button clicked");
		SignedInHome si=new SignedInHome(driver);
		wait.until(ExpectedConditions.elementToBeClickable(si.getSignOutLnk()));
		Assert.assertTrue(si.getSignOutLnk().isDisplayed());
		log.info("User is signed in");
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", si.getTShirtsLnk());
		log.info("TShirts link clicked");
		TshirtsResultsPage tp=new TshirtsResultsPage(driver);
		tp.getFirstTShirt().click();
		SelectedTshirtPageOpened stpo=new SelectedTshirtPageOpened(driver);
		Assert.assertTrue(stpo.getAddTshirtCountBtn().isDisplayed());
		log.info("Selected tshirt page opened");
		wait.until(ExpectedConditions.elementToBeClickable(stpo.getAddTshirtCountBtn()));
		//clicking on count plus button as per quantity
		for(int i=1;i<Integer.parseInt(quantity);i++)
		{
			stpo.getAddTshirtCountBtn().click();
		}
		wait.until(ExpectedConditions.elementToBeClickable(stpo.getAddToCartBtn()));
		stpo.getAddToCartBtn().click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(stpo.getProceedToCheckoutBtn()));
		action.moveToElement(stpo.getProceedToCheckoutBtn()).click().perform();
		stpo.getProceedToCheckoutBtn().click();
		Thread.sleep(3000);
		ShoppingCartSummary scs=new ShoppingCartSummary(driver);
		Assert.assertTrue(scs.getProceedToCheckoutBtn().isDisplayed());
		log.info("Add to cart successful");
		scs.getProceedToCheckoutBtn().click();
		Thread.sleep(2000);
		OrderAddress oa=new OrderAddress(driver);
		wait.until(ExpectedConditions.elementToBeClickable(oa.getproceedToCheckoutBtn()));
		action.moveToElement(oa.getproceedToCheckoutBtn()).click().perform();
		OrderShipping os=new OrderShipping(driver);
		wait.until(ExpectedConditions.elementToBeClickable(os.getproceedToCheckoutBtn()));
		os.getIAgreeChkbox().click();
		os.getproceedToCheckoutBtn().click();
		PaymentsPage pp=new PaymentsPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(pp.getPaymentMethodLnk()));
		pp.getPaymentMethodLnk().click();
		OrderConfirmation oc=new OrderConfirmation(driver);
		wait.until(ExpectedConditions.elementToBeClickable(oc.getIConfirmOrderBtn()));
		action.moveToElement(oc.getIConfirmOrderBtn()).click().perform();
		OrderSuccessful osu=new OrderSuccessful(driver);
		wait.until(ExpectedConditions.elementToBeClickable(osu.getOrderStatusEle()));
		Assert.assertEquals(osu.getOrderStatusEle().getText(), "Your order on My Store is complete.");
		String orderNumber=getOrderNumber(osu.getOrderTextEle().getText());
		log.info("Order is successful "+orderNumber);
		osu.getAccountNameLnk().click();
		MyOrders mo=new MyOrders(driver);
		wait.until(ExpectedConditions.elementToBeClickable(mo.getMyOrdersLnk()));
		mo.getMyOrdersLnk().click();
		MyOrdersHistoryList mohl=new MyOrdersHistoryList(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("order-list")));
		System.out.println(driver.findElements(By.partialLinkText(orderNumber)).size());
		Assert.assertEquals(driver.findElements(By.partialLinkText(orderNumber)).isEmpty(), false);
		log.info("Order is present in order history "+orderNumber);
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		Object[][] data=new Object[1][3];
		data[0][0]=Base.getCelldata(1,0);
		data[0][1]=Base.getCelldata(1,1);
		data[0][2]=Base.getCelldata(1,2);
		return data;
	}
	@AfterTest
	public void closeDriver()
	{
		driver.close();
	}
	
	public static String getOrderNumber(String str)
	{
		String[] strArr=str.split("reference");
		String orderNumber=strArr[1];
		orderNumber=orderNumber.substring(1,10);
		return orderNumber;
	}

}
