package Archiving.PROGRAMMERS;

public class 최고의_집합 {
  public static int[] solution(int n, int s) {
    int[] answer = new int[n];
    int base = s / n;
    int rem = s % n;

    if (base == 0) {
      return new int[]{-1};
    }

    for (int i = 1; i <= n; i++) {
      if (i > n - rem) {
        answer[i-1] = base + 1;
      } else {
        answer[i-1] = base;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    solution(3, 8);
  }
}
