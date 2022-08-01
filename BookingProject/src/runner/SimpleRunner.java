package runner;

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

public class SimpleRunner {

	public static void main(String[] args) {

        TestNG testng =new TestNG();
		
		XmlSuite mySuite = new XmlSuite();
		//mySuite.setParallel(ParallelMode.TESTS);
		mySuite.setName("Booking Suite");
		List<XmlSuite> allSuites=new ArrayList<XmlSuite>();
		allSuites.add(mySuite);
		
		testng.setXmlSuites(allSuites);
		XmlTest createBookingTest = new XmlTest(mySuite);
		createBookingTest.setName("Create Booking Test- Apply discount - Pay@Hotel");
		
		Map<String,String> parameters=new HashMap<String, String>();
		parameters.put("action", "Pay@Hotel");
		createBookingTest.setParameters(parameters);
		List<XmlClass> testClasses=new ArrayList<XmlClass>();
		XmlClass testClass=new XmlClass("testcases.BookingSearch");
		List<XmlInclude> methods=new ArrayList<XmlInclude>();
		methods.add(new XmlInclude("serachHotel",1));
		methods.add(new XmlInclude("selectHotel",2));
		methods.add(new XmlInclude("enterGuestInfo",3));
		testClass.setIncludedMethods(methods);
		testClasses.add(testClass);
		
		//adding more tests
		testClass=new XmlClass("testcases.PaymentManager");
		methods=new ArrayList<XmlInclude>();
		methods.add(new XmlInclude("applyDiscount",1));
		methods.add(new XmlInclude("makePayment",2));
		testClass.setIncludedMethods(methods);
		testClasses.add(testClass);
		
		//adding more tests. Here adding class with all methods not including or excluding any methods
		testClass=new XmlClass("testcases.CustomerCommunicatios");
		testClasses.add(testClass);
		
		
		createBookingTest.setXmlClasses(testClasses);
		//-------------------------------------------------
		//2nd Test
		XmlTest InstantPayTest = new XmlTest(mySuite);
		createBookingTest.setName("Create Booking Test- Apply discount - Instantpay");
		
		Map<String,String> parametersInstantPayTest=new HashMap<String, String>();
		parametersInstantPayTest.put("action", "Instantpay");
		InstantPayTest.setParameters(parametersInstantPayTest);
		List<XmlClass> testClasses_InstantPay=new ArrayList<XmlClass>();
		XmlClass testClass_InstantPayTest=new XmlClass("testcases.BookingSearch");
		List<XmlInclude> methods_InstantPay=new ArrayList<XmlInclude>();
		methods_InstantPay.add(new XmlInclude("serachHotel",1));
		methods_InstantPay.add(new XmlInclude("selectHotel",2));
		methods_InstantPay.add(new XmlInclude("enterGuestInfo",3));
		testClass_InstantPayTest.setIncludedMethods(methods_InstantPay);
		testClasses_InstantPay.add(testClass_InstantPayTest);
		
		//adding more tests
		testClass_InstantPayTest=new XmlClass("testcases.PaymentManager");
		methods_InstantPay=new ArrayList<XmlInclude>();
		methods_InstantPay.add(new XmlInclude("applyDiscount",1));
		methods_InstantPay.add(new XmlInclude("makePayment",2));
		testClass_InstantPayTest.setIncludedMethods(methods_InstantPay);
		testClasses_InstantPay.add(testClass_InstantPayTest);
		
		//adding more tests. Here adding class with all methods not including or excluding any methods
		testClass_InstantPayTest=new XmlClass("testcases.CustomerCommunicatios");
		testClasses_InstantPay.add(testClass_InstantPayTest);
		
		
		InstantPayTest.setXmlClasses(testClasses_InstantPay);
		
	
//--------------------------------------------
		
		
		
		testng.run();

	}

}
