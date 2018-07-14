package hybrid.srinivas_bank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RolePage {
	// NewRole Button
	@FindBy(how = How.ID, using = "btnRoles")
	private WebElement newRole;

	public RolePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Click on New Role
	public void clickNewRole() {
		this.newRole.click();

	}
}
