package PROGRAMMERS.simul.test5;

import java.util.Stack;

public class Four {
  private static final String UP = "U";
  private static final String DOWN = "D";
  private static final String REMOVE = "C";
  private static final String UNDO = "Z";

 int curRow;
 int curSize;
 Stack<Integer> removed = new Stack<>();

  public String solution(int n, int k, String[] cmd) {
    curRow  = k;
    curSize = n;

    for (String input : cmd) {
      String command = input.substring(0, 1);

      switch (command) {
        case UP:
          up(Integer.parseInt(input.substring(2)));
          break;
        case DOWN:
          down(Integer.parseInt(input.substring(2)));
          break;
        case REMOVE:
          remove();
          break;
        case UNDO:
          undo();
          break;
      }
    }

    return buildAnswer();
  }

  private String buildAnswer() {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < curSize; i++) {
      sb.append("O");
    }

    while(!removed.isEmpty()) {
      sb.insert(removed.pop(), "X");
    }

    return sb.toString();
  }

  private void up(int shift) {
    curRow -= shift;
  }

  private void down(int shift) {
    curRow += shift;
  }

  private void remove() {
    removed.push(curRow);
    curSize--;

    if (curRow == curSize) {
      curRow--;
    }
  }

  private void undo() {
    int row = removed.pop();
    curSize++;

    if (row <= curRow) {
      curRow++;
    }
  }
}
