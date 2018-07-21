package hybrid.srinivas_bank;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class GridExecution extends TestExecution{
	@BeforeClass(groups= {"branch", "search", "clear", "create" , "reset", "duplicate", "emptydata", "role", "employee", "data_driven"})
	@Parameters({"browser", "url", "nodeURL"})
	public void launchDefultBrowser(String browser, String url,String nodeURL) {
		launchBrowser(browser, url, nodeURL);
		initialize();
	}
	
	@AfterClass(groups= {"branch", "search", "clear", "create" , "reset", "duplicate", "emptydata", "role", "employee", "data_driven"})
	public void close() {
		closeBrowser();
	}

}
