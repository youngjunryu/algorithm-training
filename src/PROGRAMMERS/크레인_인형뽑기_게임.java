package PROGRAMMERS;

import java.util.Stack;

public class 크레인_인형뽑기_게임 {
  public int solution(int[][] board, int[] moves) {
    int answer = 0;
    int n = board.length;

    int[] count = new int[board[0].length];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] > 0) {
          count[j] += 1;
        }
      }
    }

    Stack<Integer> s = new Stack<>();
    for (int move : moves) {
      if (count[move - 1] <= 0) {
        continue;
      }

      int pick = board[n - count[move - 1]][move - 1];
      if (!s.isEmpty() && s.peek() == pick) {
        answer += 2;
        s.pop();
      } else {
        s.add(pick);
      }

      count[move - 1]--;
    }

    return answer;
  }
}
