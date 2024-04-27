package LeetCode.medium.Next_Permutation;

class Solution2 {

  public void nextPermutation(int[] nums) {
    int n = nums.length;

    int index = -1;
    for (int i = n - 2; i >= 0; i--) {
      if (nums[i] < nums[i + 1]) {
        index = i;
        break;
      }
    }

    for (int i = n - 1; i >= index && index != -1; i--) {
      if (nums[i] > nums[index]) {
        swap(i, index, nums);
        break;
      }
    }

    int left = index + 1;
    int right = n - 1;
    while (left < right) {
      swap(left, right, nums);
      left++;
      right--;
    }
  }

  private void swap(int a, int b, int[] nums) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
  }
}
