package TempJava;

public class enumDemo {

	public static void main(String[] args) {

		Apple ap, ap2, ap3;
		
		ap=Apple.GoldenDel;
		ap=Apple.Jonathan;
		
		System.out.println(ap);
		ap=Apple.valueOf("GoldenDel");
		System.out.println(ap);
		
		for(Apple a: Apple.values()) {
			System.out.println(a);
		}
		
		//System.out.println("Winsap costs "+Apple.Winesap.getPrice()+" cents.");
		System.out.println("-------------------------------");
		for(Apple a: Apple.values()) {
			System.out.println(a +" "+a.ordinal());
		}
		System.out.println("-------------------------------");
		
		int i=200;
		Integer iob=Integer.valueOf(i);
		System.out.println(iob);
		int x=iob.intValue();
		System.out.println("x value is :"+x);
		System.out.println("-------------------------------");
		
		Long lob=Long.valueOf(300000);
		System.out.println(lob);
		System.out.println("-------------------------------");
		Character cob=Character.valueOf('b');
		System.out.println(cob);
		
		
		boolean boo1=false;
		boolean boo2=true;
		
		String str1=new Boolean(boo1).toString();
		System.out.println(str1);
		
		
	
		

	}

}
