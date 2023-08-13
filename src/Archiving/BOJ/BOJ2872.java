package Archiving.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2872 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int idx = 0;
		int cnt = 0;
		int order = N - 1;

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
			if (num == N) {
				idx = i;
			}
		}

		for (int i = idx - 1; i >= 0; i--) {
			if (arr[i] == order) {
				order--;
			} else {
				cnt++;
			}
		}

		int answer = N - idx - 1 + cnt;
		System.out.println(answer);
	}
}
