package Baekjoon._2805;

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
    int M = Integer.parseInt(st.nextToken());

    int[] tree = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      tree[i] = Integer.parseInt(st.nextToken());
    }

    long left = 0;
    long right = 2000000000;

    while (left <= right) {
      long mid = (left + right) / 2;

      long sum = calculate(tree, mid);
      if (sum < M)
        right = mid - 1;
      else {
        left = mid + 1;
      }
    }

    System.out.println(right);
  }

  private static long calculate(int[] tree, long mid) {
    long sum = 0;
    for (int i = 0; i < tree.length; i++)
      if (tree[i] - mid > 0)
        sum += tree[i] - mid;
    return sum;
  }
}
