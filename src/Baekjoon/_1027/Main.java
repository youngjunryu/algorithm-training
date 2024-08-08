package Baekjoon._1027;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int maxCnt = 0;
    for (int i = 0; i < N; i++) {
      double degree = 1000000000;
      int cnt = 0;

      for (int j = i - 1; j >= 0; j--) {
        double now = (double) (arr[j] - arr[i]) / (j - i);
        if (degree > now) {
          degree = now;
          cnt++;
        }
      }

      degree = -1000000000;
      for (int j = i + 1; j < N; j++) {
        double now = (double) (arr[j] - arr[i]) / (j - i);
        if (degree < now) {
          degree = now;
          cnt++;
        }
      }

      maxCnt = Math.max(maxCnt, cnt);
    }

    System.out.println(maxCnt);
  }
}
