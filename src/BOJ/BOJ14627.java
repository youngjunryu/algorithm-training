package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14627 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] arr;
        int left = 1;
        int right = 1000000000;
        int paLength = 0;
        long sum = 0;

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        arr = new int[S];
        for (int i = 0; i < S; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;

            for (int pa : arr) {
                cnt += pa / mid;
            }

            if (cnt >= C) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(sum - right * (long) C);
    }
}
