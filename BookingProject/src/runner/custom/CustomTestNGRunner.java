package runner.custom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlSuite.ParallelMode;
import org.testng.xml.XmlTest;

public class CustomTestNGRunner {

	List<XmlSuite> mySuites;// all the test suites to run
    XmlSuite suite;// single test suite
    List<XmlTest> suiteTestCases;// all test cases under suite
    XmlTest test;// test case
    Map<String,String> testngParams;
    List<XmlClass> testClasses;  //all classes in a test
    TestNG myTestNG;
	
    public CustomTestNGRunner(int ThreadPoolSize) {
    	mySuites = new ArrayList<XmlSuite>();// all suites- initialized empty
    	myTestNG = new TestNG();
    	myTestNG.setSuiteThreadPoolSize(ThreadPoolSize);// how many suites can run parallel 
    	myTestNG.setXmlSuites(mySuites);//inform testng about test suites
		
	}
    
    
    //Creates a suite in list of suites
    public void createSuite(String suiteName,boolean parallelTests) {
		suite = new XmlSuite(); // create suite
		suite.setName(suiteName);
		if(parallelTests)
			suite.setParallel(ParallelMode.TESTS);  // enable parallel execution of tests in suite
		mySuites.add(suite);  // set the suite in list of suites
		//suite.setTests(suiteTestCases);
			
	}
    
    //add a test case inside the suite
    public void addTest(String testName) {
		test = new XmlTest(suite); // create a test in suite.Map it to suite
		test.setName(testName);    // name of the test
		testngParams = new HashMap<String, String>();// init test para- blank
		test.setParameters(testngParams);// blank-0 parameters
		testClasses = new ArrayList<XmlClass>();// empty test classes
		test.setXmlClasses(testClasses);// blank - 0 claasses
		
		//suiteTestCases.add(test);  // add test to suite
		
	}
    
    //set parameters of the test
    public void addTestParameter(String key, String value) {
    	testngParams.put(key, value);
	}
    
    //set a test class to list of classes in test
    public void addTestClass(String fullClassName, List<String> includedMethodNames) {
		XmlClass testClass=new XmlClass(fullClassName); // 1 class
		List<XmlInclude> includeMethods = new ArrayList<XmlInclude>(); // add include methods in class
		int priority=1;
		for(String name: includedMethodNames) {
			//XmlInclude xmlInclude = new XmlInclude(name,priority);
			//xmlInclude.setName(name);
			includeMethods.add(new XmlInclude(name,priority));
			priority++;
		}
		testClass.setIncludedMethods(includeMethods);  // add class to test of classes
		testClasses.add(testClass); // add classs to test classes
	}
    
    public void run() {
    	myTestNG.run();
    }
    
	
}
