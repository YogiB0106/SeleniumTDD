package testcases;

import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PaymentManager {
	
	@Test
	public void applyDiscount() {
		System.out.println("Applying discount code");
	}
	
	@Parameters({"action"})
	@Test
	public void makePayment(String paymentType, ITestContext context) {
		
		if(paymentType.equals("Pay@Hotel"))
		    System.out.println("Making payment at Hotel");
		else
			System.out.println("Making Instant payment");
		
		
		String bookingId="12232eed45";
		context.setAttribute("bookingId", bookingId);
		
	}

}
