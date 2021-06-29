package pages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.seleniumhq.jetty9.util.StringUtil;

import infra.StringUtility;
import infra.WebElementData;

public class OverViewPage extends BasePage {
	
	private WebElementData taxPrice=new WebElementData(By.className("summary_tax_label"));
	private WebElementData totalPrice=new WebElementData(By.className("summary_total_label"));
	private WebElementData finishBtn=new WebElementData(By.id("finish"));
	
	@Override
	public void fillPage() {		
		finishBtn.click();
	}

	public double getTotalPrice(){
		return StringUtility.getPriceFromString(totalPrice.getText());
	}
	
	public double getTaxPrice(){
		return StringUtility.getPriceFromString(taxPrice.getText());
	}
}
