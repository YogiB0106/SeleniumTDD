package testcases.rediff;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import testbase.BaseTest;

public class Testcheck extends BaseTest {
	
	@Test
	public void deleteclick() {
		System.out.println("Logging in");
		test.log(Status.INFO, "Logging In");		
				
		app.openBrowser("Chrome");
		app.navigate("url");
		app.type("username_id", "yogesh_biswas");
		app.type("password_id", "Yogirediff@1");
		app.click("login_button_xpath");
		app.selectByVisibleText("portfolio_dropdown_id", "PortfolioYogi002");
		app.wait(10);
		app.click("deletePortfolio_id");
	}

}
