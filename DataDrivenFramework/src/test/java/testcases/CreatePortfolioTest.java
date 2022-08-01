package testcases;

import org.testng.annotations.Test;

import keywords.ApplicationKeywords;
import keywords.GenericKeywords;

public class CreatePortfolioTest {
	
	
	
	@Test
	public void createPortFolioTest() throws InterruptedException {
		
	ApplicationKeywords app=new ApplicationKeywords();
	
	app.openBrowser("Chrome");
	//app.navigate("https://portfolio.rediff.com/portfolio-login");
	app.navigate("url");
	//password rediff Yogirediff@1
	
	//Thread.sleep(10);
	//app.type("useremail", "yogesh_biswas");
	app.type("username_id", "yogesh_biswas");
	app.type("password_id", "Yogirediff@1");
	app.click("login_button_xpath");
	
	
	
	
	}

}
