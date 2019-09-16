package com.atmecs.phptravels.screenshots;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.atmecs.phptravels.testbase.TestBase;

public class ScreenShots extends TestBase {
	@AfterMethod
	public void tearDown(ITestResult result) {
	if (ITestResult.FAILURE== result.getStatus()) {
	try {
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(source, new File("/screenshot/"+result.getName() + ".png")); //this will save the screenshot in screenshot folder with failed "methodname.png"
	System.out.println("Screenshot taken");
	} catch (Exception e) {
	System.out.println("Exception while taking screenshot " + e.getMessage());
	}
	}
	}


}
