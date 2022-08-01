package keywords;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import reports.ExtentManager;

public class GenericKeywords {

	
	public WebDriver driver; 
	public Properties prop;
	public Properties envProp;
	public ExtentTest test;
	public SoftAssert softAssert;
	
	public void openBrowser(String browser) {
		System.out.println("opening the browser"+browser);
		log( "opening the browser : "+browser);
		
		if(browser.equals("Chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jumpy\\Desktop\\Ashish Thakur\\Jars\\Chrome-103\\chromedriver.exe");
		driver=new ChromeDriver();
		}else if(browser.equals("Mozilla")) {
			System.setProperty("webdriver.gecko.driver", " specified the jar location");
			driver=new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
	}
	
	public void navigate(String urlKey) {
		System.out.println("Navigate to  "+envProp.getProperty(urlKey));
		test.log(Status.INFO, "Navigate to  "+envProp.getProperty(urlKey));
		driver.get(envProp.getProperty(urlKey));
	}
	
	public void click(String locatorKey) {
		//driver.findElement(By.xpath(locatorKey)).click();;
		//driver.findElement(By.xpath(envProp.getProperty(locatorKey))).click();
		System.out.println("Clicking on element : "+" ' "+locatorKey+" ' ");
		test.log(Status.INFO, "Clicking on element : "+" ' "+locatorKey+" ' ");
		getElemnt(locatorKey).click();
	}
	
	public void type(String locatorKey, String data) {
		System.out.println("Typing in feild box: "+" ' "+ locatorKey+" ' "+ " and the type data is : "+" ' "+ data +" ' ");
		//driver.findElement(By.id(envProp.getProperty(locatorKey))).sendKeys(data);;
		test.log(Status.INFO, "Typing in feild box: "+" ' "+ locatorKey+" ' "+ " and the type data is : "+" ' "+ data +" ' ");
		getElemnt(locatorKey).sendKeys(data);
	}
	
	public void select(String locator, String data) {
		
	}
	
	public String getText(String locatorKey) {
		return getElemnt(locatorKey).getText();
	}
	
	
	//central function to extract element
	public WebElement getElemnt(String locatorKey) {
		
		if(!isElementPrestent(locatorKey)) {
			//report failure
			System.out.println("Element not present "+ locatorKey);
		}
		if(!isElementVisible(locatorKey)) {
			//report failure
			System.out.println("Element not visible "+ locatorKey);
		}
		
		
		WebElement e=driver.findElement(getLocator(locatorKey));
		
		
		return e;
		
	}
	
	public boolean isElementPrestent(String locatorKey) {
		System.out.println("checking presence of element "+locatorKey);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			
			//we can use only below commented code and skip all if-else
			//wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorKey)));
			
			if(locatorKey.endsWith("_id"))
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id(envProp.getProperty(locatorKey))));
				else if(locatorKey.endsWith("_xpath"))
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(envProp.getProperty(locatorKey))));
				else if(locatorKey.endsWith("_css"))
					wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(envProp.getProperty(locatorKey))));
				else if(locatorKey.endsWith("_name"))
					wait.until(ExpectedConditions.presenceOfElementLocated(By.name(envProp.getProperty(locatorKey))));
			
		}catch(Exception e) {
			return false;
		}
		return true;
		
	}
	
    public boolean isElementVisible(String locatorKey) {
    	System.out.println("checking visibility of element "+locatorKey);
    	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    	try {
    		
    		//we can use only below commented code and skip all if-else
			//wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator(locatorKey)));
    		
    		if(locatorKey.endsWith("_id"))
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(envProp.getProperty(locatorKey))));
				else if(locatorKey.endsWith("_xpath"))
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(envProp.getProperty(locatorKey))));
				else if(locatorKey.endsWith("_css"))
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(envProp.getProperty(locatorKey))));
				else if(locatorKey.endsWith("_name"))
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(envProp.getProperty(locatorKey))));
    		
		
    	}catch(Exception e) {
    		return false;
    	}
    	return true;
	}
	
	public By getLocator(String locatorKey) {
		
		By by=null;
		
		    if(locatorKey.endsWith("_id"))
			    by=By.id(envProp.getProperty(locatorKey));
			else if(locatorKey.endsWith("_xpath"))
				by=By.xpath(envProp.getProperty(locatorKey));
			else if(locatorKey.endsWith("_css"))
				by=By.cssSelector(envProp.getProperty(locatorKey));
			else if(locatorKey.endsWith("_name"))
				by=By.name(envProp.getProperty(locatorKey));
		
		return by;
	}
	
	//reporting function
	
	public void log(String msg) {
		System.out.println(msg);
		test.log(Status.INFO, msg);
	}
	
	public void reportFailure(String failureMsg,boolean stopOnFailure) {
		System.out.println(failureMsg);
		test.log(Status.FAIL, failureMsg);//fail in extent report
		takeScreenShot();//put the screenshot in reports
		softAssert.fail(failureMsg); // fail in TestNG
		
		if(stopOnFailure) {
			Reporter.getCurrentTestResult().getTestContext().setAttribute("criticalFailure", "Y");
			assertAll();
		}
		
	}
	
	public void assertAll() {
		
		softAssert.assertAll();
	}
	
	public void takeScreenShot(){
		// fileName of the screenshot
		Date d=new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		// take screenshot
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			// get the dynamic folder name
			FileUtils.copyFile(srcFile, new File(ExtentManager.screenshotFolderPath+"//"+screenshotFile));
			//put screenshot file in reports
			test.log(Status.INFO,"Screenshot-> "+ test.addScreenCaptureFromPath(ExtentManager.screenshotFolderPath+"//"+screenshotFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void waitForPageToLoad(){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int i=0;
		// ajax status
		while(i!=10){
		String state = (String)js.executeScript("return document.readyState;");
		System.out.println(state);

		if(state.equals("complete"))
			break;
		else
			wait(2);

		i++;
		}
		// check for jquery status
		i=0;
		while(i!=10){
	
			Long d= (Long) js.executeScript("return jQuery.active;");
			System.out.println(d);
			if(d.longValue() == 0 )
			 	break;
			else
				 wait(2);
			 i++;
				
			}
		
		}
	
	public void wait(int time) {
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	public void clear(String locatorKey) {
		getElemnt(locatorKey).clear();
	}
	
	public void clickEnterButton(String locatorKey) {
		log("Clinking enter button");
		getElemnt(locatorKey).sendKeys(Keys.ENTER);
	}
	
	public void selectByVisibleText(String locatorKey, String data) {
		Select s = new Select(getElemnt(locatorKey));
		s.selectByVisibleText(data);
	}
	
	public void acceptAlert(){
		test.log(Status.INFO, "Switching to alert");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
		try{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			test.log(Status.INFO, "Alert accepted successfully");
		}catch(Exception e){
				reportFailure("Alert not found when mandatory",true);
		}
		
	}
	
	// finds the row number of the data
		public int getRowNumWithCellData(String tableLocator, String data) {
			
			WebElement table = getElemnt(tableLocator);
			List<WebElement> rows = table.findElements(By.tagName("tr"));
			for(int rNum=0;rNum<rows.size();rNum++) {
				WebElement row = rows.get(rNum);
				List<WebElement> cells = row.findElements(By.tagName("td"));
				for(int cNum=0;cNum<cells.size();cNum++) {
					WebElement cell = cells.get(cNum);
					System.out.println("Text "+ cell.getText());
					if(!cell.getText().trim().equals(""))
						if(data.startsWith(cell.getText()))
							return(rNum+1);
				}
			}
			
			return -1; // data is not found
		}
	
	
	
}
