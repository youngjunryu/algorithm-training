package Baekjoon._1107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  static Set<Integer> set;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    set = new HashSet<>();
    if (M != 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < M; i++) {
        int val = Integer.parseInt(st.nextToken());
        set.add(val);
      }
    }

    int minPress = Math.abs(N - 100);

    if (set.size() == 10) {
      System.out.println(minPress);
      return;
    }

    for (int i = 0; i <= 999999; i++) {
      if (canMake(i)) {
        int sum = String.valueOf(i).length();
        sum += Math.abs(N - i);
        minPress = Math.min(minPress, sum);
      }
    }

    System.out.println(minPress);
  }

  private static boolean canMake(int num) {
    if (num == 0 && set.contains(num)) {
      return false;
    }

    while (num > 0) {
      int v = num % 10;

      if (set.contains(v)) {
        return false;
      }

      num /= 10;
    }

    return true;
  }
}
