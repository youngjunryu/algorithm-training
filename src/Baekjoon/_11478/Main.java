package Baekjoon._11478;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input = br.readLine();

    int len = input.length();

    HashSet<String> set = new HashSet<>();

    for (int i = 1; i <= len; i++) {
      for (int j = 0; j + i <= len; j++) {
        String temp = input.substring(j, j + i);
        set.add(temp);
      }
    }

    System.out.println(set.size());
  }
}
