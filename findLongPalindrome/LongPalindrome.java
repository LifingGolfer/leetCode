package findLongPalindrome;

public class LongPalindrome {

	public static void main(String[] args) {

		String s = "cbbd";
		
		System.out.println(longestPalindrome(s));
		
	}

	public static String longestPalindrome(String s) {
		int len=0;
		int maxLen = 0;
		String longPalindrome = "";

		for (int i=0; i<s.length(); i++) {
			String l1 = searchFromMiddle(s, i, i);
			String l2 = searchFromMiddle(s, i ,i+1);

			len = Math.max(l1.length(), l2.length());
			if (len  > maxLen) {
				maxLen = len;
				if (l1.length() > l2.length()) {
					longPalindrome = l1;
				} else {
					longPalindrome = l2;
				}
			}
		}
		return longPalindrome;
	}



public static String searchFromMiddle(String s, int left, int right) {

	while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
		left--;
		right++;
	}

	String palindrome = s.substring(left+1,right);
	return palindrome;
	//return right - left - 1;
}


}
