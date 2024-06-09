package LeetCode.contest.weekly_401.Find_the_Child_Who_Has_the_Ball_After_K_Seconds;

class Solution {

  public int numberOfChild(int n, int k) {
    n--;

    int round = k / n;
    int result = k % n;

    if (round % 2 == 0) {
      return result;
    } else {
      return n - result;
    }
  }
}
