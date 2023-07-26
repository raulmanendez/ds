package start.recursion;

public class CountPaths {

	public static int countPaths(int row, int col, int destRow, int destCol) {
		
		System.out.println("row "+row+" col "+col+" destRow "+destRow+" destCol "+destCol);
		
	    if (row == destRow && col == destCol) {
	        return 1; // Base case: reached the destination cell
	    }

	    int rightPaths = 0;
	    int downPaths = 0;

	    // Move right if within the grid boundaries
	    if (col < destCol) {
	        rightPaths = countPaths(row, col + 1, destRow, destCol);
	    }

	    // Move down if within the grid boundaries
	    if (row < destRow) {
	        downPaths = countPaths(row + 1, col, destRow, destCol);
	    }

	    // Total paths from current cell to destination = rightPaths + downPaths
	    
	    System.out.println("returning "+" rightPaths "+rightPaths +" downPaths "+ downPaths+" paths for row "+row+" col "+col+" destRow "+destRow+" destCol "+destCol);
	    return rightPaths + downPaths;
	}
	
	public static void main(String[] args) {
		System.out.println(countPaths(0, 0, 2, 2));
	}
}
