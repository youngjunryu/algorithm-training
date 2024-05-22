package Baekjoon._25757;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    char game = st.nextToken().charAt(0);
    int sum = 0;
    if (game == 'Y') {
      sum = 1;
    } else if (game == 'F') {
      sum = 2;
    } else {
      sum = 3;
    }

    int result = 0;
    int val = 0;
    HashSet<String> set = new HashSet<>();
    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      if (set.contains(str)) {
        continue;
      }

      set.add(str);
      val++;
      if (val == sum) {
        val = 0;
        result++;
      }
    }

    System.out.println(result);
  }
}
