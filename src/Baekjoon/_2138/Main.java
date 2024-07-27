package Baekjoon._2138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    char[] before = br.readLine().toCharArray();
    char[] after = br.readLine().toCharArray();
    char[] before2 = before.clone();

    // 0번을 누르지 않음
    int firstResult = turn(before, after);

    // 0번을 누름
    before2[0] = before2[0] == '1' ? '0' : '1';
    before2[1] = before2[1] == '1' ? '0' : '1';
    int result = turn(before2, after);
    int secondResult = result + 1;

    if (firstResult == -1 && result == -1) {
      System.out.println("-1");
    } else if (firstResult == -1) {
      System.out.println(secondResult);
    } else if (result == -1) {
      System.out.println(firstResult);
    } else {
      System.out.println(Math.min(firstResult, secondResult));
    }
  }

  private static int turn(char[] before, char[] after) {
    int result = 0;
    for (int i = 1; i < N; i++) {
      char prev = before[i - 1];
      if (prev != after[i - 1]) {
        result++;
        if (i != N - 1) {
          before[i - 1] = after[i - 1];
          before[i] = before[i] == '1' ? '0' : '1';
          before[i + 1] = before[i + 1] == '1' ? '0' : '1';
        } else {
          before[i - 1] = after[i - 1];
          before[i] = before[i] == '1' ? '0' : '1';
        }
      }
    }

    for (int i = 0; i < N; i++) {
      if (before[i] != after[i]) {
        return -1;
      }
    }

    return result;
  }
}
