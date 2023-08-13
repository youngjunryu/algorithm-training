package Archiving.PROGRAMMERS;

public class 파괴되지_않은_건물 {
  static int[][] arr;

  public static int solution(int[][] board, int[][] skill) {
    int answer = 0;
    arr = new int[board.length+1][board[0].length+1];

    for (int[] s : skill) {
      int degree = s[0] == 1 ? -s[5] : s[5];
      arr[s[1]][s[2]] += degree;
      arr[s[1]][s[4]+1] -= degree;
      arr[s[3]+1][s[2]] -= degree;
      arr[s[3]+1][s[4]+1] += degree;
    }

    for (int i = 1; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        arr[i][j] += arr[i-1][j];
      }
    }

    for (int i = 0; i < arr.length; i++) {
      for (int j = 1; j < arr[0].length; j++) {
        arr[i][j] += arr[i][j-1];
      }
    }

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        board[i][j] += arr[i][j];
        if (board[i][j] >= 1) {
          answer++;
        }
      }
    }

    System.out.println(answer);

    return answer;
  }

  public static void main(String[] args) {
    solution(new int[][]{{1, 2, 3},{4, 5, 6},{7, 8, 9}},
             new int[][]{{1,1,1,2,2,4},{1,0,0,1,1,2},{2,2,0,2,0,100}});
  }
}
