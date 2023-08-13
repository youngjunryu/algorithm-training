package Archiving.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1463 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		Arrays.fill(arr, Integer.MAX_VALUE);
		arr[1] = 0;

		for (int i = 2; i <= N; i++) {
			if (i % 3 == 0) {
				arr[i] = arr[i/3] + 1;
			}

			if (i % 2 == 0) {
				arr[i] = Math.min(arr[i/2] + 1, arr[i]);
			}

			arr[i] = Math.min(arr[i-1] + 1, arr[i]);
		}

		System.out.println(arr[N]);
	}
}
