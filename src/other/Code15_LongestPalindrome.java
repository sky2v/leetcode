package other;

/**
 * 暴力破解
 * 1.根据回文子串的定义，枚举所有长度大于等于 2 的子串，依次判断它们是否是回文；
 * 2.可以只针对大于「当前得到的最长回文子串长度」的子串进行回文验证；
 * 3.当得到了一个更长的回文时，不需要真的做截取。只需要记录「当前子串的起始位置」和「子串长度」。
 * <p>
 *
 * 最长回文子串
 */
public class Code15_LongestPalindrome {

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // s.charAt(i) 每次都会检查数组下标越界，因此先转换成字符数组
        char[] charArray = s.toCharArray();

        // 枚举所有长度大于 1 的子串 charArray[i..j]
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLen && validPalindromic(charArray, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * 验证子串 s[left..right] 是否为回文串
     */
    private boolean validPalindromic(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
