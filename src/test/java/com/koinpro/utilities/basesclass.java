package com.koinpro.utilities;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class basesclass {
	
	@BeforeSuite
	public void beforeSuite() {
		DOMConfigurator.configure("log4j.xml");
		log.info("This is beforeSuite method");
	}
	
	@AfterSuite
	public void afterSuite() {
		log.info("This is afterSuite method");
	}

}
