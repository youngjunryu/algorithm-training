package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9466 {
	static int n;
	static int[] arr;
	static boolean[] visited;
	static boolean[] finished;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());
			count = 0;
			arr = new int[n+1];
			visited = new boolean[n+1];
			finished = new boolean[n+1];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= n; i++) {
				dfs(i);
			}

			System.out.println(n - count);
		}
	}

	private static void dfs(int cur) {
		visited[cur] = true;
		int next = arr[cur];

		if (!visited[next]) {
			dfs(next);
		} else {
			if (!finished[next]) {
				count++;
				for (int i = next; i != cur; i = arr[i]) {
					count++;
				}
			}
		}

		finished[cur] = true;
	}
}
