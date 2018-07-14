package hybrid.srinivas_bank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

//page Factory
public class AdminHomePage {

	// branches
	@FindBy(how = How.XPATH, using = "//a[@href='admin_banker_master.aspx']")
	private WebElement branchesButton;

	// roles
	@FindBy(how = How.XPATH, using = "//a[@href='Admin_Roles_details.aspx']")
	private WebElement rolesButton;

	// employees
	@FindBy(how = How.XPATH, using = "//a[@href='userdetails.aspx']")
	private WebElement usersButton;

	// users
	@FindBy(how = How.XPATH, using = "//a[@href='Admin_Emp_details.aspx']")
	private WebElement employeeButton ;

	// home
	@FindBy(how = How.XPATH, using = "//a[@href='adminflow.aspx']")
	private WebElement homeButton;

	// changePassword
	@FindBy(how = How.XPATH, using = "//a[@href='change_password1234.aspx']")
	private WebElement changePasswordButton;

	// logout
	@FindBy(how = How.XPATH, using = "//a[@href='home.aspx']")
	private WebElement logoutButton;

	public AdminHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// click on branches
	public void clickBranchesButton() {
		this.branchesButton.click();
	}

	// click on roles
	public void clickRolesButton() {
		this.rolesButton.click();
	}

	// click on users
	public void clickUsersButton() {
		this.usersButton.click();
	}

	// click on employee
	public void clickEmployeeButton() {
		this.employeeButton.click();
	}

	// click on home
	public void clickHomeButton() {
		this.homeButton.click();
	}

	// click on change password
	public void clickChangePasswordButton() {
		this.changePasswordButton.click();
	}

	// click on logout
	public void clickLogoutButton() {
		this.logoutButton.click();
	}
}
