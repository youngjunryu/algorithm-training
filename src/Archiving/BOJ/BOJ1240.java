package Archiving.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1240 {
	static ArrayList<Node>[] list;
	static int[] dist;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		dist = new int[N+1];
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b, distance));
			list[b].add(new Node(a, distance));
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			Arrays.fill(dist, Integer.MAX_VALUE);

			dijkstra(start);

			sb.append(dist[end]).append("\n");
		}

		System.out.println(sb);
	}

	private static void dijkstra(int src) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N+1];

		dist[src] = 0;
		pq.add(new Node(src, 0));

		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int u = cur.v;

			if (visited[u]) {
				continue;
			}

			visited[u] = true;
			for (int i = 0; i < list[u].size(); i++) {
				Node next = list[u].get(i);
				if (dist[next.v] > dist[u] + next.d) {
					dist[next.v] = dist[u] + next.d;
					pq.add(new Node(next.v, dist[next.v]));
				}
			}
		}
	}

	static class Node implements Comparable<Node> {
		int v;
		int d;

		public Node(int v, int d) {
			this.v = v;
			this.d = d;
		}

		@Override
		public int compareTo(Node o) {
			return this.d - o.d;
		}
	}
}
