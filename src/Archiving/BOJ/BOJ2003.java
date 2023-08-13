package Archiving.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] arr;
        int sum = 0;
        int left = 0;
        int right = 0;
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while (left <= N-1 && right <= N) {
            if (sum >= M) {
                if (sum == M) {
                    answer++;
                }
                sum -= arr[left++];
            } else {
                if (right == N) {
                    break;
                }
                sum += arr[right++];
            }
        }

        System.out.println(answer);
    }
}
