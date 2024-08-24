package Baekjoon._2920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int now = Integer.parseInt(st.nextToken());
    int next = Integer.parseInt(st.nextToken());

    boolean isAscending = true;
    if (now - next == 1) {
      isAscending = false;
    } else {
      isAscending = true;
    }

    String result = null;
    while (st.hasMoreTokens()) {
      int num = Integer.parseInt(st.nextToken());
      if (isAscending) {
        if (num != next + 1) {
          result = "mixed";
          break;
        }
      } else {
        if (num != next - 1) {
          result = "mixed";
          break;
        }
      }

      next = num;
    }

    if (result == null) {
      if (isAscending) {
        System.out.println("ascending");
      } else {
        System.out.println("descending");
      }
    } else {
      System.out.println(result);
    }
  }
}
