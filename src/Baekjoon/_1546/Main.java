package Baekjoon._1546;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    int max = 0;
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      max = Math.max(max, arr[i]);
    }

    double result = 0;
    for (int i = 0; i < N; i++) {
      result += ((double) arr[i] / max) * 100;
    }

    System.out.println(result / N);
  }
}
