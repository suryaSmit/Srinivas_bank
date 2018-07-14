package hybrid.srinivas_bank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BranchCreationPage extends AdminHomePage{
	
	//branch name
	@FindBy(how = How.ID_OR_NAME, using = "txtbName")
	private WebElement branchName;
	
	//address1
	@FindBy(how = How.ID_OR_NAME, using = "txtAdd1")
	private WebElement address1;
	
	//zipcode
	@FindBy(how = How.ID_OR_NAME, using = "txtZip")
	private WebElement zipcode;
	
	//country
	@FindBy(how = How.ID_OR_NAME, using = "lst_counrtyU")
	private WebElement country;
	
	//state
	@FindBy(how = How.ID_OR_NAME, using = "lst_stateI")
	private WebElement state;
	
	//city
	@FindBy(how = How.ID_OR_NAME, using = "lst_cityI")
	private WebElement city;
	
	//submit
	@FindBy(how = How.ID_OR_NAME, using = "btn_insert")
	private WebElement submitButton;
	
	//reset
	@FindBy(how = How.ID_OR_NAME, using = "Btn_Reset")
	private WebElement resetButton;
	
	//cancel
	@FindBy(how = How.ID_OR_NAME, using = "Btn_cancel")
	private WebElement cancelButton;
	
	public BranchCreationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	//clear branch name
	public void clearBranchName() {
		this.branchName.clear();
	}
	
	//clear address1
	public void clearAddress1() {
		this.address1.clear();
	}
	
	//clear zipcode
	public void clearZipCode() {
		this.zipcode.clear();
	}
	
	//fill branch Name
	public void fillBranchName(String branchName) {
		this.branchName.sendKeys(branchName);
	}
	
	//fill address1
	public void fillAddress1(String address1) {
		this.address1.sendKeys(address1);
	}
	
	//fill zipcode
	public void fillZipCode(String zipcode) {
		this.zipcode.sendKeys(zipcode);
	}
	
	//select country
	public void selectCountry(String country) {
		new Select(this.country).selectByVisibleText(country);
	}
	
	//select state
	public void selectState(String state) {
		new Select(this.state).selectByVisibleText(state);
	}
	
	//select city
	public void selectCity(String city) {
		new Select(this.city).selectByVisibleText(city);
	}
	
	//click submit button
	public void clickSubmitButton() {
		this.submitButton.click();
	}
	
	//click reset button
	public void clickResetButton() {
		this.resetButton.click();
	}
	
	//click cancel button
	public void clickCancelButton() {
		this.cancelButton.click();
	}
}
