package start.ctci.java;

public class A {

	private A() {
		
	}
	
	//inner class can access A's constructor
	static class AA {
		A a = new A();
		
		AA() {
			
		}
	}
}
