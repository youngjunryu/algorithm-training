package Baekjoon._11279;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      int val = Integer.parseInt(br.readLine());
      if (val == 0) {
        if (pq.isEmpty()) {
          bw.write("0\n");
        } else {
          int out = pq.poll();
          bw.write(out + "\n");
        }
      } else {
        pq.add(val);
      }
    }

    bw.flush();
    bw.close();
  }
}
