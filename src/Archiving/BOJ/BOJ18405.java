package Archiving.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ18405 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[][] arr = new int[n+1][n+1];
    List<Data> q = new LinkedList<>();
    int[] dx = new int[]{0, 0, -1, 1};
    int[] dy = new int[]{1, -1, 0, 0};

    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= n; j++) {
        int type = Integer.parseInt(st.nextToken());
        if (type != 0) {
          q.add(new Data(i, j, type));
        }
        arr[i][j] = type;
      }
    }

    st = new StringTokenizer(br.readLine());
    int s = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());

    int time = 0;
    while (!q.isEmpty()) {

      if (time == s) {
        break;
      }

      Collections.sort(q);

      int size = q.size();
      for (int i = 0; i < size; i++) {
        Data cur = q.get(0);
        q.remove(0);

        for (int d = 0; d < 4; d++) {
          int nx = cur.n + dx[d];
          int ny = cur.m + dy[d];

          if (nx < 1 || ny < 1 || nx >= n+1 || ny >= n+1) {
            continue;
          }

          if (arr[nx][ny] != 0) {
            continue;
          }

          arr[nx][ny] = cur.type;
          q.add(new Data(nx, ny, cur.type));
        }
      }

      time++;
    }

    System.out.println(arr[x][y]);
  }

  static class Data implements Comparable<Data> {
    int n;
    int m;
    int type;

    public Data(int n, int m, int type) {
      this.n = n;
      this.m = m;
      this.type = type;
    }

    @Override
    public int compareTo(Data o) {
      return this.type - o.type;
    }
  }
}
