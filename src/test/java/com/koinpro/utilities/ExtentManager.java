package com.koinpro.utilities;
import java.io.IOException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.koinpro.testCases.BaseClass;

public class ExtentManager {
	
	public static ExtentSparkReporter htmlReporter ;
	public static ExtentReports extent;
	public static ExtentTest test;



public static void setExtent() throws IOException {
	
//	Date currentdate = new Date();
//	String exactdate = currentdate.toString().replace(" ","-").replace(":","-");
	htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/MyReport "+BaseClass.exactdate()+".html");
	
	htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extenet-config.xml");
//	htmlReporter.config().setDocumentTitle("Automation Test Report");
//	htmlReporter.config().setReportName("Koinpro Automation report");
//	htmlReporter.config().setTheme(Theme.STANDARD);
	
	extent = new ExtentReports();
	extent.attachReporter(htmlReporter);
	extent.setSystemInfo("HostName","Md shahnawaz");
	extent.setSystemInfo("ProjectName","KoinPro");
	extent.setSystemInfo("Tester","Md shahnawaz");
	extent.setSystemInfo("OS","Windows 10");
	extent.setSystemInfo("Browser","Chrome");
}


public static void endreport() {
	extent.flush();
}




}
