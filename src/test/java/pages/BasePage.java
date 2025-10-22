package pages;

import org.openqa.selenium.WebElement;

public class BasePage {
	public void type(WebElement element,String text) {
		element.sendKeys(text);
	}
	public void click(WebElement element) {
		element.click();
		
	}

}
