package start.array.recurse;

class Grid {
	int nRows = 3;
	int nCols = 3;
	int grid[][] = new int[nRows][nCols];
	
	void markBlocked(int x ,int y) {
		grid[x][y] = 1;//1 means blocked
	}
	
	boolean move(int x,int y) {
		if(x > nRows -1 || y > nCols -1) {
			return false;
		}
		
		if(grid[x][y]==1) return false;
		
		if(x==nRows-1 && y==nCols-1) {
			return true;
		}
		
		boolean rightPath = move(x + 1, y);
		boolean downPath = move(x , y + 1);
		
		return rightPath || downPath ;
	}
}

public class RobotInGridV2 {

	
	public static void main(String[] args) {
		 Grid grid= new Grid();
		 grid.markBlocked(0, 1);
//		 grid.markBlocked(1, 0);
		
		 boolean exists =  grid.move(0, 0);
		
		System.out.println(exists);
	}
	
	
	
}
