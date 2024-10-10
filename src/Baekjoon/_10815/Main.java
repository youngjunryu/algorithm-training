package Baekjoon._10815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] card = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      card[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(card);

    int M = Integer.parseInt(br.readLine());
    StringBuilder result = new StringBuilder();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      int m = Integer.parseInt(st.nextToken());
      if (isIncluding(card, m)) {
        result.append(1).append(" ");
      } else {
        result.append(0).append(" ");
      }
    }

    System.out.println(result);
  }

  private static boolean isIncluding(int[] card, int target) {
    int left = 0;
    int right = card.length - 1;

    while (left <= right) {
      int mid = (left + right) / 2;

      if (card[mid] == target) {
        return true;
      } else if (card[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return false;
  }
}
