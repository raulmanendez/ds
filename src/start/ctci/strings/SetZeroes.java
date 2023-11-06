package start.ctci.strings;

import start.array.easy.MyArrayUtil;

public class SetZeroes {

	public static void setZeroes(int matrix[][]) {
		
		boolean z_rows[]=new boolean[matrix.length];
		boolean z_cols[]=new boolean[matrix[0].length];
		
		for(int i=0;i<matrix.length;i++) {
			
			for(int j=0;j<matrix[i].length;j++) {
				
				if(matrix[i][j]==0) {
					z_rows[i]=true;
					z_cols[j]=true;
				}
			}
		}
		
		for(int i=0;i<z_rows.length;i++) {
			if(z_rows[i]) clearRow(matrix,i);
		}
		
		for(int i=0;i<z_cols.length;i++) {
			if(z_cols[i]) clearCol(matrix,i);
		}
		
	}
	
	public static void clearRow(int matrix[][],int index) {
		for(int i=0;i<matrix[0].length;i++) {
			matrix[index][i]=0;
		}
	}
	
	public static void clearCol(int matrix[][],int index) {
		for(int i=0;i<matrix.length;i++) {
			matrix[i][index]=0;
		}
	}

	public static void main(String[] args) {
		int matrix[][] = { { 1, 2, 3, 4, 0 }, { 5, 6, 7, 1, 8 }, { 0, 2, 5, 6, 7 } };
		
		System.out.println("Before Set Zero::");
		MyArrayUtil.print(matrix);
		
		setZeroes(matrix);
		
		System.out.println("After Set Zero::");
		
		MyArrayUtil.print(matrix);
	}
}
