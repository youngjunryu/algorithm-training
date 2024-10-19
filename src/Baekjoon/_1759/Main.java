package Baekjoon._1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static ArrayList<Character> m;
  static ArrayList<Character> in;
  static List<String> result;
  static int L;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    L = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());

    m = new ArrayList<>();
    in = new ArrayList<>();
    result = new ArrayList<>();

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < C; i++) {
      char c = st.nextToken().charAt(0);
      if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
        in.add(c);
      }
      m.add(c);
    }

    Collections.sort(m);

    combination(0, 0, new ArrayList<>());

    for (String r : result) {
      System.out.println(r);
    }
  }

  private static void combination(int start, int depth, List<Character> now) {
    if (depth == L) {
      if (check(now)) {
        StringBuilder sb = new StringBuilder();
        for (char c : now) {
          sb.append(c);
        }
        result.add(sb.toString());
      }
      return;
    }

    for (int i = start; i < m.size(); i++) {
      now.add(m.get(i));
      combination(i + 1, depth + 1, now);
      now.remove(now.size() - 1);
    }
  }

  private static boolean check(List<Character> now) {
    int count = 0;
    for (char c : now) {
      if (in.contains(c)) {
        count++;
      }
    }

    if (count < 1) {
      return false;
    }

    if (L - count < 2) {
      return false;
    }

    return true;
  }
}
