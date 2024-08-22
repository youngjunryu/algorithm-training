package Baekjoon._16236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static int[][] map;
  static Node shark;
  static ArrayList<Node> fish = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    map = new int[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        int val = Integer.parseInt(st.nextToken());
        map[i][j] = val;

        if (val == 9) {
          shark = new Node(i, j, 2);
        } else if (val != 0) {
          fish.add(new Node(i, j, val));
        }
      }
    }

    int result = 0;
    while (true) {
      Node next = eatNext();

      if (next == null) {
        break;
      }

      result += shark.plus;
      shark.plus = 0;
      shark.count++;
      if (shark.count == shark.size) {
        shark.count = 0;
        shark.size++;
      }

    }

    System.out.println(result);
  }

  private static Node eatNext() {
    Node next = null;
    int minDist = Integer.MAX_VALUE;

    for (Node now : fish) {
      if (now.size >= shark.size) {
        continue;
      }

      int nowDist = getDistance(now);

      if (nowDist == Integer.MAX_VALUE) {
        continue;
      }

      if (nowDist < minDist) {
        next = now;
        minDist = nowDist;
      } else if (nowDist == minDist) {
        if (next.x > now.x || (next.x == now.x && next.y > now.y)) {
          next = now;
          minDist = nowDist;
        }
      }
    }

    if (next == null) {
      return next;
    }

    map[shark.x][shark.y] = 0;
    shark.x = next.x;
    shark.y = next.y;
    shark.plus = minDist;
    fish.remove(next);
    map[next.x][next.y] = 0;
    map[shark.x][shark.y] = 9;

    return next;
  }

  private static int getDistance(Node f) {
    int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    int[][] board = new int[N][N];
    boolean[][] visited = new boolean[N][N];
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{shark.x, shark.y});
    visited[shark.x][shark.y] = true;

    while (!q.isEmpty()) {
      int[] now = q.poll();

      for (int d = 0; d < 4; d++) {
        int nx = now[0] + dir[d][0];
        int ny = now[1] + dir[d][1];

        if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || map[nx][ny] > shark.size) {
          continue;
        }

        q.add(new int[]{nx, ny});
        board[nx][ny] = board[now[0]][now[1]] + 1;
        visited[nx][ny] = true;

        if (f.x == nx && f.y == ny) {
          break;
        }
      }
    }

    if (board[f.x][f.y] == 0) {
      return Integer.MAX_VALUE;
    }

    return board[f.x][f.y];
  }

  static class Node {

    int x;
    int y;
    int size;
    int count;
    int plus;

    public Node(int x, int y, int size) {
      this.x = x;
      this.y = y;
      this.size = size;
      this.count = 0;
      this.plus = 0;
    }
  }
}
