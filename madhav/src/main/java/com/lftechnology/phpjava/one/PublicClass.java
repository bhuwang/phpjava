package main.java.com.lftechnology.phpjava.one;

public class PublicClass {
	public void outputString() {
		System.out.println("Output from method of public class");
	}
	
	public void accessDefaultOut() {
		DefaultClass dc = new DefaultClass();
		dc.outputString();
	}
}
