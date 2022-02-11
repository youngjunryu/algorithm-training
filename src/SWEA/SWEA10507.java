package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA10507 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            st =  new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            int[] num = new int[N];
            st =  new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++)
                num[i] = Integer.parseInt(st.nextToken());

            int[] arr = new int[num[N-1] + 1];
            for(int i = 0; i < N; i++) {
                arr[num[i]] = 1;
            }

            int result = P + 1;
            int cnt = 0;
            int p1 = 1;
            int p2 = 1;

            while(p2 < num[N-1]+1) {
                if(arr[p2] == 1) {
                    cnt++;
                    p2++;
                    result = Math.max(result, cnt);
                } else {
                    if(P == 0) {
                        if(arr[p1] == 0) {
                            P++;
                        }
                        p1++;
                        cnt--;
                    } else {
                       cnt++;
                       p2++;
                       P--;
                    }
                }
            }

            System.out.printf("#%d %d\n", tc, result);
        }
    }
}
