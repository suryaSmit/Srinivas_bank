package resources;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import hybrid.srinivas_bank.Repository;

public class TestListener extends Repository implements ITestListener, ISuiteListener{

	@Override
	public void onTestStart(ITestResult result) {
		test = report.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName()+" is started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(LogStatus.PASS, result.getName()+"is passed");
		report.endTest(test);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(LogStatus.FAIL, result.getName()+"is failed");
		report.endTest(test);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(LogStatus.SKIP, result.getName()+"is skipped");
		report.endTest(test);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ISuite suite) {
		report = new ExtentReports(getPath(suite.getName()+getDate()+".html"));
		
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
		report.close();
		
	}

}
