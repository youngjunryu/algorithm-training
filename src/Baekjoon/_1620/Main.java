package Baekjoon._1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());

    String[] arr = new String[M + 1];
    HashMap<String, Integer> map = new HashMap<>();
    for (int i = 1; i <= M; i++) {
      String val = br.readLine();
      map.put(val, i);
      arr[i] = val;
    }

    for (int i = 0; i < N; i++) {
      String input = br.readLine();

      char firstChar = input.charAt(0);

      if (firstChar >= '0' && firstChar <= '9') {
        System.out.println(arr[Integer.parseInt(input)]);
      } else {
        System.out.println(map.get(input));
      }
    }
  }
}
