package Baekjoon._10989;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

    int N = Integer.parseInt(br.readLine());

    int[] count = new int[10001];
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());
      count[num]++;
    }

    for (int i = 1; i <= 10000; i++) {
      while (count[i] != 0) {
        bw.write(i + "\n");
        count[i]--;
      }
    }

    bw.flush();
    bw.close();
  }
}
