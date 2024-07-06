package Baekjoon._17615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    String str = br.readLine();

    int firstRed = checkFirst(str, n, 'R', 'B');
    int firstBlue = checkFirst(str, n, 'B', 'R');
    int lastRed = checkLast(str, n, 'R', 'B');
    int lastBlue = checkLast(str, n, 'B', 'R');

    int[] result = new int[]{firstRed, firstBlue, lastRed, lastBlue};
    Arrays.sort(result);
    System.out.println(result[0]);
  }

  private static int checkFirst(String str, int n, char a, char b) {
    int result = 0;
    boolean flag = false;
    for (int i = 0; i < n; i++) {
      char c = str.charAt(i);
      if (!flag && c == a) {
        flag = true;
      }

      if (flag && c == b) {
        result++;
      }
    }

    return result;
  }

  private static int checkLast(String str, int n, char a, char b) {
    int result = 0;
    boolean flag = false;
    for (int i = n - 1; i >= 0; i--) {
      char c = str.charAt(i);
      if (!flag && c == a) {
        flag = true;
      }

      if (flag && c == b) {
        result++;
      }
    }

    return result;
  }
}
