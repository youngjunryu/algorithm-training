package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17609 {
  static String str;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());

    while(t-- > 0) {
      str = br.readLine();

      if (check(0, str.length() - 1)) {
        System.out.println(0);
      } else {
        if(reCheck(0, str.length() - 1)) {
          System.out.println(1);
        } else {
          System.out.println(2);
        }
      }
    }
  }

  private static boolean reCheck(int left, int right) {
    while (left < right) {
      if (str.charAt(left) != str.charAt(right)) {
        boolean a = check(left + 1, right);
        boolean b = check(left, right - 1);

        if (!a && !b) {
          return false;
        } else {
          return true;
        }
      }

      left++;
      right--;
    }

    return true;
  }

  private static boolean check(int left, int right) {
    while (left < right) {
      if (str.charAt(left) != str.charAt(right)) {
        return false;
      }

      left++;
      right--;
    }

    return true;
  }
}
