package hybrid.srinivas_bank;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import resources.TestListener;

@Listeners(TestListener.class)
public class TestExecution extends Repository{
	
	@AfterMethod(groups= {"branch", "search", "clear", "create" , "reset", "duplicate", "emptydata", "role", "employee", "data_driven"})
	public void closeUnexpectedAlert(ITestResult result) {
		if( result.getStatus() == ITestResult.FAILURE) {
			try {
				driver.switchTo().alert().accept();
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
  	}

	
	@Test(priority = 0, groups= {"branch", "search", "clear", "create" , "reset", "duplicate", "emptydata" ,"role", "data_driven"})
	public void loginTest() {
		bankHomePage.fillUsername("Admin");
		bankHomePage.fillPassword("Admin");
		bankHomePage.clickLoginButton();
	}
	
	@Test(priority = 1, groups= {"branch", "search"})
	public void searchBranchTest() {
		adminHomePage.clickBranchesButton();
		branchesPage.selectCountry("INDIA");
		branchesPage.selectState("GOA");
		branchesPage.selectCity("GOA");
		branchesPage.clickSearchButton();
		sleep(2000);
	}
	
	@Test(priority = 2, groups= {"branch", "clear"})
	public void clearBranchSearchTest()  {
		searchBranchTest();
		branchesPage.clickClearButton();	
	}
	
	@Test(priority = 3, groups= {"branch", "create"})
	public void createNewBranchTest() {
		adminHomePage.clickBranchesButton();
		branchesPage.clickNewBranchButton();
		fillBranchCreationForm("HDFCKPHB", "KPHB", "50005", "INDIA", "Andhra Pradesh", "Hyderabad");
		branchCreationPage.clickSubmitButton();
		System.out.println(getAlertText());
		acceptAlert();
	}
	
	@Test(priority = 4, groups= {"branch", "reset"})
	public void ResetBranchFormTest() {
		adminHomePage.clickBranchesButton();
		branchesPage.clickNewBranchButton();
		fillBranchCreationForm("HDFCKPHB", "KPHB", "50005", "INDIA", "Andhra Pradesh", "Hyderabad");
		branchCreationPage.clickResetButton();
	}
	
	@Test(priority = 5, groups= {"branch", "cancel"})
	public void CancelBranchCreationFormTest() {
		adminHomePage.clickBranchesButton();
		branchesPage.clickNewBranchButton();
		branchCreationPage.clickCancelButton();
	}
	
	@Test(priority = 6,groups= {"branch", "duplicate"})
	public void createNewBranchWithDuplicateDataTest() {
		adminHomePage.clickBranchesButton();
		branchesPage.clickNewBranchButton();
		fillBranchCreationForm("HDFCKPHB", "KPHB", "50005", "INDIA", "Andhra Pradesh", "Hyderabad");
		branchCreationPage.clickSubmitButton();
		System.out.println(getAlertText());
		acceptAlert();
	}
	
	@Test(priority = 7, groups= {"branch", "emptydata"})
	public void createNewBranchWithEmptyDataTest() {
		adminHomePage.clickBranchesButton();
		branchesPage.clickNewBranchButton();
		branchCreationPage.clickSubmitButton();
		System.out.println(getAlertText());
		acceptAlert();
	}
	
	
	@Test(priority = 8, groups= {"role", "create"})
	public void createNewRole() {
		adminHomePage.clickRolesButton();
		rolePage.clickNewRole();
		fillRoleCreationForm("assistantmanagerOne", "E");
		newRolePage.clickSubmit();
		System.out.println(getAlertText());
		acceptAlert();
	}
	
	@Test(priority = 9, groups= {"role", "reset"})
	public void resetNewRolePageForm() {
		adminHomePage.clickRolesButton();
		rolePage.clickNewRole();
		fillRoleCreationForm("assistantmanagerOne", "E");
		newRolePage.clickReset();
	}
	
	@Test(priority = 10, groups= {"role", "cancel"})
	public void cancelNewRolePageForm() {
		adminHomePage.clickRolesButton();
		rolePage.clickNewRole();
		sleep(2000);
		newRolePage.clickCancel();
	}
	
	@Test(priority = 11, groups= {"employee", "create"})
	public void createNewEmployee() {
		adminHomePage.clickEmployeeButton();
		employeePage.clickNewEmployee();
		fillEmployeeCreationForm("srinivas", "selenium", "assistantmanagerOne", "HDFCKPHB");
		newEmployeePage.clickSubmit();
		System.out.println(getAlertText());
		acceptAlert();
	}
	
	@Test(priority = 12, groups= {"employee", "reset"})
	public void resetNewEmployeeCreationForm() {
		adminHomePage.clickEmployeeButton();
		employeePage.clickNewEmployee();
		fillEmployeeCreationForm("srinivas", "selenium", "assistantmanagerOne", "HDFCKPHB");
		newEmployeePage.clickReset();
	}
	
	@Test(priority = 13, groups= {"employee", "cancel"})
	public void cancelNewEmployeeCreationForm() {
		adminHomePage.clickEmployeeButton();
		employeePage.clickNewEmployee();
		sleep(2000);
		newEmployeePage.clickCancel();
	}
	
	@Test(priority = 14, groups = {"branch","data_driven"}, dataProviderClass = DataProviders.class, dataProvider = "branch_data")
	public void testBranchCreationWithMulipleData(String branchName, String address1, String zipcode, String country, String state, String city) {
		adminHomePage.clickBranchesButton();
		branchesPage.clickNewBranchButton();
		fillBranchCreationForm(branchName, address1, zipcode, country, state, city);
		branchCreationPage.clickSubmitButton();
		System.out.println(getAlertText());
		acceptAlert();
	}
	
	@Test(priority = 15, groups = {"role", "data_driven"}, dataProviderClass=DataProviders.class, dataProvider = "role_data")
	public void testRoleCreationWithMultipleData(String roleName, String roleType) {
		adminHomePage.clickRolesButton();
		rolePage.clickNewRole();
		fillRoleCreationForm(roleName, roleType);
		newRolePage.clickSubmit();
		System.out.println(getAlertText());
		acceptAlert();
	}
	
	@Test(priority = 16, groups = {"employee","data_driven"}, dataProviderClass = DataProviders.class, dataProvider ="employee_data")
	public void testEmployeeCreationWithMultipleData(String empName, String password, String role, String branchName) {
		adminHomePage.clickEmployeeButton();
		employeePage.clickNewEmployee();
		fillEmployeeCreationForm(empName, password, role, branchName);
		newEmployeePage.clickSubmit();
		System.out.println(getAlertText());
		acceptAlert();
	}
	
	@Test(priority = 18, groups= {"branch", "search", "clear", "create" , "reset", "duplicate", "emptydata", "role", "employee", "data_driven"})
	public void logoutTest() {
		adminHomePage.clickLogoutButton();
	}
}
