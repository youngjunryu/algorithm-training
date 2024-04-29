package LeetCode.medium.Largest_Number;

import java.util.Arrays;

class Solution {

  public String largestNumber(int[] nums) {
    if (Arrays.stream(nums).sum() == 0) {
      return "0";
    }

    Integer[] array = Arrays.stream(nums).boxed().toArray(Integer[]::new);

    Arrays.sort(array, (a, b) -> {
      String aStr = String.valueOf(a);
      String bStr = String.valueOf(b);
      return -(aStr + bStr).compareTo(bStr + aStr);
    });

    StringBuilder sb = new StringBuilder();
    for (Integer i : array) {
      sb.append(i);
    }

    return sb.toString();
  }
}
