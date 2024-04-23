package LeetCode.medium.Multiply_Strings;

public class Solution {

  public String multiply(String num1, String num2) {
    int n = num1.length();
    int m = num2.length();

    int[] arr = new int[n + m];

    for (int i = n - 1; i >= 0; i--) {
      for (int j = m - 1; j >= 0; j--) {
        int multiple = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
        int val = multiple + arr[i + j + 1];
        arr[i + j] += val / 10;
        arr[i + j + 1] = val % 10;
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int a : arr) {
      if (a == 0 && sb.length() > 0) {
        sb.append(a);
      } else if (a != 0) {
        sb.append(a);
      }
    }

    return sb.length() == 0 ? "0" : sb.toString();
  }
}

