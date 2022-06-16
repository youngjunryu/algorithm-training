package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ11508 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] milk = new int[N];
        int answer = 0;

        for (int i = 0; i < N; i++) {
            milk[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(milk);

        int i = N - 1;
        while (i >= 2) {
            answer += milk[i] + milk[i - 1];
            i -= 3;
        }

        while (i >= 0) {
            answer += milk[i--];
        }

        System.out.println(answer);
    }
}
