package Baekjoon._2467;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    long[] map = new long[N + 1];

    for (int i = 0; i < N; i++) {
      map[i] = Long.parseLong(st.nextToken());
    }

    long min = Long.MAX_VALUE;
    int left = 0;
    int right = N - 1;
    int resultLeft = -1;
    int resultRight = -1;

    while (left < right) {
      long sum = map[left] + map[right];

      long now = Math.abs(sum);

      if (now < min) {
        min = now;
        resultLeft = left;
        resultRight = right;
      }

      if (sum > 0) {
        right--;
      } else if (sum < 0) {
        left++;
      } else {
        break;
      }
    }

    System.out.println(map[resultLeft] + " " + map[resultRight]);
  }
}
