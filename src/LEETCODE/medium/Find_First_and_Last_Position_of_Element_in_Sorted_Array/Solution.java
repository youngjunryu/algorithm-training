package LeetCode.medium.Find_First_and_Last_Position_of_Element_in_Sorted_Array;

class Solution {
  public int[] searchRange(int[] nums, int target) {
    int[] result = new int[]{-1, -1};

    int a = lowerBound(0, nums.length - 1, nums, target);
    int b = upperBound(0, nums.length - 1, nums, target);

    if (a < nums.length && nums[a] == target) {
      return new int[]{a, b - 1};
    }

    return result;
  }

  private int lowerBound(int start, int end, int[] nums, int target) {
    while (start <= end) {
      int mid = (start + end) / 2;

      if (nums[mid] < target) {
        start = mid + 1;
      }  else {
        end = mid - 1;
      }
    }

    return start;
  }

  private int upperBound(int start, int end, int[] nums, int target) {
    while (start <= end) {
      int mid = (start + end) / 2;

      if (nums[mid] <= target) {
        start = mid + 1;
      }  else {
        end = mid - 1;
      }
    }

    return start;
  }
}
