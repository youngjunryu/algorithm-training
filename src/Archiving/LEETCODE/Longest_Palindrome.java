package Archiving.LEETCODE;

import java.util.HashMap;

public class Longest_Palindrome {
  static HashMap<Character, Integer> map;

  public static int longestPalindrome(String s) {
    initMap(s);
    return getAnswer();
  }

  private static int getAnswer() {
    int answer = 0;
    boolean flag = false;

    for (int n: map.values()) {
      if (n % 2 == 0) {
        answer += n;
      } else {
        answer = answer + n - 1;
        flag = true;
      }
    }

    if (flag) {
      answer++;
    }

    return answer;
  }

  private static void initMap(String s) {
    map = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
  }

  public static void main(String[] args) {
    longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth");
  }
}
