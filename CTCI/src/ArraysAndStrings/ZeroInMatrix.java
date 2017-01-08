package ArraysAndStrings;

import java.util.*;

public class ZeroInMatrix {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		sc.nextLine();
		int[][] matrix = new int[m][n];
		for (int i = 0; i < matrix.length; i++){
			String s = sc.nextLine();
			int j = 0;
			for (char c : s.toCharArray()){
				matrix[i][j] = Character.getNumericValue(c);
				j++;
			}
		}
		sc.close();
		setZeroInMatrix(matrix);
		for (int[] row : matrix){
			for (int value : row){
				System.out.print(value);
			}
			System.out.println();
		}
	}
	
	private static void setZeroInMatrix(int[][] matrix){
		// Store positions of the rows with zero
		Stack<Integer> rows = new Stack<Integer>();
		
		// Store position of the cols with zero
		Stack<Integer> cols = new Stack<Integer>();
		
		// Iterate through the matrix and get positions of zeros
		for (int row = 0; row < matrix.length;){
			for (int col = 0; col < matrix[0].length;){
				if (matrix[row][col] == 0){
					rows.add(row);
					cols.add(col);
				}
				col++;
			}
			row++;
		}
		
		// Set the entire row to zero
		while (!rows.isEmpty()){
			int row = rows.pop();
			for(int col = 0; col < matrix[row].length;){
				matrix[row][col] = 0;
				col++;
			}
		}
		
		// Set the entire col with zero
		while(!cols.isEmpty()){
			int col = cols.pop();
			for(int row = 0; row < matrix.length;){
				matrix[row][col] = 0;
				row++;
			}
		}
	}
}
