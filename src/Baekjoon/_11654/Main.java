package Baekjoon._11654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    char[] charArray = str.toCharArray();
    System.out.println((int) charArray[0]);
  }
}
