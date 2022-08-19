package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ11536 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    String[] real = new String[N];
    String[] inc;
    String[] dec;

    for (int i = 0; i < N; i++) {
      real[i] = br.readLine();
    }

    inc = Arrays.copyOf(real, real.length);
    dec = Arrays.copyOf(real, real.length);

    Arrays.sort(inc);
    Arrays.sort(dec, Comparator.reverseOrder());

    if (Arrays.deepEquals(real, inc)) {
      System.out.println("INCREASING");
    } else if (Arrays.deepEquals(real, dec)) {
      System.out.println("DECREASING");
    } else {
      System.out.println("NEITHER");
    }
  }
}
