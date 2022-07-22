package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ2170 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

		int left = arr[0][0];
		int right = arr[0][1];
		long sum = right - left;

		for (int i = 1; i < N; i++) {
			if (arr[i][0] <= right) {
				if (arr[i][1] > right) {
					sum += arr[i][1] - right;
					right = arr[i][1];
				}
			} else {
				left = arr[i][0];
				right = arr[i][1];
				sum += right - left;
			}
		}

		System.out.println(sum);
	}
}
