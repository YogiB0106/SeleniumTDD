package TempJava;


class RecTest{
	int values[];
	
	RecTest(int i){
		values=new int[i];
	}
	
	//display array
	void printArray(int i) {
		if(i==0) return;
		else printArray(i-1);
		System.out.println("["+(i-1) + "]"+values[i-1]);
	}
	
}

public class recurssion {

	public static void main(String[] args) {
		
		RecTest ob1=new RecTest(10);
		int i;
		
		for(i=0;i<10;i++) ob1.values[i]=i;
		
		ob1.printArray(10);
	}

}
