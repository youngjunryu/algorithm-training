package Baekjoon._11866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 1; i <= N; i++) {
      list.add(i);
    }

    StringBuilder sb = new StringBuilder();
    sb.append("<");

    int idx = -1;
    int count = 0;

    while (true) {
      idx = (idx + 1) % list.size();
      count++;

      if (count == K) {
        int num = list.remove(idx);
        sb.append(num);
        sb.append(", ");

        if (list.isEmpty()) {
          break;
        }

        idx = (idx - 1) % list.size();
        count = 0;
      }
    }

    sb.deleteCharAt(sb.length() - 1);
    sb.deleteCharAt(sb.length() - 1);
    sb.append(">");

    System.out.println(sb);
  }
}
