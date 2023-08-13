package Archiving.PROGRAMMERS;

public class 합승_택시_요금 {
  static final int INF = 20000000;

  public static int solution(int n, int s, int a, int b, int[][] fares) {
    int[][] map = new int[n+1][n+1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (i == j) {
          map[i][j] = 0;
        } else {
          map[i][j] = INF;
        }
      }
    }

    for (int[] f : fares) {
      map[f[0]][f[1]] = f[2];
      map[f[1]][f[0]] = f[2];
    }

    for (int k = 1; k <= n; k++) {
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
        }
      }
    }

    int min = Integer.MAX_VALUE;
    for (int i = 1; i <= n; i++) {
      int sum = 0;
      if (map[s][i] == -1) {
        continue;
      }

      sum += map[s][i];
      sum += map[i][a];
      sum += map[i][b];
      min = Math.min(sum, min);
    }

    System.out.println(min);
    return min;
  }

  public static void main(String[] args) {
    solution(7, 3, 4, 1, new int[][]{{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}});
  }
}
