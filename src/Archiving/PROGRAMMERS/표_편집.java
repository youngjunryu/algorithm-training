package Archiving.PROGRAMMERS;

import java.util.Stack;

public class 표_편집 {
  public String solution(int n, int k, String[] cmd) {
    Stack<Integer> remove = new Stack<>();
    int size = n;
    for (String c : cmd) {
      char ch = c.charAt(0);
      if (ch == 'U') {
        k -= Integer.parseInt(c.substring(2));
      } else if (ch == 'D') {
        k += Integer.parseInt(c.substring(2));
      } else if (ch == 'C') {
        remove.add(k);
        size--;
        if (k == size) {
          k--;
        }
      } else if (ch == 'Z') {
        int r = remove.pop();
        if (k >= r) {
          k++;
        }
        size++;
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < size; i++) {
      sb.append('O');
    }

    while (!remove.isEmpty()) {
      sb.insert(remove.pop().intValue(), 'X');
    }

    return sb.toString();
  }
}
