package testcases.regression;


import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import util.UtilKitPractisce1;
 
public class ValidateLoginTestUsingExcel2 extends BaseTest  {
	
	@Test(dataProvider="getData")
	public void validateLogin(HashMap<String,String> testData) {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(testData.get("username"));
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(testData.get("password"));
		driver.findElement(By.xpath("//input[@id='login']")).click();
		Assert.assertEquals( driver.getTitle(),testData.get("expected Title"));
		WebElement dropDownElement =driver.findElement(By.xpath("//select[@id='location']"));
		Select selectElement=new Select(dropDownElement);
		selectElement.selectByVisibleText(testData.get("location"));
		WebElement dropDownElement2 =driver.findElement(By.xpath("//select[@id='hotels']"));
		Select selectElement2=new Select(dropDownElement2);
		selectElement2.selectByVisibleText(testData.get("hotel"));
		driver.findElement(By.xpath("//input[@id='datepick_in']")).sendKeys(testData.get("Check In Date"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@id='Submit']")).click();
	
		
		
		
		
		
		// Adactin.com - Hotel Reservation System
	}
	@DataProvider
	public Object[][] getData(){
		Object[][] data=new Object[1][1];
		data[0][0]=UtilKitPractisce1.getDatafromExcel("TC-113");
		
		return data;
		
	}

}
