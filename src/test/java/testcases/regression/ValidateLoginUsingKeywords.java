package testcases.regression;

import org.testng.annotations.Test;

import base.BaseTest;
import keywords.ApplicationKeywords;

public class ValidateLoginUsingKeywords extends BaseTest {
	@Test
	public void validLogin() {
		ApplicationKeywords app=new ApplicationKeywords();
		app.startBrowser();
		app.startApp();
		app.type("username_textbox", "reyaz0806");
		app.type("password_textbox", "reyaz123");
		app.clickButton("login_button");
		app.verifyTile("Adactin.com - Search Hotel");
		
	}
	

}
