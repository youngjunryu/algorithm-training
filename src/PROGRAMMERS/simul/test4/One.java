package PROGRAMMERS.simul.test4;

public class One {
  public int solution(int[] absolutes, boolean[] signs) {
    int ans = 0;

    for (int i = 0; i < absolutes.length; i++) {
      ans += signs[i] ? absolutes[i] : -absolutes[i];
    }

    return ans;
  }

  public static void main(String[] args) {

  }
}
