package Baekjoon._18111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

  static int N, M, B;
  static int[][] map;
  static int minTime = Integer.MAX_VALUE, maxHeight = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    B = Integer.parseInt(st.nextToken());

    TreeSet<Integer> set = new TreeSet<>();
    map = new int[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        int val = Integer.parseInt(st.nextToken());
        map[i][j] = val;
        set.add(val);
      }
    }

    for (int h = set.first(); h <= set.last(); h++) {
      int remain = B;
      int result = 0;

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          int val = map[i][j];
          if (val > h) {
            int minus = val - h;
            remain += minus;
            result += minus * 2;
          }
        }
      }

      boolean flag = true;
      for (int i = 0; i < N && flag; i++) {
        for (int j = 0; j < M; j++) {
          int val = map[i][j];
          if (val < h) {
            int plus = h - val;
            if (remain >= plus) {
              remain -= plus;
              result += plus;
            } else {
              flag = false;
              break;
            }
          }
        }
      }

      if (!flag) {
        continue;
      }

      if (minTime > result) {
        minTime = result;
        maxHeight = h;
      } else if (minTime == result) {
        maxHeight = Math.max(maxHeight, h);
      }
    }

    System.out.println(minTime + " " + maxHeight);
  }
}
