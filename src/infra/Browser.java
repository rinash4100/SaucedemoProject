package infra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

	private static WebDriver driver;

	/**
	 * This function implements a design pattern called Singleton - A single class performance
	 */
	public static WebDriver getDriver() {
		if (driver == null) {
			//You can set different types of browser according to a parameter to be defined 
			//Like new InternetExplorerDriver();	
	        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		return driver;
	}
	
	public static void goToSite(String addres){
		driver.get(addres);
		driver.manage().window().maximize();
	}

}
