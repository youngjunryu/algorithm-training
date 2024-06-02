package LeetCode.medium.Heaters;

import java.util.Arrays;

class Solution {

  public int findRadius(int[] houses, int[] heaters) {
    int i = 0;
    int j = 0;
    int result = 0;

    Arrays.sort(houses);
    Arrays.sort(heaters);

    while (i < houses.length) {
      while (j < heaters.length - 1 && Math.abs(heaters[j + 1] - houses[i]) <= Math.abs(
          heaters[j] - houses[i])) {
        j++;
      }
      result = Math.max(result, Math.abs(heaters[j] - houses[i]));
      i++;
    }

    return result;
  }
}
