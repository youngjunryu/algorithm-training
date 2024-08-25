package Baekjoon._9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      String str = br.readLine();
      Stack<Character> stack = new Stack();
      boolean flag = true;
      for (int j = 0; j < str.length(); j++) {
        char c = str.charAt(j);
        if (c == '(') {
          stack.add(c);
        } else {
          if (stack.isEmpty() || stack.peek() != '(') {
            flag = false;
            break;
          } else {
            stack.pop();
          }
        }
      }

      if (!stack.isEmpty() || !flag) {
        System.out.println("NO");
      } else {
        System.out.println("YES");
      }
    }
  }
}
