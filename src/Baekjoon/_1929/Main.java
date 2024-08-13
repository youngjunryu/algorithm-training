package Baekjoon._1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());

    for (int t = M; t <= N; t++) {
      if (t == 1) {
        continue;
      }

      boolean flag = true;
      for (int i = 2; i <= Math.sqrt(t); i++) {

        if (t % i == 0) {
          flag = false;
          break;
        }
      }

      if (flag) {
        System.out.println(t);
      }
    }
  }
}
