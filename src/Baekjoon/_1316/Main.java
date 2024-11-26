package Baekjoon._1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int result = 0;

    while (N-- > 0) {
      String str = br.readLine();
      HashSet<Character> set = new HashSet<>();
      Character prev = null;
      boolean flag = true;

      for (int i = 0; i < str.length(); i++) {
        char now = str.charAt(i);

        if (!set.contains(now)) {
          set.add(now);
          prev = now;
        } else if (prev == now) {

        } else {
          flag = false;
          break;
        }
      }

      if (flag) {
        result++;
      }
    }

    System.out.println(result);
  }
}
