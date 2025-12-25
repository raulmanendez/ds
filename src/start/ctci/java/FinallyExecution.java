package start.ctci.java;

public class FinallyExecution {

	
	public static void main(String[] args) {
		
		
		try {
			
			System.out.println("Try...");
			System.exit(0);
		} finally {
			System.out.println("Finally...");
		}
	}
}
