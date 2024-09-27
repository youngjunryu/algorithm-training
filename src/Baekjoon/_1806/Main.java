package Baekjoon._1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int s = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int[] sum = new int[n + 1];
    for (int i = 0; i < n; i++) {
      sum[i + 1] = arr[i] + sum[i];
    }

    int min = 100001;
    int left = 0;
    int right = 1;

    while (right <= n) {
      int now = sum[right] - sum[left];

      if (now > s) {
        min = Math.min(min, right - left);
        left++;
      } else if (now < s) {
        right++;

      } else {
        min = Math.min(min, right - left);
        left++;
        right++;
      }
    }

    if (min == 100001) {
      System.out.println(0);
    } else {
      System.out.println(min);
    }
  }
}
