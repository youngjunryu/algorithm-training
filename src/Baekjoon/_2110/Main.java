package Baekjoon._2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static int[] map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());
    map = new int[N];

    for (int i = 0; i < N; i++) {
      map[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(map);

    int left = 1;
    int right = map[N - 1] - map[0];

    while (left <= right) {
      int mid = (left + right) / 2;

      if (isPossible(mid) < C) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    System.out.println(left - 1);
  }

  private static int isPossible(int dist) {
    int count = 1;
    int prev = map[0];

    for (int i = 1; i < N; i++) {
      int now = map[i];

      if (now - prev < dist) {
        continue;
      }

      prev = now;
      count++;
    }

    return count;
  }
}

/*

1 2 4 8 9

 */
