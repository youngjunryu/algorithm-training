package LeetCode.easy.Single_Number;

class Solution {
  public int singleNumber(int[] nums) {
    int result = 1000000;
    int val = 3 * (int)Math.pow(10, 4);
    System.out.println(val);

    int[] arr = new int[60001];
    for (int n : nums) {
      arr[n + val]++;
    }

    for (int i = 0; i < 60001; i++) {
      if (arr[i] == 1) {
        result = i;
        break;
      }
    }

    return result - val;
  }
}
