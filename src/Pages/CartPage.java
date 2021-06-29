package pages;

import org.openqa.selenium.By;

import infra.WebElementData;

public class CartPage extends BasePage {

	private WebElementData checkOutBtn=new WebElementData(By.id("checkout"));
	
	@Override
	public void fillPage() {
		checkOutBtn.click();
	}


}
