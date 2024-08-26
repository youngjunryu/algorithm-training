package Baekjoon._28702;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String a = br.readLine();
    String b = br.readLine();
    String c = br.readLine();

    if (isDigit(a)) {
      int num = Integer.parseInt(a);
      int now = num + 3;
      System.out.println(print(now));
      return;
    }

    if (isDigit(b)) {
      int num = Integer.parseInt(b);
      int now = num + 2;
      System.out.println(print(now));
      return;
    }

    if (isDigit(c)) {
      int num = Integer.parseInt(c);
      int now = num + 1;
      System.out.println(print(now));
    }
  }

  private static boolean isDigit(String str) {
    char c = str.charAt(0);

    if (c >= '1' && c <= '9') {
      return true;
    }

    return false;
  }

  private static String print(int num) {
    if (num % 3 == 0 && num % 5 == 0) {
      return "FizzBuzz";
    } else if (num % 3 == 0 && num % 5 != 0) {
      return "Fizz";
    } else if (num % 3 != 0 && num % 5 == 0) {
      return "Buzz";
    }

    return String.valueOf(num);
  }
}
