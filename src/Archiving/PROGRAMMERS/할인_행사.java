package Archiving.PROGRAMMERS;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class 할인_행사 {
  public static int solution(String[] want, int[] number, String[] discount) {
    int answer = 0;
    HashMap<String, Integer> wantMap = new HashMap<>();
    HashMap<String, Integer> discountMap = new HashMap<>();
    for (int i = 0; i < want.length; i++) {
      wantMap.put(want[i], number[i]);
    }

    for (int i = 0; i < 10; i++) {
      discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0) + 1);
    }

    for (int i = 0; i <= discount.length - 10; i++) {
      Set<Map.Entry<String, Integer>> entries = wantMap.entrySet();
      boolean flag = true;
      for (Map.Entry<String, Integer> e : entries) {
        String stuff  = e.getKey();
        int count = e.getValue();

        if (!discountMap.containsKey(stuff)) {
          flag = false;
          break;
        }

        if (!Objects.equals(discountMap.get(stuff), count)) {
          flag = false;
          break;
        }
      }

      if (flag) {
        answer++;
      }


      if (i == discount.length - 10) {
        break;
      }

      discountMap.put(discount[i], discountMap.get(discount[i]) - 1);
      discountMap.put(discount[i + 10], discountMap.getOrDefault(discount[i + 10], 0) + 1);
    }

    return answer;
  }

  public static void main(String[] args) {
    solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3, 2, 2, 2, 1}, new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"});
  }
}
