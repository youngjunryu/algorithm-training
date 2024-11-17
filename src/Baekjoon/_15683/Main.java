package Baekjoon._15683;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
  static int N;
  static int M;
  static int[][] map;
  static ArrayList<Node> store;
  static int min;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    store = new ArrayList<>();
    min = N * M;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        int val = Integer.parseInt(st.nextToken());
        map[i][j] = val;
        if (val == 1 || val == 2 || val == 3 || val == 4 || val == 5) {
          store.add(new Node(i, j, val));
        }
      }
    }

    backtracking(0);
    System.out.println(min);
  }

  private static void backtracking(int idx) {
    if (idx == store.size()) {
      int blindSpot = count();
      min = Math.min(blindSpot, min);
      return;
    }

    Node now = store.get(idx);
    List<List<Integer>> list = new ArrayList<>();

    switch (now.val) {
      case 1:
        list.add(List.of(0));
        list.add(List.of(1));
        list.add(List.of(2));
        list.add(List.of(3));
        break;
      case 2:
        list.add(List.of(0, 2));
        list.add(List.of(1, 3));
        break;
      case 3:
        list.add(List.of(0, 1));
        list.add(List.of(1, 2));
        list.add(List.of(2, 3));
        list.add(List.of(3, 0));
        break;
      case 4:
        list.add(List.of(0, 1, 2));
        list.add(List.of(1, 2, 3));
        list.add(List.of(2, 3, 0));
        list.add(List.of(3, 0, 1));
        break;
      case 5:
        list.add(List.of(0, 1, 2, 3));
        break;
    }

    for (List<Integer> ds : list) {
      ArrayList<Node> paintSpots = new ArrayList<>();
      paint(ds, now, paintSpots);
      backtracking(idx + 1);
      rollback(paintSpots);
    }
  }

  private static void paint(List<Integer> ds, Node now, ArrayList<Node> paintSpots) {
    for (int d : ds) {
      int nx = now.x;
      int ny = now.y;
      while (true) {
        nx += dir[d][0];
        ny += dir[d][1];

        if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
          break;
        }

        int val = map[nx][ny];

        if (val == 6) {
          break;
        }

        if (val == 1 || val == 2 || val == 3 || val == 4 || val == 5) {
          continue;
        }

        if (val == 0) {
          map[nx][ny] = 11;
          paintSpots.add(new Node(nx, ny, 0));
        } else {
          map[nx][ny] += 1;
          paintSpots.add(new Node(nx, ny, 0));
        }
      }
    }
  }

  private static void rollback(ArrayList<Node> paintSpots) {
    for (Node n : paintSpots) {
      int val = map[n.x][n.y];
      if (val > 11) {
        map[n.x][n.y]--;
      } else if (val == 11) {
        map[n.x][n.y] = 0;
      }
    }
  }

  private static int count() {
    int blindSpot = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == 0) {
          blindSpot++;
        }
      }
    }

    return blindSpot;
  }

  static class Node {

    int x;
    int y;
    int val;

    public Node(int x, int y, int val) {
      this.x = x;
      this.y = y;
      this.val = val;
    }
  }
}


