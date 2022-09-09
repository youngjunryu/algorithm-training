package LEETCODE;

public class Valid_Palindrome {
  public boolean isPalindrome(String s) {
    boolean answer = true;
    s = removeAllNonAlphanumeric(s).toLowerCase();

    int left = 0;
    int right = s.length() - 1;

    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        answer = false;
        break;
      }

      left++;
      right--;
    }

    return answer;
  }

  private String removeAllNonAlphanumeric(String s) {
    return s.replaceAll("[^A-Za-z0-9]", "");
  }
}
