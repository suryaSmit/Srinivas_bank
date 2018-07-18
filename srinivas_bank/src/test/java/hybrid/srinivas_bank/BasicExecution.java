package hybrid.srinivas_bank;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BasicExecution extends TestExecution{
	@BeforeClass(groups= {"branch", "search", "clear", "create" , "reset", "duplicate", "emptydata", "role", "employee", "data_driven"})
	public void launchDefultBrowser() {
		launchBrowser();
		initialize();
	}
	
	@AfterClass(groups= {"branch", "search", "clear", "create" , "reset", "duplicate", "emptydata", "role", "employee", "data_driven"})
	public void close() {
		closeBrowser();
	}

}
