package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	@FindBy(xpath="//input[@id='username']")
	WebElement username_textbox;
	@FindBy(xpath="//input[@id='password']")
	WebElement password_textbox;
	@FindBy(xpath="//input[@id='login']")
	WebElement loginButton;
	public void userNametext(String text) {
		type(username_textbox,text);
		
	}
	public void password_text(String text) {
		type(password_textbox,text);
	}
	public void loginButton() {
		loginButton.click();
		
	}

}
