package hybrid.srinivas_bank;

import org.testng.annotations.DataProvider;

import resources.Excel;

public class DataProviders {
	
	@DataProvider(name = "branch_data")
	public Object[][] gerBranchData(){
		return Excel.readExcelData("test_data.xlsx", "branchdata");
	}
	
	@DataProvider(name="role_data")
	public Object[][] getRoleData(){
		return Excel.readExcelData("test_data.xlsx","roledata");
	}

	@DataProvider(name="employee_data")
	public Object[][] getEmployeeData(){
		return Excel.readExcelData("test_data.xlsx","employeedata");
	}
}
