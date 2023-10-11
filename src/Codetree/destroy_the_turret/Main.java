package Codetree.destroy_the_turret;

import java.util.*;
import java.io.*;

public class Main {
  static int N, M, K;
  static int[][] map;
  static int[][] check;
  static boolean[][] effect;
  static Node start, target;
  static int[] dx = { 0, 1, 0, -1 };
  static int[] dy = { 1, 0, -1, 0 };
  static int[] bdx = { 0, 1, 0, -1, 1, 1, -1, -1 };
  static int[] bdy = { 1, 0, -1, 0, -1, 1, -1, 1 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    check = new int[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int k = 1; k <= K; k++) {
      if (isFinish()) {
        break;
      }
      process(k);
    }

    getResult();
  }

  static boolean isFinish() {
    int count = 0;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] != 0) {
          count++;
        }
      }
    }

    //System.out.println(count);
    return count == 1;
  }

  static void getResult() {
    int max = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] > max) {
          max = map[i][j];
        }
      }
    }

    System.out.println(max);
  }

  static void process(int k) {
    select(k);
    attack();
    destroy();
    clean();
  }

  static void select(int k) {
    effect = new boolean[N][M];
    ArrayList<Node> list = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] != 0) {
          list.add(new Node(i, j, map[i][j], check[i][j]));
        }
      }
    }

    Collections.sort(list);

    start = list.get(0);
    target = list.get(list.size() - 1);
    //System.out.println(k + " " + start.x + " " + start.y);
    effect[start.x][start.y] = true;
    check[start.x][start.y] = k;
    map[start.x][start.y] += N + M;
    target.power = map[start.x][start.y];
  }

  static void attack() {
    if (!laser()) {
      bomb();
    }
  }

  static boolean laser() {
    Node[][] route = new Node[N][M];
    Queue<Node> q = new LinkedList<>();
    boolean[][] visited = new boolean[N][M];
    q.add(start);
    visited[start.x][start.y] = true;

    while (!q.isEmpty()) {
      Node now = q.poll();

      for (int i = 0; i < 4; i++) {
        int nx = (N + now.x + dx[i]) % N;
        int ny = (M + now.y + dy[i]) % M;

        if (map[nx][ny] != 0 && !visited[nx][ny]) {
          q.add(new Node(nx, ny));
          visited[nx][ny] = true;
          route[nx][ny] = now;
        }
      }
    }

    if (!visited[target.x][target.y]) {
      return false;
    }

    int x = target.x;
    int y = target.y;
    while (x != start.x || y != start.y) {
      int power = map[start.x][start.y] / 2;
      if (x == target.x && y == target.y) {
        power = map[start.x][start.y];
      }

      map[x][y] -= power;
      effect[x][y] = true;
      Node node = route[x][y];
      x = node.x;
      y = node.y;
    }
    return true;
  }

  static void bomb() {
    int power = map[start.x][start.y];
    map[target.x][target.y] -= power;
    effect[target.x][target.y] = true;

    power /= 2;

    for (int i = 0; i < 8; i++) {
      int nx = (N + target.x + bdx[i]) % N;
      int ny = (M + target.y + bdy[i]) % M;

      if (nx != start.x || ny != start.y) {
        map[nx][ny] -= power;
        effect[nx][ny] = true;
      }
    }
  }

  static void destroy() {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] <= 0) {
          map[i][j] = 0;
        }
      }
    }
  }

  static void clean() {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] != 0 && !effect[i][j]) {
          map[i][j]++;
        }
      }
    }
  }

  static class Node implements Comparable<Node> {
    int x;
    int y;
    int power;
    int check;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public Node(int x, int y, int power, int check) {
      this.x = x;
      this.y = y;
      this.power = power;
      this.check = check;
    }

    public int compareTo(Node n) {
      if (power == n.power) {
        if (check == n.check) {
          if (x + y == n.x + n.y) {
            return n.y - y;
          }
          return (n.x + n.y) - (x + y);
        }
        return n.check - check;
      }
      return power - n.power;
    }
  }
}
