package Baekjoon;

import java.util.Scanner;

public class Main {

  static int N;
  static int[][] board;
  static boolean[] diagonal1, diagonal2;
  static int blackMax = 0, whiteMax = 0;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    board = new int[N][N];

    // 체스판 입력 받기
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        board[i][j] = sc.nextInt();
      }
    }

    // 대각선 방문 체크 배열 초기화
    diagonal1 = new boolean[2 * N - 1]; // '/' 방향 대각선
    diagonal2 = new boolean[2 * N - 1]; // '\' 방향 대각선

    // 흑, 백 비숍 배치 백트래킹 실행
    backtrack(0, 0, 0);  // 흑 비숍 탐색
    backtrack(0, 1, 0);  // 백 비숍 탐색

    // 최대 비숍 개수 출력
    System.out.println(blackMax + whiteMax);
  }

  // 백트래킹 함수
  public static void backtrack(int row, int col, int count) {
    // 모든 행을 다 탐색한 경우
    if (col >= N) {
      row++;
      col = (col % 2 == 0) ? 1 : 0; // 다음 행의 시작 열 조정 (흑-백 구분)
    }

    // 탐색이 끝난 경우 최대값 갱신
    if (row >= N) {
      if (col == 0) {
        blackMax = Math.max(blackMax, count);
      } else {
        whiteMax = Math.max(whiteMax, count);
      }
      return;
    }

    // 비숍을 놓을 수 있는 경우
    if (board[row][col] == 1 && !diagonal1[row + col] && !diagonal2[row - col + N - 1]) {
      // 비숍 배치
      diagonal1[row + col] = true;
      diagonal2[row - col + N - 1] = true;

      backtrack(row, col + 2, count + 1); // 다음 칸으로 이동

      // 비숍 제거 (백트래킹)
      diagonal1[row + col] = false;
      diagonal2[row - col + N - 1] = false;
    }

    // 비숍을 놓지 않고 이동
    backtrack(row, col + 2, count);
  }
}
