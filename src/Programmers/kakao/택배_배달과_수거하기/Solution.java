package Programmers.kakao.택배_배달과_수거하기;

class Solution {
  public long solution(int cap, int n, int[] deliveries, int[] pickups) {
    long answer = 0;

    reverseArray(deliveries);
    reverseArray(pickups);

    int d = 0;
    int p = 0;

    for (int i = 0; i < n; i++) {
      d += deliveries[i];
      p += pickups[i];

      while (d > 0 || p > 0) {
        d -= cap;
        p -= cap;

        answer += (n - i) * 2;
      }
    }

    return answer;
  }

  private void reverseArray(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n / 2; i++) {
      int temp = arr[i];
      arr[i] = arr[n - i - 1];
      arr[n - i - 1] = temp;
    }
  }
}
