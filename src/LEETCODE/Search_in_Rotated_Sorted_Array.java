package LEETCODE;

import java.util.Arrays;
import java.util.HashMap;

public class Search_in_Rotated_Sorted_Array {
  public static int search(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i  < nums.length; i++) {
      map.put(nums[i], i);
    }

    if (!map.containsKey(target)) {
      return -1;
    }

    Arrays.sort(nums);

    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      int val = nums[mid];

      if (val == target) {
        return map.get(val);
      } else if (val > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    System.out.println(search(new int[]{1}, 0));
  }
}
