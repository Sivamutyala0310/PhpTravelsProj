package com.atmecs.phptravels.validateSignUp;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import com.atmecs.phptravels.helpers.LoginPageData;
import com.atmecs.phptravels.helpers.Waits;
import com.atmecs.phptravels.pageactions.PageActions;
import com.atmecs.phptravels.testbase.ConstantFilePaths;
import com.atmecs.phptravels.testbase.TestBase;
import com.atmecs.phptravels.utils.LogReports;
import com.atmecs.phptravels.utils.ReadLocatorsFile;
import com.atmecs.phptravels.validateprofile.ValidateResult;

public class SignUp extends TestBase {
	
	static LoginPageData data = new LoginPageData();
	static LogReports log = new LogReports();
	static Properties properties;
	static String value;
	
	static String actualRequiredFieldsValues;
	
	static String expectedRequiredFields = "The Email field is required." + "\n"
	  + "The Password field is required." + "\n" +
	  "The Password field is required." + "\n" +
	  "The First name field is required." + "\n" +
	  "The Last Name field is required.";
	
	static String actuallEmailError;
	
	static String expectedEmailError="The Email field must contain a valid email address.";
	
	@Test(priority=2)
	
	public static void validateSignUp() 
	{
			validate();
			
			PageActions.clickElement(driver, data.getSignUpXpath());
			
			log.info("without filling any required fields directly clicking on signUp function");

			actualRequiredFieldsValues = PageActions.fetchAttributeText(driver, data.getEmptySignUpXpath());  //actual result
	
			        // validating signup function without filling any required fields
			
			ValidateResult.validateData(actualRequiredFieldsValues, expectedRequiredFields, "validatingSignUpFunction");
	}
	
	@Test(priority=1)
	public static void validateSignUpEmail() throws Exception
	{
		properties = ReadLocatorsFile.loadProperty(ConstantFilePaths.ValidationTESTDATA_FILE);
		validate();
		value = properties.getProperty("firtsName");
		PageActions.sendKeys(driver, data.getFirstNameXpath(), value);
		
		value = properties.getProperty("lastName");
		PageActions.sendKeys(driver, data.getLastNameXpath(), value);
		
		value = properties.getProperty("mobileNumber");
		PageActions.sendKeys(driver, data.getMobileNumberXpath(), value);
		
		value = properties.getProperty("wrongEmail");
		PageActions.sendKeys(driver,data.getEmailXpath(), value);        // validating mail without @domain syntax
		
		value = properties.getProperty("password");
		PageActions.sendKeys(driver,data.getPasswordXpath(), value);
		
		value = properties.getProperty("confirmPassword");
		PageActions.sendKeys(driver,data.getConfirmPasswordXpath(), value);
		
		Waits.explicitWaitClick(driver, data.getSignUpXpath());
		
		actuallEmailError= PageActions.fetchAttributeText(driver, data.getEmptySignUpXpath());
		ValidateResult.validateData(actuallEmailError, expectedEmailError, "validating SignUp Email field");	
	}
	
	
	public static void validate() {
		try {

			data.getData();
			PageActions.clickElement(driver, data.getclickOnMyAccountXpath());
			log.info("clicking my accunt");

			PageActions.clickElement(driver, data.getSignUpDropDown());
			log.info("selecting sign up dropdown");
		} 
		catch (IOException e) {

			e.printStackTrace();
			log.info("exception raised in selecting SignUp");
		}
	}

}
