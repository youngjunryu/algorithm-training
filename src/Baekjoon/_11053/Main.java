package Baekjoon._11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int result = 0;
    int[] length = new int[N];

    for (int i = 0; i < N; i++) {
      length[i] = 1;
      for (int j = 0; j < i; j++) {
        if (arr[j] < arr[i]) {
          length[i] = Math.max(length[i], length[j] + 1);
        }
      }

      result = Math.max(result, length[i]);
    }

    System.out.println(result);
  }
}
