package TempJava;

class Balance{
	
	String name;
	double bal;
	
	Balance(String n, double b){
		name=n;
		bal=b;
	}
	
	void show() {
		if(bal<0) {
			System.out.print("--> ");
		}
		System.out.println(name + ": $"+bal);
	}
}


public class AAccountBalance {

	public static void main(String[] args) {
		Balance current[]=new Balance[3];
		current[0]=new Balance("Yogi 1", 123.23);
		current[1]=new Balance("will tell", 157.02);
		current[2]=new Balance("linh", -12.32);
		
		
		for(int i=0;i<3;i++) {
			current[i].show();

		}
	}

}
