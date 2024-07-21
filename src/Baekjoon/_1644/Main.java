package Baekjoon._1644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    if (N == 1) {
      System.out.println(0);
      return;
    }

    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 2; i <= N; i++) {
      if (isPrimeNumber(i)) {
        list.add(i);
      }
    }

    int result = 0;
    int left = 0;
    int right = 0;
    int sum = list.get(0);
    while (true) {
      if (sum == N) {
        result++;

        right++;
        if (right >= list.size()) {
          break;
        }
        sum += list.get(right);

        sum -= list.get(left);
        left++;
      } else if (sum < N) {
        right++;
        if (right >= list.size()) {
          break;
        }
        sum += list.get(right);
      } else {
        sum -= list.get(left);
        left++;
      }
    }

    System.out.println(result);
  }

  public static boolean isPrimeNumber(int n) {
    if (n == 1) {
      return false;
    }

    if (n == 2) {
      return true;
    }

    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        return false;
      }
    }

    return true;
  }
}
