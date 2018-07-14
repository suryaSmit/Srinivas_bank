package hybrid.srinivas_bank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BranchesPage extends AdminHomePage{

	public BranchesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	//country dropdown list
	@FindBy(how=How.ID_OR_NAME, using="lst_countryS")
	private WebElement courtryEle;
	
	//state
	@FindBy(how=How.ID_OR_NAME, using="lst_stateS")
	private WebElement stateEle;
	
	//city
	@FindBy(how=How.ID_OR_NAME, using="lst_cityS")
	private WebElement cityEle;
	
	//search
	@FindBy(how=How.ID_OR_NAME, using="btn_search")
	private WebElement searchButton;
	
	//clear
	@FindBy(how=How.ID_OR_NAME, using="btn_clsearch")
	private WebElement clearButton;
	
	//newBranch
	@FindBy(how=How.ID_OR_NAME, using="BtnNewBR")
	private WebElement newBranchButton;
	
	//select country
	public void selectCountry(String country) {
		new Select(this.courtryEle).selectByVisibleText(country);
	}
	
	//select state
	public void selectState(String state) {
		new Select(this.stateEle).selectByVisibleText(state);
	}
	
	//select city
	public void selectCity(String city) {
		new Select(this.cityEle).selectByVisibleText(city);
	}
	
	//click on search
	public void clickSearchButton() {
		this.searchButton.click();
	}
	
	//click on clear
	public void clickClearButton() {
		this.clearButton.click();
	}
	
	//click on new Branch Button
	public void clickNewBranchButton() {
		this.newBranchButton.click();
	}
}
