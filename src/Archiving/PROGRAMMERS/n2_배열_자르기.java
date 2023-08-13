package Archiving.PROGRAMMERS;

public class n2_배열_자르기 {
  public static int[] solution(int n, long left, long right) {
    int[] answer = new int[(int)(right - left + 1)];
    int idx = 0;
    for (long i = left; i <= right; i++) {
      answer[idx++] = (int)(Math.max(i / n, i % n) + 1);
    }

    return answer;
  }

  public static void main(String[] args) {
    solution(4, 7, 14);
  }
}
