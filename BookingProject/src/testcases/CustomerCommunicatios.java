package testcases;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class CustomerCommunicatios {

	@Test
	public void checkEmail(ITestContext context) {
		System.out.println("Checking email for confirmation");
		String bookingId=(String) context.getAttribute("bookingId");
		System.out.println("booking id is: "+bookingId);
		
	}
	
	
	
}
