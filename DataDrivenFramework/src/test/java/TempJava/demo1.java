package TempJava;


class kata{
	
	  public static int grow(int[] x){
		    int result = 1;
		    for (int a : x) {
		      result *= a;
		    }
		    return result;
		  }
}

public class demo1 {

	public static void main(String[] args) {

  kata ob=new kata();
  
  int[] y= {1,2,3,4};
  System.out.println(ob.grow(y));

	}

}
