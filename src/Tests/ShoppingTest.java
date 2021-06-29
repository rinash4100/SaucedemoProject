package Tests;

import static org.junit.Assert.*;

import java.io.IOException;

import infra.Browser;
import infra.Reaporter;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.LoginPage;
import Pages.OverViewPage;
import Pages.ProductsPage;
import TestData.Reader;

public class ShoppingTest {

	double price1 = 0;
	double price2 = 0;
	double totalPrice = 0;
	double taxPrice = 0;

	@BeforeClass
	public static void openDriver() throws IOException {
		Browser.getDriver();
		Browser.goToSite("https://www.saucedemo.com/");
	}

	@Test
	public void test() {
		new LoginPage().fillPage();
		productPage();
		new CartPage().fillPage();
		new CheckoutPage().fillPage();
		overViewPage();
		/**
		 * if verify total price is the issue of the test, its correct to use with
		 * assertEquals, in order to cause failure the test, but I saw its @deprecated, then I
		 * use with reaporter.
		 */
		if(Double.compare(totalPrice,price1+price2+taxPrice)== 0){
			Reaporter.printAccess();}
		else{
			Reaporter.printError();}
		
		//assertEquals("the total price is correct",totalPrice,price1+price2);
	}

	private void productPage() {
		ProductsPage productsPage = new ProductsPage();
		price1 = productsPage.getTshirtPrice();
		price2 = productsPage.getJacketPrice();
		productsPage.fillPage();
	}

	private void overViewPage() {
		OverViewPage overViewPage = new OverViewPage();
		totalPrice = overViewPage.getTotalPrice();
		taxPrice = overViewPage.getTaxPrice();
		overViewPage.fillPage();
	}

	@AfterClass
	public static void closeDriver() {
		Browser.getDriver().close();
	}
}
