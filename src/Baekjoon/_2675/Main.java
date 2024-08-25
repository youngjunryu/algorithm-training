package Baekjoon._2675;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int R = Integer.parseInt(st.nextToken());
      String S = st.nextToken();

      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < S.length(); j++) {
        char c = S.charAt(j);
        int count = R;
        while (count-- > 0) {
          sb.append(c);
        }
      }

      System.out.println(sb);
    }
  }
}
