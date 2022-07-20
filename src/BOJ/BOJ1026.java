package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1026 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		Integer[] arr = new Integer[N];
		Integer[] arr2 = new Integer[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		Arrays.sort(arr2, Collections.reverseOrder());

		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += arr[i] * arr2[i];
		}

		System.out.println(sum);
	}
}
