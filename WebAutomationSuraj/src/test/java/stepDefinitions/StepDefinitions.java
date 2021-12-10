package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import PageObjects.LandingPage;
import PageObjects.MyOrders;
import PageObjects.MyOrdersHistoryList;
import PageObjects.OrderAddress;
import PageObjects.OrderConfirmation;
import PageObjects.OrderShipping;
import PageObjects.OrderSuccessful;
import PageObjects.PaymentsPage;
import PageObjects.PersonalInfo;
import PageObjects.SelectedTshirtPageOpened;
import PageObjects.ShoppingCartSummary;
import PageObjects.SignInPage;
import PageObjects.SignedInHome;
import PageObjects.TshirtsResultsPage;
import Resources.Base;

public class StepDefinitions extends Base 
{
	JavascriptExecutor executor;
	@Given("user is on landing page of {string}")
	public void user_is_on_landing_page_of(String string) throws IOException 
	{
		driver=initializeDriver();
		driver.get(string);
	}
	@When("user log in to the application with {string} and {string}")
	public void user_log_in_to_the_application_with_and(String string, String string2) 
	{
		LandingPage lp=new LandingPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(lp.getSignIn()));
		Assert.assertTrue(lp.getSignIn().isDisplayed());
		lp.getSignIn().click();
		SignInPage sp=new SignInPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(sp.getEmail()));
		sp.getEmail().sendKeys(string);
		sp.getPswd().sendKeys(string2);
		sp.getSignInBtn().click();
	}
	@Then("user should be able to log in")
	public void user_should_be_able_to_log_in() 
	{
		SignedInHome si=new SignedInHome(driver);
		wait.until(ExpectedConditions.elementToBeClickable(si.getSignOutLnk()));
		Assert.assertTrue(si.getSignOutLnk().isDisplayed());

	}
	@Then("user should be able to add {string} of tshirt to cart")
	public void user_should_be_able_to_add_of_tshirt_to_cart(String string) throws InterruptedException 
	{
		SignedInHome si=new SignedInHome(driver);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", si.getTShirtsLnk());
		TshirtsResultsPage tp=new TshirtsResultsPage(driver);
		tp.getFirstTShirt().click();
		SelectedTshirtPageOpened stpo=new SelectedTshirtPageOpened(driver);
		Assert.assertTrue(stpo.getAddTshirtCountBtn().isDisplayed());
		wait.until(ExpectedConditions.elementToBeClickable(stpo.getAddTshirtCountBtn()));
		//clicking on count plus button as per quantity
		for(int i=1;i<Integer.parseInt(string);i++)
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
		
	}
	@Then("user should be able to order those tshirts")
	public void user_should_be_able_to_order_those_tshirts() throws InterruptedException 
	{
		ShoppingCartSummary scs=new ShoppingCartSummary(driver);
		Assert.assertTrue(scs.getProceedToCheckoutBtn().isDisplayed());
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
		osu.getAccountNameLnk().click();
		MyOrders mo=new MyOrders(driver);
		wait.until(ExpectedConditions.elementToBeClickable(mo.getMyOrdersLnk()));
		mo.getMyOrdersLnk().click();
		MyOrdersHistoryList mohl=new MyOrdersHistoryList(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("order-list")));
		System.out.println(driver.findElements(By.partialLinkText(orderNumber)).size());
		Assert.assertEquals(driver.findElements(By.partialLinkText(orderNumber)).isEmpty(), false);
	}
	
	@Then("user should be able to update the existing username to {string} using {string}")
	public void user_should_be_able_to_update_the_existing_username(String updatedUsername,String password)
	{
		SignedInHome si=new SignedInHome(driver);
		wait.until(ExpectedConditions.elementToBeClickable(si.getSignOutLnk()));
		Assert.assertTrue(si.getSignOutLnk().isDisplayed());
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", si.getUsernameLnk());
		MyOrders mo=new MyOrders(driver);
		wait.until(ExpectedConditions.elementToBeClickable(mo.getPersonalInfoLnk()));
		Assert.assertTrue(mo.getPersonalInfoLnk().isDisplayed());
		mo.getPersonalInfoLnk().click();
		PersonalInfo pi=new PersonalInfo(driver);
		wait.until(ExpectedConditions.elementToBeClickable(pi.getSaveBtn()));
		Assert.assertTrue(pi.getFirstNameEdt().isDisplayed());
		pi.getFirstNameEdt().clear();
		pi.getFirstNameEdt().sendKeys(updatedUsername);
		pi.getConfirmPswdEdt().sendKeys(password);
		pi.getSaveBtn().click();
		Assert.assertTrue(pi.getSucessMsgEle().isDisplayed());
	}
	
	public static String getOrderNumber(String str)
	{
		String[] strArr=str.split("reference");
		String orderNumber=strArr[1];
		orderNumber=orderNumber.substring(1,10);
		return orderNumber;
	}
	
}
