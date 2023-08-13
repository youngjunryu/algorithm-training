package Archiving.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] block = new int[W];
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            block[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < W-1; i++) {
            int left = block[i];

            for (int j = i-1; j >= 0; j--) {
                left = Math.max(block[j], left);
            }

            if (left == block[i]) {
                continue;
            }

            int right = block[i];

            for (int j = i+1; j < W; j++) {
                right = Math.max(block[j], right);
            }

            if (right == block[i]) {
                continue;
            }

            int high = Math.min(left, right);
            answer += high - block[i];
        }

        System.out.println(answer);
    }
}
