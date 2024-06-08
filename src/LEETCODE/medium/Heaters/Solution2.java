package LeetCode.medium.Heaters;

import java.util.Arrays;

class Solution2 {

  public int findRadius(int[] houses, int[] heaters) {
    Arrays.sort(houses);
    Arrays.sort(heaters);

    int housesLen = houses.length;
    int heatersLen = heaters.length;
    int result = -1;
    int idx = 0;

    for (int i = 0; i < housesLen; i++) {
      int house = houses[i];
      int min = Integer.MAX_VALUE;
      if (idx != 0) {
        idx--;
      }

      while (idx < heatersLen) {
        int diff = Math.abs(house - heaters[idx]);
        if (diff <= min) {
          min = diff;
        } else {
          break;
        }

        idx++;
      }

      result = Math.max(min, result);
    }

    return result;
  }
}
