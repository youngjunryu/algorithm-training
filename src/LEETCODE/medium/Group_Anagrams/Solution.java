package LeetCode.medium.Group_Anagrams;

import java.util.*;

class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result = new ArrayList<>();
    HashMap<String, Integer> map = new HashMap<>();
    int idx = 0;

    for (String s : strs) {
      String val = new String(s);
      char[] charArr = val.toCharArray();
      Arrays.sort(charArr);
      val = new String(charArr);

      if (map.containsKey(val)) {
        result.get(map.get(val)).add(s);
      } else {
        List<String> list = new ArrayList();
        list.add(s);
        result.add(list);
        map.put(val, idx++);
      }
    }

    return result;
  }
}
