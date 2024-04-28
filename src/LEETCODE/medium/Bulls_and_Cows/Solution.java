package LeetCode.medium.Bulls_and_Cows;

public class Solution {

  public String getHint(String secret, String guess) {
    int x = 0;
    int y = 0;

    int[] a = new int[10];
    int[] b = new int[10];
    boolean[] flag = new boolean[1000];

    for (int i = 0; i < secret.length(); i++) {
      Character c = secret.charAt(i);
      int idx = c - '0';
      if (c.equals(guess.charAt(i))) {
        x++;
        a[idx]++;
        b[idx]++;
        flag[i] = true;
      } else {
        a[idx]++;
      }
    }

    for (int i = 0; i < guess.length(); i++) {
      Character c = guess.charAt(i);
      int idx = c - '0';

      if (flag[i]) {
        continue;
      }

      if (a[idx] > b[idx]) {
        y++;
        b[idx]++;
      }
    }

    return x + "A" + y + "B";
  }
}
