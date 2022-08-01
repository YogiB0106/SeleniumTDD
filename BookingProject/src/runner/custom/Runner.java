package runner.custom;

import java.util.ArrayList;
import java.util.List;



public class Runner {
	
	public static void main(String[] args) {
		
		
		CustomTestNGRunner runner=new CustomTestNGRunner(1);
		runner.createSuite("Booking Suite", false);
		runner.addTest("Create Booking Test- Apply discount - Pay@Hotel");
		runner.addTestParameter("action", "Pay@Hotel");
		
		List<String> includedMethodNames=new ArrayList<String>();
		includedMethodNames.add("serachHotel");
		includedMethodNames.add("selectHotel");
		includedMethodNames.add("enterGuestInfo");
		runner.addTestClass("testcases.BookingSearch", includedMethodNames);
		
		//2nd test
		includedMethodNames=new ArrayList<String>();
		includedMethodNames.add("applyDiscount");
		includedMethodNames.add("makePayment");
		runner.addTestClass("testcases.PaymentManager", includedMethodNames);
		
		
		//3rd Test
		includedMethodNames=new ArrayList<String>();
		runner.addTestClass("testcases.CustomerCommunicatios", includedMethodNames);
		
		runner.run();
		
		
	}
}
