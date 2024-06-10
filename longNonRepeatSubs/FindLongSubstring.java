package longNonRepeatSubs;

import java.util.HashMap;

public class FindLongSubstring {

	public static void main(String[] args) {
		// Find longest substring without repeating characters
		//"ohomm"
		//"abcabcbb"
		//"pwwkew"
		//"bbbbbbb"
		System.out.println(shorter("ohmm"));
		System.out.println(shorter("abcabcbb"));
		System.out.println(shorter("pwwkew"));
		System.out.println(shorter("bbbbbbb"));	
		System.out.println(shorter("abcdefg"));

	}
	public static int shorter(String s) {
		int maxLen = 0;
		HashMap<Character,Integer> foundChars = new HashMap<>();
		for (int right = 0, left = 0; right < s.length(); right++ ) {
			char curChar = s.charAt(right);
			if (foundChars.containsKey(curChar) && foundChars.get(curChar) >= left) {
				left= foundChars.get(curChar) + 1;
			}
			maxLen = Math.max(maxLen, right-left+1);
			foundChars.put(curChar,right);
		}
		return maxLen;
	}
}
