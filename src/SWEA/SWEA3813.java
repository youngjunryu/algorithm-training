package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA3813 {
    static int N;
    static int K;
    final static int MAX = 200009;
    static int[] w = new int[MAX];
    static int[] s = new int[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++) {
                w[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= K; i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }

            int start = 1;
            int end = MAX;
            int m;

            while(start < end) {
                m = (start + end) / 2;
                if(isAvailable(m))
                    end = m;
                else
                    start = m + 1;
            }

            System.out.println("#" + tc + " " + start);
        }
    }

    private static boolean isAvailable(int m) {
        int now = 1;
        int cnt = 0;

        for(int i = 1; i <= N; i++) {
            if(w[i] <= m)
                cnt++;
            else
                cnt = 0;
            if(cnt == s[now]) {
                cnt = 0;
                if(++now > K)
                    break;
            }
        }

        return now > K;
    }
}
