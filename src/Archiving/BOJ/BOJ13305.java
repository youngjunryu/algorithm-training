package Archiving.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13305 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] road = new int[N-1];
		int[] gas = new int[N];
		long answer = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++) {
			road[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			gas[i] = Integer.parseInt(st.nextToken());
		}

		int min = gas[0];

		for (int i = 0; i < N - 1; i++) {
			if (min > gas[i]) {
				min = gas[i];
			}

			answer += (long)road[i] * min;
		}

		System.out.println(answer);
	}
}
