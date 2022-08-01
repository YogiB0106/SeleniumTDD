package testbase;

import org.testng.ITestContext;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import keywords.ApplicationKeywords;
import reports.ExtentManager;

public class BaseTest {
	
	public ApplicationKeywords app;
	public ExtentReports rep;
	public ExtentTest test;
	
	@BeforeTest(alwaysRun = true)
	public void beforeTest(ITestContext context) {
		System.out.println("------------------Before Test------------------");
		//init and share with all tests
		app=new ApplicationKeywords(); //1 app keyword object for entire tests-All the @Test
		context.setAttribute("app", app);
		
		//init the reporting for the test
		rep=ExtentManager.getReports();
		test=rep.createTest(context.getCurrentXmlTest().getName());
		test.log(Status.INFO, "Starting Test : "+context.getCurrentXmlTest().getName());
		app.setReport(test);
		context.setAttribute("report", rep);
		context.setAttribute("test", test);
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(ITestContext context) {
		System.out.println("******************Before Method******************");
		
		test=(ExtentTest)context.getAttribute("test");
		String criticalFailure=(String)context.getAttribute("criticalFailure");
		if(criticalFailure != null && criticalFailure.equals("Y")) {
			test.log(Status.SKIP, "Critical Failure in previous Tests");//skip in Extent report
			throw new SkipException("Critical Failure in previous Tests"); //skip in TestNG
		}
		app= (ApplicationKeywords)context.getAttribute("app");
		rep=(ExtentReports)context.getAttribute("report");
		
	}
	
	
	@AfterTest
	public void quit() {
		if(rep !=null)
			rep.flush();
	}
	
	

}
