package com.atmecs.phptravels.utils;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.atmecs.phptravels.testbase.ConstantFilePaths;


public class LogReports {

		
		Logger log=null;

		public LogReports() {
			getlogger();
			log = Logger.getLogger(LogReports.class.getName());
		}

		public void getlogger() {
			PropertyConfigurator.configure(ConstantFilePaths.LOG4J_FILE);
		}

		public void info(String message) {
			log.info(message);
		}

	/*
	 * public void info(ArrayList<String[]> addValues) { log.info(addValues);
	 */
			


		public void info(ArrayList<String> list) {
		log.info(list);
			
		}
	}