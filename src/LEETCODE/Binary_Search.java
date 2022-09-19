package LEETCODE;

public class Binary_Search {
  public static int search(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;
    int answer = -1;

    while (start <= end) {
      int mid = (start + end) / 2;

      if (nums[mid] == target) {
        answer = mid;
        break;
      } else if (nums[mid] > target) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }

    return answer;
  }
}
