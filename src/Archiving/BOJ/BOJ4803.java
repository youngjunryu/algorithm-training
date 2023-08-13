package Archiving.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ4803 {
	static ArrayList<Integer>[] graph;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int answer;
		int T = 1;

		while(true) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			if (n == 0 && m == 0) {
				break;
			}

			answer = 0;
			graph = new ArrayList[n+1];
			visited = new boolean[n+1];

			for (int i = 1; i <= n; i++) {
				graph[i] = new ArrayList<>();
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				graph[a].add(b);
				graph[b].add(a);
			}

			for (int i = 1; i <= n; i++) {
				if (!visited[i]) {
					visited[i] = true;
					if (dfs(-1, i)) {
						answer++;
					}
				}
			}

			sb.append("Case ").append(T).append(": ");
			if (answer == 0) {
				sb.append("No trees.\n");
			} else if (answer == 1) {
				sb.append("There is one tree.\n");
			} else {
				sb.append("A forest of ").append(answer).append(" trees.\n");
			}
			T++;
		}

		System.out.println(sb);
	}

	private static boolean dfs(int prev, int cur) {
		for (int next : graph[cur]) {
			if (prev == next) {
				continue;
			}

			if (visited[next]) {
				return false;
			}

			visited[next] = true;
			if (!dfs(cur, next)) {
				return false;
			}
		}

		return true;
	}
}
