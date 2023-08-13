package Archiving.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1337 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(arr);

    int left = 0;
    int cnt = 0;
    int ans = 0;

    for (int right = 0; right < n; right++) {
      cnt++;

      while (arr[right] - arr[left] > 4) {
        left++;
        cnt--;
      }

      ans = Math.max(ans, cnt);
    }

    if (ans > 5) {
      ans = 5;
    }

    System.out.println(5 - ans);
  }
}
