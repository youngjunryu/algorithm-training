package Archiving.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] point;
        boolean[] tape;
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        point = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            point[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(point);
        tape = new boolean[point[N-1] + 1];

        for (int i = 0; i < N; i++) {
            if (tape[point[i]]) {
                continue;
            }

            int l = L;
            int cur = point[i];
            while (cur < tape.length && l-- > 0) {
                tape[cur++] = true;
            }

            answer++;
        }

        System.out.println(answer);
    }
}
