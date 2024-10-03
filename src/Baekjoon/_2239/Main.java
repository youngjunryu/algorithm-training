package Baekjoon._2239;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

  static boolean[][] row;
  static boolean[][] col;
  static boolean[][][] map;
  static int[][] board;
  static ArrayList<int[]> order;
  static int n;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    board = new int[9][9];
    row = new boolean[9][10];
    col = new boolean[9][10];
    map = new boolean[3][3][10];
    order = new ArrayList<>();

    for (int i = 0; i < 9; i++) {
      String str = br.readLine();
      for (int j = 0; j < 9; j++) {
        int v = str.charAt(j) - '0';

        board[i][j] = v;

        if (v == 0) {
          order.add(new int[]{i, j});
          continue;
        }

        row[i][v] = true;
        col[j][v] = true;
        map[i / 3][j / 3][v] = true;
      }
    }

    n = order.size();
    backtracking(0);
  }

  private static void backtracking(int depth) {
    if (depth == n) {
      print();
      System.exit(0);
    }

    int[] now = order.get(depth);
    int r = now[0];
    int c = now[1];

    for (int i = 1; i <= 9; i++) {
      if (row[r][i]) {
        continue;
      }

      if (col[c][i]) {
        continue;
      }

      if (map[r / 3][c / 3][i]) {
        continue;
      }

      row[r][i] = true;
      col[c][i] = true;
      map[r / 3][c / 3][i] = true;
      board[r][c] = i;
      backtracking(depth + 1);
      board[r][c] = 0;
      row[r][i] = false;
      col[c][i] = false;
      map[r / 3][c / 3][i] = false;
    }
  }

  private static void print() {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        System.out.print(board[i][j]);
      }
      System.out.println();
    }
  }
}
