package Baekjoon._2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine();

    HashSet<String> set = new HashSet<>();
    set.add("c=");
    set.add("c-");
    set.add("dz=");
    set.add("d-");
    set.add("lj");
    set.add("nj");
    set.add("s=");
    set.add("z=");

    int result = 0;

    int len = str.length();

    int left = 0;
    int right = 0;

    while (left < len) {
      String s = str.substring(left, right + 1);
      
      if (set.contains(s)) {
        left = right + 1;
        right = left;
        result++;
      } else {
        right++;

        if (right == len) {
          result++;
          left++;
          right = left;
        }
      }
    }

    System.out.println(result);
  }
}
