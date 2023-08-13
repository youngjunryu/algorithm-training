package Archiving.LEETCODE;

import java.util.HashMap;

public class Majority_Element {
  static int size;
  static HashMap<Integer, Integer> map;

  public static int majorityElement(int[] nums) {
    size = nums.length / 2;
    initMap(nums);
    return getAnswer();
  }

  private static int getAnswer() {
    for (int k : map.keySet()) {
      System.out.println(map.get(k));
      if (map.get(k) > size) {
        return k;
      }
    }

    return -1;
  }

  private static void initMap(int[] nums) {
    map = new HashMap<>();
    for (int n : nums) {
      map.put(n, map.getOrDefault(n, 0) + 1);
    }
  }

  public static void main(String[] args) {
    majorityElement(new int[]{3, 2, 3});
  }
}
