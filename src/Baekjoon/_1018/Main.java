package Baekjoon._1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    char[][] map = new char[N][M];
    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i][j] = str.charAt(j);
      }
    }

    int result = Integer.MAX_VALUE;
    for (int i = 0; i <= N - 8; i++) {
      for (int j = 0; j <= M - 8; j++) {
        int count = check(i, j, map);
        result = Math.min(count, result);
      }
    }

    System.out.println(result);
  }

  private static int check(int x, int y, char[][] map) {
    int bCount = 0;
    int wCount = 0;

    char[][] temp = new char[8][8];
    for (int i = x, a = 0; i < x + 8; i++, a++) {
      for (int j = y, b = 0; j < y + 8; j++, b++) {
        temp[a][b] = map[i][j];
      }
    }

    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if (i % 2 == 0) {
          if (j % 2 == 0) {
            if (temp[i][j] != 'B') {
              bCount++;
            }
          } else {
            if (temp[i][j] != 'W') {
              bCount++;
            }
          }
        } else {
          if (j % 2 == 0) {
            if (temp[i][j] != 'W') {
              bCount++;
            }
          } else {
            if (temp[i][j] != 'B') {
              bCount++;
            }
          }
        }
      }
    }

    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if (i % 2 == 0) {
          if (j % 2 == 0) {
            if (temp[i][j] != 'W') {
              wCount++;
            }
          } else {
            if (temp[i][j] != 'B') {
              wCount++;
            }
          }
        } else {
          if (j % 2 == 0) {
            if (temp[i][j] != 'B') {
              wCount++;
            }
          } else {
            if (temp[i][j] != 'W') {
              wCount++;
            }
          }
        }
      }
    }

    return Math.min(bCount, wCount);
  }
}
