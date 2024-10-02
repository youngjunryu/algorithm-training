package Baekjoon._13460;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int N, M;
  static char[][] map;
  static int hx, hy;
  static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
  static boolean[][][][] visited;
  static int result = -1;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new char[N][M];
    int firstRx = 0, firstRy = 0, firstBx = 0, firstBy = 0;
    for (int i = 0; i < N; i++) {
      String val = br.readLine();
      for (int j = 0; j < M; j++) {
        char c = val.charAt(j);
        if (c == 'B') {
          firstBx = i;
          firstBy = j;
          map[i][j] = '.';
        } else if (c == 'R') {
          firstRx = i;
          firstRy = j;
          map[i][j] = '.';
        } else if (c == 'O') {
          hx = i;
          hy = j;
          map[i][j] = '.';
        } else {
          map[i][j] = c;
        }
      }
    }

    visited = new boolean[10][10][10][10];
    Node first = new Node(firstRx, firstRy, firstBx, firstBy, 0);
    visited[firstRx][firstRy][firstBx][firstBy] = true;
    bfs(first);
    System.out.println(result);
  }

  private static void bfs(Node first) {
    Queue<Node> q = new LinkedList<>();
    q.add(first);

    while (!q.isEmpty()) {
      Node now = q.poll();

      for (int d = 0; d < 4; d++) {
        Node newNode = new Node(now.rx, now.ry, now.bx, now.by, now.count + 1);
        moveRed(newNode, d);
        moveBlue(newNode, d);

        if (newNode.bx == hx && newNode.by == hy) {
          continue;
        }

        if (newNode.bx == newNode.rx && newNode.by == newNode.ry) {
          switch (d) {
            case 0: // 위
              if (now.rx < now.bx) {
                newNode.bx++;
              } else {
                newNode.rx++;
              }
              break;
            case 1: // 아래
              if (now.rx < now.bx) {
                newNode.rx--;
              } else {
                newNode.bx--;
              }
              break;
            case 2: // 오른쪽
              if (now.ry < now.by) {
                newNode.ry--;
              } else {
                newNode.by--;
              }
              break;
            case 3: // 왼쪽
              if (now.ry < now.by) {
                newNode.by++;
              } else {
                newNode.ry++;
              }
              break;
          }
        }

        if (newNode.count > 10) {
          continue;
        }

        if (newNode.rx == hx && newNode.ry == hy) {
          result = newNode.count;
          return;
        }

        if (!visited[newNode.rx][newNode.ry][newNode.bx][newNode.by]) {
          q.add(newNode);
          visited[newNode.rx][newNode.ry][newNode.bx][newNode.by] = true;
        }
      }
    }
  }

  private static void moveRed(Node now, int d) {
    while (true) {
      now.rx += dir[d][0];
      now.ry += dir[d][1];

      if (map[now.rx][now.ry] == '#') {
        now.rx -= dir[d][0];
        now.ry -= dir[d][1];
        break;
      } else if (now.rx == hx && now.ry == hy) {
        break;
      }
    }
  }

  private static void moveBlue(Node now, int d) {
    while (true) {
      now.bx += dir[d][0];
      now.by += dir[d][1];

      if (map[now.bx][now.by] == '#') {
        now.bx -= dir[d][0];
        now.by -= dir[d][1];
        break;
      } else if (now.bx == hx && now.by == hy) {
        break;
      }
    }
  }

  static class Node {

    int rx, ry;
    int bx, by;
    int count;

    public Node(int rx, int ry, int bx, int by, int count) {
      this.rx = rx;
      this.ry = ry;
      this.bx = bx;
      this.by = by;
      this.count = count;
    }
  }
}
