package Baekjoon._10431;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int P = Integer.parseInt(br.readLine());

    for (int p = 1; p <= P; p++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int T = Integer.parseInt(st.nextToken());

      ArrayList<Integer> list = new ArrayList<>();
      for (int i = 0; i < 20; i++) {
        list.add(Integer.parseInt(st.nextToken()));
      }

      int result = 0;
      for (int i = 0; i < 20; i++) {
        for (int j = 0; j < i; j++) {
          int a = list.get(i);
          int b = list.get(j);
          if (a < b) {
            result += i - j;
            list.add(j, a);
            list.remove(i + 1);
            break;
          }
        }
      }

      System.out.println(T + " " + result);
    }
  }
}
