package Archiving.PROGRAMMERS.simul.test4;

public class Two {
  public int solution(int[] a, int[] b) {
    int ans = 0;

    for (int i = 0; i < a.length; i++) {
      ans += a[i] * b[i];
    }

    return ans;
  }
}
