package Baekjoon._12919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Main {

  static Queue<String> q = new ArrayDeque<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();
    String t = br.readLine();

    q.add(t);
    System.out.println(exec(s));
  }

  public static int exec(String s) {
    while (!q.isEmpty()) {
      String str = q.poll();

      if (str.equals(s)) {
        return 1;
      }

      Set<String> set = new HashSet<>();

      if (str.endsWith("A")) {
        String substring = str.substring(0, str.length() - 1);
        if (!substring.isEmpty()) {
          set.add(substring);
        }
      }

      if (str.startsWith("B")) {
        String substring = new StringBuilder(str).reverse().substring(0, str.length() - 1);
        if (!substring.isEmpty()) {
          set.add(substring);
        }
      }

      q.addAll(set);
    }

    return 0;
  }
}
