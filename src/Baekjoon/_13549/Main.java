package Baekjoon._13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] map = new int[100001];
    Arrays.fill(map, Integer.MAX_VALUE);

    Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
    map[N] = 0;
    q.add(new int[]{0, N});

    while (!q.isEmpty()) {
      int[] arr = q.poll();
      int time = arr[0];
      int pos = arr[1];

      if (pos == K) {
        break;
      }

      // 1초 후 X-1로 이동
      if (pos >= 1 && time + 1 < map[pos - 1]) {
        map[pos - 1] = time + 1;
        q.add(new int[]{time + 1, pos - 1});
      }

      // 1초 후 X+1로 이동
      if (pos < 100000 && time + 1 < map[pos + 1]) {
        map[pos + 1] = time + 1;
        q.add(new int[]{time + 1, pos + 1});
      }

      // 0초 후 2*X로 이동
      if (pos * 2 <= 100000 && time < map[pos * 2]) {
        map[pos * 2] = time;
        q.add(new int[]{time, pos * 2});
      }
    }

    System.out.println(map[K]);
  }
}

/*
5 10 9 18 17
 */