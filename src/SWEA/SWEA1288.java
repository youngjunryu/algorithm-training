package SWEA;

import java.util.*;
import java.io.*;

public class SWEA1288 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++)
        {
            int N = Integer.parseInt(br.readLine());

            int i = N;
            int t = 0;

            while(true) {
                int k = i;
                while(k > 0) {
                    t = t | (1 << (k % 10));
                    k = k / 10;
                }

                if(t == 1023)
                    break;

                i += N;
            }

            System.out.printf("#%d %d\n", tc, i);

        }
    }
}