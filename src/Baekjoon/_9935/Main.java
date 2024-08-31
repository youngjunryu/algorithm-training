package Baekjoon._9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Stack<Character> stack = new Stack<>();
    String str = br.readLine();
    String bomb = br.readLine();
    int size = bomb.length();

    for (int i = 0; i < str.length(); i++) {
      char now = str.charAt(i);
      stack.add(now);

      if (stack.size() >= size) {
        boolean flag = true;

        for (int t = stack.size() - size, j = 0; t < stack.size(); t++, j++) {
          if (stack.get(t) != bomb.charAt(j)) {
            flag = false;
            break;
          }
        }

        if (flag) {
          for (int j = 0; j < size; j++) {
            stack.pop();
          }
        }
      }
    }

    if (stack.isEmpty()) {
      System.out.println("FRULA");
    } else {
      StringBuilder sb = new StringBuilder();
      while (!stack.isEmpty()) {
        sb.append(stack.pop());
      }
      System.out.println(sb.reverse());
    }
  }
}
