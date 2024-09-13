package Baekjoon._2473;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static ArrayList<Long> map;
  static long min = Long.MAX_VALUE;
  static ArrayList<Long> result = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    map = new ArrayList<>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      map.add(Long.parseLong(st.nextToken()));
    }

    Collections.sort(map);

    for (int i = 0; i < N; i++) {
      Long center = map.remove(i);
      search(center);
      map.add(i, center);
    }

    Collections.sort(result);
    for (Long val : result) {
      System.out.print(val + " ");
    }
  }

  private static void search(Long center) {
    int left = 0;
    int right = N - 2;

    while (left < right) {
      long sum = map.get(left) + center + map.get(right);
      long close = Math.abs(sum);

      if (close < min) {
        min = close;
        result = new ArrayList<>();
        result.add(map.get(left));
        result.add(center);
        result.add(map.get(right));
      }

      if (sum > 0) {
        right--;
      } else if (sum < 0) {
        left++;
      } else {
        min = close;
        result = new ArrayList<>();
        result.add(map.get(left));
        result.add(center);
        result.add(map.get(right));
        break;
      }
    }
  }
}
