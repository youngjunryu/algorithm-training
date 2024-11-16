package Baekjoon._18258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());
    ArrayDeque<Integer> deque = new ArrayDeque<>();

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String command = st.nextToken();

      switch (command) {
        case "push":
          int value = Integer.parseInt(st.nextToken());
          deque.add(value);
          break;

        case "pop":
          sb.append(deque.isEmpty() ? -1 : deque.poll()).append('\n');
          break;

        case "size":
          sb.append(deque.size()).append('\n');
          break;

        case "empty":
          sb.append(deque.isEmpty() ? 1 : 0).append('\n');
          break;

        case "front":
          sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append('\n');
          break;

        case "back":
          sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append('\n');
          break;
      }
    }

    System.out.print(sb);
  }
}
