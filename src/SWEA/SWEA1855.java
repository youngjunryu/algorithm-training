package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA1855 {
    static int N;
    static ArrayList<ArrayList<Integer>> adjList;
    static ArrayList<Integer> list;
    static int[][] parent;
    static int[] deep;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());

            list = new ArrayList<>();
            adjList = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                adjList.add(new ArrayList<>());
            }

            parent = new int[N+1][20];
            parent[1][0] = 1;
            deep = new int[N+1];
            visited = new boolean[N+1];

            st = new StringTokenizer(br.readLine());
            for(int i = 2; i <= N; i++) {
                int p = Integer.parseInt(st.nextToken());
                adjList.get(p).add(i);
            }

            bfs(1, 0);
            connecting();

            long result = 0;
            for(int i = 0; i < N - 1; i++) {
                int LCA = LCA(list.get(i), list.get(i+1));
                int a = deep[list.get(i)] - deep[LCA];
                int b = deep[list.get(i+1)] - deep[LCA];
                result += a;
                result += b;
            }

            System.out.println("#" + tc + " " + result);
        }
    }

    private static void bfs(int cur, int depth) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {cur, depth});
        visited[cur] = true;

        while(!q.isEmpty()) {
            int[] p = q.poll();
            int current = p[0];
            int d = p[1];
            deep[current] = d;
            list.add(current);
            for(int next : adjList.get(current)) {
                if(!visited[next]) {
                    visited[next] = true;
                    parent[next][0] = current;
                    q.offer(new int[] {next, d + 1});
                }
            }
        }
    }

    private static void connecting() {
        for(int p = 1; p < 20; p++) {
            for(int cur = 1; cur <= N; cur++) {
                parent[cur][p] = parent[parent[cur][p-1]][p-1];
            }
        }
    }

    private static int LCA(int node1, int node2) {
        if(deep[node1] > deep[node2]) {
            int temp = node1;
            node1 = node2;
            node2 = temp;
        }

        for(int i = 19; i >= 0; i--) {
            int jump = 1 << i;
            if(deep[node2] - deep[node1] >= jump)
                node2 = parent[node2][i];
        }

        if(node1 == node2)
            return node1;

        for(int i = 19; i >= 0; i--) {
            if(parent[node1][i] == parent[node2][i])
                continue;
            node1 = parent[node1][i];
            node2 = parent[node2][i];
        }

        return parent[node1][0];
    }
}
