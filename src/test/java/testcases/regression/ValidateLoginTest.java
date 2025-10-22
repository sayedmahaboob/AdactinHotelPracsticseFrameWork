package testcases.regression;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
 
public class ValidateLoginTest extends BaseTest  {
	
	@Test(dataProvider="getData")
	public void validateLogin(String username,String password,String title) {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='login']")).click();
		Assert.assertEquals( driver.getTitle(),title);
		
		// Adactin.com - Hotel Reservation System
	}
	@DataProvider
	public Object[][] getData(){
		Object[][] data=new Object[4][3];
		data[0][0]="sayed1991";
		data[0][1]="arks@1234";
		data[0][2]="Adactin.com - Search Hotel";
		
		data[1][0]="sayed1991";
		data[1][1]="arks@1235";
		data[1][2]="Adactin.com - Hotel Reservation System";
		
		data[2][0]="sayed1992";
		data[2][1]="arks@1234";
		data[2][2]="Adactin.com - Hotel Reservation System";
		
		data[3][0]="sayed1992";
		data[3][1]="arks@1235";
		data[3][2]="Adactin.com - Hotel Reservation System";
		
		return data;
		
	}

}
