package Archiving.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ2668 {
	static boolean[] visited;
	static int[] arr;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		arr = new int[N+1];
		visited = new boolean[N+1];
		list = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 1; i <= N; i++) {
			visited[i] = true;
			dfs(i, i);
			visited[i] = false;
		}

		Collections.sort(list);
		System.out.println(list.size());
		list.stream().forEach(System.out::println);
	}

	private static void dfs(int end, int cur) {
		if (arr[cur] == end) {
			list.add(cur);
		}

		if(!visited[arr[cur]]) {
			visited[arr[cur]] = true;
			dfs(end, arr[cur]);
			visited[arr[cur]] = false;
		}
	}
}
