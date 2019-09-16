package com.atmecs.phptravels.helpers;

import java.io.IOException;
import java.util.Properties;

import com.atmecs.phptravels.testbase.ConstantFilePaths;
import com.atmecs.phptravels.utils.ReadLocatorsFile;

public class ProfilePageData {

	String profileXpath;
	String timeXpath;
	String dateXpath;
	String profileFirstNameXpath;
	String profileLastNameXpath;
	String profileMobileNumberXpath;
	String profileEmailXpath;
	String validateProfileXpath;
	Properties properties;

	public void getData() throws IOException {
		properties = ReadLocatorsFile.loadProperty(ConstantFilePaths.LOCATORS_FILE);
		setProfileXpath();
		setTimeXpath();
		setDateXpath();
		setProfileFirstNameXpath();
		setProfileLastNameXpath();
		setProfileMobileNumberXpath();
		setProfileEmailXpath();
		setValidateProfileXpath();
	}

	public String getProfileXpath() {
		return profileXpath;

	}

	public void setProfileXpath() {
		profileXpath = properties.getProperty("profileXpath");
	}

	public String getTimeXpath() {
		return timeXpath;
	}

	public void setTimeXpath() {
		timeXpath = properties.getProperty("timeXpath");
	}

	public String getDateXpath() {
		return dateXpath;
	}

	public void setDateXpath() {
		dateXpath = properties.getProperty("dateXpath");
	}

	public String getProfileFirstNameXpath() {
		return profileFirstNameXpath;
	}

	public void setProfileFirstNameXpath() {
		profileFirstNameXpath = properties.getProperty("profileFirstNameXpath");
	}

	public String getProfileLastNameXpath() {
		return profileLastNameXpath;
	}

	public void setProfileLastNameXpath() {
		profileLastNameXpath = properties.getProperty("profileLastNameXpath");
	}

	public String getProfileMobileNumberXpath() {
		return profileMobileNumberXpath;
	}

	public void setProfileMobileNumberXpath() {
		profileMobileNumberXpath = properties.getProperty("profileMobileNumberXpath");
	}

	public String getProfileEmailXpath() {
		return profileEmailXpath;
	}

	public void setProfileEmailXpath() {
		profileEmailXpath = properties.getProperty("profileEmailXpath");
	}
	public String getValidateProfileXpath() {
		return validateProfileXpath;
	}

	public void setValidateProfileXpath() {
		validateProfileXpath =  properties.getProperty("validateProfileXpath");
	}


	public static void main(String[] args) throws Exception {

		ProfilePageData data = new ProfilePageData();
		data.getData();
	}
}
