package keywords;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class GenericKeywords extends BaseTest {
	public void startBrowser() {
		String browserName = configProp.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
	}
	public void startApp() {
		driver.get(configProp.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Long.parseLong(configProp.getProperty("implicitWait"))));
		
	}
	public void type(String locator,String text) {
		//driver.findElement(By.xpath(locatorsProp.getProperty(locator))).sendKeys(text);
		getElement(locator).sendKeys(text);
	}
	public void clickButton(String locatorKey) {
		getElement( locatorKey).click();
		
		
	}
	public String getsTitle() {
		return driver.getTitle();
		
	}
	private WebElement getElement(String locator) {
		WebElement element=null;
		WebDriverWait myWait=new WebDriverWait(driver, Duration.ofSeconds(30));
		myWait.until(ExpectedConditions.presenceOfElementLocated(getLocatorValue(locator)));
		element=driver.findElement(getLocatorValue(locator));
		return element;
		// TODO Auto-generated method stub
		
	}
	private By getLocatorValue(String locator) {
		// TODO Auto-generated method stub
		By by=null;
		if(locator.endsWith("_id")) {
			by=By.id(locatorsProp.getProperty(locator));
		
	}
		else if(locator.endsWith("_text")) {
			by=By.linkText(locatorsProp.getProperty(locator));
		
	}
		else if(locator.endsWith("_xpath")) {
			by=By.xpath(locatorsProp.getProperty(locator));
		
	}
		else {
			by=By.xpath(locatorsProp.getProperty(locator));
			
		}
		
		
		return by;

}
}