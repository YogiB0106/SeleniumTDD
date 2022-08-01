package testcases.rediff;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import testbase.BaseTest;

public class PortfolioManagement extends BaseTest {

	
	@Test
	public void createPortfolio(ITestContext context) {
		
		String portfolioName="PortfolioYogi007";
		System.out.println("Creating Portfolio");
		test.log(Status.INFO, "Creating Portfolio");
		app.log("Creating Portfolio");
		app.click("createPortfolio_id");
		app.clear("portfolioName_id");
		app.type("portfolioName_id", portfolioName);
		app.click("createPortfolioButton_id");
		app.waitForPageToLoad();
		app.validateSelectedValueInDropdwon("portfolio_dropdown_id", portfolioName);
		
	}
	
	@Test
	public void deletePortfolio() {
		String portfolioName="PortfolioYogi007";
		
		test.log(Status.INFO, "Deleting Portfolio");
		app.log("Deleting portfolio");
		app.selectByVisibleText("portfolio_dropdown_id", portfolioName);
		//app.waitForPageToLoad();
		app.wait(15);
		app.click("deletePortfolio_id");
		app.acceptAlert();
		app.validateSelectedValueNOTInDropdwon("portfolio_dropdown_id", portfolioName);
		
	}
	
	@Test
	public void selectPortfolio() {
		app.log("Selecting Portfolio");
		app.selectByVisibleText("portfolio_dropdown_id", "PortfolioYogi001");//data is portfolio name which suppose to select.Change it
		app.wait(5);
	}
	
	
}
