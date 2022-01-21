import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA3304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken();
            String str2 = st.nextToken();

            int[][] lcs = new int[str1.length() + 1][str2.length() + 1];

            for(int i = 1; i <= str1.length(); i++) {
                for(int j = 1; j <= str2.length(); j++) {
                    if(str1.charAt(i-1) == str2.charAt(j-1)) {
                        lcs[i][j] = lcs[i-1][j-1] + 1;
                    } else {
                        lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                    }
                }
            }

            System.out.printf("#%d %d\n", tc, lcs[str1.length()][str2.length()]);

        }
    }
}
