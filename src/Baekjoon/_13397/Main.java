package Baekjoon._13397;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int result = 10000;
    int left = 0;
    int right = 10000;

    while (left <= right) {
      int mid = (left + right) / 2;

      if (canSplit(arr, M, mid)) {
        result = mid;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    System.out.println(result);
  }

  private static boolean canSplit(int[] arr, int m, int maxVal) {
    TreeSet<Integer> set = new TreeSet<>();
    int splits = 0;

    for (int a : arr) {
      set.add(a);

      int diff = Math.abs(set.first() - set.last());

      if (diff > maxVal) {
        splits++;
        set.clear();
        set.add(a);
      }

      if (splits > m - 1) {
        return false;
      }
    }

    return true;
  }
}
