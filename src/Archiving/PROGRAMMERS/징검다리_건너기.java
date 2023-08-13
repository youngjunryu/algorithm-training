package Archiving.PROGRAMMERS;

public class 징검다리_건너기 {
  public static int solution(int[] stones, int k) {
    int answer = -1;

    int start = 1;
    int end = 200000000;

    while (start <= end) {
      int mid = (start + end) / 2;
      boolean flag = check(stones, mid, k);
      if (flag) {
        start = mid + 1;
        answer = Math.max(answer, mid);
      } else {
        end = mid - 1;
      }
    }

    return answer;
  }

  private static boolean check(int[] stones, int mid, int k) {
    int count = 0;
    for (int i = 0; i < stones.length; i++) {
      int num = stones[i] - mid;
      if (num < 0) {
        count++;
        if (count == k) {
          return false;
        }
      } else {
        count = 0;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3);
  }
}
