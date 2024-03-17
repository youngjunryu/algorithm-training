package Programmers.lv1.폰켓몬;

import java.util.*;

class Solution {
  public int solution(int[] nums) {
    int n = nums.length / 2;
    HashSet<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }

    if (set.size() > n) return n;
    else return set.size();
  }
}

/*

1. N마리 중 N/2 마리 가져가도 됨
2. N/2 마리 중에서 최대한 많은 종류의 폰켓몬을 선택해야됨.
3. 그 때 최대한 많은 종류의 수가 리턴값

*/
