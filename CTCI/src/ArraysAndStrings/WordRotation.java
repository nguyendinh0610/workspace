package ArraysAndStrings;

import java.util.*;

public class WordRotation {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		System.out.println(isRotation(s1, s2));
	}
	
	private static boolean isRotation(String s1, String s2){
		if (s1.length() != s2.length() || 
				s1.length() == 0 || s2.length() == 0){
			return false;
		}
		
		// if s2 is a rotation of s1
		// s2 have to be a substring of s1s1
		// s1 = xy, s2 = yx
		// s1s1 = xyxy
		String s = s1.concat(s1);
		
		return isSubstring(s, s2);
	}
	
	private static boolean isSubstring(String s1, String s2){
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		if (s2.length() > s1.length()){
			return false;
		}
		for (char c : s1.toCharArray()){
			if (hm.containsKey(c)){
				int currCount = ((Integer)hm.get(c)).intValue();
				hm.put(c, new Integer(currCount + 1));
			} else {
				hm.put(c, new Integer(1));
			}
		}
		for (char c : s2.toCharArray()){
			if (hm.containsKey(c)){
				int currCount = ((Integer)hm.get(c)).intValue();
				if (currCount == 1){
					hm.remove(c);
				} else {
					hm.put(c, new Integer(currCount + 1));
				}
			} else {
				return false;
			}
		}
		return true;
	}
}
