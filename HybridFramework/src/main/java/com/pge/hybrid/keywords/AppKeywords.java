package com.pge.hybrid.keywords;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

public class AppKeywords extends GenericKeywords{

	public void gmailLogin(){
		test.log(Status.INFO, "Logging in"); 
		//getObject("signin_xpath").click();
		String username="";
		String password="";
		
		if(data.get("Username") == null){
			username=envProp.getProperty("defaultUsername");
			password=envProp.getProperty("defaultPass");
		}else{
			username=data.get("Username");
			password=data.get("Password");
		}
		getObject("username_id").sendKeys(username);
		getObject("NextBtn_xpath").click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(getObject("pwd_name")));
		
		getObject("pwd_name").sendKeys(password);
		getObject("NextBtn_xpath").click();
		// security warining - mozilla
		wait(5);
		
		//acceptAlert();
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("password_id")));
	}
	
	public void yahooLogin(){
		test.log(Status.INFO, "Logging in"); 
		String username="";
		String password="";
		
		if(data.get("Username") == null){
			username=envProp.getProperty("defaultUsername");
			password=envProp.getProperty("defaultPass");
		}else{
			username=data.get("Username");
			password=data.get("Password");
		}
		type("yahoo_username_id","Username");
		//click("yahoo_nextbtn_id");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(getObject("yahoo_pwd_id")));
		
		type("yahoo_pwd_id","Password");
		//click("yahoo_loginbtn_id");
		// security warining - mozilla
		wait(5);
		
		//acceptAlert();
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("password_id")));
	}
	
	public void validateLogin(){
		test.log(Status.INFO, "Validating Login");
		boolean result = isElementPresent("portfolioSelection_xpath");
		String expectedResult=data.get("ExpectedResult");
		String actualResult="";
		
		if(result)	
			actualResult="Loginsuccess";
		else
			actualResult="Loginfailure";
		if(!actualResult.equals(expectedResult))
			reportFailure("Got  result "+actualResult );

		
		
	}
	
	public void defaultLogin(){
		test.log(Status.INFO, "Logging in with default ID");

		String username=envProp.getProperty("adminusername");
		String password=envProp.getProperty("adminpassword");
		System.out.println("Default username "+username );
		System.out.println("Default password "+password );
	}
	
	public void verifyPortFolio(){
		test.log(Status.INFO, "Verifying portfolio name "+data.get(dataKey));
		waitTillSelectionToBe("portfolioSelection_xpath",data.get(dataKey));
		
	}
	
}