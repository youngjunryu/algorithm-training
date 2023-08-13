package Archiving.PROGRAMMERS;

import java.util.HashMap;
import java.util.HashSet;

public class 뉴스_클러스터링 {
  public static int solution(String str1, String str2) {
    HashMap<String, Integer> map1 = new HashMap<>();
    HashMap<String, Integer> map2 = new HashMap<>();
    HashSet<String> set = new HashSet<>();

    for (int i = 0; i < str1.length() - 1; i++) {
      String s1 = str1.substring(i, i + 2);

      if (s1.matches("^[a-zA-Z]*$")) {
        map1.put(s1.toLowerCase(), map1.getOrDefault(s1.toLowerCase(), 0) + 1);
        set.add(s1.toLowerCase());
      }
    }

    for (int i = 0; i < str2.length() - 1; i++) {
      String s2 = str2.substring(i, i + 2);

      if (s2.matches("^[a-zA-Z]*$")) {
        map2.put(s2.toLowerCase(), map2.getOrDefault(s2.toLowerCase(), 0) + 1);
        set.add(s2.toLowerCase());
      }
    }


    if (map1.isEmpty() && map2.isEmpty()) {
      return 65536;
    }

    int interaction = 0;
    int union = 0;
    for (String s : set) {
      if (map1.containsKey(s) && map2.containsKey(s)) {
        interaction += Math.min(map1.get(s), map2.get(s));
        union += Math.max(map1.get(s), map2.get(s));
        continue;
      }

      if (map1.containsKey(s)) {
        union += map1.get(s);
        continue;
      }

      union += map2.get(s);
    }

    double answer = (double)interaction / union * 65536;

    return (int)answer;
  }

  public static void main(String[] args) {
    solution("FRANCE", "french");
  }
}
