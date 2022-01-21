import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA3282 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] v = new int[101];
            int[] c = new int[101];
            int[][] dp = new int[N + 1][K + 1];

            for(int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                v[i] = Integer.parseInt(st.nextToken());
                c[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= K; j++) {
                    if(j - v[i] >= 0) {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - v[i]] + c[i]);
                    }
                    else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }

            System.out.printf("#%d %d\n", tc, dp[N][K]);
        }
    }
}