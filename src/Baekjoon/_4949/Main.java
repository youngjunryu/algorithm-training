package Baekjoon._4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      String str = br.readLine();

      if (str.equals(".")) {
        break;
      }

      Stack<Character> stack = new Stack<>();
      boolean flag = true;
      for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);

        if (c == '(') {
          stack.push(c);
        } else if (c == ')') {
          if (stack.isEmpty() || stack.peek() != '(') {
            flag = false;
            break;
          } else {
            stack.pop();
          }
        } else if (c == '[') {
          stack.push(c);
        } else if (c == ']') {
          if (stack.isEmpty() || stack.peek() != '[') {
            flag = false;
            break;
          } else {
            stack.pop();
          }
        }
      }

      if (!flag || !stack.isEmpty()) {
        System.out.println("no");
      } else {
        System.out.println("yes");
      }
    }
  }
}
