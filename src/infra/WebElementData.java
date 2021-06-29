/**
 * 
 */
package infra;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Creating a shell for elements
 */
public class WebElementData{

	private By selector;
	private WebElement element;

	public WebElementData(By by) {
		this.selector = by;
		List<WebElement> elements = Browser.getDriver().findElements(this.selector);
		if (elements.size() == 0) {
			try {
				throw new Exception("אלמנט לא קיים");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		element = elements.get(0);
	}
	
	public void input(String text){
		element.clear();
	    element.sendKeys(text);
	}

	public void click() {
		element.click();
	}
	
	public String getText(){
		return element.getText();
	}
	
}
