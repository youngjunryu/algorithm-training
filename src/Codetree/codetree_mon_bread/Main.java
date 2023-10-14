package Codetree.codetree_mon_bread;

import java.util.*;
import java.io.*;

/*

14 28
0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 1 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 1 0 0 0 0 0
0 0 0 0 0 0 0 0 0 1 0 0 0 0
0 1 0 0 1 0 0 1 1 1 0 0 0 0
0 1 0 1 0 0 1 0 0 1 0 0 0 0
0 0 0 0 0 0 0 0 0 1 0 0 0 0
0 0 1 0 0 0 0 0 1 1 0 0 0 0
1 0 1 1 0 0 0 0 0 0 0 0 1 0
1 1 1 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 1 0 0 0 0 1 0 1
1 0 0 0 0 0 0 1 0 0 0 1 0 0
0 0 0 0 0 1 0 0 1 0 0 0 0 0
0 0 1 0 0 0 0 0 1 1 0 0 0 0
4 12
10 9
13 4
11 8
10 7
8 7
7 3
3 1
4 2
14 8
2 14
12 6
9 9
4 3
10 4
5 1
10 10
3 2
14 11
5 13
4 11
1 3
6 14
5 4
10 13
11 4
5 14
7 5

 */

public class Main {
  static class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  static int n, m;
  static int[][] map;
  static Pair[] cons; // 편의점 위치
  static Pair[] people;
  static int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    map = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= n; j++) {
        int val = Integer.parseInt(st.nextToken());
        map[i][j] = val;
      }
    }

    cons = new Pair[m + 1];
    for (int i = 1; i <= m; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      cons[i] = new Pair(x, y);
    }

    people = new Pair[m + 1];
    for (int i = 0; i <= m; i++) {
      people[i] = new Pair(0, 0);
    }

    int time = 0;
    while (true) {
      time++;

      move();
      goToBasecamp(time);

      if(isFinish()) break;
    }

    System.out.println(time);
  }

  static boolean isFinish() {
    int cnt = 0;
    for (int i = 1; i <= m; i++) {
      Pair person = people[i];
      Pair con = cons[i];

      if (person.x == 0 && person.y == 0) continue;

      if (con.x == person.x && con.y == person.y) {
        cnt++;
      }
    }

    if (cnt == m) return true;
    return false;
  }

  static void goToBasecamp(int time) {
    if (time > m) {
      return;
    }

    // 자신이 가장 가고 싶은 편의점에서 가장 가까이 있는 베이스 캠프 찾기
    int[] start = findBasecamp(time);
    people[time] = new Pair(start[0], start[1]);
  }

  static int[] findBasecamp(int time) {
    Pair con = cons[time];
    Queue<int[]> q = new LinkedList<>();
    boolean[][] visited = new boolean[n + 1][n + 1];
    int[][] distance = new int[n + 1][n + 1];
    visited[con.x][con.y] = true;
    q.add(new int[]{con.x, con.y, 1});

    while (!q.isEmpty()) {
      int[] now = q.poll();

      for (int d = 0; d < 4; d++) {
        int nx = now[0] + dir[d][0];
        int ny = now[1] + dir[d][1];

        if (nx < 1 || ny < 1 || nx > n || ny > n || visited[nx][ny] || map[nx][ny] == -1) {
          continue;
        }

        visited[nx][ny] = true;
        distance[nx][ny] = now[2] + 1;
        q.add(new int[]{nx, ny, distance[nx][ny]});
      }
    }

    int[] min = new int[3];
    min[0] = Integer.MAX_VALUE;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (map[i][j] == 1) {
          if (distance[i][j] != 0 && min[0] > distance[i][j]) {
            min[0] = distance[i][j];
            min[1] = i;
            min[2] = j;
          }
        }
      }
    }

    map[min[1]][min[2]] = -1; // 베이스 캠프가 있는 칸은 지나갈 수 없도록 설정
    return new int[]{min[1], min[2]};
  }

  static void move() {
    for (int i = 1; i <= m; i++) {
      Pair person = people[i];
      Pair con = cons[i];

      if (person.x == 0 && person.y == 0) continue;
      if (con.x == person.x && con.y == person.y) continue;

      // 최단 거리로 이동, ↑, ←, →, ↓ 의 우선 순위로 이동, map 값이 -1이면 지나갈 수 없음
      Queue<int[]> q = new LinkedList<>();
      boolean[][] visited = new boolean[n + 1][n + 1];
      int[][] distance = new int[n + 1][n + 1];
      visited[con.x][con.y] = true;
      distance[con.x][con.y] = 1;
      q.add(new int[]{con.x, con.y, 1});

      while (!q.isEmpty()) {
        int[] now = q.poll();

        for (int d = 0; d < 4; d++) {
          int nx = now[0] + dir[d][0];
          int ny = now[1] + dir[d][1];

          if (nx < 1 || ny < 1 || nx > n || ny > n || visited[nx][ny] || map[nx][ny] == -1) {
            continue;
          }

          visited[nx][ny] = true;
          distance[nx][ny] = now[2] + 1;
          q.add(new int[]{nx, ny, distance[nx][ny]});
        }
      }

      int[] min = new int[3];
      min[0] = Integer.MAX_VALUE;
      for (int d = 0; d < 4; d++) {
        int nx = person.x + dir[d][0];
        int ny = person.y + dir[d][1];

        if (nx < 1 || ny < 1 || nx > n || ny > n || map[nx][ny] == -1) {
          continue;
        }

        if (distance[nx][ny] != 0 && min[0] > distance[nx][ny]) {
          min[0] = distance[nx][ny];
          min[1] = nx;
          min[2] = ny;
        }
      }

      person.x = min[1];
      person.y = min[2];
    }

    // 사람이 편의점에 도착한다면, 해당 칸으로는 지나갈 수 없도록 설정
    for (int i = 1; i <= m; i++) {
      Pair person = people[i];
      Pair con = cons[i];

      if (person.x == 0 && person.y == 0) continue;

      if (con.x == person.x && con.y == person.y) {
        map[person.x][person.y] = -1;
      }
    }
  }
}