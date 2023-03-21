package PROGRAMMERS;

import java.util.Arrays;

public class 연속_펄스_부분_수열의_합 {
  public long solution(int[] sequence) {
    int len = sequence.length;

    long[] seq1 = new long[len];
    long[] seq2 = new long[len];
    for (int i = 0; i < len; i++) {
      if (i % 2 == 0) {
        seq1[i] = sequence[i];
        seq2[i] = -sequence[i];
      } else {
        seq1[i] = -sequence[i];
        seq2[i] = sequence[i];
      }
    }

    long[] dp1 = new long[len];
    long[] dp2 = new long[len];
    dp1[0] = seq1[0];
    dp2[0] = seq2[0];

    for (int i = 1; i < len; i++) {
      dp1[i] = Math.max(dp1[i-1] + seq1[i], seq1[i]);
    }

    for (int i = 1; i < len; i++) {
      dp2[i] = Math.max(dp2[i-1] + seq2[i], seq2[i]);
    }

    Arrays.sort(dp1);
    Arrays.sort(dp2);

    return Math.max(dp1[len - 1], dp2[len - 1]);
  }
}
