package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import infra.Browser;
import infra.StringUtility;
import infra.WebElementData;

public class ProductsPage extends BasePage {

	private WebElementData addTshirtBtn = new WebElementData(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
	private WebElementData addJacketBtn = new WebElementData(By.id("add-to-cart-sauce-labs-fleece-jacket"));
	
	//(this element for JavascriptExecutor) 
	private WebElement addJacket = Browser.getDriver().findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));

	/**
	 * The prices of the products dont have a unique ID, in order to find their
	 * price you need to use XPATH which allows to go to the parents of the
	 * element that is identified. I used two different ways to find the
	 * element: 1.with XPath axes-I found the product according to his name,I
	 * got to parent and then found the price. look at the TshirtPrice. 
	 * 2.with JavascriptExecutor-I found the product according to ADD TO CART button,I got to
	 * parent and then found the price. look at the JacketPrice.
	 */

	WebElementData tshirtPrice = new WebElementData(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']/ancestor::div[2] //div[@class='inventory_item_price']"));
	
	WebElement addJacketBtnParent = (WebElement) ((JavascriptExecutor) Browser.getDriver())
			.executeScript("return arguments[0].parentNode;",addJacket);
	WebElement jacketPrice= addJacketBtnParent.findElement(By.className("inventory_item_price"));
	
	WebElementData shoppingCartLink = new WebElementData(By.className("shopping_cart_link"));

	@Override
	public void fillPage() {
		addTshirtBtn.click();
		addJacketBtn.click();
		shoppingCartLink.click();
	}
	
	public double getTshirtPrice(){
		return StringUtility.getPriceFromString(tshirtPrice.getText());
	}
	
	public double getJacketPrice(){
		return StringUtility.getPriceFromString(jacketPrice.getText());
	}

}
