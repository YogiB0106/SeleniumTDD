package TempJava;



class outer{
	
	int outer_x=100;
	
	void test() {
	Inner ob=new Inner();
	ob.display();
	}
	class Inner{
		
		void display() {
			System.out.println("outer x is accessed by inner class and value is:"+outer_x);
		}
	}
	
}

public class NestedClassDemo {

	public static void main(String[] args) {
		outer ob=new outer();
		System.out.println(ob.outer_x);
		ob.test();
		

	}

}
