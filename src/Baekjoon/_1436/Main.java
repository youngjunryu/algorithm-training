package Baekjoon._1436;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 666; i <= Integer.MAX_VALUE; i++) {
      if (count(i)) {
        list.add(i);
      }

      if (list.size() == N) {
        break;
      }
    }

    Collections.sort(list);

    System.out.println(list.get(N - 1));
  }

  private static boolean count(int num) {
    int count = 0;

    while (num != 0) {
      int n = num % 10;

      if (n == 6) {
        count++;
      } else {
        count = 0;
      }

      if (count == 3) {
        return true;
      }

      num /= 10;
    }

    return false;
  }
}

/*

666
1666
2666
3666
4666
5666
6660
6661
6662
6663
.
6669
7666
8666
9666
10666

 */