package Baekjoon._15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    ArrayList<String> temp = new ArrayList<>();

    for (int i = 1; i <= (1 << N); i++) {
      StringBuilder sb = new StringBuilder();
      int count = 0;
      for (int j = 0; j < N; j++) {
        if ((i & (1 << j)) != 0) {
          sb.append(1);
          count++;
        } else {
          sb.append(0);
        }
      }

      if (count == M) {
        temp.add(sb.toString());
      }
    }

    ArrayList<String> result = new ArrayList<>();
    for (String next : temp) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < next.length(); i++) {
        if (next.charAt(i) == '1') {
          sb.append(i + 1).append(" ");
        }
      }
      result.add(sb.deleteCharAt(sb.length() - 1).toString());
    }

    Collections.sort(result);
    for (String n : result) {
      System.out.println(n);
    }
  }
}
