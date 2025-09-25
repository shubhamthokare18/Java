package practice;

public class Strings1 {
    private String s;
    private int start = 0, maxLen = 0;

    public String longestPalindrome(String str) {
        if (str == null || str.length() < 1) return "";
        this.s = str;

        for (int i = 0; i < s.length(); i++) {
            expand(i, i);     // odd-length palindrome
            expand(i, i + 1); // even-length palindrome
        }

        return s.substring(start, start + maxLen);
    }

    private void expand(int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // after while loop ends, [left+1 .. right-1] is palindrome
        int len = right - left - 1;
        if (len > maxLen) {
            maxLen = len;
            start = left + 1;
        }
    }

    public static void main(String[] args) {
        Strings1 lp = new Strings1();
        System.out.println(lp.longestPalindrome("babad")); // Output: "bab" or "aba"
        System.out.println(lp.longestPalindrome("cbbd"));  // Output: "bb"
        System.out.println(lp.longestPalindrome("racecar")); // Output: "racecar"
    }
}