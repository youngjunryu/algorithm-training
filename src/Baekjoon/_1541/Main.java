package Baekjoon._1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String val = br.readLine();

    int result = 0;

    boolean flag = false;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < val.length(); i++) {
      char c = val.charAt(i);

      if (c == '+' || c == '-') {
        if (flag) {
          result += -Integer.parseInt(sb.toString());
        } else {
          result += Integer.parseInt(sb.toString());
        }

        sb = new StringBuilder();
        
        if (c == '-') {
          flag = true;
        }
      } else {
        sb.append(c);
      }
    }

    if (flag) {
      result += -Integer.parseInt(sb.toString());
    } else {
      result += Integer.parseInt(sb.toString());
    }

    System.out.println(result);
  }
}
