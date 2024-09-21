package Baekjoon._16953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    Queue<long[]> q = new LinkedList<>();
    q.add(new long[]{a, 1});
    long result = -1;

    while (!q.isEmpty()) {
      long[] now = q.poll();

      if (now[0] == b) {
        result = now[1];
        break;
      }

      long one = now[0] * 2;
      long two = now[0] * 10 + 1;

      if (one <= b) {
        q.add(new long[]{one, now[1] + 1});
      }

      if (two <= b) {
        q.add(new long[]{two, now[1] + 1});
      }
    }

    System.out.println(result);
  }
}
