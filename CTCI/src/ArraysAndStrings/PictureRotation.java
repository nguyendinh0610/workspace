package ArraysAndStrings;

import java.util.*;

public class PictureRotation {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int[][] pic = new int[n][n];
		String line;
		for (int i = 0; i < n; i++){
			line = sc.nextLine();
			for (int j = 0; j < n; j++){
				pic[i][j] = Character.getNumericValue(line.charAt(j));
			}
		}
		sc.close();
		rotatePicture(pic);
		for (int i = 0; i < n; i++){
			for (int j = 0; j < n; j++){
				System.out.print(pic[i][j]);
			}
			System.out.println();
		}
	}
	
	private static void rotatePicture(int[][] pic){
		for (int layer = 0; layer < pic.length/2; layer++){
			int first = layer;
			int last = pic.length -1 - layer;
			for (int i = first; i < last; i++){
				int offset = i - first;
				
				// save top
				int top = pic[first][i];
				
				// left -> top
				pic[first][i] = pic[last - offset][first];
				
				// bottom -> left
				pic[last - offset][first] = pic[last][last - offset];
				
				// right -> bottom
				pic[last][last - offset] = pic[i][last];
				
				// top -> right
				pic[i][last] = top;
			}
		}
	}
}
