package Baekjoon._30804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
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

    int left = 0;
    int maxLength = 0;

    HashMap<Integer, Integer> map = new HashMap<>();

    for (int right = 0; right < N; right++) {
      map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

      while (map.size() > 2) {
        map.put(arr[left], map.get(arr[left]) - 1);
        if (map.get(arr[left]) == 0) {
          map.remove(arr[left]);
        }
        left++;
      }

      maxLength = Math.max(maxLength, right - left + 1);
    }

    System.out.println(maxLength);
  }
}
