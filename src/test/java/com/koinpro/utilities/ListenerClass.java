package com.koinpro.utilities;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.koinpro.testCases.BaseClass;

public class ListenerClass extends ExtentManager implements ITestListener {
	
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
	}
	
public void onTestSuccess(ITestResult result) {
	if(result.getStatus()==ITestResult.SUCCESS) {
		test.log(Status.PASS, "Pass Test case is: "+result.getName());
	}
	}

public void onTestFailure(ITestResult result) {
	
	if(result.getStatus()==ITestResult.FAILURE) {
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() +" - Test case Failed", ExtentColor.RED));
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() +" - Test case Failed", ExtentColor.RED));
		
		String str = result.getName();
		String pathString = BaseClass.Screenshot(BaseClass.driver,str);
		try {
			test.addScreenCaptureFromPath(pathString);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
	
	public void onTestSkipped(ITestResult result) {
		if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, "Skipped test case is: "+result.getName());
		}

	}
}


