package arraysandstring;

import java.util.Stack;

public class Palindrome {
    public static Boolean isPalindrome(String s) {
        StringBuffer sgood = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(ch);

            }
        }
        StringBuffer reverse = new StringBuffer(sgood).reverse();
        return sgood.toString().equals(reverse.toString());

    }


    /**
     * 使用双指针。初始时，左右指针分别指向 sgood\textit{sgood}sgood 的两侧，随后我们不断地将这两个指针相向移动，每次移动一步，
     * 并判断这两个指针指向的字符是否相同。当这两个指针相遇时，就说明 sgood\textit{sgood}sgood 时回文串。
     *
     * @param s
     * @return
     */
    public boolean isPalindrome2(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        int n = sgood.length();
        int left = 0, right = n - 1;
        while (left < right) {
            if (Character.toLowerCase(sgood.charAt(left)) != Character.toLowerCase(sgood.charAt(right))) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }


    public static void main(String[] args) {
        isPalindrome("abccba");
    }



}
