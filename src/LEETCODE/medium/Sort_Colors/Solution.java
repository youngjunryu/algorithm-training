package LeetCode.medium.Sort_Colors;

import java.util.HashMap;

class Solution {
  public void sortColors(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int n : nums) {
      map.put(n, map.getOrDefault(n, 0) + 1);
    }

    int idx = 0;
    for (int i = 0; i < 3; i++) {
      if (map.containsKey(i)) {
        int cnt = map.get(i);
        while (cnt-- > 0) {
          nums[idx++] = i;
        }
      }
    }
  }
}
