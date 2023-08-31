package Programmers.lv2.혼자서_하는_틱택토;

class Solution {
  public int solution(String[] board) {
    int firstCnt = 0, lastCnt = 0;;

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length(); j++) {
        char c = board[i].charAt(j);
        if (c == 'O') {
          firstCnt++;
        } else if (c == 'X') {
          lastCnt++;
        }
      }
    }

    // 시작 안함
    if (firstCnt == 0 && lastCnt == 0) {
      return 1;
    }

    // 후공이 많을 때
    if (firstCnt < lastCnt) {
      return 0;
    }

    if (isWin('O', board) && (firstCnt <= lastCnt)) {
      return 0;
    }

    if (isWin('X', board) && (firstCnt > lastCnt)) {
      return 0;
    }

    if (firstCnt - lastCnt > 1) {
      return 0;
    }

    return 1;
  }

  private boolean isWin(char c, String[] board) {
    if (board[0].charAt(0) == c && board[0].charAt(1) == c && board[0].charAt(2) == c) {
      return true;
    } else if (board[1].charAt(0) == c && board[1].charAt(1) == c && board[1].charAt(2) == c) {
      return true;
    } else if (board[2].charAt(0) == c && board[2].charAt(1) == c && board[2].charAt(2) == c) {
      return true;
    } else if (board[0].charAt(0) == c && board[1].charAt(0) == c && board[2].charAt(0) == c) {
      return true;
    } else if (board[0].charAt(1) == c && board[1].charAt(1) == c && board[2].charAt(1) == c) {
      return true;
    } else if (board[0].charAt(2) == c && board[1].charAt(2) == c && board[2].charAt(2) == c) {
      return true;
    } else if (board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c) {
      return true;
    } else if (board[0].charAt(2) == c && board[1].charAt(1) == c && board[2].charAt(0) == c) {
      return true;
    } else {
      return false;
    }
  }
}
