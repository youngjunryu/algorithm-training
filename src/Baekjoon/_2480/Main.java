package Baekjoon._2480;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] dice = new int[7];
    StringTokenizer st = new StringTokenizer(br.readLine());

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    dice[a]++;
    dice[b]++;
    dice[c]++;

    int twice = -1;
    int triple = -1;
    int max = -1;

    for (int i = 1; i <= 6; i++) {
      if (dice[i] == 2) {
        twice = i;
      } else if (dice[i] == 3) {
        triple = i;
      }

      if (dice[i] > 0) {
        max = Math.max(i, max);
      }
    }

    if (twice != -1) {
      int result = twice * 100 + 1000;
      System.out.println(result);
      return;
    }

    if (triple != -1) {
      int result = triple * 1000 + 10000;
      System.out.println(result);
      return;
    }

    System.out.println(max * 100);
  }
}
