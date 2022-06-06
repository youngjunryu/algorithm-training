package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ16194 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] cards = new int[10001];
        int idx = 1;
        int maxValue = 10001;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            cards[idx++] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[N+1];
        Arrays.fill(result, maxValue);
        result[0] = 0;
        result[1] = cards[1];

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                result[i] = Math.min(result[i], result[i-j] + cards[j]);
            }
        }

        System.out.println(result[N]);
    }
}

/*

0 1 5 6 7
0 1 2 3 0

 */