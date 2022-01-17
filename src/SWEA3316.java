import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA3316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[][]dp;

        for(int tc = 1; tc <= T; tc++) {
            String club = br.readLine();
            dp = new int[club.length()][16];
            checkFirstDay(club, dp);
            for(int i = 1; i < club.length(); i++) {
                checkOtherDay(club, dp, i);
            }
            System.out.printf("#%d %d\n", tc, solve(dp));
        }
    }

    private static void checkFirstDay(String club, int[][] dp) {
        int admin = 1 << (club.charAt(0) - 'A');
        for(int i = 1; i < 16; i++) {
            if((i & admin) != 0 && (i & 1) != 0)
                dp[0][i] = 1;
        }
    }

    private static void checkOtherDay(String club, int[][] dp, int day) {
        int admin = 1 << (club.charAt(day) - 'A');
        for(int i = 1; i < 16; i++) {
            if(dp[day - 1][i] != 0) {
                for(int j = 1; j < 16; j++) {
                    if((j & i) != 0 && (j & admin) != 0) {
                        dp[day][j] += dp[day-1][i];
                        dp[day][j] %= 1000000007;
                    }
                }
            }
        }
    }

    private static int solve(int[][] dp) {
        int sum = 0;
        for(int i = 1; i < 16; i++) {
            sum += dp[dp.length - 1][i];
            sum %= 1000000007;
        }
        return sum;
    }

}
