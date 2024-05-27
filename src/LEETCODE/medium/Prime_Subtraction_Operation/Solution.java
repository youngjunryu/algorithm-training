package LeetCode.medium.Prime_Subtraction_Operation;

class Solution {

  public boolean primeSubOperation(int[] nums) {
    int n = nums.length;
    for (int i = n - 2; i >= 0; i--) {
      if (nums[i] >= nums[i + 1]) {
        int minimum = nums[i] - nums[i + 1];
        int p = getP(minimum, nums[i]);
        if (nums[i] - p >= nums[i + 1] || p == -1) {
          return false;
        }
        nums[i] -= p;
        System.out.println(nums[i]);
      }
    }
    return true;
  }

  private int getP(int minimum, int now) {
    int num = minimum + 1;
    while (num < now) {
      if (isPrime(num)) {
        return num;
      }
      num++;
    }

    return -1;
  }

  private boolean isPrime(int num) {
    if (num <= 1) {
      return false;
    }

    for (int i = 2; i < num; i++) {
      if (num % i == 0) {
        return false;
      }
    }

    return true;
  }
}
