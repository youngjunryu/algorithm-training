package LeetCode.easy.Excel_Sheet_Column_Number;

class Solution {
  public int titleToNumber(String columnTitle) {
    int result = 0;
    int len = columnTitle.length();

    for (int i = 0; i < len; i++) {
      int val = len - i - 1;
      result += Math.pow(26, val) * (int)(columnTitle.charAt(i) - 64);
    }

    return result;
  }
}
