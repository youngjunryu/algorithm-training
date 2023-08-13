package Archiving.LEETCODE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Product_of_Array_Except_Self {
  public static int[] productExceptSelf(int[] nums) {
    int[] answer = new int[nums.length];
    List<Integer> zeroIdxList = new ArrayList<>();
    int total = 1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        zeroIdxList.add(i);
      } else {
        total *= nums[i];
      }
    }

    if (zeroIdxList.isEmpty()) {
      for (int i = 0; i < nums.length; i++) {
        answer[i] = total / nums[i];
      }
      return answer;
    }

    if (zeroIdxList.size() == 1) {
      answer[zeroIdxList.get(0)] = total;
      return answer;
    }

    return answer;
  }

  public static void main(String[] args) {
    int[] ints = productExceptSelf(new int[]{-1, 1, 0, -3, 3});
    System.out.println(Arrays.toString(ints));
  }
}
