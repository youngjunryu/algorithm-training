package Archiving.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] visit;
        int max = 0;
        int cur;
        int cnt = 1;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        visit = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            visit[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < X; i++) {
            max += visit[i];
        }

        cur = max;

        if (max == 0) {
            System.out.println("SAD");
        } else {
            for (int i = X; i < N; i++) {
                cur = cur - visit[i-X] + visit[i];

                if (max == cur) {
                    cnt++;
                } else if (max < cur){
                    max = cur;
                    cnt = 1;
                }
            }

            System.out.println(max);
            System.out.println(cnt);
        }
    }
}
