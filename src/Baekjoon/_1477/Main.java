package Baekjoon._1477;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static int N, M;
  static int L;
  static int[] map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());

    if (N == 0) {
      map = new int[N + 1];
      map[N] = L;
    } else {
      st = new StringTokenizer(br.readLine());
      map = new int[N + 1];
      for (int i = 0; i < N; i++) {
        map[i] = Integer.parseInt(st.nextToken());
      }
      map[N] = L;
    }

    Arrays.sort(map);
    N++;

    int prev = 0;
    int maxDist = 0;
    for (int i = 0; i < N; i++) {
      maxDist = Math.max(map[i] - prev, maxDist);
      prev = map[i];
    }

    System.out.println(search(maxDist));
  }

  private static int search(int maxDist) {
    int left = 0;
    int right = maxDist;
    int result = maxDist;

    while (left <= right) {
      int mid = (left + right) / 2;
      if (canBuild(mid)) {
        result = mid;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return result;
  }

  private static boolean canBuild(int dist) {
    int count = M;

    int prev = 0;
    for (int i = 0; i < N; ) {
      int now = map[i];
      if (now - prev > dist) {
        if (count == 0) {
          return false;
        }
        count--;
        prev = prev + dist;
      } else {
        prev = map[i];
        i++;
      }
    }

    return true;
  }
}

/*

0 82 201 411 555 622 755 800

210
mid = 105 / M이 남음 => right = mid - 1;
mid = 52 / M이 부족함 => mid = left + 1;

고정 값이 "휴게소가 없는 구간의 최댓값"

 */