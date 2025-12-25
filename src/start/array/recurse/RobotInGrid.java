package start.array.recurse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RobotInGrid {

	public boolean pathExists(boolean maze[][]) {
		recursioncount=0;
		List<String> set=new ArrayList<>();

		boolean pathExists=pathExists(maze, 0, 0, set);
		System.out.println("path::"+set);
		return pathExists;
	}

	static int recursioncount=0;
	public boolean pathExists(boolean maze[][],int r,int c,List<String> set) {
		recursioncount++;
		if(r >= maze.length || c >= maze[r].length || !maze[r][c]) {
			return false;
		}

		if(r==maze.length-1 && c==maze[r].length-1) return true;

		if(pathExists(maze, r+1, c, set) || pathExists(maze, r, c+1, set)) {
			set.add(r+""+c);
			return true;
		}

		return false;
	}

	public boolean pathExistsMemoized(boolean maze[][]) {
		memoizedcount=0;
		List<String> set=new ArrayList<>();

		boolean pathExists=pathExistsMemo(maze, 0, 0, set);
		System.out.println("path::"+set);
		return pathExists;
	}

	static Map<String, Boolean> memo=new HashMap<>();
	static int memoizedcount=0;
	public boolean pathExistsMemo(boolean maze[][],int r,int c,List<String> list) {
		memoizedcount++;
		if(r >= maze.length || c >= maze[r].length || !maze[r][c]) {
			return false;
		}
		String key=r+""+c;
		if(memo.containsKey(key)) return false;

		if(r==maze.length-1 && c==maze[r].length-1)
			return true;

		if(pathExistsMemo(maze, r+1, c, list) || pathExistsMemo(maze, r, c+1, list)) {
			list.add(key);
			return true;
		}

		memo.put(key, false);
		return false;
	}

	public static void main(String[] args) {
		RobotInGrid test=new RobotInGrid();

		boolean mazeTrue[][]=new boolean[][]
				{
						{true,true,false,true},
						{true,true,false,true},
						{true,true,true,false},
						{true,false,true,true},
				};

		boolean mazeFalse[][]=new boolean[][]
				{
						{true,true,true,true,true},
						{true,true,true,true,true},
						{true,true,true,false,false},//last true and it will contain path
						{true,true,false,true,true},
				};

		System.out.println("pathExists::mazeTrue ::"+test.pathExists(mazeTrue)+" with recursion count::"+recursioncount);
		System.out.println("pathExists::mazeFalse ::"+test.pathExists(mazeFalse)+" with recursion count::"+recursioncount);


		System.out.println("pathExists::mazeTrue ::"+test.pathExistsMemoized(mazeTrue)+" with memoizedcount count::"+memoizedcount);
		System.out.println("pathExists::mazeFalse ::"+test.pathExistsMemoized(mazeFalse)+" with memoizedcount count::"+memoizedcount);

	}
}
