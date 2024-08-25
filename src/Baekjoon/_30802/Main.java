package Baekjoon._30802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[6];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 6; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    int T = Integer.parseInt(st.nextToken());
    int P = Integer.parseInt(st.nextToken());

    int sum = 0;
    for (int i = 0; i < 6; i++) {
      sum += arr[i] / T;
      if (arr[i] % T != 0) {
        sum += 1;
      }
    }

    int b = N / P;
    int c = N % P;

    System.out.println(sum);
    System.out.println(b + " " + c);
  }
}
