package hybrid.srinivas_bank;

import java.awt.Event;
import java.awt.List;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.internal.EventFiringTouch;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import resources.Listener;

public class Repository {
	WebDriver wdriver;
	EventFiringWebDriver driver;
	BankHomePage bankHomePage;
	AdminHomePage adminHomePage;
	BranchesPage branchesPage;
	BranchCreationPage branchCreationPage;
	RolePage rolePage;
	NewRolePage newRolePage;
	EmployeePage employeePage;
	NewEmployeePage newEmployeePage;
	protected static ExtentReports report;
	protected static ExtentTest test;

	public void launchBrowser(String browser, String url) {
		if (System.getProperty("os.name").startsWith("Mac")) {
			if (browser.equalsIgnoreCase("chrome")) {
				String path = Repository.class.getClassLoader().getResource("resources/chromedriver").getPath();
				System.setProperty("webdriver.chrome.driver", path);
				wdriver = new ChromeDriver();

			} else if (browser.equalsIgnoreCase("firefox")) {
				String path = Repository.class.getClassLoader().getResource("resources/geckodriver").getPath();
				System.setProperty("webdriver.gecko.driver", path);
				wdriver = new FirefoxDriver();
			}
		} else if (System.getProperty("os.name").startsWith("Windows")) {
			if (browser.equalsIgnoreCase("firefox")) {
				String path = Repository.class.getClassLoader().getResource("resources/geckodiriver.exe").getPath();
				System.setProperty("webdriver.chrome.driver", path);
				wdriver = new ChromeDriver();

			}
		}
		driver = new EventFiringWebDriver(wdriver);
		Listener listener = new Listener();
		driver.register(listener);
		driver.get(url);
		driver.manage().window().maximize();
	}

	public void launchBrowser() {
		launchBrowser("chrome", "http://srssprojects.in");
	}

	public String getDate() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("dd-MM-YY hh-mm-ss");
		return df.format(date);
	}

	public String getPath(String fileName) {
		StringBuilder path = new StringBuilder(
				System.getProperty("user.dir") + File.separator + "report" + File.separator + fileName);
		return path.toString();
	}

	public void initialize() {
		bankHomePage = new BankHomePage(driver);
		adminHomePage = new AdminHomePage(driver);
		branchesPage = new BranchesPage(driver);
		branchCreationPage = new BranchCreationPage(driver);
		rolePage = new RolePage(driver);
		newRolePage = new NewRolePage(driver);
		employeePage = new EmployeePage(driver);
		newEmployeePage = new NewEmployeePage(driver);

	}

	public void closeBrowser() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (driver.getWindowHandles().size() > 1) {
			driver.quit();
		} else {
			driver.close();
		}
	}

	public void sleep(long timeInMilliS) {
		try {
			Thread.sleep(timeInMilliS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getAlertText() {
		return driver.switchTo().alert().getText();
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public void fillBranchCreationForm(String branchName, String address1, String zipcode, String country, String state,
			String city) {
		branchCreationPage.fillBranchName(branchName);
		branchCreationPage.fillAddress1(address1);
		branchCreationPage.fillZipCode(zipcode);
		branchCreationPage.selectCountry(country);
		branchCreationPage.selectState(state);
		branchCreationPage.selectCity(city);
	}

	public void fillRoleCreationForm(String roleName, String roleType) {
		newRolePage.fillRoleName(roleName);
		newRolePage.selectRoleType(roleType);
	}

	public void fillEmployeeCreationForm(String empName, String password, String role, String branch) {
		newEmployeePage.fillEmpName(empName);
		newEmployeePage.fillPassword(password);
		newEmployeePage.selectRole(role);
		newEmployeePage.selectBranch(branch);
	}

}
