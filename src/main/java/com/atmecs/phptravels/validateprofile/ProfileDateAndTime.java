package com.atmecs.phptravels.validateprofile;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import com.atmecs.phptravels.pageactions.PageActions;
import com.atmecs.phptravels.testbase.ConstantFilePaths;
import com.atmecs.phptravels.testbase.TestBase;
import com.atmecs.phptravels.utils.ExcelFileWriter;
import com.atmecs.phptravels.utils.LogReports;
import com.atmecs.phptravels.utils.ReadLocatorsFile;

public class ProfileDateAndTime extends TestBase {
	static LogReports report = new LogReports();
	static Properties properties;
	static String xpath;
	
	public static void getDataAndTime() 
	{
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		report.info("System Current date and time is " + date1);
	}

	public static void profileDateAndTime() throws Exception 
	{
	
		properties = ReadLocatorsFile.loadProperty(ConstantFilePaths.LOCATORS_FILE);

		xpath = properties.getProperty("systemTimeXpath");

		// String time = PageActions.fetchHtmlAttributeValue(driver, xpath);
		// report.info("user profile creation time is: " + time);

		String text = PageActions.fetchAttributeText(driver, xpath);
		ExcelFileWriter.test(text);
		report.info("user profile creation text time is: " + text);


		xpath = properties.getProperty("systemDateXpath");
		String date = PageActions.fetchAttributeText(driver, xpath);
		ExcelFileWriter.test(date);
		report.info("user profile creation date is:" + date);
	}

}
