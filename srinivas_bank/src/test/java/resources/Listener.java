package resources;

import org.omg.PortableServer.RequestProcessingPolicyOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

import hybrid.srinivas_bank.Repository;

public class Listener extends Repository implements WebDriverEventListener {

	@Override
	public void afterAlertAccept(WebDriver arg0) {
		Reporter.log("alert accepted");
		test.log(LogStatus.INFO,"alert accepted");
	}

	@Override
	public void afterAlertDismiss(WebDriver arg0) {
		Reporter.log("alert dismissed");
		test.log(LogStatus.INFO,"alert dismissed");
	}

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		Reporter.log("value of element "+arg0.getText()+" changed to "+arg2.toString());
		test.log(LogStatus.INFO,"value of element "+arg0.getText()+" changed to "+arg2.toString());
	}

	@Override
	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		Reporter.log("clicked on element");
		test.log(LogStatus.INFO,"clicked on element");
	}

	@Override
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		Reporter.log("element located using "+arg0.toString());
		test.log(LogStatus.INFO,"element located using "+arg0.toString());
	}

	@Override
	public void afterNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeAlertAccept(WebDriver arg0) {
		Reporter.log("alert came: "+arg0.switchTo().alert().getText());
		test.log(LogStatus.INFO,"element located using "+arg0.toString());
	}

	@Override
	public void beforeAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		Reporter.log("locating element using "+arg0);
		test.log(LogStatus.INFO,"locating element using "+arg0);
	}

	@Override
	public void beforeNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onException(Throwable arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

}
