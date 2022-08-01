package TempJava;

import java.util.Random;

public class HandleError {

	public static void main(String[] args) {
		
		
		int a=0, b=0, c=0;
		
		Random r =new Random();
		
		for(int i=0; i<21; i++) {
			
			try {
				b=r.nextInt();
				c=r.nextInt();
				a=12345/ (c/b);
				
			}catch(ArithmeticException e) {
				System.out.println("Division by Zero");
				a=0;
			}
			
			System.out.println("a: "+a);
			System.out.println("b: "+b);
			System.out.println("c: "+c);
		}
	}

}
