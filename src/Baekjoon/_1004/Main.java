package Baekjoon._1004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    for (int t = 0; t < T; t++) {
      int count = 0;
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      int n = Integer.parseInt(br.readLine());
      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        int cx = Integer.parseInt(st.nextToken());
        int cy = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        boolean one, two;

        int dist = (int) (Math.pow((cx - x1), 2) + Math.pow((cy - y1), 2));
        one = dist > r * r;

        dist = (int) (Math.pow((cx - x2), 2) + Math.pow((cy - y2), 2));
        two = dist > r * r;

        if (one != two) {
          count++;
        }
      }

      System.out.println(count);
    }
  }
}
