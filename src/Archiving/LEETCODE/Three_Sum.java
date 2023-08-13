package Archiving.LEETCODE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_Sum {
  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> answer = new ArrayList<>();
    Arrays.sort(nums);

    for (int i = 0; i < nums.length; i++) {
      int left = i + 1;
      int right = nums.length - 1;
      int target = -nums[i];

      while (left < right) {
        int sum = nums[left] + nums[right];
        if (sum < target) {
          left++;
        } else if (sum > target) {
          right--;
        } else {
          List<Integer> now = List.of(-target, nums[left], nums[right]);
          answer.add(now);
          while (left < right && nums[left] == now.get(1)) {
            left++;
          }

          while (left < right && nums[right] == now.get(2)) {
            right--;
          }
        }
      }

      while (i + 1 < nums.length && nums[i+1] == nums[i]) {
        i++;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    threeSum(new int[]{-1,0,1,2,-1,-4});
  }
}
