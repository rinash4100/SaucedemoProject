package pages;

import org.openqa.selenium.By;

import infra.WebElementData;

public class CheckoutPage extends BasePage{
	
	private WebElementData firstName=new WebElementData(By.id("first-name"));
	private WebElementData lastName=new WebElementData(By.id("last-name"));
	private WebElementData postalCode=new WebElementData(By.id("postal-code"));
	private WebElementData continueBtn=new WebElementData(By.id("continue"));
	
	@Override
	public void fillPage() {
		firstName.input("Rina");
		lastName.input("Shlezinger");
		postalCode.input("97350");
		continueBtn.click();
	}
	
}
