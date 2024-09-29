package Baekjoon._12015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

    ArrayList<Integer> list = new ArrayList<>();

    for (int num : arr) {
      int pos = binarySearch(list, num);

      if (pos < list.size()) {
        list.set(pos, num);
      } else {
        list.add(num);
      }
    }

    System.out.println(list.size());
  }

  private static int binarySearch(ArrayList<Integer> lis, int target) {
    int left = 0;
    int right = lis.size() - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (lis.get(mid) == target) {
        return mid;
      } else if (lis.get(mid) < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return left;
  }
}
