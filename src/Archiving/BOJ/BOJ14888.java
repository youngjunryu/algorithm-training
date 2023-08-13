package Archiving.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ14888 {
  static int N;
  static int[] nums;
  static int[] ops;
  static ArrayList<Integer> results;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    nums = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    ops = new int[4];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 4; i++) {
      ops[i] = Integer.parseInt(st.nextToken());
    }

    results = new ArrayList<>();
    backtracking(1, new int[4], nums[0]);
    Collections.sort(results);

    if (results.size() == 1) {
      System.out.println(results.get(0));
      System.out.println(results.get(0));
    } else {
      System.out.println(results.get(results.size() - 1));
      System.out.println(results.get(0));
    }
  }

  private static void backtracking(int idx, int[] now, int result) {
    if (idx == N) {
      results.add(result);
      return;
    }

    for (int i = 0; i < 4; i++) {
      if (now[i] >= ops[i]) {
        continue;
      }

      now[i]++;
      backtracking(idx + 1, now, calculate(result, idx, i));
      now[i]--;
    }
  }

  private static int calculate(int result, int idx, int i) {
    switch (i) {
      case 0:
        result += nums[idx];
        break;
      case 1:
        result -= nums[idx];
        break;
      case 2:
        result *= nums[idx];
        break;
      case 3:
        if (result < 0) {
          int value = -result;
          result = -(value / nums[idx]);
        } else {
          result /= nums[idx];
        }
        break;
    }

    return result;
  }
}
