package testcases.rediff;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import keywords.ApplicationKeywords;
import testbase.BaseTest;

public class Session extends BaseTest {
	
	@Test
	public void doLogin(ITestContext context) {
		System.out.println("Logging in");
		test.log(Status.INFO, "Logging In");		
				
		app.openBrowser("Chrome");
		app.navigate("url");
		app.type("username_id", "yogesh_biswas");
		app.type("password_id", "Yogirediff@1");
		app.click("login_button_xpath");
		
	}
	
	
	@Test
	public void doLogout() {
		System.out.println("Logging Out");
	}
	

}
