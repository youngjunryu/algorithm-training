package Archiving.LEETCODE;

import java.util.HashMap;

public class Contains_Duplicate {
  public boolean containsDuplicate(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int n : nums) {
      if (map.containsKey(n)) {
        return true;
      }

      map.put(n, 1);
    }

    return false;
  }
}
