package Archiving.PROGRAMMERS;

public class 기지국_설치 {
  public static int solution(int n, int[] stations, int w) {
    int answer = 0;
    int start = 0;
    for (int s : stations) {
      int left = s - w - 1;
      int right = s + w - 1;

      if (start >= left && start <= right) {
        start = right + 1;
        continue;
      }

      answer += (left - start) / (w * 2 + 1);
      if ((left - start) % (w * 2 + 1) != 0) {
        answer++;
      }
      start = right + 1;
    }

    if (start < n) {
      answer += (n - start) / (w * 2 + 1);
      if ((n - start) % (w * 2 + 1) != 0) {
        answer++;
      }
    }

    System.out.println(answer);

    return answer;
  }

  public static void main(String[] args) {
    solution(16, new int[]{9}, 2);
  }
}
