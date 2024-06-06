package LeetCode.medium.Hand_of_Straights;

import java.util.Arrays;
import java.util.HashMap;

class Solution {

  public boolean isNStraightHand(int[] hand, int groupSize) {
    int n = hand.length;

    if (n % groupSize != 0) {
      return false;
    }

    int size = n / groupSize;
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int h : hand) {
      map.put(h, map.getOrDefault(h, 0) + 1);
    }

    Arrays.sort(hand);

    for (int i = 0; i < n; i++) {
      if (map.get(hand[i]) == 0) {
        continue;
      }

      for (int j = 0; j < groupSize; j++) {
        int cur = hand[i] + j;
        if (map.getOrDefault(cur, 0) == 0) {
          return false;
        }

        map.put(cur, map.get(cur) - 1);
      }
    }

    return true;
  }
}

/*
two pointer
1 2 2 3 3 4 6 7 8

1 1
2 2
3 2
4 1
6 1
7 1
8 1

*/
