package Baekjoon._1655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> right = new PriorityQueue<>();

    int count = 0;

    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());

      if (left.isEmpty()) {
        left.add(num);
      } else {
        int mid = left.peek();
        if (mid > num) {
          if (count % 2 != 0) {
            right.add(left.poll());
          }
          left.add(num);
        } else {
          if (count % 2 == 0) {
            if (right.peek() < num) {
              left.add(right.poll());
              right.add(num);
            } else {
              left.add(num);
            }
          } else {
            right.add(num);
          }
        }

        if (right.size() > left.size()) {
          left.add(right.poll());
        }
      }

      count++;

      System.out.println(left.peek());
    }
  }
}
/*
1 /
1 / 9
8 1 / 9
5 1 / 8 9
5 3 1 / 8 9
3 2 1 / 5 8 9
3 2 2 1 / 5 8 9
3 2 2 1 / 5 7 8 9


 */