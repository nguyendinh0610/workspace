package ArraysAndStrings;

import java.util.*;

public class CompressString {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		if (checkInput(s)){
			System.out.println(compressString(s));
		}
	}
	
	private static boolean checkInput(String s){
		if (s == null || s.isEmpty()){
			return false;
		}
		
		return true;
	}
	
	private static String compressString(String s){
		int count = 1;
		char[] charArr = s.toCharArray();
		char prevChar = s.charAt(0);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < charArr.length; i++) {
			
			if (prevChar == charArr[i]){
				count++;
			} else {
				// Insert the previous char and count
				// since it is now reading through a new one
				sb.append(prevChar);
				sb.append(count);
				count = 1;
			}
			prevChar = charArr[i];
			if (sb.length() > s.length()){
				return s;
			}
		}
		
		// Insert the last char and its count into the string
		sb.append(Character.toString(prevChar));
		sb.append(count);
		return sb.toString();
	}
}
