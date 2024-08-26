package Baekjoon._1259;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      String str = br.readLine();
      if (str.equals("0")) {
        return;
      }

      if (check(str)) {
        System.out.println("yes");
      } else {
        System.out.println("no");
      }
    }
  }

  private static boolean check(String str) {
    int left = 0;
    int right = str.length() - 1;
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
