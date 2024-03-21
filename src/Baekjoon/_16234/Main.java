package Baekjoon._16234;

import java.util.*;
import java.io.*;

public class Main {
  static int N;
  static int L;
  static int R;
  static int[][] map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());

    map = new int[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int cnt = 0;
    while (true) {
      boolean flag = false;
      boolean[][] visited = new boolean[N][N];
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (!visited[i][j]) {
            if (bfs(i, j , visited))
              flag = true;
          }
        }
      }

      if (!flag) break;

      cnt++;
    }

    System.out.println(cnt);
  }

  public static boolean bfs(int x, int y, boolean[][] visited) {
    int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    ArrayDeque<int[]> q = new ArrayDeque<>();
    ArrayList<Data> list = new ArrayList<>();

    q.add(new int[]{x, y});
    visited[x][y] = true;
    list.add(new Data(x, y, map[x][y]));

    while (!q.isEmpty()) {
      int[] cur = q.poll();

      for (int d = 0; d < 4; d++) {
        int nx = cur[0] + dir[d][0];
        int ny = cur[1] + dir[d][1];

        if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny])
          continue;

        if (Math.abs(map[nx][ny] - map[cur[0]][cur[1]]) >= L && Math.abs(map[nx][ny] - map[cur[0]][cur[1]]) <= R) {
          q.add(new int[]{nx, ny});
          visited[nx][ny] = true;
          list.add(new Data(nx, ny, map[nx][ny]));
        }
      }
    }

    if (list.size() == 1)
      return false;

    int sumPeople = 0;
    int sumCountry = list.size();
    for (Data d : list)
      sumPeople += d.people;

    int value = sumPeople / sumCountry;
    for (Data d : list)
      map[d.x][d.y] = value;

    return true;
  }

  public static class Data {
    int x;
    int y;
    int people;

    public Data(int x, int y, int people) {
      this.x = x;
      this.y = y;
      this.people = people;
    }
  }
}
