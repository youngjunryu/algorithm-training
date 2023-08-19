package LeetCode.easy.Sqrt;

class Solution {
  public int mySqrt(int x) {
    if (x == 0 || x == 1) {
      return x;
    }

    int left = 1;
    int right = x;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      System.out.println(left + " " + right);

      if ((long) mid * mid < (long) x) {
        left = mid + 1;
      } else if (mid * mid == x) {
        return mid;
      } else {
        right = mid - 1;
      }
    }

    return right;
  }
}