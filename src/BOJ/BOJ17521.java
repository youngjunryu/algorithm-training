package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17521 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long w = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		long coin = 0;
		for (int i = 1; i < n; i++) {
			if (arr[i-1] < arr[i]) {
				coin = w / arr[i-1];
				w = w % arr[i-1];
				w += arr[i] * coin;
			}
		}

		System.out.println(w);
	}
}
