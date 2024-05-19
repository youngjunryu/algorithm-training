package LeetCode.contest.weekly_398.Special_Array_II;

class Solution {

  public boolean[] isArraySpecial(int[] nums, int[][] queries) {
    int nq = queries.length;
    int n = nums.length;

    int[] ct = new int[n];
    int last = 0;

    for (int i = 0; i < n - 1; i++) {
      boolean flag1 = nums[i] % 2 == 0;
      boolean flag2 = nums[i + 1] % 2 == 0;
      if (flag1 == flag2) {
        last++; // 이 전의 수와 현재 수가 다를 때 last는 증가한다.
      }

      System.out.println(last);
      ct[i + 1] = last;
    }

    boolean[] result = new boolean[nq];
    for (int i = 0; i < nq; i++) {
      if (ct[queries[i][1]] - ct[queries[i][0]] == 0) {
        result[i] = true;
      }
    }

    return result;
  }
}

