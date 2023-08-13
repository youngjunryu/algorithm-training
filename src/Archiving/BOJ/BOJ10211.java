package Archiving.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10211 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] X = new int[N+1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                X[i] = Integer.parseInt(st.nextToken());
            }

            int[] dp = new int[N+1];
            int answer = Integer.MIN_VALUE;
            for (int i = 1; i <= N; i++) {
                dp[i] = Math.max(X[i], dp[i-1] + X[i]);
                answer = Math.max(answer, dp[i]);
            }

            System.out.println(answer);
        }
    }
}
