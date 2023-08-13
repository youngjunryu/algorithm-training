package Archiving.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ19939 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int sum = 0;
    for (int i = 1; i <= k; i++) {
      sum += i;
    }

    if (sum > n) {
      System.out.println(-1);
    } else {
      int[] arr = new int[k];
      int idx = arr.length - 1;

      for (int i = 0; i < k; i++) {
        arr[i] = i + 1;
      }

      for (int i = sum; i < n; i++) {
        arr[idx]++;
        idx = (idx - 1 + k) % k;
      }

      System.out.println(arr[arr.length - 1] - arr[0]);
    }
  }
}
