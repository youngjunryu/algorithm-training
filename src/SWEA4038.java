import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA4038 {
    static int[] table;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            char[] parent = br.readLine().toCharArray();
            char[] pattern = br.readLine().toCharArray();

            cnt = 0;
            makeTable(pattern);
            KMP(parent, pattern);

            System.out.println("#" + tc + " " + cnt);
        }
    }

    private static void makeTable(char[] pattern) {
        int patternSize = pattern.length;
        table = new int[patternSize];
        int j = 0;

        for(int i = 1; i < patternSize; i++) {
            while(j > 0 && pattern[i] != pattern[j])
                j = table[j - 1];
            if(pattern[i] == pattern[j])
                table[i] = ++j;
        }
    }

    private static void KMP(char[] parent, char[] pattern) {
        int parentSize = parent.length;
        int patternSize = pattern.length;
        int j = 0;
        for(int i = 0; i < parentSize; i++) {
            while(j > 0 && parent[i] != parent[j]) {
                j = table[j - 1];
            }
            if(parent[i] == parent[j]) {
                if(j == patternSize - 1) {
                    cnt++;
                    j = table[j];
                } else {
                    j++;
                }
            }
        }
    }
}