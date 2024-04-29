package LeetCode.easy.License_Key_Formatting;

public class Solution {

  public String licenseKeyFormatting(String s, int k) {
    int n = s.length();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) != '-') {
        sb.append(s.charAt(i));
      }
    }

    String str = sb.reverse().toString().toUpperCase();

    sb = new StringBuilder();
    int idx = 0;
    while (true) {
      if (idx + k < str.length()) {
        sb.append(str.substring(idx, idx + k)).append('-');
        idx += k;
      } else {
        sb.append(str.substring(idx));
        break;
      }
    }

    return sb.reverse().toString();
  }
}
