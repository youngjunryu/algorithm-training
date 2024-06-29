package Baekjoon._16967;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int H = sc.nextInt();
    int W = sc.nextInt();
    int X = sc.nextInt();
    int Y = sc.nextInt();
    int[][] B = new int[H + X][W + Y];
    int[][] A = new int[H][W];

    for (int i = 0; i < B.length; i++) {
      for (int j = 0; j < B[i].length; j++) {
        B[i][j] = sc.nextInt();
      }
    }

    for (int i = 0; i < H; i++) {
      for (int j = 0; j < W; j++) {
        if (i - X >= 0 && j - Y >= 0) {
          A[i][j] = B[i][j] - A[i - X][j - Y];
        } else {
          A[i][j] = B[i][j];
        }
      }
    }

    for (int i = 0; i < H; i++) {
      for (int j = 0; j < W; j++) {
        System.out.print(A[i][j] + " ");
      }
      System.out.println();
    }
  }
}
