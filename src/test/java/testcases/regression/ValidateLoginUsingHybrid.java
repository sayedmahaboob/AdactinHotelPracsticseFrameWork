package testcases.regression;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import keywords.ApplicationKeywords;
import util.UtilKitPractisce1;

public class ValidateLoginUsingHybrid extends BaseTest {
	@Test(dataProvider="getData")
	public void validLogin(HashMap<String,String>testData) {
		ApplicationKeywords app=new ApplicationKeywords();
		app.startBrowser();
		app.startApp();
		app.type("username_textbox", testData.get("username"));
		app.type("password_textbox", testData.get("password"));
		app.clickButton("login_button");
		app.verifyTile(testData.get("expected Title"));
		
	}
	@DataProvider
	public Object[][] getData(){
		Object[][] data=new Object[1][1];
		data[0][0]=UtilKitPractisce1.getDatafromExcel("TC- 101");
		
		return data;
		
	}

}
