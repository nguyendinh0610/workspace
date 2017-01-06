package ArraysAndStrings;

import java.util.*;

public class StringReplacement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		System.out.println(replaceSpaceFromString(s));
	}
	
	private static String replaceSpaceFromString(String s){
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()){
			if (c == ' '){
				sb.append("%20");
			} else {
				sb.append(Character.toString(c));
			}
		}
		return sb.toString();
	}

}
