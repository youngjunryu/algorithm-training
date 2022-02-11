package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA9999 {
    static boolean[] check = new boolean[100000000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            int L = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());
            int result = 0;
            int sum = 0;
            int x = 0;
            int y = 0;
            int start;

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                for(int j = x; j < y; j++) {
                    check[j] = true;
                }
            }

            for(int i = 0; i < L; i++) {
                sum += check[i] ? 1 : 0;
            }

            result = sum;
            start = 0;

            for(int end = L; end < y; end++) {
                sum -= check[start++] ? 1 : 0;
                sum += check[end] ? 1 : 0;
                result = Math.max(result, sum);
            }

            System.out.println("#" + tc + " " + result);

            for (int i = 0; i < y; i++) {
                check[i] = false;
            }

        }
    }
}