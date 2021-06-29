package pages;

import infra.WebElementData;
import org.openqa.selenium.By;


public class LoginPage extends BasePage {
	
	private WebElementData userName=new WebElementData(By.id("user-name"));
	private WebElementData password=new WebElementData(By.id("password"));
	private WebElementData login=new WebElementData(By.id("login-button"));
	
	
	@Override
	public void fillPage() {
		userName.input("standard_user");
		password.input("secret_sauce");
		login.click();
	}
	
	
	
	
}