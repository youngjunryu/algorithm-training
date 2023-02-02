package PROGRAMMERS;

import java.util.Locale;

public class n진수_게임 {
  public static String solution(int n, int t, int m, int p) {
    String str = "";
    int num = 0;
    while (true) {
      str += Integer.toString(num++, n);
      if (str.length() >= t * m) {
        break;
      }
    }

    str = str.substring(0, t * m);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      if (i % m == p - 1) {
        sb.append(str.charAt(i));
      }
    }

    return sb.toString().toUpperCase(Locale.ROOT);
  }

  public static void main(String[] args) {
    solution(2, 4, 2, 1);
  }
}
