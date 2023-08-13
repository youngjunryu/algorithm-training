package Archiving.PROGRAMMERS;

import java.util.LinkedList;
import java.util.Locale;

public class 캐시 {
  public static int solution(int cacheSize, String[] cities) {
    int answer = 0;
    LinkedList<String> cache = new LinkedList<>();

    if (cacheSize == 0) {
      return cities.length * 5;
    }

    for (int i = 0; i < cities.length; i++) {
      String s = cities[i].toLowerCase(Locale.ROOT);
      if (cache.contains(s)) {
        cache.remove(s);
        cache.addLast(s);
        answer += 1;
      } else {
        if (cache.size() == cacheSize) {
          cache.removeFirst();
        }
        cache.addLast(s);
        answer += 5;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    solution(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"});
  }
}
