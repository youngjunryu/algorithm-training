package PROGRAMMERS;

public class 스타_수열 {
  public static int solution(int[] a) {
    int[] count = new int[a.length+1];
    for (int n : a) {
      count[n]++;
    }

    int max = 0;

    for (int i = 0; i < count.length; i++) {
      if (count[i] <= 0) {
        continue;
      }

      if (count[i] <= max) {
        continue;
      }

      int now = 0;
      for (int j = 0; j < a.length - 1; j++) {
        if (a[j] != i && a[j+1] != i) {
          continue;
        }

        if (a[j] == a[j+1]) {
          continue;
        }

        j++;
        now++;
      }

      max = Math.max(max, now);
    }

    return max * 2;
  }

  public static void main(String[] args) {
    solution(new int[]{0, 3, 3, 0, 7, 2, 0, 2, 2, 0});
  }
}
