package Baekjoon._20922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int left = 0;
    int right = 0;
    int max = 0;
    int[] cnt = new int[100001];

    while (right < N) {
      int num = arr[right];

      while (cnt[num] >= K) {
        cnt[arr[left]]--;
        left++;
      }

      cnt[num]++;
      max = Math.max(max, right - left + 1);
      right++;
    }

    System.out.println(max);
  }
}
