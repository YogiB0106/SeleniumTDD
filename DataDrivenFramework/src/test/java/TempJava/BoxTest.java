package TempJava;

class Box{
	
	double length;
	double height;
	double width;
	
	Box(double l, double w, double h){
		width=w;
		length=l;
		height=h;
	}
	
	Box(){
		width=-1;
		height=-1;
		length=-1;
	}
	
	Box(double len){
		width=height=length=len;
	}
	
	Box(Box ob){
		width=ob.width;
		length=ob.length;
		height=ob.height;
	}
	
	double volume() {
		return length * height * width;
	}
	
}



public class BoxTest {

	public static void main(String[] args) {
		Box mybox1=new Box(10,10,10);
		Box mybox2=new Box();
		Box mybox3=new Box(10);
		Box myClone=new Box(mybox1);
		
		
		
		double vol;
		
		System.out.println("mybox 1 volume="+mybox1.volume());
		System.out.println("mybox 2 volume="+mybox2.volume());
		System.out.println("mybox 3 volume="+mybox3.volume());
		System.out.println("myClone volume="+myClone.volume());

	}

}
