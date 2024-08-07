package Baekjoon._20310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine();

    int zero = 0;
    int one = 0;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '0') {
        zero++;
      } else {
        one++;
      }
    }

    zero /= 2;
    one /= 2;

    StringBuilder sb = new StringBuilder(str);

    for (int i = 0; i < sb.length(); i++) {
      if (sb.charAt(i) == '1' && one > 0) {
        one--;
        sb.replace(i, i + 1, "2");
      } else if (sb.charAt(i) == '0') {
        if (zero > 0) {
          zero--;
        } else {
          sb.replace(i, i + 1, "2");
        }
      }
    }

    String result = sb.toString();
    String s = result.replaceAll("2", "");

    System.out.println(s);
  }
}
